import java.util.zip.*;

public class Compress_Decompress {
    public static void main(String[] args) {
        try{
            //кодируем строку в байты
            String inputStroka = "some_blah_blah_thing";
            //getBytes() - переводит строку в массив байтов
            byte[] vhodArray = inputStroka.getBytes("UTF-8"); //в массив vhodArray занесли строку в байтах

            System.out.println("input string - " + inputStroka);

            //сжатие байтов
            byte[] vyhodArray = new byte[100]; //создаем выходной массив байтов
            Deflater compressor = new Deflater(); //создание нового "сжимателя" типа Deflater
            compressor.setInput(vhodArray); //подали компрессору массив байтов на вход
            compressor.finish(); //завершение работы компрессора
            int CompressedDataLength = compressor.deflate(vyhodArray); //получаем длину сжатого байтового массива
            compressor.end(); //освобождение ресурсов после работы компрессора

            System.out.println("decoded string - " + vyhodArray);

            //распаковка байтов
            Inflater decompressor = new Inflater(); //создание нового обьекта класса Inflater
            decompressor.setInput(vyhodArray, 0, CompressedDataLength); //на вход подаеи массив сжатых данных
            byte[] resultat = new byte[100]; //создаем выходной массив байтов
            int resultatLength = decompressor.inflate(resultat); //получаем длину распакованного массива
            decompressor.end(); //освобождение ресурсов после работы декомпрессора

            //перевод байтов в строку
            String itogStroka = new String(resultat, 0, resultatLength, "UTF-8");

            System.out.println("final string - " + itogStroka);

        } catch (java.io.UnsupportedEncodingException ex) {
            System.out.println("some problems occured during string decode / encode  - " + ex);
        } catch (java.util.zip.DataFormatException ex) {
            System.out.println("some problems with data, occured during string decode / encode - " + ex);
        }

    }
}
