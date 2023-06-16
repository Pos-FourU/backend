package Pack01.domain.cafe.repository;

import Pack01.domain.cafe.entity.Cafe;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CafeRepository {

    private static final String TABLE = "cafes";

    private final JdbcTemplate jdbcTemplate;

    public void registerCafe(Cafe cafe) {
        String sql = "INSERT INTO " + TABLE + " ( member_id, cafe_name, cafe_address, cafe_latitude, cafe_longitude, create_at, update_at) VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                cafe.getMember_id(),
                cafe.getCafe_name(),
                cafe.getCafe_address(),
                cafe.getCafe_latitude(),
                cafe.getCafe_longitude(),
                cafe.getCreate_at(),
                cafe.getUpdate_at());
    }

    public List<Cafe> findAll() {
        String sql = "SELECT * FROM " + TABLE;
        return jdbcTemplate.query(sql, new CafeRowMapper());
    }


    // RowMapper class for mapping database result set to Member object
    private static class CafeRowMapper implements RowMapper<Cafe> {
        @Override
        public Cafe mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Cafe.builder()
                    .cafe_id(rs.getLong("cafe_id"))
                    .cafe_name(rs.getString("cafe_name"))
                    .cafe_address(rs.getString("cafe_address"))
                    .cafe_latitude(rs.getFloat("cafe_latitude"))
                    .cafe_longitude(rs.getFloat("cafe_longitude"))
//                    .create_at(rs.getDate("create_at").toLocalDate())
//                    .update_at(rs.getDate("update_at").toLocalDate())
                    .build();
        }
    }

}
