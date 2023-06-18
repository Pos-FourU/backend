package Pack01.domain.member.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserUpdateReqDto {

    private Long member_id;
    private String member_name;
    private String member_email;
    private String member_phone;
    @Builder
    public UserUpdateReqDto(Long member_id, String member_name,String member_email,String member_phone) {
        this.member_id = member_id;
        this.member_name = member_name;
        this.member_email = member_email;
        this.member_phone = member_phone;
    }
}
