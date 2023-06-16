package Pack01.domain.member.repository;

import Pack01.domain.member.dto.MemberRegisterReqDto;
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

    public void registerMember(MemberRegisterReqDto member) {

        String sql = "INSERT INTO " + TABLE + " (member_email, member_pw, member_phone, member_name, member_role, create_at, update_at) VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                member.getMemberEmail(),
                member.getMemberPw(),
                member.getMemberPhone(),
                member.getMemberName(),
                MemberRole.USER,
                LocalDate.now(),
                LocalDate.now());
    }

    public List<Member> loginAdmin(String email, String pw) {
        String sql = "SELECT * FROM " + TABLE + " WHERE member_email ='"+ email+"' AND  member_pw = '"+pw+"'AND member_role in ('ADMIN','CAFE_ADMIN')";
        return jdbcTemplate.query(sql, new MemberRowMapper());
    }

    public Member findById(Long memberId) {
        String sql = "SELECT * FROM " + TABLE + " WHERE member_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{memberId}, new MemberRowMapper());
    }

    public List<Member> findAll() {
        String sql = "SELECT * FROM " + TABLE;
        return jdbcTemplate.query(sql, new MemberRowMapper());
    }

    public void updateMember(Member member) {
        String sql = "UPDATE " + TABLE + " SET member_email = ?, member_pw = ?, member_phone = ?, member_name = ?, update_at = ? WHERE member_id = ?";
        jdbcTemplate.update(sql,
                member.getMember_email(),
                member.getMember_pw(),
                member.getMember_phone(),
                member.getMember_name(),
                member.getUpdate_at(),
                member.getMember_id());
    }

    public void deleteMember(Long memberId) {
        String sql = "DELETE FROM " + TABLE + " WHERE member_id = ?";
        jdbcTemplate.update(sql, memberId);
    }

    // RowMapper class for mapping database result set to Member object
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

