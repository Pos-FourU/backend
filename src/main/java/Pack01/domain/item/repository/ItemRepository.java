package Pack01.domain.item.repository;

import Pack01.domain.item.entity.Item;
import Pack01.domain.item.entity.ItemCategory;
import Pack01.domain.item.entity.ItemStatus;
import Pack01.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private static final String TABLE = "items";

    private final JdbcTemplate jdbcTemplate;

    public void registerItem(Item item) {

        String sql = "INSERT INTO " + TABLE + " (item_status, category, create_at, update_at) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                item.getItem_status(),
                item.getCategory(),
                item.getCreate_at(),
                item.getUpdate_at());
    }

    public List<Item> findAllItems(){
        String sql = "SELECT * FROM Items";
        return jdbcTemplate.query(sql, new ItemRowMapper());
    }

    public int getCafeAllItemCounts(Long cafeId) {
        String sql = "SELECT COUNT(*) FROM " + TABLE + " WHERE cafe_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{cafeId}, Integer.class);
    }

    private class ItemRowMapper implements RowMapper<Item> {
        @Override
        public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Item.builder()
                    .item_id(rs.getLong("item_id"))
                    .item_status(ItemStatus.getItemStatus(rs.getString("item_status")))
                    .category(ItemCategory.getItemCategory(rs.getString("category")))
                    .create_at(rs.getDate("create_at").toLocalDate())
                    .update_at(rs.getDate("update_at").toLocalDate())
                    .build();
        }
    }
}
