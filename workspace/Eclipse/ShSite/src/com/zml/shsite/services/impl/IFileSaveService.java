package com.zml.shsite.services.impl;

import org.springframework.web.multipart.MultipartFile;

public interface IFileSaveService {
	 boolean fileSave(String destinationDir, MultipartFile file, String filename);
}
