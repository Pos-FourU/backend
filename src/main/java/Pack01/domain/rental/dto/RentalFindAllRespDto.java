package Pack01.domain.rental.dto;

import Pack01.domain.item.entity.ItemCategory;
import Pack01.domain.item.entity.ItemStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class RentalFindAllRespDto {
    private Long rental_id;
    private Long member_id;
    private Long item_id;
    private Date rental_time;
    private Date return_time;
    private Date rental_days;

    @Builder
    public RentalFindAllRespDto(Long rental_id, Long member_id, Long item_id, Date rental_time, Date return_time, Date rental_days) {
        this.rental_id = rental_id;
        this.member_id = member_id;
        this.item_id = item_id;
        this.rental_time = rental_time;
        this.return_time = return_time;
        this.rental_days = rental_days;
    }
}
