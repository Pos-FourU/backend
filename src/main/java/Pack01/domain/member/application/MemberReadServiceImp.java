package Pack01.domain.member.application;

import Pack01.domain.member.dto.AdminLoginReqDto;
import Pack01.domain.member.dto.ManagerFindAllRespDto;
import Pack01.domain.member.dto.MemberFindAllRespDto;

import Pack01.domain.member.entity.Member;
import Pack01.domain.member.entity.MemberRole;
import Pack01.domain.member.entity.MemberStatus;
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
    public List<MemberFindAllRespDto> getMembers(MemberRole memberRole) {
        List<Member>members;
        if (memberRole==null){
            members = memberRepository.findAll();
        }else {
            members = memberRepository.findMembers(memberRole);
        }
        return members
                .stream()
                .map(member -> new MemberFindAllRespDto().builder()
                        .member_id(member.getMember_id())
                        .member_email(member.getMember_email())
                        .member_name(member.getMember_name())
                        .member_phone(member.getMember_phone())
                        .warning_count(member.getWarning_count())
                        .member_status(member.getMember_status())
                        .build())
                .collect(Collectors.toList());
    }
    @Override
    public List<ManagerFindAllRespDto> getManagers() {
        return memberRepository.findManagers()
                .stream()
                .map(manager -> new ManagerFindAllRespDto().builder()
                        .member_id(manager.getMember_id())
                        .member_phone(manager.getMember_phone())
                        .member_name(manager.getMember_name())
                        .member_email(manager.getMember_email())
                        .cafe_id(manager.getCafe_id())
                        .cafe_name(manager.getCafe_name())
                        .cafe_address(manager.getCafe_address())
                        .build())
                .collect(Collectors.toList());
    }

    private void validateUser(List<Member> member) {
        if(member.size()<1){
            throw new RuntimeException();
        }
    }


}
