package Pack01.domain.reservation.application;

import Pack01.domain.reservation.dto.ReservationFindRespDto;

import java.util.List;

public interface ReservationReadService {
    public List<ReservationFindRespDto> getReservations(Long member_id);
}
