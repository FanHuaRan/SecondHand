package com.zml.shsite.services;

import org.springframework.web.multipart.MultipartFile;
/**
 * 文件增加和删除服务
 * @author zml
 *
 */
public interface IFileService {
	 boolean saveUserImage(MultipartFile file,int userId);
	 boolean saveGoodImage(MultipartFile file,int goodId);
	 boolean saveOrUpdateUserImage(MultipartFile file,int userId);
	 boolean saveOrUpdateGoodImage(MultipartFile file,int goodId);
	 boolean deleteUserImage(int userId);
	 boolean deleteGoodImage(int goodId);
}
