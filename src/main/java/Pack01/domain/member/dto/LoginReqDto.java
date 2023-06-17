package Pack01.domain.member.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class LoginReqDto {

    private String id;
    private String pw;
    @Builder
    public LoginReqDto(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }

}
