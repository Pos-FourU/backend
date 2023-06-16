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
public class MemberWriteServiceImp implements MemberWriteService {
    private final MemberRepository memberRepository;

    @Override
    public void register(MemberRegisterReqDto memberRegisterReqDto) {
        MemberRegisterReqDto member = new MemberRegisterReqDto().builder()
                .memberEmail(memberRegisterReqDto.getMemberEmail())
                .memberPw(memberRegisterReqDto.getMemberPw())
                .memberName(memberRegisterReqDto.getMemberName())
                .memberPhone(memberRegisterReqDto.getMemberPhone())
                .build();
        memberRepository.registerMember(member);
    }


}
