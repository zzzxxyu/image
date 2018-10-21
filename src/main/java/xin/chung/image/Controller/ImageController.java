package xin.chung.image.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import xin.chung.image.Entity.Image;
import xin.chung.image.Service.ImageService;

import java.util.List;

@RestController
@CrossOrigin
public class ImageController {
    @Autowired
    public ImageService imageService;
    @GetMapping("/match/{type}")
    @CrossOrigin
    public List<Image> matching(@PathVariable String type){
        return imageService.match(type);
    }

    //上传图片文件
    @PostMapping("/pic")
    public String imageUrl(@RequestParam MultipartFile file){
        return imageService.upLoad(file);
    }

    @GetMapping("/changeName/{type}")
    public String changeName(@PathVariable String type) {
        return imageService.changeName(type);
    }
}
