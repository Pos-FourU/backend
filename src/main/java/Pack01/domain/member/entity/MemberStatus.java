package Pack01.domain.member.entity;

public enum MemberStatus {
    ADMIN("admin"), CAFE_ADMIN("cafe_admin"), USER("user"), BLACK_LIST("black");

    private String role;

    MemberStatus(String role){
        this.role = role;
    }

    public static MemberStatus getMemberRole(String s){
        return MemberStatus.valueOf(s);
    }

}
