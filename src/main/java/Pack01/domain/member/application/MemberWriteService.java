package Pack01.domain.member.application;

import Pack01.domain.member.dto.MemberRegisterReqDto;
import Pack01.domain.member.entity.Member;
import Pack01.domain.member.entity.MemberRole;
import Pack01.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberWriteService {
    private final MemberRepository memberRepository;

    public void registerUser(MemberRegisterReqDto memberRegisterReqDto){
        Member member = Member.of(memberRegisterReqDto.getMemberEmail(),
                memberRegisterReqDto.getMemberPw(),
                memberRegisterReqDto.getMemberPhone(),
                MemberRole.USER,
                memberRegisterReqDto.getMemberName());
        memberRepository.registerMember(member);
    }

    public void registerCafeAdmin(MemberRegisterReqDto memberRegisterReqDto){
        Member member = Member.of(memberRegisterReqDto.getMemberEmail(),
                memberRegisterReqDto.getMemberPw(),
                memberRegisterReqDto.getMemberPhone(),
                MemberRole.CAFE_ADMIN,
                memberRegisterReqDto.getMemberName());
        memberRepository.registerMember(member);
    }


}
