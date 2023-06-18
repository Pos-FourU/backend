package Pack01.presentation;

import Pack01.domain.item.application.ItemReadService;
import Pack01.domain.member.application.MemberReadService;
import Pack01.domain.member.application.MemberWriteService;
import Pack01.domain.member.dto.MemberFindAllRespDto;
import Pack01.domain.member.dto.MemberRegisterReqDto;
import Pack01.domain.member.dto.MemberUpdateReqDto;
import Pack01.domain.member.entity.MemberRole;
import Pack01.domain.rental.application.RentalReadService;
import Pack01.domain.rental.application.RentalWriteService;
import Pack01.domain.rental.dto.RentalInsertReqDto;
import Pack01.global.jwt.Jwt;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Iterator;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin")
public class AdminController {

    private final MemberWriteService memberWriteService;
    private final MemberReadService memberReadService;
    private final ItemReadService itemReadService;
    private final RentalReadService rentalReadService;
    private final RentalWriteService rentalWriteService;
    private final Jwt jwt = new Jwt();



//    @PostMapping("/registerAdmin")
//    public String Register(MemberRegisterReqDto memberRegisterReqDto){
//        memberWriteService.registerCafeAdmin(memberRegisterReqDto);
//
//        return "registerAdmin";
//    }

    @GetMapping("/manageItem")
    public String showItem(Model model, HttpSession session){
        Long member_id = Long.parseLong(jwt.getJwtContents(session.getAttribute("token").toString()).get("id").toString());
        model.addAttribute("items", itemReadService.getItems(member_id));
        return "manageItem";
    }

//    @PostMapping("/manageItem")
//    public String updateItemStatus(Model model){
//    }

    @GetMapping("/manageRental")
    public String showRental(Model model, HttpSession session){
        Long member_id = Long.parseLong(jwt.getJwtContents(session.getAttribute("token").toString()).get("id").toString());
        model.addAttribute("rentals", rentalReadService.getRentals(member_id));
        return "manageRental";
    }

    @GetMapping("/manageMember")
    public String showMember(Model model){
        List<MemberFindAllRespDto> members = memberReadService.getMembers(null);
        Iterator<MemberFindAllRespDto> iterator = members.iterator();
        while (iterator.hasNext()) {
            MemberFindAllRespDto member = iterator.next();
            if (member.getMember_role() == MemberRole.ADMIN) {
                iterator.remove();
                break;
            }
        }
        model.addAttribute("members", members);
        return "manageMember";
    }

    @GetMapping("/manageManager")
    public String showManager(Model model){
        model.addAttribute("managers", memberReadService.getManagers());
        return "manageManager";
    }
    @GetMapping("/updateRole")
    public String updateRole(@RequestParam Long admin, @RequestParam Long member_id, @RequestParam String role){
        memberWriteService.updateMember(MemberUpdateReqDto.builder()
                .admin_id(admin)
                .member_id(member_id)
                .member_role(MemberRole.valueOf(role))
                .build());
        return "redirect:/api/v1/admin/manageMember";
    }

    @PostMapping("/insertRentalInfo")
    public String applyRentalInfo(RentalInsertReqDto rentalInsertReqDto){
        if(!rentalWriteService.insertRentals(rentalInsertReqDto)) {
            return "alreadyRentOK";
        }
        return "redirect:/api/v1/admin/manageItem";
    }
}
