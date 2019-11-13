package utils;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import java.util.Map;
/**
 * @Description:    这个是一个方便项目而进行二次开发的工具类,利用了org.apache.commons.beanutils.BeanUtils工具类(需要导包),
 * @author          ZhangHao
 * @CreateDate:     2019/11/13 20:16
*/
public class MyBeanUtils {

	/**
	 * @date 2019/11/13 20:14
	 *
	 * @param obj
	 * @param map	这个map来源于 request.getParameterMap();将所有的Parameter以键值对的方式获得,key是表单中的name属性值,value是客户填入的内容.
	 * @return void
	 * @Description: 有了这个方法,可以在项目中一句话搞定接收参数并赋值.
	*/
	public static void populate(Object obj, Map<String, String[]> map) {
		try {
			/** 2019/11/13 19:58
			 * 下面三行代码复制自 MyBeanUtils, 作用是设置一下如何将字符串转换成Data
			 *  BeanUtils利用反射找到User.class文件上有setBirthday方法,要执行,将字符串转换成时间日期类型.
			 *  BeanUtils不知道这个字符串的时间格式是什么,以下三行代码设置时间转换格式.
			 */
			// 由于BeanUtils将字符串"1992-3-3"向user对象的setBithday();方法传递参数有问题,手动向BeanUtils注册一个时间类型转换器
			// 1_创建时间类型的转换器
			DateConverter dt = new DateConverter();
			// 2_设置转换的格式
			dt.setPattern("yyyy-MM-dd");
			// 3_注册转换器
			ConvertUtils.register(dt, java.util.Date.class);

			/** 2019/11/13 20:07
			 * 遍历map,找到key,再通过obj的class文件(反射)找setkey的方法.再将value的值自动传入setkey方法即可.
			 */
			BeanUtils.populate(obj, map);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public static<T> T  populate(Class<T> clazz, Map<String, String[]> map) {
		try {
			
			T obj=clazz.newInstance();
			
			// 由于BeanUtils将字符串"1992-3-3"向user对象的setBithday();方法传递参数有问题,手动向BeanUtils注册一个时间类型转换器
			// 1_创建时间类型的转换器
			DateConverter dt = new DateConverter();
			// 2_设置转换的格式
			dt.setPattern("yyyy-MM-dd");
			// 3_注册转换器
			ConvertUtils.register(dt, java.util.Date.class);
			
			BeanUtils.populate(obj, map);
			
			return obj;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}		
	}
	
}
