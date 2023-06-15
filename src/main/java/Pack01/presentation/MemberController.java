package Pack01.presentation;

import Pack01.domain.member.application.MemberWriteService;
import Pack01.domain.member.dto.MemberRegisterReqDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/member")

public class MemberController {

    private final MemberWriteService memberWriteService;
    @PostMapping()
    public String register(MemberRegisterReqDto memberRegisterReqDto){
        memberWriteService.register(memberRegisterReqDto);
        return "tiger";

    }
}