package Pack01.domain.item.dto;

import Pack01.domain.item.entity.Item;
import Pack01.domain.item.entity.ItemCategory;
import Pack01.domain.item.entity.ItemStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ItemFindAllRespDto {
    private Long item_id;
    private ItemStatus item_status;
    private ItemCategory category;

    @Builder
    public ItemFindAllRespDto(Long item_id, ItemStatus item_status, ItemCategory category) {
        this.item_id = item_id;
        this.item_status = item_status;
        this.category = category;
    }
}
