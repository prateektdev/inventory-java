package com.research.inventory.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class FileUpload {

	// Save the uploaded file to this folder
	private static String UPLOADED_FOLDER = "uploads/";

	public static String uploadFile(MultipartFile file) {
		try {
			// Get the file and save it somewhere
			byte[] bytes = file.getBytes();
			String fileName = new Date().getTime()
					+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'));
			Path path = Paths.get(UPLOADED_FOLDER + fileName);
			Files.write(path, bytes);
			return fileName;
		} catch (IOException e) {
			e.printStackTrace();
			return "Not Uploaded";
		}
	}
}
