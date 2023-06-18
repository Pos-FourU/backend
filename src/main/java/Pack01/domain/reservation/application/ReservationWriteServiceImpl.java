package Pack01.domain.reservation.application;

import Pack01.domain.reservation.dto.ReservationRegisterDto;
import Pack01.domain.reservation.entity.Reservation;
import Pack01.domain.reservation.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Transactional
public class ReservationWriteServiceImpl implements ReservationWriteService {
    private final ReservationRepository reservationRepository;
    @Override
    public void register(ReservationRegisterDto reservationRegisterDto) {
        Reservation reservation = Reservation.builder()
                .member_id(reservationRegisterDto.getMember_id())
                .cafe_id(reservationRegisterDto.getCafe_id())
                .reservation_time(Date.valueOf(LocalDate.now()))
                .build();
        reservationRepository.registerReservation(reservation);

    }
    public boolean checkIfAlreadyReserved(Long memberId) {

        return reservationRepository.checkIfAlready(memberId);
    }
}