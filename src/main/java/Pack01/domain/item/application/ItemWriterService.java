package Pack01.domain.item.application;

import Pack01.domain.item.dto.ItemRegisterReqDto;

public interface ItemWriterService {
    void register(ItemRegisterReqDto itemRegisterReqDto);
}
