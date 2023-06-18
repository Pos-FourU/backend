package Pack01.domain.rental.application;

import Pack01.domain.rental.dto.RentalFindAllRespDto;

import java.util.List;

public interface RentalReadService {
    List<RentalFindAllRespDto> getRentals(Long cafe_id);
    List<Long> findAllByExpireMembers();
}
