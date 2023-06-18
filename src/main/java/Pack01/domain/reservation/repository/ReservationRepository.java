package Pack01.domain.reservation.repository;

import Pack01.domain.reservation.dto.ReservationFindRespDto;
import Pack01.domain.reservation.entity.Reservation;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReservationRepository {

    private static final String TABLE = "reservations";

    private final JdbcTemplate jdbcTemplate;

    public void registerReservation(Reservation reservation) {
        String sql = "INSERT INTO " + TABLE + " (member_id, cafe_id, reservation_time) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql,
                reservation.getMember_id(),
                reservation.getCafe_id(),
                reservation.getReservation_time());
    }

    public boolean checkIfAlready(Long memberId){
        // 멤버 아이디 확인을 위한 쿼리
        String checkQuery = "SELECT COUNT(*) FROM " +TABLE+ " WHERE member_id = ? OR member_id IN (SELECT member_id FROM rentals WHERE return_time IS NULL)";
        int count = jdbcTemplate.queryForObject(checkQuery, Integer.class,memberId);
        return count>0;
    }

    public List<Reservation> findbyManager(Long manager_id){
        String sql = "SELECT * FROM "+TABLE+" JOIN cafes ON reservations.cafe_id = cafes.cafe_id WHERE cafes.member_id = "+manager_id;
        return jdbcTemplate.query(sql, new RowMapper<Reservation>() {
            @Override
            public Reservation mapRow(ResultSet rs, int rowNum) throws SQLException {
                Reservation reservation = new Reservation(
                        rs.getLong("reservation_id"),
                        rs.getLong("cafe_id"),
                        rs.getLong("member_id"),
                        rs.getDate("reservation_time")
                );
                return reservation;
            }
        });
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
                    .reservation_time(rs.getDate("reservation_time"))
                    .build();


        }
    }
}