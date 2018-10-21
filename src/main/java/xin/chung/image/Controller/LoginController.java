package xin.chung.image.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import xin.chung.image.Entity.User;
import xin.chung.image.Entity.UserDTO;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:8081", maxAge = 3600, allowCredentials = "true")
public class LoginController {
    @PostMapping("/login")
    public User login(@RequestBody UserDTO userDTO){
        User user = new User();
        user.setUsername("admin");
        return user;
    }
}
