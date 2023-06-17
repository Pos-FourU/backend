package Pack01.presentation;

import Pack01.domain.cafe.application.CafeReadService;
import Pack01.domain.cafe.dto.CafeLeftCountRespDto;
import Pack01.domain.member.application.MemberReadService;
import Pack01.domain.member.application.MemberWriteService;
import Pack01.domain.member.dto.LoginReqDto;
import Pack01.domain.member.dto.MemberRegisterReqDto;
import Pack01.domain.member.entity.Member;
import Pack01.domain.member.entity.MemberRole;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;

import java.util.List;

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
    public String registerManager(@RequestParam String memberEmail,
                                  @RequestParam String memberPw,
                                  @RequestParam String memberPhone,
                                  @RequestParam String memberName,
                                  Model model) {
        MemberRegisterReqDto memberRegisterReqDto = MemberRegisterReqDto.builder()
                .memberEmail(memberEmail)
                .memberPhone(memberPhone)
                .memberName(memberName)
                .memberPw(memberPw)
                .build();
        memberWriteService.registerManager(memberRegisterReqDto);
        Member member = memberReadService.loginAdmin(LoginReqDto.builder().id(memberEmail).pw(memberPw)
                .build());
        model.addAttribute("member_id",member.getMember_id());
        return "addCafe";
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

    @GetMapping("/mypage")
    public String mypage(Model model, HttpSession session) {
//        session.getAttribute(member_id);
        Long member_id = 1L;
        List<Member> members = memberReadService.findById(member_id);
        model.addAttribute("members", members);
        return "mypage";
    }


}
