package Pack01.domain.member.application;

import Pack01.domain.member.dto.AdminLoginReqDto;
import Pack01.domain.member.dto.MemberRegisterReqDto;
import Pack01.domain.member.entity.Member;
import Pack01.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberReadServiceImp {
    private final MemberRepository memberRepository;

    public void loginAdmin(AdminLoginReqDto adminLoginReqDto){
        List<Member> member = memberRepository.loginAdmin(adminLoginReqDto.getAdminId(), adminLoginReqDto.getAdminPw());
        validateUser(member);
    }

    private static void validateUser(List<Member> member) {
        if(member.size()<1){
            throw new RuntimeException();
        }
    }


}
