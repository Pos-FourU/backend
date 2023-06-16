package Pack01.domain.waiting.entity;

import Pack01.domain.member.entity.MemberRole;

public enum Waiting_status {
    RESERVATION("reservation"), RENTAL("rental"), ABLE("able");

    private String status;

    Waiting_status(String status){
        this.status = status;
    }

    public static MemberRole getMemberRole(String s){
        return MemberRole.valueOf(s);
    }
}
