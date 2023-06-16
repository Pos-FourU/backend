package Pack01.domain.member.entity;

public enum MemberStatus {

    public static MemberStatus getMemberRole(String s){

    RESERVATION("reservation"), RENTAL("rental"), ABLE("able");

    private String status;

    MemberStatus(String status){
        this.status = status;
    }

    public static MemberStatus getMemberStatus(String s){

        return MemberStatus.valueOf(s);
    }

}
