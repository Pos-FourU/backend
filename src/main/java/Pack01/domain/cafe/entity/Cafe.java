package Pack01.domain.cafe.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.regex.Pattern;

import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
public class Cafe {

    private Long cafe_id;
    private Long member_id;
    private String cafe_name;
    private String cafe_address;
    private Float cafe_latitude;
    private Float cafe_longitude;
    private LocalDate create_at;
    private LocalDate update_at;


    @Builder
    public Cafe(Long cafe_id, Long member_id, String cafe_name, String cafe_address, Float cafe_latitude, Float cafe_longitude, LocalDate create_at, LocalDate update_at) {
        this.cafe_id = cafe_id;
        this.member_id = member_id;
        this.cafe_name = cafe_name;
        this.cafe_address = cafe_address;
        this.cafe_latitude = cafe_latitude;
        this.cafe_longitude = cafe_longitude;
        this.create_at = create_at;
        this.update_at = update_at;
    }

    public static Cafe of(Long cafe_id, Long member_id, String cafe_name, String cafe_address, Float cafe_latitude, Float cafe_longitude, LocalDate create_at, LocalDate update_at){
        return Cafe.builder()
                .cafe_id(cafe_id)
                .cafe_name(cafe_name)
                .cafe_address(cafe_address)
                .cafe_latitude(cafe_latitude)
                .cafe_longitude(cafe_longitude)
                .create_at(LocalDate.now())
                .update_at(LocalDate.now())
                .build();
    }


//    public void updateMember_pw(String member_pw) {
//        this.member_pw = member_pw;
//    }
//
//
//    public void updateUserRole(MemberRole memberRole) {
//        this.memberRole = memberRole;
//    }
//
//    public void setUpdate_at(LocalDate update_at) {
//        this.update_at = update_at;
//    }
}
