package xin.chung.image.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image implements Comparable {
    String pHash;
    int number;//图片编号
    int hammingDistance;//相似度，0最相似

    @Override
    public int compareTo(Object o) {
        if (this.hammingDistance == ((Image) o).hammingDistance) {
            return this.number - ((Image) o).number;
        }
        return this.hammingDistance - ((Image) o).hammingDistance;
    }
}
