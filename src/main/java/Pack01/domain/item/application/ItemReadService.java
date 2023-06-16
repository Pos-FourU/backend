package Pack01.domain.item.application;

import Pack01.domain.item.dto.ItemFindAllRespDto;

import java.util.List;

public interface ItemReadService {
    List<ItemFindAllRespDto> getAllItems();
}
