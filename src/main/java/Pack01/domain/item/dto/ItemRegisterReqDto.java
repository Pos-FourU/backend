package Pack01.domain.item.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ItemRegisterReqDto {
    private String category;
    private String status;

    @Builder
    public ItemRegisterReqDto(String category, String status) {
        this.category = category;
        this.status = status;
    }
}
