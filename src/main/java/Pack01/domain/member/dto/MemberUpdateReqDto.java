package Pack01.domain.member.dto;

import Pack01.domain.member.entity.MemberRole;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberUpdateReqDto {
    private Long admin_id;
    private Long member_id;
    private MemberRole member_role;

    @Builder
    public MemberUpdateReqDto(Long admin_id,Long member_id, MemberRole member_role) {
        this.admin_id = admin_id;
        this.member_id = member_id;
        this.member_role = member_role;
    }
}
