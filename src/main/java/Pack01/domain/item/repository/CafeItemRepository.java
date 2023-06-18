package Pack01.domain.item.repository;

import Pack01.domain.item.entity.CafeItem;
import Pack01.domain.item.entity.Item;
import Pack01.domain.item.entity.ItemCategory;
import Pack01.domain.item.entity.ItemStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class CafeItemRepository {

    private static final String TABLE = "cafe_items";

    private final JdbcTemplate jdbcTemplate;


    public List<CafeItem> findItems(Long cafe_id){
        String sql = "SELECT * " +
                "FROM "+ TABLE+
                " WHERE cafe_id = "+cafe_id;
        return jdbcTemplate.query(sql, new ItemRowMapper());
    }


    public void register(Long cafe_id,Long item_id){
        String sql = "INSERT INTO " + TABLE + " (cafe_id, item_id) VALUES (?, ?)";
        jdbcTemplate.update(sql,
                cafe_id,
                item_id);

    }






    private class ItemRowMapper implements RowMapper<CafeItem> {
        @Override
        public CafeItem mapRow(ResultSet rs, int rowNum) throws SQLException {
            return CafeItem.builder()
                    .cafe_item_id(rs.getLong("cafe_item_id"))
                    .cafe_id(rs.getLong("cafe_id"))
                    .item_id(rs.getLong("item_id"))
                    .build();
        }
    }
}
