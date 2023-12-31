package Pack01.domain.member.application;

import Pack01.domain.member.dto.MemberRegisterReqDto;
import Pack01.domain.member.dto.MemberUpdateReqDto;
import Pack01.domain.member.dto.UserUpdateReqDto;
import Pack01.domain.member.entity.Member;
import Pack01.domain.member.entity.MemberRole;
import Pack01.domain.member.entity.MemberStatus;
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
                .member_status(MemberStatus.ABLE)
                .warning_count(0L)
                .create_at(LocalDate.now())
                .update_at(LocalDate.now())
                .build();
        memberRepository.registerMember(member);
    }

    @Override
    public void registerManager(MemberRegisterReqDto memberRegisterReqDto) {
        Member member = Member.builder()
                .member_email(memberRegisterReqDto.getMemberEmail())
                .member_pw(memberRegisterReqDto.getMemberPw())
                .member_role(MemberRole.MANAGER)
                .member_phone(memberRegisterReqDto.getMemberPhone())
                .member_name(memberRegisterReqDto.getMemberName())
                .member_status(MemberStatus.ABLE)
                .warning_count(0L)
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

    @Override
    public void updateMember(MemberUpdateReqDto memberUpdateReqDto) {
        memberRepository.updateMember(memberUpdateReqDto);
    }

    @Override
    public void updateUserInfo(UserUpdateReqDto userUpdateReqDto) {
        memberRepository.updateUserInfo(userUpdateReqDto);
    }
    @Override
    public void deleteByMemberId(Long member_id) {
        memberRepository.deleteByMemberId(member_id);

    }


}
