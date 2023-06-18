package Pack01.presentation;

import Pack01.domain.item.application.ItemWriteServiceImp;
import Pack01.domain.item.dto.ItemRegisterReqDto;
import Pack01.global.exception.FourUPerMissionException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/item")
public class ItemController {
    private final ItemWriteServiceImp itemWriteServiceImp;

    @PostMapping()
    public String register(ItemRegisterReqDto itemRegisterReqDto, HttpSession session){
        Object token1 = session.getAttribute("token");
        if(token1==null){
            throw new FourUPerMissionException("아이디 혹은 비밀번호가 잘못 되었습니다.");
        }
        itemWriteServiceImp.register(itemRegisterReqDto);

        return "showItem";
    }

}
