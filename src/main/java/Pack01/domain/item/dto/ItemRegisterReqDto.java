package Pack01.domain.item.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ItemRegisterReqDto {
    private String category;

    @Builder
    public ItemRegisterReqDto(String category){
        this.category = category;
    }
}
