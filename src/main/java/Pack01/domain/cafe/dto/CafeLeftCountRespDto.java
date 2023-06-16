package Pack01.domain.cafe.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CafeLeftCountRespDto {
    private Long cafe_id;
    private Long totals;
    private String cafe_name;
    private Float cafe_latitude;
    private Float cafe_longitude;
    @Builder
    public CafeLeftCountRespDto(Long cafe_id, Long totals, String cafe_name, Float cafe_latitude, Float cafe_longitude) {
        this.cafe_id = cafe_id;
        this.totals = totals;
        this.cafe_name = cafe_name;
        this.cafe_latitude = cafe_latitude;
        this.cafe_longitude = cafe_longitude;
    }
}