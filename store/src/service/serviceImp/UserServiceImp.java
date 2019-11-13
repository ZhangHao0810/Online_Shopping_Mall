package service.serviceImp;

import dao.UserDao;
import dao.daoImp.UserDaoImp;
import domain.User;
import service.UserService;

import java.sql.SQLException;

/**
 * @author ZhangHao
 * @date 2019/11/12 14:36
 * @Description：
 */
public class UserServiceImp implements UserService {

    /**
     * @date 2019/11/13 21:06
     * @param user
     * @return void
     * @Description: 实现注册功能
    */
    @Override
    public void userRegister(User user) throws SQLException {
        UserDao userDao = new UserDaoImp();
        UserDao.userRegister(user);
    }
    

}
