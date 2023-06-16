package Pack01.domain.cafe.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CafeFindRespDto {
    private Long cafe_id;
    private Long member_id;
    private String cafe_name;
    private String cafe_address;
    private Float cafe_latitude;
    private Float cafe_longitude;


    @Builder
    public CafeFindRespDto(Long cafe_id, Long member_id, String cafe_name, String cafe_address, Float cafe_latitude, Float cafe_longitude) {
        this.cafe_id = cafe_id;
        this.member_id = member_id;
        this.cafe_name = cafe_name;
        this.cafe_address = cafe_address;
        this.cafe_latitude = cafe_latitude;
        this.cafe_longitude = cafe_longitude;
    }

}
