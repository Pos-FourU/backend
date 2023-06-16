package Pack01.domain.reservation.application;

import Pack01.domain.reservation.dto.ReservationRegistDto;
import Pack01.domain.reservation.entity.Reservation;
import Pack01.domain.reservation.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Transactional
public class ReservationWriteServiceImpl {
    private final ReservationRepository reservationRepository;
    public void register(ReservationRegistDto reservationRegistDto) {
        Reservation reservation = Reservation.builder()
                .member_id(reservationRegistDto.getMember_id())
                .cafe_id(reservationRegistDto.getCafe_id())
                .reservation_time(LocalDate.now())
                .build();
        reservationRepository.registerReservation(reservation);

    }
}