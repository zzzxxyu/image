package xin.chung.image.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import xin.chung.image.Entity.Image;
import xin.chung.image.Service.ImageService;

@RestController
public class ImageController {
    @Autowired
    public ImageService imageService;

    @GetMapping("/match/{type}")
    public Image matching(@PathVariable String type){
        return imageService.match(type);
    }

}
