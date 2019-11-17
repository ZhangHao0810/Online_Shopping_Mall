package web.servlet;

import domain.User;
import service.UserService;
import service.serviceImp.UserServiceImp;
import utils.MyBeanUtils;
import utils.UUIDUtils;
import web.base.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author： ZhangHao
 * @date： 2019/11/12 14:38
 * @Description：
 */
public class UserServlet extends BaseServlet {

    public String registUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return "/jsp/register.jsp";
    }


    public String userRegister(HttpServletRequest request, HttpServletResponse response) throws Exception {
//     1.接收表单参数,getParameterMap返回键值对.
        Map<String, String[]> map = request.getParameterMap();
        User user = new User();
        /** 2019/11/13 20:12
         * 利用MyBeanUtil来做,一句话搞定接收参数并赋值.利用反射. 忘了的话去看MyBeanUtils的源码
         */
        MyBeanUtils.populate(user, map);
//        为用户的其他属性赋值.
        user.setUid(UUIDUtils.getId());
        user.setState(0);
        user.setCode(UUIDUtils.getCode());
        System.out.println(user);

//      2.调用业务层注册功能
        UserService userService = new UserServiceImp();
        try {
            userService.userRegister(user);
//        注册成功,向邮箱发送信息,
            request.setAttribute("msg", "用户注册成功啦~ 快来激活吧!");
        } catch (Exception e) {
//        注册失败.
            request.setAttribute("msg", "用户注册失败啦~ 呜呜呜 重新注册试试.");
        }

        //不管成功与否都跳转到这个提示页面
        return "/jsp/info.jsp";
    }

}
