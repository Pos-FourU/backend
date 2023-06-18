package Pack01.presentation;

import Pack01.domain.cafe.application.CafeReadService;
import Pack01.domain.member.application.MemberReadService;
import Pack01.domain.member.application.MemberWriteService;
import Pack01.domain.member.dto.LoginReqDto;
import Pack01.domain.member.dto.MemberRegisterReqDto;
import Pack01.domain.member.entity.Member;
import Pack01.domain.member.entity.MemberRole;
import Pack01.global.exception.FourUAdminException;
import Pack01.global.exception.FourUUserException;
import Pack01.global.jwt.Jwt;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

import static Pack01.domain.member.entity.MemberRole.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/member")

public class MemberController {

    private final MemberWriteService memberWriteService;
    private final MemberReadService memberReadService;
    private final CafeReadService cafeReadService;
    @PostMapping()
    public String register(@RequestBody MemberRegisterReqDto memberRegisterReqDto){
        memberWriteService.register(memberRegisterReqDto);
        return "index";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }

    @PostMapping("/login")
    public String LoginAdmin(LoginReqDto loginReqDto, HttpSession session){
        Member member = memberReadService.loginAdmin(loginReqDto);
        Jwt jwt = new Jwt();
        String token = jwt.createJWT(member);

        session.setAttribute("token", token);
        if (member.getMember_role()== ADMIN){
            return "redirect:/api/v1/admin/manageMember";}
        else if(member.getMember_role()==MANAGER){
            Integer integer = cafeReadService.existCafeByMemberId(member.getMember_id());
            return "redirect:/api/v1/admin/manageRental";
        }else if(member.getMember_role()==USER){
            return "redirect:/api/v1/cafe/map";
        }else{
            throw new RuntimeException();
        }
    }
//    @GetMapping("/1")
//
//    public void test(){
//        throw new FourUAdminException("어드민") {
//        };
//    }
//    @GetMapping("/3")
//    public void test1(){
//        throw new FourUUserException("유저");
//    }

}
