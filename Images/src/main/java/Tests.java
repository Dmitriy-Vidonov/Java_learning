import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.crypto.Cipher;
import javax.imageio.ImageIO;

public class Tests {
    public static void main(String[] args) throws Exception {
        /*Изображение BufferedImage*/
        //Открытие изображения
        BufferedImage pic = ImageIO.read(new File("pic.jpg"));

        //Создание пустого изображения 800x6oo (здесь оно находится чисто в памяти, без связи с файлами
        //TYPE_INT_RGB - формат каждого пикселя изображния. TYPE_INT_RGB - тут используем целое число для кодирования
        //цвета одной точки изображения в формате RGB
        BufferedImage newImage = new BufferedImage(800,600, BufferedImage.TYPE_INT_RGB);

        /*Сохранение изображения*/
        //сохраняем картинку после работы либо обратно в исходный файл либо в новый
        ImageIO.write(pic, "png", new File("in1.png"));

        /*Рисование на изображении*/
        BufferedImage img = ImageIO.read(new File("in.png"));
        //заполним все изображение красным цветом
        for(int x = 0; x < img.getWidth(); x++) {
            for(int y = 0; y < img.getHeight(); y++) {
                img.setRGB(x, y, Color.RED.getRGB());
            }
        }
        ImageIO.write(img, "png", new File("red.png"));

        /*Нарисуем в центре изображения красный прямоугольник размером 150x25 пикселей*/
        BufferedImage imgDraw = ImageIO.read(new File("in.png"));
        Graphics graphic = imgDraw.getGraphics();

        //размеры прямоугольника
        int w = 150, h = 25;

        graphic.setColor(Color.RED); //задать цвет прямоугольника
        //нарисовать прямоугольник
        graphic.fillRect((imgDraw.getWidth()-w)/2, (imgDraw.getHeight()-h)/2, w, h);

        graphic.setColor(Color.GREEN);
        //нарисовать овал, вписанный в изображение
        graphic.drawOval(0, 0, imgDraw.getWidth(), imgDraw.getHeight());

        graphic.setColor(Color.ORANGE);
        //Вывести текст в позиции 50, 50 (начало координат - левый верхний угол)
        graphic.drawString("Point is here", 50,50);

        graphic.dispose(); //освобождаем холст

        //записываем итоговое изображение в файл
        ImageIO.write(imgDraw, "png", new File("red_rectangle.png"));
    }
}
