package Pack01.domain.member.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.regex.Pattern;

import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
public class Member {

    private Long member_id;
    private String member_email;
    private String member_pw;
    private String member_phone;
    private MemberRole member_role;
    private String member_name;
    private MemberStatus member_status;
    private Integer warning_count;
    private LocalDate create_at;
    private LocalDate update_at;

    @Builder
    public Member(Long member_id, String member_email, String member_pw, String member_phone, MemberRole member_role, String member_name, MemberStatus member_status, Integer warning_count, LocalDate create_at, LocalDate update_at) {
        isValidEmail(member_email);
        this.member_id = member_id;
        this.member_email = member_email;
        this.member_pw = member_pw;
        this.member_phone = member_phone;
        this.member_role = member_role;
        this.member_name = member_name;
        this.member_status = member_status;
        this.warning_count = warning_count;
        this.create_at = create_at;
        this.update_at = update_at;
    }

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    public static void isValidEmail(String email) {
        boolean matches = EMAIL_PATTERN.matcher(email).matches();
        if (!matches) {
            throw new RuntimeException();
        }
    }
}
