package Pack01.domain.member.repository;

import Pack01.domain.member.dto.MemberRegisterReqDto;
import Pack01.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private static final String TABLE = "members";

    private final JdbcTemplate jdbcTemplate;

    public void registerMember(Member member) {

        String sql = "INSERT INTO " + TABLE + " (member_email, member_pw, member_phonenum, member_name, create_at, update_at) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                member.getMember_name(),
                member.getMember_pw(),
                member.getMember_phonenum(),
                member.getMember_name(),
                member.getCreate_at(),
                member.getUpdate_at());
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
        String sql = "UPDATE " + TABLE + " SET member_email = ?, member_pw = ?, member_phonenum = ?, member_name = ?, update_at = ? WHERE member_id = ?";
        jdbcTemplate.update(sql,
                member.getMember_email(),
                member.getMember_pw(),
                member.getMember_phonenum(),
                member.getMember_name(),
                member.getUpdate_at(),
                member.getMember_id());
    }

    public void deleteMember(Long memberId) {
        String sql = "DELETE FROM " + TABLE + " WHERE member_id = ?";
        jdbcTemplate.update(sql, memberId);
    }

    // RowMapper class for mapping database result set to Member object
    private static class MemberRowMapper implements RowMapper<Member> {
        @Override
        public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Member.builder()
                    .member_id(rs.getLong("member_id"))
                    .member_email(rs.getString("member_email"))
                    .member_pw(rs.getString("member_pw"))
                    .member_phonenum(rs.getString("member_phonenum"))
                    .member_name(rs.getString("member_name"))
                    .create_at(rs.getDate("create_at").toLocalDate())
                    .update_at(rs.getDate("update_at").toLocalDate())
                    .build();
        }
    }
}

