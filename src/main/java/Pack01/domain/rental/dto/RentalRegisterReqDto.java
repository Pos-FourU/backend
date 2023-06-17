package Pack01.domain.rental.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
public class RentalRegisterReqDto {
    private Long rental_id;
    private Long member_id;
    private Long item_id;
    private Date rental_time;
    private Date return_time;

    @Builder
    public RentalRegisterReqDto(Long rental_id, Long member_id, Long item_id, Date rental_time, Date return_time) {
        this.rental_id = rental_id;
        this.member_id = member_id;
        this.item_id = item_id;
        this.rental_time = rental_time;
        this.return_time = return_time;
    }
}
