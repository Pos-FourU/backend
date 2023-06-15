package Pack01.presentation;

import Pack01.domain.cafe.application.CafeReadService;
import Pack01.domain.cafe.dto.CafeFindReqDto;
import Pack01.domain.cafe.entity.Cafe;
import Pack01.domain.member.application.MemberWriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CafeController {

    private final CafeReadService cafeReadService;
    @RequestMapping("/map")
    public String Findfunc(Model model){
        List<Cafe> cafeList = cafeReadService.findAll();

        model.addAttribute("cafeList",cafeList);
        return "mapView";
    }




}
