package Pack01.domain.rental.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@NoArgsConstructor
@Getter
public class RentalFindRespDto {

    private Long reservation_id;
    private Long member_id;
    private Long item_id;
    private LocalDate reservation_time;
}
