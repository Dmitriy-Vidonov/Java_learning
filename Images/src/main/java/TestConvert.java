import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TestConvert {
    public static void main(String[] args) throws IOException {
        BufferedImage pic = ImageIO.read(new File("in.png"));
        ImageIO.write(pic, "jpg", new File("in.jpg"));
        File file = new File("in.png");
        if (file.exists()) file.delete();
    }
}
