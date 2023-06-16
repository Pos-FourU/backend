package Pack01.domain.cafe.application;

import Pack01.domain.cafe.dto.CafeFindRespDto;
import Pack01.domain.cafe.dto.CafeLeftCountRespDto;

import java.util.List;

public interface CafeReadService {
    List<CafeFindRespDto> findAll();

    List<CafeLeftCountRespDto> getLeftItemCount() ;
}
