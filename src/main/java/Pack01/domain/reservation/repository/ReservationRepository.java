package Pack01.domain.reservation.repository;

import Pack01.domain.reservation.entity.Reservation;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
@Repository
@RequiredArgsConstructor
public class ReservationRepository {

    private static final String TABLE = "reservations";

    private final JdbcTemplate jdbcTemplate;

    public void registerReservation(Reservation reservation) {

        String sql = "INSERT INTO " + TABLE + " (member_id, cafe_id,reservation_time) VALUES ( ?, ?, ?)";
        jdbcTemplate.update(sql,
                reservation.getMember_id(),
                reservation.getCafe_id(),
                reservation.getReservation_time());
    }

    public int getCafeReservedItems(Long cafeId) {
        String sql = "SELECT COUNT(*) FROM " + TABLE + " WHERE cafe_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{cafeId}, Integer.class);
    }

    private class ReservationRowMapper implements RowMapper<Reservation> {
        @Override
        public Reservation mapRow(ResultSet rs, int rowNum) throws SQLException {
            if (rowNum == 0) return null;

            return Reservation.builder()
                    .reservation_id(rs.getLong("reservation_id"))
                    .member_id(rs.getLong("member_id"))
                    .cafe_id(rs.getLong("cafe_id"))
                    .reservation_time(rs.getDate("reservation_time").toLocalDate())
                    .build();


        }
    }
}