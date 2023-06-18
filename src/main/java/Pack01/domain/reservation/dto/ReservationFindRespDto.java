package Pack01.domain.reservation.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
@Getter
public class ReservationFindRespDto {
    private Long reservation_id;
    private Long member_id;
    private Long cafe_id;
    private Date reservation_time;

    @Builder
    public ReservationFindRespDto(Long reservation_id, Long member_id, Long cafe_id, Date reservation_time) {
        this.reservation_id=reservation_id;
        this.member_id = member_id;
        this.cafe_id = cafe_id;
        this.reservation_time = reservation_time;
    }
}
