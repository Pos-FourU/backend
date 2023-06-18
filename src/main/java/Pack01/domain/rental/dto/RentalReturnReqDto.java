package Pack01.domain.rental.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Getter
public class RentalReturnReqDto {
    private Long rental_id;
    private Long member_id;
    private Long item_id;
    private String rental_time;
    private String return_time;
    private String rental_days;

    @Builder
    public RentalReturnReqDto(Long rental_id, Long member_id, Long item_id, String rental_time, String return_time, String rental_days) {
        this.rental_id = rental_id;
        this.member_id = member_id;
        this.item_id = item_id;
        this.rental_time = rental_time;
        this.return_time = return_time;
        this.rental_days = rental_days;
    }
}
