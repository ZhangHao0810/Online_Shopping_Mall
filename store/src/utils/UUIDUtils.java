package utils;

import java.util.UUID;

/** 2019/11/8 11:16
 * 用于生成随机字符串.
*/
public class UUIDUtils {
	/**
	 * 随机生成id
	 * @return
	 */
	public static String getId(){
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();
	}
	
	
	public static String getUUID64(){
		return getId()+getId();
	}
	
	/**
	 * 生成随机码
	 * @return
	 */
	public static String getCode(){
		return getId();
	}
	
	public static void main(String[] args) {
		System.out.println(getId());

//		String str = UUID.randomUUID().toString();
//		System.out.println();

	}
}
