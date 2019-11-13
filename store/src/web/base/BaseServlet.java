package web.base;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @Description:   这是一个通用的Servlet,防止Servlet文件冗余而设置.通过客户端传入method=? 利用反射来查找并执行子类(子servlet)的相应方法.前端不用链接Servlet,链接method即可.大大减少了Servlet的数量.
 * @author          ZhangHao
 * @CreateDate:     2019/11/13 20:47
*/
public class BaseServlet extends HttpServlet {
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// localhost:8080/store/productServlet?method=addProduct
		String method = req.getParameter("method");

		if (null == method || "".equals(method) || method.trim().equals("")) {
			method = "execute";
		}

		// 注意:此处的this代表的是子类的对象
		// System.out.println(this);
		// 子类对象字节码对象
		Class clazz = this.getClass();

		try {
			// 查找子类对象对应的字节码中的名称为method的方法.这个方法的参数类型是:HttpServletRequest.class,HttpServletResponse.class
			Method md = clazz.getMethod(method, HttpServletRequest.class, HttpServletResponse.class);
			if(null!=md){
				String jspPath = (String) md.invoke(this, req, resp);
				if (null != jspPath) {
					req.getRequestDispatcher(jspPath).forward(req, resp);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 默认方法
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		return null;
	}

}