package Pack01.presentation;

import Pack01.domain.item.application.ItemReadService;
import Pack01.domain.member.application.MemberReadService;
import Pack01.domain.member.application.MemberWriteService;
import Pack01.domain.member.dto.AdminLoginReqDto;
import Pack01.domain.member.dto.MemberRegisterReqDto;
import Pack01.domain.rental.application.RentalReadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin")
public class AdminController {

    private final MemberWriteService memberWriteService;
    private final MemberReadService memberReadService;
    private final ItemReadService itemReadService;
    private final RentalReadService rentalReadService;

    @PostMapping("/login")
    public String LoginAdmin(AdminLoginReqDto adminLoginReqDto){
//        memberReadService.loginAdmin(adminLoginReqDto);
        return "redirect:/api/v1/admin/manageRental";
    }

    @GetMapping()
    public String AccessAdminPage(){
        return "adminIndex";
    }

//    @PostMapping("/registerAdmin")
//    public String Register(MemberRegisterReqDto memberRegisterReqDto){
//        memberWriteService.registerCafeAdmin(memberRegisterReqDto);
//
//        return "registerAdmin";
//    }

    @GetMapping("/manageItem")
    public String showItem(Model model){
        model.addAttribute("items",itemReadService.getAllItems());
        return "manageItem";
    }

    @GetMapping("/manageRental")
    public String showRental(Model model){
        model.addAttribute("rentals", rentalReadService.getAllRentals());
        return "manageRental";
    }
}
