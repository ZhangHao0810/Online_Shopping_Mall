package dao.daoImp;

import dao.UserDao;
import domain.User;
import org.apache.commons.dbutils.QueryRunner;
import utils.JDBCUtils;

import java.sql.SQLException;

/**
 * @author ZhangHao
 * @date 2019/11/12 14:35
 * @Description：
 */
public class UserDaoImp implements UserDao {
    @Override
    public void userRegister(User user) throws SQLException {

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
