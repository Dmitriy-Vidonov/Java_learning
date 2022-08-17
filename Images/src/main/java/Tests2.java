import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class Tests2 {
    public static void main(String[] args) {
        /*4_1*/
        //задаем 2 типа расширений
        String ext1 = "png";
        String ext2 = "tiff";
        try {
            ArrayList<String> images = new ArrayList<>();
            images = (Files_Dirs_4_2.filesNdirs(".", ext1, false)).get(0);

            for(int i=0; i< images.size(); i++) {
                String name = images.get(i);
                BufferedImage img = ImageIO.read(new File(name));
                ImageIO.write(img, ext2, new File(name.substring(0, name.lastIndexOf('.'))));
                
                File file = new File(name);
                if (file.exists()) file.delete();
            }
        } catch (Exception ex) {
            System.out.println("Exception during work with convertation - " + ex);
        }
    }
}
