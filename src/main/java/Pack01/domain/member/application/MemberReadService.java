package Pack01.domain.member.application;


import Pack01.domain.member.dto.AdminLoginReqDto;

public interface MemberReadService {
    void loginAdmin(AdminLoginReqDto adminLoginReqDto);

    void findByWaringCountUser();
}