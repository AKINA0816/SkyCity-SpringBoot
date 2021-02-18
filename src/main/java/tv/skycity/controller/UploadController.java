package tv.skycity.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;

@Controller
public class UploadController {
    @Value("${user.file.path}")
    private String filepath;

    @PostMapping("/avatar_update")
    public String avatarUpdate(@RequestParam("avatar") MultipartFile multipartFile, Model model) throws IOException {
        File file = new File(filepath + multipartFile.getOriginalFilename());
        multipartFile.transferTo(file);
        model.addAttribute("uploadMessage","上传成功");
        return "forward:/userSetting";
    }
}
