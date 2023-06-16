package Pack01.domain.member.application;

import Pack01.domain.member.dto.LoginReqDto;
import Pack01.domain.member.dto.ManagerFindAllRespDto;
import Pack01.domain.member.dto.MemberFindAllRespDto;
import Pack01.domain.member.entity.MemberRole;

import java.util.List;

public interface MemberReadService {
    MemberRole loginAdmin(LoginReqDto loginReqDto);
    List<MemberFindAllRespDto> getMembers(MemberRole memberRole);


    List<ManagerFindAllRespDto> getManagers();
   void findByWaringCountUser();

}

