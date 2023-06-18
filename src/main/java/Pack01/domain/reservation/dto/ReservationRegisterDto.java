package Pack01.domain.reservation.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReservationRegisterDto {

    private Long member_id;
    private Long cafe_id;


    @Builder
    public ReservationRegisterDto(Long member_id, Long cafe_id) {
        this.member_id = member_id;
        this.cafe_id = cafe_id;

    }
}