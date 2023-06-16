package Pack01.domain.cafe.application;

import Pack01.domain.cafe.dto.CafeFindRespDto;
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
public class CafeReadService {

    private final CafeRepository cafeRepository;
    public List<CafeFindRespDto> findAll() {
        List<Cafe> all = cafeRepository.findAll();
        return all
                .stream()
                .map(cafe -> new CafeFindRespDto()
                        .of(cafe.getCafe_id(),
                        cafe.getMember_id(),
                        cafe.getCafe_name(),
                        cafe.getCafe_address(),
                        cafe.getCafe_latitude(),
                        cafe.getCafe_longitude()))
                .collect(Collectors.toList());
    }

}
