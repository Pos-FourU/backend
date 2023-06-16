package Pack01.domain.rental.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
public class Rental {
    private Long reservation_id;
    private Long member_id;
    private Long item_id;
    private LocalDate reservation_time;
}
