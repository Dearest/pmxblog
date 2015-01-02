package com.iotu.pmx.controller;

import java.awt.Color;
import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iotu.pmx.model.User;
import com.iotu.pmx.service.IUserService;
import com.iotu.pmx.util.SystemConstant;
import com.iotu.pmx.util.ValidateCode;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource(name="userSerivce")
	private IUserService userService;
	
	@RequestMapping("/login")
	public String show(){
		return "login";
	}
	@RequestMapping("/in")
	public String login(User user,ModelMap modelMap,HttpServletRequest request,String validateCode) throws Exception{
	
	String sessionVailCode = (String)request.getSession().getAttribute(
				SystemConstant.VALIDATECODE);
	if (validateCode.trim().equals("")) {
		modelMap.addAttribute(SystemConstant.LOGINERROR, "验证码不能为空");
		return "login";
	}
	
	if (!sessionVailCode.toLowerCase().equals(
			validateCode.trim().toLowerCase())) {
		modelMap.addAttribute(SystemConstant.LOGINERROR, "验证码错误");
		return "login";
	}
	if (user.getName() == null || user.getName().isEmpty()
			|| user.getPassword().isEmpty()) {
		modelMap.addAttribute(SystemConstant.LOGINERROR, "用户名或密码不能为空");
		return "login";
	}
	User queryUser = userService.login(user);
	if (queryUser != null &&queryUser.getUserId() != 0 ) {
		request.getSession().setAttribute(SystemConstant.LOGIN_ADMIN, queryUser);
		return "list";
	} else {
		modelMap.addAttribute(SystemConstant.LOGINERROR, "用户名或密码错误");
		return "login";
	}
	}
	
	/**
	 * 输出验证码
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/validateCode")
	public void showValidateCode(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// 禁止图像缓存
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");

		// 为了开发方便 把验证码设置成只有数字 以后可根据需要改为字母加数字
		String validateCodeStr = ValidateCode.generateTextCode(
				ValidateCode.TYPE_NUM_ONLY, 4, null);
		request.getSession().setAttribute(SystemConstant.VALIDATECODE,
				validateCodeStr);
		request.getSession().setAttribute(SystemConstant.SESSION_TIME, new Date().getTime());
		// 将图像输出到Servlet输出流中
		ServletOutputStream sos = response.getOutputStream();
		ImageIO.write(ValidateCode.generateImageCode(validateCodeStr,
				SystemConstant.VALIDATEWIDTH, SystemConstant.VALIDATEHEIGHT,
				SystemConstant.INTERLINE, true, Color.lightGray, null, null),
				"jpeg", sos);
		sos.close();

	}
}
