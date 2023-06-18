package Pack01.domain.rental.application;

import Pack01.domain.cafe.repository.CafeRepository;
import Pack01.domain.item.repository.ItemRepository;
import Pack01.domain.member.entity.Member;
import Pack01.domain.member.repository.MemberRepository;
import Pack01.domain.rental.dto.RentalInsertReqDto;
import Pack01.domain.rental.entity.Rental;
import Pack01.domain.rental.repository.RentalRepository;
import Pack01.global.exception.FourUAdminException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Service
@RequiredArgsConstructor
@Transactional
public class RentalWriteServiceImp implements RentalWriteService{

    private final RentalRepository rentalRepository;
    private final MemberRepository memberRepository;
    private final CafeRepository cafeRepository;
    private final ItemRepository itemRepository;

    @Override
    public void deleteExpiredRentals() {
        rentalRepository.deleteExpiredRentals();
    }

    @Override
    public boolean insertRentals(RentalInsertReqDto rentalInsertReqDto) {
        Member member = memberRepository.findByEmail(rentalInsertReqDto.getMember_email());
        Long member_id = member.getMember_id();
        if(rentalRepository.isNotRental(member_id)) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date rentalTime;
            try {
                rentalTime = formatter.parse(rentalInsertReqDto.getRental_time());
            } catch (ParseException e) {
                System.out.println(e.getMessage());
                throw new RuntimeException();
            }
            Calendar c = Calendar.getInstance();
            c.setTime(rentalTime);
            c.add(Calendar.DATE, (Integer.parseInt(rentalInsertReqDto.getRental_days()) - 1));
            Date rentalDay = c.getTime();

            Long cafe_id = cafeRepository.findByCafeManagerID(Long.parseLong(rentalInsertReqDto.getCafe_manager_id())).getCafe_id();
            Long item_id = Long.parseLong(rentalInsertReqDto.getItem_id());

            Rental rental = Rental.builder()
                    .member_id(member_id)
                    .item_id(item_id)
                    .cafe_id(cafe_id)
                    .rental_time(rentalTime)
                    .return_time(null)
                    .rental_days(rentalDay)
                    .build();

            rentalRepository.insertRental(rental);
            itemRepository.updateItem(item_id, "INVALID");

            return true;
        }
        else{
            return false;
        }
    }
}
