package Pack01.domain.item.application;

import Pack01.domain.item.dto.ItemRegisterReqDto;
import Pack01.domain.item.entity.Item;
import Pack01.domain.item.entity.ItemCategory;
import Pack01.domain.item.entity.ItemStatus;
import Pack01.domain.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemWriteServiceImp implements ItemWriterService{
    private final ItemRepository itemRepository;

    @Override
    public void register(ItemRegisterReqDto itemRegisterReqDto){
        Item item = Item.of(
                ItemStatus.VALID,
                ItemCategory.getItemCategory(itemRegisterReqDto.getCategory()));
        itemRepository.registerItem(item);
    }
}
