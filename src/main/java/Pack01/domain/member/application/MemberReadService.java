package Pack01.domain.member.application;


import Pack01.domain.member.dto.AdminLoginReqDto;
import Pack01.domain.member.entity.Member;

import java.util.List;

public interface MemberReadService {
    void loginAdmin(AdminLoginReqDto adminLoginReqDto);
}
