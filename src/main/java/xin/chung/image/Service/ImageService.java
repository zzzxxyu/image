package xin.chung.image.Service;

import org.springframework.stereotype.Service;
import xin.chung.image.Entity.Image;
import xin.chung.image.Utils.Fingerprint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ImageService {
    public Image match(String type) {
        String s0 = "src\\img\\mbtx\\" + type + ".jpg", s = null;
        Image image = new Image(Fingerprint.getFingerprintPhash(s0), 0, -1);
        //s0 =  getFingerprint("F:\\image processing\\测试图片素材\\images(0).jpg");

        List<Image> imageList = new ArrayList<>();
        for (int i = 1; i <= 300; i++) {
            s = "src\\img\\" + type + "\\" + type + " (" + i + ").jpg";
            imageList.add(new Image(Fingerprint.getFingerprintPhash(s), i, Fingerprint.hammingDistance(image.getPHash(), Fingerprint.getFingerprintPhash(s))));
        }

        String result = "";
        Collections.sort(imageList);
        for (Image i : imageList) {
            result += String.valueOf(i.getNumber()) + "-" + String.valueOf(i.getHammingDistance()) + "\n";
        }

        return imageList.get(0);
    }
}
