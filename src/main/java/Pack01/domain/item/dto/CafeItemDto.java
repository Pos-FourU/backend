package Pack01.domain.item.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CafeItemDto {
    private Long cafe_id;
    private Long item_id;

    @Builder
    public CafeItemDto(Long cafe_id, Long item_id) {
        this.cafe_id = cafe_id;
        this.item_id = item_id;
    }
}
