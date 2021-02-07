package com.research.inventory.controller;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.research.inventory.utils.BaseResponse;
import com.research.inventory.utils.FileUpload;

@RestController
@RequestMapping("/api")
public class FileUploadController {


	// Save the uploaded file to this folder
	private static String UPLOADED_FOLDER = "uploads/";

	@PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE) // //new annotation since 4.3
	public BaseResponse singleFileUpload(@RequestParam("file") MultipartFile file,
			RedirectAttributes redirectAttributes) {
		if (file.isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
			return new BaseResponse(false, "please select any file");
		}
		String response = FileUpload.uploadFile(file);
		redirectAttributes.addFlashAttribute("message", "You successfully uploaded '" + response + "'");
		return new BaseResponse(true, response);
	}

	@GetMapping("/uploadStatus")
	public String uploadStatus() {
		return "uploadStatus";
	}

	

}
