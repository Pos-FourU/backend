package Pack01.domain.rental.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class RentalInsertReqDto {
    private String member_email;
    private String rental_days;
    private String cafe_manager_id;
    private String item_id;
    private String rental_time;

    @Builder
    public RentalInsertReqDto(String item_id, String cafe_manager_id,  String rental_time, String member_email, String rental_days) {
        this.member_email = member_email;
        this.rental_days = rental_days;
        this.cafe_manager_id = cafe_manager_id;
        this.item_id = item_id;
        this.rental_time = rental_time;
    }
}
