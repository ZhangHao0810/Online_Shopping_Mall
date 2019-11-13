package dao;

import domain.User;
import org.apache.commons.dbutils.QueryRunner;
import utils.JDBCUtils;

import java.sql.SQLException;

/**
 * @author ZhangHao
 * @date 2019/11/12 14:34
 * @Description： UserDao接口
 */
public interface UserDao {
    static void userRegister(User user) throws SQLException {
        String sql = "INSERT INTO USER VALUES(?,?,?,?,?,?,?,?,?,?)";
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        Object[] params = {
                user.getUid(),
                user.getUsername(),
                user.getPassword(),
                user.getName(),
                user.getEmail(),
                user.getTelephone(),
                user.getBirthday(),
                user.getSex(),
                user.getState(),
                user.getCode()};
        qr.update(sql, params);
    }
}
