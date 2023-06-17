package Pack01.presentation;

import Pack01.domain.cafe.application.CafeReadService;
import Pack01.domain.cafe.application.CafeWriteService;
import Pack01.domain.cafe.dto.CafeLeftCountRespDto;
import Pack01.domain.cafe.dto.CafeRegisterReqDto;
import Pack01.domain.reservation.application.ReservationWriteService;
import Pack01.domain.reservation.dto.ReservationRegisterDto;
import Pack01.infrastructure.external.KakaoLocationService;
import Pack01.infrastructure.external.kakao.Document;
import Pack01.infrastructure.external.kakao.KakaoApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/cafe")
public class CafeController {

    private final CafeReadService cafeReadService;
    private final CafeWriteService cafeWriteService;
    private final ReservationWriteService reservationWriteService;
    private final KakaoLocationService kakaoLocationService;

    @GetMapping("/map")
    public String Findfunc(Model model) {
        List<CafeLeftCountRespDto> leftItemCount = cafeReadService.getLeftItemCount();
        model.addAttribute("leftItemCount", leftItemCount);
        return "mapView";
    }

    @GetMapping("/rent")
    public String Rent(@RequestParam Long cafe_id, @RequestParam Long member_id) {
        ReservationRegisterDto reservationRegisterDto = ReservationRegisterDto.builder()
                .cafe_id(cafe_id)
                .member_id(member_id)
                .build();
        reservationWriteService.register(reservationRegisterDto);
        return "success";
    }

    @PostMapping("/register")
    public String register(@RequestParam Long member_id,
                           @RequestParam String cafe_name,
                           @RequestParam String cafe_address
                          ) {
        KakaoApiResponse kakaoApiResponse = kakaoLocationService.requestSearch(cafe_address);
        Document document = kakaoApiResponse.getDocumentList().get(0);
        CafeRegisterReqDto cafeRegisterReqDto = CafeRegisterReqDto.builder()
                .member_id(member_id)
                .cafe_name(cafe_name)
                .cafe_address(cafe_address)
                .cafe_latitude((float)document.getLatitude())
                .cafe_longitude((float)document.getLongitude())
                .build();
        cafeWriteService.register(cafeRegisterReqDto);
        return "redirect:/api/v1/admin/manageMember";
    }

}
