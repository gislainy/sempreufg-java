package br.com.sempreufg.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import br.com.sempreufg.model.utils.FileInfo;

@Service
@RequestMapping("/imagem")
public class FileService {
	@Autowired
	ServletContext context;
	
	@RequestMapping(value = "/fileupload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, headers = ("content-type=multipart/*"), method = RequestMethod.POST)
	public ResponseEntity<FileInfo> upload(@RequestParam("file") MultipartFile inputFile) {
		FileInfo fileInfo = new FileInfo();
		HttpHeaders headers = new HttpHeaders();
		if (!inputFile.isEmpty()) {
			try {
				String originalFilename = inputFile.getOriginalFilename();
				File destinationFile = new File(context.getRealPath("/uploaded") + File.separator + originalFilename);
				inputFile.transferTo(destinationFile);
				fileInfo.setFileName(destinationFile.getPath());
				fileInfo.setFileSize(inputFile.getSize());
				headers.add("File Uploaded Successfully - ", originalFilename);
				return new ResponseEntity<FileInfo>(fileInfo, headers, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<FileInfo>(HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<FileInfo>(HttpStatus.BAD_REQUEST);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/uploadMultipleFile", method = RequestMethod.POST)
	public String uploadMultipleFileHandler(@RequestParam("file") MultipartFile[] files) {
		ArrayList<MultipartFile> arquivos = new ArrayList<MultipartFile>(Arrays.asList(files));
		String message = "";
		for (MultipartFile file : arquivos) {
			String name = file.getOriginalFilename();
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = context.getRealPath("/uploaded");
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				message = message + "Seu arquivo '" + name + "' foi carregado com êxito!\n";
			} catch (Exception e) {
				return "Ao carregar o arquivo '" + name + "' ocorreu a seguinte falha => " + e.getMessage();
			}
		}
		return message;
	}
}
