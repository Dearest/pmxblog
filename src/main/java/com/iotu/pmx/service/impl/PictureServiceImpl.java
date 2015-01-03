package com.iotu.pmx.service.impl;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

import com.iotu.pmx.dao.IPictureDao;
import com.iotu.pmx.model.Page;
import com.iotu.pmx.model.Picture;
import com.iotu.pmx.service.IPictureService;
import com.iotu.pmx.util.SystemConstant;

public class PictureServiceImpl implements IPictureService{
	private IPictureDao pictureDao;
	
	public void setPictureDao(IPictureDao pictureDao) {
		this.pictureDao = pictureDao;
	}
	public Boolean savePicture(Picture picture,
			DefaultMultipartHttpServletRequest multipartrequest,
			String savePath, String contentPath) throws Exception {
		Date date = new Date();
		MultipartFile mFile = multipartrequest.getFile("file");
		if (mFile.getSize() != 0) {
			File f1 = new File(savePath);
			if (!f1.exists()) {
				f1.mkdirs();
			}
			// 保存图片
			DiskFileItemFactory fac = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(fac);
			upload.setHeaderEncoding("utf-8");
			String extName = "";//文件后缀
			String name = mFile.getOriginalFilename();
			if (name.lastIndexOf(".") >= 0) {
				extName = name.substring(name.lastIndexOf("."));
				//当文件格式不符合
				if (!SystemConstant.PICTURE_TYPE.contains(extName.toLowerCase())) {
					return false;
				}
			}
			
			String saveName = date.getTime() + extName;
			File saveFile = new File(savePath + saveName);
			// 将文件保存到磁盘上
			mFile.transferTo(saveFile);
			//保存图片路径
			picture.setPath(contentPath+saveName);
		}
		// 保存上传时间
		picture.setStar(1);
		picture.setContent("void");
		//保存新闻
		if (pictureDao.save(picture)) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public List<Picture> getPictures(Page page) throws Exception {
	
		return pictureDao.getPictures(page);
	}

}
