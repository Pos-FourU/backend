package Pack01.domain.item.repository;

import Pack01.domain.item.entity.Item;
import Pack01.domain.item.entity.ItemCategory;
import Pack01.domain.item.entity.ItemStatus;
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

    public List<Item> findItems(Long member_id){
        String sql = "SELECT * " +
                "FROM items " +
                "JOIN cafe_items " +
                "ON items.item_id=cafe_items.item_id " +
                "JOIN cafes " +
                "ON cafes.cafe_id = cafe_items.cafe_id " +
                "WHERE member_id = "+member_id;
        return jdbcTemplate.query(sql, new ItemRowMapper());
    }

<<<<<<< Updated upstream
=======
    public void updateItem(Long itemId, String status){
        String sql = "UPDATE "+TABLE+" SET item_status = \""+status+"\" WHERE item_id = "+itemId;
        jdbcTemplate.update(sql);
    }

    public void deleteByItemIds(List<Long> itemIds) {

        String sql = "DELETE FROM items WHERE item_id IN (:itemIds)";
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("itemIds", itemIds);
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate.getDataSource());
        namedParameterJdbcTemplate.update(sql, parameters);
    }

>>>>>>> Stashed changes
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
