package Pack01.domain.reservation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@NoArgsConstructor
@Getter
public class ReservationFindRespDto {

    private Long member_id;
    private Long cafe_id;
    private Long item_id;
    private LocalDate reservation_time;
}
