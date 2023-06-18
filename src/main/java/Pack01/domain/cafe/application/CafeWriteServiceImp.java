package Pack01.domain.cafe.application;

import Pack01.domain.cafe.dto.CafeRegisterReqDto;
import Pack01.domain.cafe.entity.Cafe;
import Pack01.domain.cafe.repository.CafeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@Transactional
@RequiredArgsConstructor
public class CafeWriteServiceImp implements CafeWriteService {

    private final CafeRepository cafeRepository;

    public void register(CafeRegisterReqDto cafeRegisterReqDto) {
        Cafe cafe = Cafe.builder()
                .member_id(cafeRegisterReqDto.getMember_id())
                .cafe_address(cafeRegisterReqDto.getCafe_address())
                .cafe_longitude(cafeRegisterReqDto.getCafe_longitude())
                .cafe_latitude(cafeRegisterReqDto.getCafe_latitude())
                .cafe_name(cafeRegisterReqDto.getCafe_name())
                .create_at(LocalDate.now())
                .update_at(LocalDate.now())
                .build();
        cafeRepository.registerCafe(cafe);
    }

    @Override
    public void deleteByCafeId(Long cafe_id) {
        cafeRepository.deleteCafeByMemberId(cafe_id);
    }
}
