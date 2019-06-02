package dao;

import domain.User;
import utils.JDBCutils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserData {

    //声明jdbcTemplate
    private JdbcTemplate template =new JdbcTemplate(JDBCutils.getDs());
    public User login(User loginuser) {
        //        //数据库连接池
        try {
            String sql = "select * " +
                    "from user " +
                    "where username=? and password =?";
            User user2 = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),
                    loginuser.getUsername(),loginuser.getPassword());
            return user2;
        } catch (DataAccessException e) {
            return null;
        }
    }
}

