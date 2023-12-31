package Pack01.domain.member.entity;

public enum MemberRole {
    ADMIN("admin"), MANAGER("manager"), USER("user"), BLACK_LIST("black");

    private String role;

    MemberRole(String role){
        this.role = role;
    }

    public static MemberRole getMemberRole(String s){
        return MemberRole.valueOf(s);
    }

}
