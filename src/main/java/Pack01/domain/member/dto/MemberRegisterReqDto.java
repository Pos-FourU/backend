package Pack01.domain.member.dto;


import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberRegisterReqDto {
    private String memberEmail;
    private String memberPw;
    private String memberPhoneNum;
    private String memberName;

    @Builder
    public MemberRegisterReqDto(String memberEmail, String memberPw, String memberPhoneNum, String memberName) {
        this.memberEmail = memberEmail;
        this.memberPw = memberPw;
        this.memberPhoneNum = memberPhoneNum;
        this.memberName = memberName;
    }
}
