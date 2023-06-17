package Pack01.presentation;

import Pack01.infrastructure.external.KakaoLocationService;
import Pack01.infrastructure.external.kakao.KakaoApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KakaoSearchController {

    private final KakaoLocationService kakaoLocationService;

    @Autowired
    public KakaoSearchController(KakaoLocationService kakaoLocationService) {
        this.kakaoLocationService = kakaoLocationService;
    }

    @GetMapping("/api/v1/search")
    public KakaoApiResponse getKakaoSearch(@RequestParam String query) {
        return kakaoLocationService.requestSearch(query);
    }
}