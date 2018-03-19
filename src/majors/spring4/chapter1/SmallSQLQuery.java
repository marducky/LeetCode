package majors.spring4.chapter1;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/03/19 17:02
 **/
public class SmallSQLQuery {
    private JdbcTemplate jdbcTemplate;

    public Company getEmployById(long id) {
        return jdbcTemplate.queryForObject("select * from a where id =?", new RowMapper<Company>() {
            @Override
            public Company mapRow(ResultSet resultSet, int i) throws SQLException {
                return null;
            }
        }, id);
    }

}
