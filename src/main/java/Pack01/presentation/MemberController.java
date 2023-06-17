package Pack01.presentation;

import Pack01.domain.cafe.application.CafeReadService;
import Pack01.domain.member.application.MemberReadService;
import Pack01.domain.member.application.MemberWriteService;
import Pack01.domain.member.dto.LoginReqDto;
import Pack01.domain.member.dto.MemberRegisterReqDto;
import Pack01.domain.member.entity.Member;
import Pack01.domain.member.entity.MemberRole;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
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
    public String register(@RequestBody MemberRegisterReqDto memberRegisterReqDto) {
        memberWriteService.register(memberRegisterReqDto);
        return "index";
    }
    @PostMapping("/manager")
    public String registerManager(@RequestBody MemberRegisterReqDto memberRegisterReqDto) {
        memberWriteService.registerManager(memberRegisterReqDto);
        return "reservation";
    }

    @PostMapping("/login")
    public String LoginAdmin(LoginReqDto loginReqDto, HttpSession session) {
        Member member = memberReadService.loginAdmin(loginReqDto);
        MemberRole role = member.getMember_role();
        session.setAttribute("role", role);
        if (role == ADMIN) {
            return "redirect:/api/v1/admin/manageMember";
        } else if (role == MANAGER) {
                return "redirect:/api/v1/admin/manageRental";
        } else if (role == USER) {
            return "redirect:/api/v1/cafe/map";
        } else {
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
