package dao;

import domain.User;

import java.sql.SQLException;

/**
 * @author ZhangHao
 * @date 2019/11/12 14:34
 * @Description： UserDao接口
 */
public interface UserDao {

     void userRegister(User user) throws SQLException ;

}
