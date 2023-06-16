package Pack01.presentation;

import Pack01.domain.member.application.MemberWriteService;
import Pack01.domain.member.dto.MemberRegisterReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/member")

public class MemberController {

    private final MemberWriteService memberWriteService;
    @PostMapping()
    public String register(@RequestBody MemberRegisterReqDto memberRegisterReqDto){
        memberWriteService.register(memberRegisterReqDto);
        return "index";
    }
    @GetMapping
    public void test(){
        throw new RuntimeException();
    }
}
