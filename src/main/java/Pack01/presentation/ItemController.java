package Pack01.presentation;

import Pack01.domain.cafe.application.CafeReadService;
import Pack01.domain.item.application.ItemReadService;
import Pack01.domain.item.application.ItemWriteServiceImp;
import Pack01.domain.item.application.ItemWriterService;
import Pack01.domain.item.dto.CafeItemDto;
import Pack01.domain.item.dto.ItemRegisterReqDto;
import Pack01.domain.item.entity.Item;
import Pack01.global.exception.FourUPerMissionException;
import Pack01.global.jwt.Jwt;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/item")
public class ItemController {
    private final ItemWriterService itemWriteService;
    private final ItemReadService itemReadService;
    private final CafeReadService cafeReadService;

    private final Jwt jwt = new Jwt();

    @GetMapping()
    public String addItem(){
       return "addItem";
    }

    @PostMapping ("/add")
    public String register(@RequestParam String status,
                           @RequestParam String category,HttpSession session){
        Object token1 = session.getAttribute("token");
        if(token1==null){
            throw new FourUPerMissionException("아이디 혹은 비밀번호가 잘못 되었습니다.");
        }
        Claims token = jwt.getJwtContents(token1.toString());
        Long member_id = Long.parseLong(token.get("id").toString());
        Long cafe_id = cafeReadService.findByMemberId(member_id);
        itemWriteService.register(ItemRegisterReqDto.builder()
                .category(category)
                .status(status)
                .build());
        List<Item> allItem = itemReadService.getAllItem();
        int size = allItem.size();
        Item item = allItem.get(size - 1);
        itemWriteService.registerCafeItem(CafeItemDto.builder()
                .item_id(item.getItem_id())
                .cafe_id(cafe_id)
                .build());
        return "redirect:/api/v1/admin/manageItem";
    }


}
