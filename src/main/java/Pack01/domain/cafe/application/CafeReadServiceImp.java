package Pack01.domain.cafe.application;

import Pack01.domain.cafe.dto.CafeFindRespDto;
import Pack01.domain.cafe.dto.CafeLeftCountRespDto;
import Pack01.domain.cafe.entity.Cafe;
import Pack01.domain.cafe.repository.CafeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CafeReadServiceImp implements CafeReadService {

    private final CafeRepository cafeRepository;

    @Override
    public List<CafeFindRespDto> findAll() {
        List<Cafe> all = cafeRepository.findAll();
        return all
                .stream()
                .map(cafe ->new CafeFindRespDto().builder()
                        .cafe_id(cafe.getCafe_id())
                        .cafe_name(cafe.getCafe_name())
                        .cafe_address(cafe.getCafe_address())
                        .cafe_latitude(cafe.getCafe_latitude())
                        .cafe_longitude(cafe.getCafe_longitude())
                        .build())
                .collect(Collectors.toList());
    }
    @Override
    public List<CafeLeftCountRespDto>  getLeftItemCount() {
        return cafeRepository.getCafeLeftItemCount();
    }

    @Override
    public Integer existCafeByMemberId(Long member_id) {
        return cafeRepository.existCafeByMemberId(member_id);
    }

}
