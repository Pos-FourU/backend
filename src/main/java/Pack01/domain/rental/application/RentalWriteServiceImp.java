package Pack01.domain.rental.application;

import Pack01.domain.rental.repository.RentalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class RentalWriteServiceImp implements RentalWriteService{

    private final RentalRepository rentalRepository;

    @Override
    public void deleteExpiredRentals() {
        rentalRepository.deleteExpiredRentals();
    }
}
