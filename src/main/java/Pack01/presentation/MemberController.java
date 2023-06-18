package Pack01.presentation;

import Pack01.domain.cafe.application.CafeReadService;
import Pack01.domain.member.application.MemberReadService;
import Pack01.domain.member.application.MemberWriteService;
import Pack01.domain.member.dto.LoginReqDto;
import Pack01.domain.member.dto.MemberRegisterReqDto;
import Pack01.domain.member.dto.UserUpdateReqDto;
import Pack01.domain.member.entity.Member;
import Pack01.domain.rental.application.RentalReadService;
import Pack01.global.exception.FourUPerMissionException;
import Pack01.global.jwt.Jwt;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

import static Pack01.domain.member.entity.MemberRole.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/member")

public class MemberController {

    private final MemberWriteService memberWriteService;
    private final MemberReadService memberReadService;
    private final RentalReadService rentalReadService;
    private final CafeReadService cafeReadService;

    private final Jwt jwt = new Jwt();
    @PostMapping()
    public String register(@RequestParam String memberEmail,
                           @RequestParam String memberPw,
                           @RequestParam String memberPhone,
                           @RequestParam String memberName) {
        memberWriteService.register(MemberRegisterReqDto.builder()
                .memberEmail(memberEmail)
                .memberPw(memberPw)
                .memberPhone(memberPhone)
                .memberName(memberName)
                .build()
        );
        return "redirect:/";
    }

    @GetMapping()
    public String regist() {
        return "addUser";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @PostMapping("/manager")
    public String registerManager(@RequestParam String memberEmail,
                                  @RequestParam String memberPw,
                                  @RequestParam String memberPhone,
                                  @RequestParam String memberName,
                                  Model model,HttpSession session) {
        Object token1 = session.getAttribute("token");
        if(token1==null){
            throw new FourUPerMissionException("아이디 혹은 비밀번호가 잘못 되었습니다.");
        }
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
        Jwt jwt = new Jwt();
        String token = jwt.createJWT(member);

        session.setAttribute("token", token);
        if (member.getMember_role()== ADMIN){
            return "redirect:/api/v1/admin/manageMember";}
        else if(member.getMember_role()==MANAGER){
            Integer integer = cafeReadService.existCafeByMemberId(member.getMember_id());
            return "redirect:/api/v1/admin/manageItem";
        }else if(member.getMember_role()==USER){
            return "redirect:/api/v1/cafe/map";
        } else {
            throw new RuntimeException();
        }
    }

    @GetMapping("/mypage")
    public String mypage(Model model, HttpSession session) {
//        Jwt jwt = new Jwt;
        Object token1 = session.getAttribute("token");
        if(token1==null){
            throw new FourUPerMissionException("아이디 혹은 비밀번호가 잘못 되었습니다.");
        }
        Claims token = jwt.getJwtContents(token1.toString());
        Long member_id = Long.parseLong(token.get("id").toString());
        Integer countThismonth = rentalReadService.countThismonth(member_id);
        model.addAttribute("member", memberReadService.findById(member_id));
        model.addAttribute("countThismonth",countThismonth);
        return "mypageView";
    }

    @GetMapping("/mypage/toupdate")
    public String toupdate(){
        return "updateMember";
    }
    @PostMapping("/mypage/update")
    public String updateMembers(@RequestParam String memberName,
                                @RequestParam String memberEmail,
                                @RequestParam String memberPhone,
                                HttpSession session){
        Claims token = jwt.getJwtContents(session.getAttribute("token").toString());
        Long member_id = Long.parseLong(token.get("id").toString());
        UserUpdateReqDto user = UserUpdateReqDto.builder()
                .member_id(member_id)
                .member_name(memberName)
                .member_email(memberEmail)
                .member_phone(memberPhone)
                .build();
        memberWriteService.updateUserInfo(user);
        return "updateOK";
    }


}
