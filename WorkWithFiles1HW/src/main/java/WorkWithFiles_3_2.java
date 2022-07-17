import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WorkWithFiles_3_2 {
    public static int SumOf6(int a, int b, String filePath) throws IOException {
    int sum = 0;
    int[] arr = {a, b};

    for (int i = 0; i < 2; i++) {
        BufferedReader br = new BufferedReader(new FileReader(filePath + arr[i] + ".txt"));
        int stringsControl = 0; //контрольная переменная для проверки числа строк в файле
        String st = br.readLine();

        try {
            while (st != null) {
                sum += Integer.parseInt(st);
                st = br.readLine();
                stringsControl += 1;
            }
            assert stringsControl == 3 : "file" + filePath + arr[i] + ".txt" + " has incorrect amount of only digit strings: " + stringsControl;
        } catch(Exception ex) {
            System.out.println("Error in (while loop) of SumOf6 method! Wrong string = " + st);
        }
       finally {
            br.close();
        }
    }
        return sum;
    }
}
