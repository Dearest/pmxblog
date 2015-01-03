package com.iotu.pmx.dao;

import java.util.List;

import com.iotu.pmx.model.Page;
import com.iotu.pmx.model.Picture;

public interface IPictureDao {
	
	public boolean save(Picture picture) throws Exception;
	
	
	/**
	 * 图片列表
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<Picture> getPictures(Page page) throws Exception;
}
