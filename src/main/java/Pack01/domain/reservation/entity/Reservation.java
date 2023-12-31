package Pack01.domain.reservation.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
public class Reservation {
    private Long reservation_id;
    private Long member_id;
    private Long cafe_id;
    private Date reservation_time;


    @Builder
    public Reservation(Long reservation_id, Long member_id, Long cafe_id, Date reservation_time) {
        this.reservation_id = reservation_id;
        this.member_id = member_id;
        this.cafe_id = cafe_id;
        this.reservation_time = reservation_time;
    }

    public static Reservation of(Long reservation_id, Long member_id, Long item_id, Date reservation_time){
        return Reservation.builder()
                .reservation_id(reservation_id)
                .member_id(member_id)
                .cafe_id(item_id)
                .reservation_time(java.sql.Date.valueOf(LocalDate.now()))
                .build();
    }
}
