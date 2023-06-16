package Pack01.domain.rental.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.Date;

import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
public class Rental {
    private Long rental_id;
    private Long member_id;
    private Long item_id;
    private Date rental_time;
    private Date return_time;

    @Builder
    public Rental(Long rental_id, Long member_id, Long item_id, Date rental_time, Date return_time){
        this.rental_id=rental_id;
        this.member_id=member_id;
        this.item_id=item_id;
        this.rental_time=rental_time;
        this.return_time=return_time;
    }

    public static Rental of(Long member_id, Long item_id, Date rental_time){
        return Rental.builder()
                .member_id(member_id)
                .item_id(item_id)
                .rental_time(rental_time)
                .return_time(null)
                .build();
    }

    public void updateRental_returnTime(Date return_time){
        this.return_time=return_time;
    }

}
