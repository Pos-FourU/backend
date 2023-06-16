package Pack01.presentation;

import Pack01.domain.item.application.ItemReadServiceImp;
import Pack01.domain.member.application.MemberReadService;
import Pack01.domain.member.application.MemberReadServiceImp;
import Pack01.domain.member.application.MemberWriteService;
import Pack01.domain.member.application.MemberWriteServiceImp;
import Pack01.domain.member.dto.AdminLoginReqDto;
import Pack01.domain.member.entity.MemberRole;
import Pack01.domain.rental.application.RentalReadServiceImp;
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

    private final MemberWriteServiceImp memberWriteServiceImp;
    private final MemberReadService memberReadService;
    private final ItemReadServiceImp itemReadServiceImp;
    private final RentalReadServiceImp rentalReadServiceImp;

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
        model.addAttribute("items", itemReadServiceImp.getAllItems());
        return "manageItem";
    }

//    @PostMapping("/manageItem")
//    public String updateItemStatus(Model model){
//    }

    @GetMapping("/manageRental")
    public String showRental(Model model){
        model.addAttribute("rentals", rentalReadServiceImp.getAllRentals());
        return "manageRental";
    }

    @GetMapping("/manageMember")
    public String showMember(Model model){
        model.addAttribute("members", memberReadService.getMembers(null));
        return "manageMember";
    }

    @GetMapping("/manageManager")
    public String showManager(Model model){
        model.addAttribute("managers", memberReadService.getManagers());
        return "manageManager";
    }

}
