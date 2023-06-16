package Pack01.domain.reservation.entity;

import Pack01.domain.member.entity.Member;
import Pack01.domain.member.entity.MemberRole;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
public class Reservation {
    private Long reservation_id;
    private Long member_id;
    private Long cafe_id;
    private LocalDate reservation_time;


    @Builder
    public Reservation(Long reservation_id, Long member_id, Long cafe_id, LocalDate reservation_time) {
        this.reservation_id = reservation_id;
        this.member_id = member_id;
        this.cafe_id = cafe_id;
        this.reservation_time = reservation_time;
    }

    public static Reservation of(Long reservation_id, Long member_id, LocalDate reservation_time){
        return Reservation.builder()
                .reservation_id(reservation_id)
                .member_id(member_id)
                .reservation_time(LocalDate.now())
                .build();
    }
}
