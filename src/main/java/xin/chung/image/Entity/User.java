package xin.chung.image.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author Chung
 * @Date 2018/09/22 20:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User{
    private int id;

    private String username;

    private String password;

    private Date lastLogin;
}
