package Pack01.domain.member.entity;

public enum MemberStatus {

    RESERVATION("reservation"), RENTAL("rental"), ABLE("able");

    private String status;

    MemberStatus(String status){
        this.status = status;
    }

    public static MemberStatus getMemberStatus(String s){

        return MemberStatus.valueOf(s);
    }

}
