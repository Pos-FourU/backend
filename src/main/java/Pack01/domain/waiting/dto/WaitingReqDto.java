package Pack01.domain.waiting.dto;


import lombok.Builder;
import lombok.Getter;

@Getter
public class WaitingReqDto {
    private String memberEmail;
    private String memberPw;
    private String memberPhoneNum;
    private String memberName;

    @Builder
    public WaitingReqDto(String memberEmail, String memberPw, String memberPhoneNum, String memberName) {
        this.memberEmail = memberEmail;
        this.memberPw = memberPw;
        this.memberPhoneNum = memberPhoneNum;
        this.memberName = memberName;
    }
}
