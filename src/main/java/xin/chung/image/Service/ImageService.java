package xin.chung.image.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import xin.chung.image.Entity.Image;
import xin.chung.image.Utils.Fingerprint;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ImageService {
    public List<Image> match(String type) {
        //String s0 = "src\\img\\mbtx\\" + type + ".jpg", s = null;
        String s0 = "E:\\IDEA-1.6\\VueAdmin-master\\src\\assets\\img\\mbtx\\" + type + ".jpg", s = null;
        Image image = new Image(Fingerprint.getFingerprintPhash(s0), 0, -1);
        //s0 =  getFingerprint("F:\\image processing\\测试图片素材\\images(0).jpg");

        List<Image> imageList = new ArrayList<>();
        for (int i = 1; i <= 300; i++) {
            //s = "src\\img\\" + type + "\\" + type + " (" + i + ").jpg";
            s = "E:\\IDEA-1.6\\VueAdmin-master\\src\\assets\\img\\" + type + "\\" + type + " (" + i + ").jpg";
            imageList.add(new Image(Fingerprint.getFingerprintPhash(s), i, Fingerprint.hammingDistance(image.getPHash(), Fingerprint.getFingerprintPhash(s))));
        }

        String result = "";
        Collections.sort(imageList);
        /*for (Image i : imageList) {
            result += type + " (" + String.valueOf(i.getNumber()) + ").jpg" + "-" + String.valueOf(i.getHammingDistance()) + "\n";
        }*/
        //return result;
        return imageList;
    }

    public String changeName(String type){
        String result = "";
        String directory = "E:\\IDEA-1.6\\VueAdmin-master\\src\\assets\\img\\mbtx";
        File dir = new File(directory);
        String [] fileName = dir.list();
        if(fileName.length == 1){
            File old = new File(dir +"\\"+ fileName[0]);
            File newFile = new File(dir +"\\"+ type+ ".jpg");
            old.renameTo(newFile);
            result = directory + "\\" +  type+ ".jpg";
        }

        return result;
    }

    //上传图片
    public String upLoad(MultipartFile file){
        String res = "";
        // 判断文件是否为空
        if (!file.isEmpty()) try {
            // 文件保存路径
            //File directory = new File("");// 参数为空
            String directory = "E:\\IDEA-1.6\\VueAdmin-master\\src\\assets\\img\\mbtx";
            //删除文件夹下所有文件
            try {
                //delAllFile(directory.getCanonicalPath() + "\\src\\img\\mbtx\\"); // 删除完里面所有内容
                delAllFile(directory); // 删除完里面所有内容
            } catch (Exception e) {
                e.printStackTrace();
            }

            String filePath = directory +'\\'+ file.getOriginalFilename();
            // 转存文件
            file.transferTo(new File(filePath));
            res = filePath;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    //删除文件夹下所有文件
    public static boolean delAllFile(String path) {
        boolean flag = false;
        File file = new File(path);
        if (!file.exists()) {
            return flag;
        }
        if (!file.isDirectory()) {
            return flag;
        }
        String[] tempList = file.list();
        File temp = null;
        for (int i = 0; i < tempList.length; i++) {
            if (path.endsWith(File.separator)) {
                temp = new File(path + tempList[i]);
            } else {
                temp = new File(path + File.separator + tempList[i]);
            }
            if (temp.isFile()) {
                temp.delete();
            }
            if (temp.isDirectory()) {
                delAllFile(path + "/" + tempList[i]);// 删除文件夹里面的文件
                flag = true;
            }
        }
        return flag;
    }

}
