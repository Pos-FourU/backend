package Pack01.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @RequestMapping("/t1")
    public String func01(){
        System.out.println("func01 call");

        String sql = "INSERT INTO members (member_name, member_email) VALUES (?, ?)";
        jdbcTemplate.update(sql, "username", "email");
        return "TigerView";

    }
}
