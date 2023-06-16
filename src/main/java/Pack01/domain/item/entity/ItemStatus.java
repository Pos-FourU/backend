package Pack01.domain.item.entity;

public enum ItemStatus {
    VALID("valid"), INVALID("invalid"), DAMAGED("damaged");

    private String status;

    ItemStatus(String status){this.status=status;}

    public static ItemStatus getItemStatus(String s){
        return ItemStatus.valueOf(s);
    }
}
