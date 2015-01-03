package com.iotu.pmx.service;

import java.util.List;

import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

import com.iotu.pmx.model.Page;
import com.iotu.pmx.model.Picture;

public interface IPictureService {
	
	/**
	 * 保存图片
	 * @param article
	 * @param multipartrequest
	 * @param savePath
	 * @param contentPath
	 * @return
	 * @throws Exception
	 */
	public Boolean savePicture(Picture picture,
			DefaultMultipartHttpServletRequest multipartrequest, String savePath,String contentPath) throws Exception;
	
	/**
	 * 图片列表
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<Picture> getPictures(Page page) throws Exception;
}
