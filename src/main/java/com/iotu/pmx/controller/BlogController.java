package com.iotu.pmx.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.iotu.pmx.model.Article;
import com.iotu.pmx.model.Comment;
import com.iotu.pmx.model.User;
import com.iotu.pmx.service.IArticleService;
import com.iotu.pmx.service.ICommentService;
import com.iotu.pmx.util.SystemConstant;

@Controller
public class BlogController {
	
	@Resource(name="articleService")
	private IArticleService articleService;
	@Resource(name="commentService")
	private ICommentService commentService;
	
	@RequestMapping("/")
	public String mainPage(){
		return "list";
	}
	
	/**
	 * 发表评论
	 * @param comment
	 * @param response
	 * @param printWriter
	 * @param contentId
	 * @throws Exception
	 */
	@RequestMapping("/comment")
	public void comment(Comment comment,HttpServletResponse response,PrintWriter printWriter,String articleId) throws Exception{
		JSONObject result = new JSONObject();
		System.out.println("contentId"+articleId);
		comment.setTime(new Date());
		comment.setArticle(new Article(Integer.parseInt(articleId)));
		if (commentService.saveComment(comment).getCommentId() > 0) {
			result.put("code", "100");
			result.put("result", "评论发表成功");
		}else{
			result.put("code", "141");
			result.put("result", "评论发表失败");
		}
		out(result,response);
	}
	
	/**
	 * 文章的详情
	 * 包含了评论
	 * @param content
	 * @param modelMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/details")
	public String details(Article article,ModelMap modelMap) throws Exception{
		article = articleService.findArticleById(article);
		modelMap.addAttribute("article", article);
		
		return "details";
	}
	
	/**
	 * 给文章点赞
	 * @param content
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/star")
	public void star(Article article,HttpServletResponse response) throws Exception{
		article = articleService.starArticle(article);
		JSONObject result = new JSONObject();
		result.put("star", article.getStar());
		out(result, response);
	}
	
	/**
	 * 打开发布博文的页面
	 * @param content
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/add")
	public String add(HttpSession session) throws Exception{
		User user = (User) session.getAttribute(SystemConstant.LOGIN_USER);
		if (user == null) {
			return "redirect:/user/login";
		}
		
		return "add";
	}
	
	@RequestMapping("/save")
	public String save(Article article,HttpSession session) throws Exception{
		
		User user = (User) session.getAttribute(SystemConstant.LOGIN_USER);
		
		if (user == null) {
			return "redirect:/user/login";
		}
		article.setTime(new Date());
		article.setUser(user);
		articleService.saveArticle(article);
		
		return "redirect:/blog";
	}

	/**重构的带代码  输出json字符串
	 * @param result
	 * @param response
	 * @throws IOException
	 */
	public void out(JSONObject result,HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("UTF-8");  
	    response.setContentType("text/json; charset=utf-8"); 
	    PrintWriter out = response.getWriter();
		out.append(result.toJSONString());
		out.flush();
		out.close();
	}
}


