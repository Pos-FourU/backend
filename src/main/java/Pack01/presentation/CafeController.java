package Pack01.presentation;

import Pack01.domain.cafe.application.CafeReadService;
import Pack01.domain.cafe.dto.CafeFindReqDto;
import Pack01.domain.cafe.entity.Cafe;
import Pack01.domain.member.application.MemberWriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/cafe")
public class CafeController {

    private final CafeReadService cafeReadService;
    @GetMapping("/map")
    public String Findfunc(Model model){
        List<Cafe> cafeList = cafeReadService.findAll();

        model.addAttribute("cafeList",cafeList);
        return "mapView";
    }

    @GetMapping("/rent")
    public String Rent(@RequestParam Long cafe_id,Model model){
        model.addAttribute("cafe_id",cafe_id);
        return "reservation";
    }

}
