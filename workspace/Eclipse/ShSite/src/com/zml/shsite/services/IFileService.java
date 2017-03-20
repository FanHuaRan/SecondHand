package com.zml.shsite.services;

import org.springframework.web.multipart.MultipartFile;
/**
 * 文件增加和删除服务
 * @author zml
 *
 */
public interface IFileService {
	 boolean fileSave(String destinationDir, MultipartFile file, String filename);
	 boolean fileDelete(String fileName);
}