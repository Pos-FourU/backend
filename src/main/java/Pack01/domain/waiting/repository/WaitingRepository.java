package Pack01.domain.waiting.repository;


import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class WaitingRepository {

    private static final String TABLE = "waitings";

    private final JdbcTemplate jdbcTemplate;

    public void updateWaiting() {
        String sql = "UPDATE " + TABLE +
                " SET waiting_status = 'ABLE' WHERE waiting_count < CURRENT_DATE;";
        jdbcTemplate.update(sql);
    }
}

