package Pack01.domain.member.application;

import Pack01.domain.member.dto.MemberFindAllRespDto;
import Pack01.domain.member.dto.MemberRegisterReqDto;
import Pack01.domain.member.dto.MemberUpdateReqDto;
import Pack01.domain.member.dto.UserUpdateReqDto;

import java.util.List;


public interface MemberWriteService {
    void register(MemberRegisterReqDto memberRegisterReqDto);
    void registerManager(MemberRegisterReqDto memberRegisterReqDto);
    void increaseWarningCount(List<Long> memberIds);
    void updateMember(MemberUpdateReqDto memberUpdateReqDto);
    void updateUserInfo(UserUpdateReqDto userUpdateReqDto);

    void deleteByMemberId(Long member_id);

}
