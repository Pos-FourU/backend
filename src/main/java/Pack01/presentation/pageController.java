package Pack01.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class pageController {
    @RequestMapping("/map")
    public String mapfunc(){
        return "mapView";
    }
}
