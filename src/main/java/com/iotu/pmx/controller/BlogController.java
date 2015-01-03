package com.iotu.pmx.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.iotu.pmx.model.Article;
import com.iotu.pmx.model.Comment;
import com.iotu.pmx.model.Page;
import com.iotu.pmx.model.SearchParams;
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
	public String mainPage(ModelMap modelMap,Page page,SearchParams searchParams) throws Exception{
		List<Article> articles = articleService.getArticles(page, searchParams);
		List<Article> top5 = articleService.top5Articles();
		modelMap.addAttribute("articles", articles);
		modelMap.addAttribute("top5", top5);
		modelMap.addAttribute("page", page);
		modelMap.addAttribute("search", searchParams);
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
	public void comment(Comment comment,HttpServletResponse response,PrintWriter printWriter,String articleId,HttpSession session,HttpServletRequest request) throws Exception{
		JSONObject result = new JSONObject();
		//如果是对评论的回复 就执行if里面的语句 先判断是否登录 再赋值fromUser
		if (comment.getIsRecomment() == 1 ) {
			User user = (User) session.getAttribute(SystemConstant.LOGIN_USER);
			
			if (user == null) {
				result.put("code", "142");
				result.put("result", "您还没有登录");
			}else {   
				//当user不为null 即已经登录
				comment.setFromUser(user.getName());
				comment.setTime(new Date());
				comment.setArticle(new Article(Integer.parseInt(articleId)));
				if (commentService.saveComment(comment).getCommentId() > 0) {
					result.put("code", "100");
					result.put("result", "评论发表成功");
				}else{
					result.put("code", "141");
					result.put("result", "评论发表失败");
				}
			}
			
		}else {
			comment.setTime(new Date());
			comment.setArticle(new Article(Integer.parseInt(articleId)));
			if (commentService.saveComment(comment).getCommentId() > 0) {
				result.put("code", "100");
				result.put("result", "评论发表成功");
			}else{
				result.put("code", "141");
				result.put("result", "评论发表失败");
			}
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
		List<Article> top5 = articleService.top5Articles();
		modelMap.addAttribute("article", article);
		modelMap.addAttribute("top5", top5);
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
			return "add";
		}
		
		return "add";
	}
	
	@RequestMapping("/save")
	public String save(Article article,HttpSession session) throws Exception{
		
		User user = (User) session.getAttribute(SystemConstant.LOGIN_USER);
		
		if (user == null) {
			return "add";
		}
		article.setStar(1);
		article.setTime(new Date());
		article.setUser(user);
		articleService.saveArticle(article);
		
		return "redirect:/";
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


