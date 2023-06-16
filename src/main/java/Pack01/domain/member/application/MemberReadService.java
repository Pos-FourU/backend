package Pack01.domain.member.application;

import Pack01.domain.member.dto.AdminLoginReqDto;
import Pack01.domain.member.dto.ManagerFindAllRespDto;
import Pack01.domain.member.dto.MemberFindAllRespDto;
import Pack01.domain.member.entity.MemberRole;
import Pack01.domain.member.entity.MemberStatus;

import java.util.List;

import Pack01.domain.member.dto.AdminLoginReqDto;

public interface MemberReadService {
    void loginAdmin(AdminLoginReqDto adminLoginReqDto);
    List<MemberFindAllRespDto> getMembers(MemberRole memberRole);


    List<ManagerFindAllRespDto> getManagers();
   void findByWaringCountUser();

}

