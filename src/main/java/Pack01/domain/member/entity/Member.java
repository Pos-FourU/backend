package Pack01.domain.member.entity;

import lombok.AccessLevel;
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
    private String member_phonenum;
    private MemberRole memberRole;
    private String member_name;
   private LocalDate create_at;
   private LocalDate update_at;

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    public static void isValidEmail(String email) {
        boolean matches = EMAIL_PATTERN.matcher(email).matches();
        if(!matches){
            throw new RuntimeException();
        }
    }

    @Builder
    public Member(Long member_id, String member_email, String member_pw, String member_phonenum, MemberRole memberRole, String member_name, LocalDate create_at, LocalDate update_at) {
        isValidEmail(member_email);
        this.member_id = member_id;
        this.member_email = member_email;
        this.member_pw = member_pw;
        this.member_phonenum = member_phonenum;
        this.memberRole = memberRole;
        this.member_name = member_name;
        this.create_at = create_at;
        this.update_at = update_at;
    }

    public static Member of(String member_email,String member_pw,String member_phonenum,String member_name){
        return Member.builder()
                .member_email(member_email)
                .member_pw(member_pw)
                .member_phonenum(member_phonenum)
                .memberRole(MemberRole.USER)
                .member_name(member_name)
                .create_at(LocalDate.now())
                .update_at(LocalDate.now())
                .build();
    }

    public void updateMember_email(String member_email) {
        this.member_email = member_email;
    }

    public void updateMember_pw(String member_pw) {
        this.member_pw = member_pw;
    }


    public void updateUserRole(MemberRole memberRole) {
        this.memberRole = memberRole;
    }

    public void setUpdate_at(LocalDate update_at) {
        this.update_at = update_at;
    }
}
