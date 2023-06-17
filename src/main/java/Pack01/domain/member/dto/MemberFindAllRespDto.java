package Pack01.domain.member.dto;

import Pack01.domain.member.entity.MemberRole;
import Pack01.domain.member.entity.MemberStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberFindAllRespDto {
    private Long member_id;
    private String member_email;
    private String member_name;
    private String member_phone;
    private Long warning_count;
    private MemberStatus member_status;
    private MemberRole member_role;

    @Builder
    public MemberFindAllRespDto(Long member_id, String member_email,String member_name, String member_phone, Long warning_count, MemberStatus member_status,MemberRole member_role) {
        this.member_id = member_id;
        this.member_email = member_email;
        this.member_name = member_name;
        this.member_phone = member_phone;
        this.warning_count = warning_count;
        this.member_status = member_status;
        this.member_role = member_role;
    }
}
