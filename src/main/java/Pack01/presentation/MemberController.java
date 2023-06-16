package Pack01.presentation;

import Pack01.domain.member.application.MemberReadService;
import Pack01.domain.member.application.MemberWriteService;
import Pack01.domain.member.dto.LoginReqDto;
import Pack01.domain.member.dto.MemberRegisterReqDto;
import Pack01.domain.member.entity.MemberRole;
import Pack01.global.exception.FourUAdminException;
import Pack01.global.exception.FourUUserException;
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
    @PostMapping()
    public String register(@RequestBody MemberRegisterReqDto memberRegisterReqDto){
        memberWriteService.register(memberRegisterReqDto);
        return "index";
    }
    @PostMapping("/login")
    public String LoginAdmin(LoginReqDto loginReqDto, HttpSession session){
        MemberRole role = memberReadService.loginAdmin(loginReqDto);
        session.setAttribute("role",role);
        if (role== ADMIN){
            return "redirect:/api/v1/admin/manageMember";}
        else if(role==MANAGER){
            return "redirect:/api/v1/admin/manageRental";
        }else if(role==USER){
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
