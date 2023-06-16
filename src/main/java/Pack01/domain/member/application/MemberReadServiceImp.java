package Pack01.domain.member.application;

import Pack01.domain.member.dto.MemberRegisterReqDto;
import Pack01.domain.member.entity.Member;
import Pack01.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberReadServiceImp implements MemberReadService{


}
