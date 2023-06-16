package Pack01.domain.member.repository;

import Pack01.domain.member.entity.Member;
import Pack01.domain.member.entity.MemberRole;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private static final String TABLE = "members";

    private final JdbcTemplate jdbcTemplate;

    public void registerMember(Member member) {

        String sql = "INSERT INTO " + TABLE + " (member_email, member_pw, member_phone, member_name, member_role, create_at, update_at) VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                member.getMember_name(),
                member.getMember_pw(),
                member.getMember_phone(),
                member.getMember_name(),
                member.getMember_role(),
                member.getCreate_at(),
                member.getUpdate_at());

    }

    public List<Member> loginAdmin(String email, String pw) {
        String sql = "SELECT * FROM " + TABLE + " WHERE member_email ='"+ email+"' AND  member_pw = '"+pw+"'AND member_role in ('ADMIN','CAFE_ADMIN')";
        return jdbcTemplate.query(sql, new MemberRowMapper());
    }



    public List<Member> findAll() {
        String sql = "SELECT * FROM " + TABLE;
        return jdbcTemplate.query(sql, new MemberRowMapper());
    }
    public List<Member> findByWaringCountUser() {
        String sql = "SELECT * FROM " + TABLE+" where warning_count>=3";
        return jdbcTemplate.query(sql, new MemberRowMapper());
    }

    public void increaseWarningCount(Long memberId) {
        String sql = "UPDATE members SET warning_count = warning_count + 1 WHERE member_id = ?";
        jdbcTemplate.update(sql, memberId);
    }
    public void ChangeBlackList(Long memberId) {
        String sql = "UPDATE members SET member_status = 'BLACK_LIST'WHERE member_id = ?";
        jdbcTemplate.update(sql, memberId);
    }

    private class MemberRowMapper implements RowMapper<Member> {
        @Override
        public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
            if(rowNum==0) return null;

            return Member.builder()
                    .member_id(rs.getLong("member_id"))
                    .member_email(rs.getString("member_email"))
                    .member_pw(rs.getString("member_pw"))
                    .member_phone(rs.getString("member_phone"))
                    .member_name(rs.getString("member_name"))
                    .member_role(MemberRole.getMemberRole(rs.getString("member_role")))
                    .create_at(rs.getDate("create_at").toLocalDate())
                    .update_at(rs.getDate("update_at").toLocalDate())
                    .build();
        }
    }
}

