package Pack01.domain.member.application;

import Pack01.domain.member.dto.MemberRegisterReqDto;
import Pack01.domain.member.dto.MemberUpdateReqDto;

import java.util.List;


public interface MemberWriteService {
    void register(MemberRegisterReqDto memberRegisterReqDto);
    void registerManager(MemberRegisterReqDto memberRegisterReqDto);
    void increaseWarningCount(List<Long> memberIds);
    void updateMember(MemberUpdateReqDto memberUpdateReqDto);

}
