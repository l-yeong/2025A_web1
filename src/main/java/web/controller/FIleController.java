package web.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import web.service.FileService;

@RestController
@RequestMapping("/file")
public class FIleController {
    @Autowired FileService fileService;

    //[1] 업로드
    //[2]
    @PostMapping("/upload")
    public String fileUpload(MultipartFile multipartFile){
        System.out.println("FIleController.fileUpload");
        System.out.println("multipartFile = " + multipartFile);
        String result = fileService.fileUpload(multipartFile);
        return result;
    }//func end

    @GetMapping("/download")
    public void fileDownload(@RequestParam String fileName, HttpServletResponse response){
        System.out.println("FIleController.fileDonwload");
        System.out.println("filename = " + fileName + ", response = " + response);
        fileService.fileDownload(fileName,response);
    }//func end

    @DeleteMapping("/delete")
    public boolean fileDelete(@RequestParam String fileName){
        System.out.println("FIleController.fileDelete");
        System.out.println("Name = " + fileName);
        boolean result = fileService.fileDelete(fileName);
        return result;
    }
}//class end
