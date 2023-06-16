package Pack01.domain.member.application;

import Pack01.domain.member.dto.MemberRegisterReqDto;
import Pack01.domain.member.entity.Member;
import Pack01.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberWriteServiceImp {
    private final MemberRepository memberRepository;

    public void register(MemberRegisterReqDto memberRegisterReqDto){
        Member member = Member.of(memberRegisterReqDto.getMemberEmail(),
                memberRegisterReqDto.getMemberPw(),
                memberRegisterReqDto.getMemberPhoneNum(),
                memberRegisterReqDto.getMemberName());
        memberRepository.registerMember(member);
    }


}
