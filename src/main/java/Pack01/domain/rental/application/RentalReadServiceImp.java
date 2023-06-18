package Pack01.domain.rental.application;



import Pack01.domain.item.repository.ItemRepository;
import Pack01.domain.rental.dto.RentalFindAllRespDto;
import Pack01.domain.rental.repository.RentalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class RentalReadServiceImp implements RentalReadService{
    private final RentalRepository rentalRepository;
    private final ItemRepository itemRepository;

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
                        .rental_days(rental.getRental_days())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public List<Long> findAllByExpireMembers() {
        return rentalRepository.findAllByExpireMembers();
    }

    @Override
    public void returnRentals(Long rental_id, Long member_id, Long item_id, String rental_time, String return_time, String rental_days){
        itemRepository.updateItem(item_id, "VALID");

        rentalRepository.updateReturnTime(return_time, rental_id);
    }

    @Override
    public Integer countThismonth(Long member_id) {
        return rentalRepository.countThismonth(member_id);
    }
}
