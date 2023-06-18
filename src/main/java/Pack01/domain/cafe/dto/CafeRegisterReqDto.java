package Pack01.domain.cafe.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CafeRegisterReqDto {
    private String cafe_name;
    private String cafe_address;
    private Long member_id;
    private Float cafe_latitude;
    private Float cafe_longitude;

    @Builder

    public CafeRegisterReqDto(String cafe_name, String cafe_address, Long member_id, Float cafe_latitude, Float cafe_longitude) {
        this.cafe_name = cafe_name;
        this.cafe_address = cafe_address;
        this.member_id = member_id;
        this.cafe_latitude = cafe_latitude;
        this.cafe_longitude = cafe_longitude;
    }
}
