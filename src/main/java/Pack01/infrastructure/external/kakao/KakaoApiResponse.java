package Pack01.infrastructure.external.kakao;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class KakaoApiResponse {
    @JsonProperty("documents")
    private List<Document> documentList;

    public List<Document> getDocumentList() {
        return documentList;
    }
}
