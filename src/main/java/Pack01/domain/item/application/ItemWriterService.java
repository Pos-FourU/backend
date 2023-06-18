package Pack01.domain.item.application;

import Pack01.domain.item.dto.ItemRegisterReqDto;

import java.util.List;

public interface ItemWriterService {
    void register(ItemRegisterReqDto itemRegisterReqDto);
    void deleteByItemId(List<Long> itemId);
}
