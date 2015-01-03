package com.iotu.pmx.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

import com.iotu.pmx.model.Page;
import com.iotu.pmx.model.Picture;
import com.iotu.pmx.model.User;
import com.iotu.pmx.service.IPictureService;
import com.iotu.pmx.util.DateUtils;
import com.iotu.pmx.util.SystemConstant;



@Controller
@RequestMapping("/photo")
public class PictureController {
	
	@Resource(name="pictureService")
	private IPictureService pictureService;
	
	@RequestMapping("/list")
	public String list(ModelMap modelMap,Page page) throws Exception{
		List<Picture> pictures = pictureService.getPictures(page);
		modelMap.addAttribute("pictures", pictures);
		return "picture";
	}
	
	@RequestMapping("/save")
	public String save(HttpServletRequest request,HttpSession session) throws Exception{
		User user = (User) session.getAttribute(SystemConstant.LOGIN_USER);
		DefaultMultipartHttpServletRequest multipartrequest = (DefaultMultipartHttpServletRequest) request;
		Picture picture = new Picture();
		picture.setTitle(multipartrequest.getParameter("pictitle"));
		picture.setDescription(multipartrequest.getParameter("picsummary"));
		picture.setUser(user);
		// 图片保存的路径
		String savePath = request.getServletContext()
				.getRealPath("")
				+ SystemConstant.UPLOAD_PATH+DateUtils.getDate(new Date())+"\\";
		
		String contentPath = SystemConstant.RELATIVE_PATH+DateUtils.getDate(new Date())+"/";
		

		//保存图片
		pictureService.savePicture(picture, multipartrequest, savePath, contentPath);
		return "redirect:/photo/list";
	}
}
