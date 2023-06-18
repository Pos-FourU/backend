package Pack01.presentation;

import Pack01.domain.cafe.application.CafeWriteService;
import Pack01.domain.item.application.ItemReadService;
import Pack01.domain.item.application.ItemWriterService;
import Pack01.domain.member.application.MemberReadService;
import Pack01.domain.member.application.MemberWriteService;
import Pack01.domain.member.dto.MemberFindAllRespDto;
import Pack01.domain.member.dto.MemberUpdateReqDto;
import Pack01.domain.member.entity.MemberRole;
import Pack01.domain.rental.application.RentalReadService;
import Pack01.domain.rental.application.RentalWriteService;
import Pack01.domain.rental.dto.RentalInsertReqDto;
import Pack01.domain.reservation.application.ReservationReadService;
import Pack01.global.exception.FourUAdminException;
import Pack01.global.exception.FourUPerMissionException;
import Pack01.global.jwt.Jwt;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    private final ItemWriterService itemWriterService;
    private final RentalReadService rentalReadService;
    private final RentalWriteService rentalWriteService;
    private final CafeWriteService cafeWriteService;
    private final ReservationReadService reservationReadService;

    private final Jwt jwt = new Jwt();


//    @PostMapping("/registerAdmin")
//    public String Register(MemberRegisterReqDto memberRegisterReqDto){
//        memberWriteService.registerCafeAdmin(memberRegisterReqDto);
//
//        return "registerAdmin";
//    }

    @GetMapping("/manageItem")
    public String showItem(Model model, HttpSession session) {
        Object token1 = session.getAttribute("token");
        if (token1 == null) {
            throw new FourUPerMissionException("아이디 혹은 비밀번호가 잘못 되었습니다.");
        }
        Long member_id = Long.parseLong(jwt.getJwtContents(token1.toString()).get("id").toString());
        model.addAttribute("items", itemReadService.getItems(member_id));
        return "manageItem";
    }

    @PostMapping("/deleteCafe")
    public String updateItemStatus(@RequestParam Long cafe_id, @RequestParam Long member_id, HttpSession session) {
        Object token1 = session.getAttribute("token");
        if (token1 == null) {
            throw new FourUPerMissionException("아이디 혹은 비밀번호가 잘못 되었습니다.");
        }
        List<Long> cafeItem = itemReadService.getCafeItem(cafe_id);
        cafeWriteService.deleteByCafeId(cafe_id);
        itemWriterService.deleteByItemId(cafeItem);
        memberWriteService.deleteByMemberId(member_id);
        return "redirect:/api/v1/admin/manageMember";
    }

    @GetMapping("/manageRental")
    public String showRental(Model model, HttpSession session) {
        Object token1 = session.getAttribute("token");
        if (token1 == null) {
            throw new FourUPerMissionException("아이디 혹은 비밀번호가 잘못 되었습니다.");
        }
        Long member_id = Long.parseLong(jwt.getJwtContents(token1.toString()).get("id").toString());
        model.addAttribute("rentals", rentalReadService.getRentals(member_id));
        return "manageRental";
    }

    @GetMapping("/manageReservation")
    public String showReservation(Model model, HttpSession session) {
        String token = session.getAttribute("token").toString();
        if (token == null) {
            throw new FourUAdminException("유효하지 않은 토큰입니다.");
        }
        Long member_id = Long.parseLong(jwt.getJwtContents(token).get("id").toString());
        model.addAttribute("reservations", reservationReadService.getReservations(member_id));
        return "manageReservation";
    }

    @GetMapping("/manageMember")
    public String showMember(Model model, HttpSession session) {
        Object token1 = session.getAttribute("token");
        if (token1 == null) {
            throw new FourUPerMissionException("아이디 혹은 비밀번호가 잘못 되었습니다.");
        }
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
    public String showManager(Model model, HttpSession session) {
        Object token1 = session.getAttribute("token");
        if (token1 == null) {
            throw new FourUPerMissionException("아이디 혹은 비밀번호가 잘못 되었습니다.");
        }
        model.addAttribute("managers", memberReadService.getManagers());
        return "manageManager";
    }

    @GetMapping("/updateRole")
    public String updateRole(@RequestParam Long member_id,
                             @RequestParam String role,
                             HttpSession session) {
        Object token1 = session.getAttribute("token");
        if (token1 == null) {
            throw new FourUPerMissionException("아이디 혹은 비밀번호가 잘못 되었습니다.");
        }
        memberWriteService.updateMember(MemberUpdateReqDto.builder()
                .member_id(member_id)
                .member_role(MemberRole.valueOf(role))
                .build());
        return "redirect:/api/v1/admin/manageMember";
    }

    @PostMapping("/insertRentalInfo")
    public String applyRentalInfo(RentalInsertReqDto rentalInsertReqDto) {
        if (!rentalWriteService.insertRentals(rentalInsertReqDto)) {
            return "alreadyRentOK";
        }
        return "redirect:/api/v1/admin/manageItem";
    }

    @PostMapping("/manageRental")
    public String returnItem(@RequestParam Long rental_id, @RequestParam Long member_id, @RequestParam Long item_id, @RequestParam String rental_time, @RequestParam String return_time, @RequestParam String rental_days){
        rentalReadService.returnRentals(rental_id, member_id, item_id, rental_time, return_time, rental_days);
        return "redirect:/api/v1/admin/manageRental";
    }
}
