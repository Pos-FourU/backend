package Pack01.domain.rental.application;

import Pack01.domain.rental.dto.RentalFindAllRespDto;

import java.util.List;

public interface RentalReadService {
    List<RentalFindAllRespDto> getAllRentals();
    List<Long> findAllByExpireMembers();
    Integer countThismonth(Long member_id);
}
