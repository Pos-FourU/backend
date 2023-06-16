package Pack01.presentation;

import Pack01.domain.item.application.ItemWriteService;
import Pack01.domain.item.dto.ItemRegisterReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/item")
public class ItemController {
    private final ItemWriteService itemWriteService;

    @PostMapping()
    public String register(ItemRegisterReqDto itemRegisterReqDto){
        itemWriteService.register(itemRegisterReqDto);

        return "showItem";
    }

}
