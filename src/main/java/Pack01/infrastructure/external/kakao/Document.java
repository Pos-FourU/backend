package Pack01.infrastructure.external.kakao;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Document {

    @JsonProperty("address_name")
    private String addressName;
    @JsonProperty("y")
    private double latitude;
    @JsonProperty("x")
    private double longitude;


    public String getAddressName() {
        return addressName;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
