package Pack01.domain.member.application;

import Pack01.domain.member.dto.AdminLoginReqDto;
import Pack01.domain.member.entity.Member;
import Pack01.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberReadServiceImp implements MemberReadService{
    private final MemberRepository memberRepository;

    public void loginAdmin(AdminLoginReqDto adminLoginReqDto){
        List<Member> member = memberRepository.loginAdmin(adminLoginReqDto.getAdminId(), adminLoginReqDto.getAdminPw());
        validateUser(member);
    }

    @Override
    public void findByWaringCountUser() {
        List<Member> memberList = memberRepository.findByWaringCountUser();
        if (memberList == null || memberList.stream().allMatch(Objects::isNull)) {
            return;
        }
        List<Long> members = memberList
                .stream()
                .map(Member::getMember_id)
                .collect(Collectors.toList());
        members.forEach(memberRepository::ChangeBlackList);
    }

    private void validateUser(List<Member> member) {
        if(member.size()<1){
            throw new RuntimeException();
        }
    }


}
