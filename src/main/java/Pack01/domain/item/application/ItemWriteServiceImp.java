package Pack01.domain.item.application;

import Pack01.domain.item.dto.CafeItemDto;
import Pack01.domain.item.dto.ItemRegisterReqDto;
import Pack01.domain.item.entity.Item;
import Pack01.domain.item.entity.ItemCategory;
import Pack01.domain.item.entity.ItemStatus;
import Pack01.domain.item.repository.CafeItemRepository;
import Pack01.domain.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemWriteServiceImp implements ItemWriterService{
    private final ItemRepository itemRepository;
    private final CafeItemRepository cafeItemRepository;

    @Override
    public void register(ItemRegisterReqDto itemRegisterReqDto){
        Item item = Item.of(
                ItemStatus.valueOf(itemRegisterReqDto.getStatus()),
                ItemCategory.getItemCategory(itemRegisterReqDto.getCategory()));
        itemRepository.registerItem(item);
    }

    @Override
    public void registerCafeItem(CafeItemDto cafeItemDto) {
        cafeItemRepository.register(cafeItemDto.getCafe_id(),cafeItemDto.getItem_id());
    }

    @Override
    public void deleteByItemId(List<Long> itemIds) {
        if(itemIds.isEmpty()){
            return;
        }
        itemRepository.deleteByItemIds(itemIds);
    }
}
