package Pack01.domain.rental.application;

import Pack01.domain.rental.dto.RentalInsertReqDto;

public interface RentalWriteService {
void deleteExpiredRentals();

void insertRentals(RentalInsertReqDto rentalInsertReqDto);
}
