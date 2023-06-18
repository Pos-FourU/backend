package Pack01.domain.item.application;

import Pack01.domain.item.dto.ItemFindAllRespDto;
import Pack01.domain.item.entity.CafeItem;
import Pack01.domain.item.entity.Item;

import java.util.List;

public interface ItemReadService {
    List<ItemFindAllRespDto> getItems(Long member_id);
    List<Long> getCafeItem(Long cafe_id);
    List<Item> getAllItem();
}
