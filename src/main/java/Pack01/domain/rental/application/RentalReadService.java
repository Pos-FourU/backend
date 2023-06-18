package Pack01.domain.rental.application;

import Pack01.domain.rental.dto.RentalFindAllRespDto;

import java.util.List;

public interface RentalReadService {
    List<RentalFindAllRespDto> getRentals(Long cafe_id);
    List<Long> findAllByExpireMembers();
    Integer countThismonth(Long member_id);

    public void returnRentals(Long rental_id, Long member_id, Long item_id, String rental_time, String return_time, String rental_days);
}
