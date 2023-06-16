package Pack01.domain.member.application;

import Pack01.domain.member.dto.MemberRegisterReqDto;

import java.util.List;


public interface MemberWriteService {
    void register(MemberRegisterReqDto memberRegisterReqDto);
    void increaseWarningCount(List<Long> memberIds);

}
