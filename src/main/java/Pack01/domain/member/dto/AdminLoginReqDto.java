package Pack01.domain.member.dto;


import lombok.Builder;
import lombok.Getter;

@Getter
public class AdminLoginReqDto {

    private String adminId;
    private String adminPw;
    @Builder
    public AdminLoginReqDto(String adminId, String adminPw) {
        this.adminId = adminId;
        this.adminPw = adminPw;
    }

}
