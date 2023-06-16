package Pack01.domain.member.application;

import Pack01.domain.member.dto.MemberRegisterReqDto;

public interface MemberWriteService {
    void register(MemberRegisterReqDto memberRegisterReqDto);
}
