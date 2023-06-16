package Pack01.domain.item.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
public class Item {

    private Long item_id;
    private ItemStatus item_status;
    private ItemCategory category;
    private LocalDate create_at;
    private LocalDate update_at;


    @Builder
    public Item(Long item_id, ItemStatus item_status, ItemCategory category, LocalDate create_at, LocalDate update_at) {
        this.item_id = item_id;
        this.item_status = item_status;
        this.category = category;
        this.create_at = create_at;
        this.update_at = update_at;
    }

    public static Item of(ItemStatus itemStatus,ItemCategory category) {
        return Item.builder()
                .item_status(itemStatus)
                .category(category)
                .create_at(LocalDate.now())
                .update_at(LocalDate.now())
                .build();
    }

    public void updateItem_status(ItemStatus item_status) {
        this.item_status = item_status;
    }

    public void setUpdate_at(LocalDate update_at) {
        this.update_at = update_at;
    }
}
