package com.lcomputerstudy.testmvc.service;

import com.lcomputerstudy.testmvc.dao.ImageDAO;
import com.lcomputerstudy.testmvc.vo.Image;

public class ImageService {
	
	private static ImageService service = null;
	private static ImageDAO dao = null;
	
	private ImageService() {
		
	}
	
	public static ImageService getInstance() {
		if(service == null) {
			service = new ImageService();
			dao = ImageDAO.getInstance();
		}
		return service;
	}
	
	public Image getImage(int b_idx) {
		return dao.getImage(b_idx);
	}
	
	public void insertImage(String i_name, String i_real_name) {
		dao.insertImage(i_name, i_real_name);
	}
}
