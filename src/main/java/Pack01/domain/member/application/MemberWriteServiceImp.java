package Pack01.domain.member.application;

import Pack01.domain.member.dto.MemberRegisterReqDto;
import Pack01.domain.member.entity.Member;
import Pack01.domain.member.entity.MemberRole;
import Pack01.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberWriteServiceImp implements MemberWriteService {

    private final MemberRepository memberRepository;

    public void register(MemberRegisterReqDto memberRegisterReqDto) {
        Member member = Member.builder()
                .member_email(memberRegisterReqDto.getMemberEmail())
                .member_pw(memberRegisterReqDto.getMemberPw())
                .member_role(MemberRole.USER)
                .member_phone(memberRegisterReqDto.getMemberPhone())
                .member_name(memberRegisterReqDto.getMemberName())
                .create_at(LocalDate.now())
                .update_at(LocalDate.now())
                .build();
        memberRepository.registerMember(member);
    }

    @Override
    public void increaseWarningCount(List<Long> memberIds) {
        for(Long memberId:memberIds){
            memberRepository.increaseWarningCount(memberId);
        }
    }
}
