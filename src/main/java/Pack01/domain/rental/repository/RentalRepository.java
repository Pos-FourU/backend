package Pack01.domain.rental.repository;


import Pack01.domain.item.entity.Item;
import Pack01.domain.item.entity.ItemCategory;
import Pack01.domain.item.entity.ItemStatus;
import Pack01.domain.rental.entity.Rental;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class RentalRepository {
    private static final String TABLE = "rentals";
    private final JdbcTemplate jdbcTemplate;
    public void registerRental(Rental rental) {
        String sql = "INSERT INTO " + TABLE + " (member_id, item_id, rental_time, return_time) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                rental.getMember_id(),
                rental.getItem_id(),
                rental.getRental_time(),
                rental.getReturn_time());
    }

    public List<Long> findAllByExpireMembers() {
        String sql = "SELECT member_id " +
                "FROM rentals " +
                "WHERE rental_days < CURDATE() AND return_time IS NULL " +
                "  AND ((CURDATE() - rental_days) % 7) = 0;\n";
        return jdbcTemplate.query(sql, new RentalMembersRowMapper());
    }

    public List<Rental> findAllRentals() {
        String sql = "SELECT * FROM rentals";
        return jdbcTemplate.query(sql, new RentalRowMapper());
    }
    public void deleteExpiredRentals(){
        String sql ="DELETE FROM rentals\n" +
                "WHERE rental_days < DATE_SUB(CURDATE(), INTERVAL 1 YEAR);\n";
        jdbcTemplate.update(sql);
    }

    public int countThismonth(Long member_id){
            String sql = "SELECT COUNT(*) AS rental_count " +
                    "FROM rentals " +
                    "WHERE member_id = ? " +
                    "  AND MONTH(rental_time) = MONTH(CURRENT_DATE())" +
                    "  AND YEAR(rental_time) = YEAR(CURRENT_DATE());";
            return jdbcTemplate.queryForObject(sql, Integer.class, member_id);
        }


    private class RentalRowMapper implements RowMapper<Rental> {
        @Override
        public Rental mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Rental.builder()
                    .rental_id(rs.getLong("rental_id"))
                    .member_id(rs.getLong("member_id"))
                    .item_id(rs.getLong("item_id"))
                    .rental_time(rs.getTime("rental_time"))
                    .return_time(rs.getTime("return_time"))
                    .build();
        }
    }

    private class RentalMembersRowMapper implements RowMapper<Long> {
        @Override
        public Long mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            return resultSet.getLong("member_id");
        }
    }
}
