package Pack01.domain.member.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberRegisterReqDto {
    private String memberEmail;
    private String memberPw;
    private String memberPhone;
    private String memberName;

    @Builder
    public MemberRegisterReqDto(String memberEmail, String memberPw, String memberPhone, String memberName) {
        this.memberEmail = memberEmail;
        this.memberPw = memberPw;
        this.memberPhone = memberPhone;
        this.memberName = memberName;
    }
}
