package test;

import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZhangHao
 * @date 2019/11/13 19:45
 * @Description： 一个测试类 测试 org.apache.commons.beanutils.BeanUtils;
 *      想要使用BeanUtils,要导入相应的jar包.
 */
public class TestBeanUtils  {


    /** 2019/11/13 19:57
     * 这个方法能成功的前提是 birthday字段注释掉.
     * 否则会产生:org.apache.commons.beanutils.ConversionException: DateConverter does not support default String to 'Date' conversion.
    */
    @Test
    public void test01() throws Exception {
//        模拟request.getParameterMap()
        Map<String,String[]> map=new HashMap<>();
        map.put("username", new String[]{"mm"});
        map.put("password", new String[]{"123"});

//        创建一个User对象,利用BeanUtils自动填充数据.
        User user=new User();
        BeanUtils.populate(user,map);
        System.out.println(user);
    }


    /**
     * @date 2019/11/13 20:02
     *
     * @param
     * @return void
     * @Description: test2解决了test01的无法输入birthday的问题.
    */
    @Test
    public void test02() throws Exception {
//        模拟request.getParameterMap()
        Map<String,String[]> map=new HashMap<>();
        map.put("username", new String[]{"mm"});
        map.put("password", new String[]{"123"});
        map.put("birthday", new String[]{"1997-8-3"});

        User user=new User();

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
         * 遍历map,找到key,再通过user的clss文件找setkey的方法.再将value的值自动传入setkey方法即可.
        */
        BeanUtils.populate(user,map);
        System.out.println(user);
    }
}
