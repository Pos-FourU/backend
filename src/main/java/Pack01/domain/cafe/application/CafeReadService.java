package Pack01.domain.cafe.application;

import Pack01.domain.cafe.dto.CafeFindReqDto;
import Pack01.domain.cafe.entity.Cafe;
import Pack01.domain.cafe.repository.CafeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CafeReadService {

    private final CafeRepository cafeRepository;
    public List<Cafe> findAll() {
        return cafeRepository.findAll();
    }

}
