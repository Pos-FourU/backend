package Pack01.domain.item.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
public class CafeItem {
    private Long cafe_item_id;
    private Long cafe_id;
    private Long item_id;

    @Builder
    public CafeItem(Long cafe_item_id, Long cafe_id, Long item_id) {
        this.cafe_item_id = cafe_item_id;
        this.cafe_id = cafe_id;
        this.item_id = item_id;
    }
}
