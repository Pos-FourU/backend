package Pack01.domain.cafe.application;

import Pack01.domain.cafe.dto.CafeFindRespDto;

import java.util.List;

public interface CafeReadService {
    List<CafeFindRespDto> findAll();
}
