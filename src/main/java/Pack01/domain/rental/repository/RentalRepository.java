package Pack01.domain.rental.repository;


import Pack01.domain.rental.dto.RentalInsertReqDto;
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

    public List<Rental> findRentals(Long member_id) {
        String sql = "SELECT * " +
                "FROM rentals " +
                "JOIN items ON rentals.item_id = items.item_id " +
                "JOIN cafes c on rentals.cafe_id = c.cafe_id " +
                "WHERE c.member_id="+member_id;
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

    public void insertRental(Rental rental){
        String sql = "INSERT INTO " + TABLE + " (member_id, item_id, cafe_id, rental_time, return_time, rental_days) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, rental.getMember_id(), rental.getItem_id(), rental.getCafe_id(), rental.getRental_time(), rental.getReturn_time(), rental.getRental_days());
    }

    public Boolean isNotRental(Long member_id){
        String sql = "SELECT * FROM "+TABLE+" WHERE member_id = "+member_id;
        if(jdbcTemplate.query(sql, new RentalRowMapper()).size()>0)
        {
            return false;
        };
        return true;
    }

    private class RentalRowMapper implements RowMapper<Rental> {
        @Override
        public Rental mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Rental.builder()
                    .rental_id(rs.getLong("rental_id"))
                    .member_id(rs.getLong("member_id"))
                    .item_id(rs.getLong("item_id"))
                    .rental_time(rs.getDate("rental_time"))
                    .return_time(rs.getDate("return_time"))
                    .rental_days(rs.getDate("rental_days"))
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
