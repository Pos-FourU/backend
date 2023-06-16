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

    public List<Rental> findAllRentals(){
        String sql = "SELECT * FROM rentals";
        return jdbcTemplate.query(sql, new Pack01.domain.rental.repository.RentalRepository.RentalRowMapper());
    }

    public int getCafeRentedItems(Long cafeId) {
        String sql = "SELECT COUNT(*) FROM " + TABLE + " WHERE cafe_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{cafeId}, Integer.class);
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
}
