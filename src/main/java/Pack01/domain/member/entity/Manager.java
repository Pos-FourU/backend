package Pack01.domain.member.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Manager {
    private Long cafe_id;
    private Long member_id;
    private String cafe_name;
    private String cafe_address;
    private String member_name;
    private String member_phone;
    private String member_email;

    @Builder
    public Manager(Long cafe_id, Long member_id, String cafe_name, String cafe_address, String member_name, String member_phone, String member_email) {
        this.cafe_id = cafe_id;
        this.member_id = member_id;
        this.cafe_name = cafe_name;
        this.cafe_address = cafe_address;
        this.member_name = member_name;
        this.member_phone = member_phone;
        this.member_email = member_email;
    }
}
