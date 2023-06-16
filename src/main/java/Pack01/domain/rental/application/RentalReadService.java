package Pack01.domain.rental.application;



import Pack01.domain.item.entity.Item;
import Pack01.domain.rental.dto.RentalFindAllRespDto;
import Pack01.domain.rental.entity.Rental;
import Pack01.domain.rental.repository.RentalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class RentalReadService {
    private final RentalRepository rentalRepository;
    public List<RentalFindAllRespDto> getAllRentals(){
        return rentalRepository.findAllRentals()
                .stream()
                .map(rental->new RentalFindAllRespDto().builder()
                        .rental_id(rental.getRental_id())
                        .member_id(rental.getMember_id())
                        .item_id(rental.getItem_id())
                        .rental_time(rental.getRental_time())
                        .return_time(rental.getReturn_time())
                        .build())
                .collect(Collectors.toList());
    }
}
