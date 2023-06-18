package Pack01.domain.reservation.application;

import Pack01.domain.rental.dto.RentalFindAllRespDto;
import Pack01.domain.reservation.dto.ReservationFindRespDto;
import Pack01.domain.reservation.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ReservationReadServiceImpl implements ReservationReadService {
    private final ReservationRepository reservationRepository;

    @Override
    public List<ReservationFindRespDto> getReservations(Long member_id){
        return reservationRepository.findbyManager(member_id)
                .stream()
                .map(reservation->new ReservationFindRespDto().builder()
                        .reservation_id(reservation.getReservation_id())
                        .member_id(reservation.getMember_id())
                        .cafe_id(reservation.getCafe_id())
                        .reservation_time(reservation.getReservation_time())
                        .build())
                .collect(Collectors.toList());
    }

}
