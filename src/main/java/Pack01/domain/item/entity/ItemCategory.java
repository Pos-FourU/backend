package Pack01.domain.item.entity;

public enum ItemCategory {

    텀블러("텀블러"), 우산("우산"), 담요("담요");

    private String category;

    ItemCategory(String category) {
        this.category = category;
    }

    public static ItemCategory getItemCategory(String s) {
        return ItemCategory.valueOf(s);
    }
}
