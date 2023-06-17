package Pack01.domain.reservation.application;

import Pack01.domain.reservation.dto.ReservationRegistDto;

public interface ReservationWriteService {
    void register(ReservationRegistDto reservationRegistDto);
    boolean checkIfAlreadyReserved(Long memberId);
}
