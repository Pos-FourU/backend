package Pack01.domain.cafe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CafeFindReqDto {
    private Long cafe_id;
    private Long member_id;
    private String cafe_name;
    private String cafe_address;
    private Float cafe_latitude;
    private Float cafe_longitude;

}
