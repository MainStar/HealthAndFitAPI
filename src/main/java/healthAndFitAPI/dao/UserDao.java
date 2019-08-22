package healthAndFitAPI.dao;

import healthAndFitAPI.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public synchronized UserModel getUser(String email) {
        String query =
                "select " +
                        " user_name," +
                        " second_name," +
                        " user_password," +
                        " email," +
                        " sex," +
                        " birthday_date," +
                        " height," +
                        " weight," +
                        " target_weight," +
                        " trainings\n" +
                        "from users " +
                        "where email = \"%s\"";
        return jdbcTemplate.queryForObject(String.format(query, email), new UserMapper());
    }

    public synchronized Integer createUser(UserModel user) {
        String query =
                "insert into users (" +
                        " user_name," +
                        " second_name," +
                        " user_password," +
                        " email," +
                        " sex," +
                        " birthday_date," +
                        " height," +
                        " weight," +
                        " target_weight," +
                        " trainings\n" +
                        ") values (\"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\")";
        return jdbcTemplate.update(String.format(query, user.getUserName(), user.getSecondName(), user.getUserPassword(), user.getEmail(), user.getSex(),
                user.getBirthdayDate(), user.getHeight(), user.getCurrentWeight(), user.getTargetWeight(), user.getTrainings()));
    }

    public synchronized Integer updateUser(UserModel user) {
        String query =
                "update users set " +
                        " user_name = \"%s\"," +
                        " second_name = \"%s\"," +
                        " user_password = \"%s\"," +
                        " email = \"%s\"," +
                        " sex = \"%s\"," +
                        " birthday_date = \"%s\"," +
                        " height = \"%s\"," +
                        " weight = \"%s\"," +
                        " target_weight = \"%s\"," +
                        " trainings = \"%s\" \n" +
                        "where email = \"%s\"";
        return jdbcTemplate.update(String.format(query, user.getUserName(), user.getSecondName(), user.getUserPassword(), user.getEmail(), user.getSex(),
                user.getBirthdayDate(), user.getHeight(), user.getCurrentWeight(), user.getTargetWeight(), user.getTrainings(), user.getEmail()));
    }

    private static final class UserMapper implements RowMapper<UserModel> {
        @Nullable
        @Override
        public synchronized UserModel mapRow(ResultSet resultSet, int i) throws SQLException {
            UserModel user = new UserModel();
            user.setUserName(resultSet.getString("user_name"));
            user.setSecondName(resultSet.getString("second_name"));
            user.setUserPassword(resultSet.getString("user_password"));
            user.setEmail(resultSet.getString("email"));
            user.setSex(resultSet.getString("sex"));
            user.setBirthdayDate(resultSet.getString("birthday_date"));
            user.setHeight(resultSet.getString("height"));
            user.setCurrentWeight(resultSet.getString("weight"));
            user.setTargetWeight(resultSet.getString("target_weight"));
            user.setTrainings(resultSet.getString("trainings"));
            return user;
        }
    }
}
