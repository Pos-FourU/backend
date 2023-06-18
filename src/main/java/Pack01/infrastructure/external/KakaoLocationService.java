package Pack01.infrastructure.external;

import Pack01.infrastructure.external.kakao.KakaoApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class KakaoLocationService {
    public static final String KAKAO_AK = "KakaoAK ";
    private static final String KAKAO_LOCAL_ADDRESS_SEARCH_URL = "https://dapi.kakao.com/v2/local/search/address.json";
    private static final String KAKAO_SECRET_KEY = "7dd27a288371a30477c1c3a821f787c1";

    private final RestTemplate restTemplate;

    @Autowired
    public KakaoLocationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public KakaoApiResponse requestSearch(String query){
        URI uri = builderSearchURL(query);
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.AUTHORIZATION, KAKAO_AK + KAKAO_SECRET_KEY);
        return restTemplate
                .exchange(uri, HttpMethod.GET, new HttpEntity<>(headers), KakaoApiResponse.class)
                .getBody();
    }


    private URI builderSearchURL(String query){
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(KAKAO_LOCAL_ADDRESS_SEARCH_URL);
        uriBuilder.queryParam("query", query);
        return uriBuilder.build()
                .encode()
                .toUri();
    }
}
