package Pack01.domain.member.repository;

import Pack01.domain.member.dto.MemberUpdateReqDto;
import Pack01.domain.member.entity.Manager;
import Pack01.domain.member.entity.Member;
import Pack01.domain.member.entity.MemberRole;
import Pack01.domain.member.entity.MemberStatus;
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
        String sql = "INSERT INTO " + TABLE + " (member_email, member_pw, member_phone, member_name, member_role,member_status,warning_count, create_at, update_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                member.getMember_email(),
                member.getMember_pw(),
                member.getMember_phone(),
                member.getMember_name(),
                member.getMember_role().toString(),
                member.getMember_status().toString(),
                member.getWarning_count(),
                member.getCreate_at(),
                member.getUpdate_at());

    }

    public List<Member> loginAdmin(String email, String pw) {
        String sql = "SELECT * FROM " + TABLE + " WHERE member_email ='" + email + "' AND  member_pw = '" + pw + "'";
        return jdbcTemplate.query(sql, new MemberRowMapper());
    }


    public List<Member> findAll() {
        String sql = "SELECT * FROM " + TABLE;
        return jdbcTemplate.query(sql, new MemberRowMapper());
    }
    public Member findById(Long member_id){
        String sql = "SELECT * FROM " +TABLE +"WHERE member_id = " + member_id;
        return (Member) jdbcTemplate.query(sql,new MemberRowMapper());
    }
    public List<Member> findByRole() {
        String sql = "SELECT * FROM " + TABLE+" where member_role='USER' or member_role ='BLACK_LIST'";
        return jdbcTemplate.query(sql, new MemberRowMapper());
    }

    public Member findByEmail(String member_email){
        String sql = "SELECT * FROM " + TABLE + " WHERE member_email = \""+member_email+"\"";
        return jdbcTemplate.query(sql, new MemberRowMapper()).get(0);
    }

    public List<Member> findByWaringCountUser() {
        String sql = "SELECT * FROM " + TABLE + " where warning_count>=3";
        return jdbcTemplate.query(sql, new MemberRowMapper());
    }

    public List<Member> findMembers(MemberRole memberRole) {
        String sql = "SELECT * FROM " + TABLE + " WHERE member_role = '" + memberRole + "'";
        return jdbcTemplate.query(sql, new MemberRowMapper());
    }

    public List<Manager> findManagers() {
        String sql = "SELECT * FROM " + TABLE + " JOIN cafes ON members.member_id=cafes.member_id";
        return jdbcTemplate.query(sql, new ManagerRowMapper());
    }

    public void updateMember(MemberUpdateReqDto memberUpdateReqDto) {
        String sql = "UPDATE " + TABLE + " SET member_role = ? WHERE member_id = ?";
        String s = memberUpdateReqDto.getMember_role().toString();
        System.out.println(s);
        jdbcTemplate.update(sql,
               s,
                memberUpdateReqDto.getMember_id());
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
            return Member.builder()
                    .member_id(rs.getLong("member_id"))
                    .member_email(rs.getString("member_email"))
                    .member_pw(rs.getString("member_pw"))
                    .member_phone(rs.getString("member_phone"))
                    .member_name(rs.getString("member_name"))
                    .member_role(MemberRole.getMemberRole(rs.getString("member_role")))
                    .member_status(MemberStatus.getMemberStatus(rs.getString("member_status")))
                    .warning_count(rs.getLong("warning_count"))
                    .create_at(rs.getDate("create_at").toLocalDate())
                    .update_at(rs.getDate("update_at").toLocalDate())
                    .build();
        }
    }

    private class ManagerRowMapper implements RowMapper<Manager> {
        @Override
        public Manager mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Manager.builder()
                    .member_id(rs.getLong("member_id"))
                    .member_name(rs.getString("member_name"))
                    .member_phone(rs.getString("member_phone"))
                    .member_email(rs.getString("member_email"))
                    .cafe_id(rs.getLong("cafe_id"))
                    .cafe_name(rs.getString("cafe_name"))
                    .cafe_address(rs.getString("cafe_address"))
                    .build();
        }
    }
}


