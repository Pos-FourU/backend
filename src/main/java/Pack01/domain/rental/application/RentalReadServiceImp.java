package Pack01.domain.rental.application;



import Pack01.domain.rental.dto.RentalFindAllRespDto;
import Pack01.domain.rental.repository.RentalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class RentalReadServiceImp implements RentalReadService{
    private final RentalRepository rentalRepository;

    @Override
    public List<RentalFindAllRespDto> getRentals(Long member_id){
        return rentalRepository.findRentals(member_id)
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

    @Override
    public List<Long> findAllByExpireMembers() {
        return rentalRepository.findAllByExpireMembers();
    }
}
