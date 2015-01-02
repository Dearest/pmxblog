package com.iotu.pmx.util;

import java.util.Arrays;
import java.util.List;

/**
 * 定义系统常量
 * 
 * @author zjc
 * 
 */
public class SystemConstant {
	
	private SystemConstant(){
		
	}

	/**
	 * 验证码 值为validateCode
	 */
	public static final String VALIDATECODE = "validateCode";

	/**
	 * 验证码中随机线条的条数 值为0
	 */
	public static final int INTERLINE = 0;

	/**
	 * 验证码图片的宽度 默认80
	 */
	public static final int VALIDATEWIDTH = 80;

	/**
	 * 验证码图片的高度 默认30
	 */
	public static final int VALIDATEHEIGHT = 30;

	/**
	 * 登陆异常 loginError
	 */
	public static final String LOGINERROR = "loginError";

	/**
	 * 每页显示数据量定义 10
	 */
	public static final int PER_PAGE_NUM = 10;

	/**
	 * 单位页面数据量定义 5
	 */
	public static final int DEP_PAGE_NUM = 5;

	/**
	 * 登陆成功的管理员在session的键名 loginAdmin
	 */
	public static final String LOGIN_ADMIN = "loginAdmin";

	/**
	 * 文件保存的绝对路径 "
	 * 
	 */
	public static final String UPLOAD_PATH = "\\news\\image\\";
	
	
	/**
	 *图片在数据库保存的相对路径 
	 */
	public static final String RELATIVE_PATH = "/news/image/";

	/**
	 * 允许上传的文件列表
	 */
	public static final List<String> PICTURE_TYPE = Arrays.asList(".jpg", ".png",
			".gif");
	
	/**
	 * 允许上传的下载文件类型
	 */
	public static  final List<String> DOWNLOAD_TYPE = Arrays.asList(".pdf");
	
	/**
	 * 允许上传的视频文件类型
	 */
	public static final List<String> VIDEO_TYPE = Arrays.asList(".mp4",".mkv",".rmvb",".rm",".avi",".wmv",".mov");
	
	/**
	 * 重置的默认密码  需用sha256.js加密 现在是12345678
	 */
	public static final String DEFAULT_PSW ="ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f";
	
	/**
	 * 验证码生成的时间
	 */
	public static final String SESSION_TIME = "sessionTime";
	
	/**
	 * 验证码失效时间 默认30秒
	 */
	public static final int VALIDATE_END_TIME = 30*1000;
	
	/**
	 * 登录后的在session保存的键名
	 */
	public static final String LOGIN_USER = "loginUser";
}
