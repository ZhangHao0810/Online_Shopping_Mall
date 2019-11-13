package service;

import domain.User;

import java.sql.SQLException;

/**
 * @author ZhangHao
 * @date 2019/11/12 14:36
 * @Description：
 */
public interface UserService {
    void userRegister(User user) throws SQLException;
}
