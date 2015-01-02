package com.iotu.pmx.util;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.multipart.MultipartFile;

public class UploadFile {

	public String[] writeFile(String savePath, String relaPath,
			MultipartFile... files) throws IllegalStateException, IOException {
		String[] result = new String[files.length];
		File f1 = new File(savePath);
		int index = 0;
		DiskFileItemFactory fac = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(fac);
		upload.setHeaderEncoding("utf-8");
		if (!f1.exists()) {
			f1.mkdirs();
		}
		for (MultipartFile mf : files) {
			String name = mf.getOriginalFilename();
			name = getName(name);
			File file = new File(savePath + name);
			mf.transferTo(file);
			result[index++] = relaPath + name;
		}

		return result;
	}

	public String getName(String name) {
		Date date = new Date();
		return date.getTime() + name;
	}
}
