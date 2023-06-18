package Pack01.domain.item.application;

import Pack01.domain.item.dto.ItemFindAllRespDto;
import Pack01.domain.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemReadServiceImp implements ItemReadService{
    private final ItemRepository itemRepository;

    @Override
    public List<ItemFindAllRespDto> getItems(Long member_id){
        return itemRepository.findItems(member_id)
                .stream()
                .map(item-> new ItemFindAllRespDto().builder()
                        .item_id(item.getItem_id())
                        .item_status(item.getItem_status())
                        .category(item.getCategory())
                        .build())
                .collect(Collectors.toList());
    }
}
