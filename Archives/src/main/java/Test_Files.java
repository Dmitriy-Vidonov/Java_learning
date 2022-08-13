import java.io.*;

public class Test_Files {
    public static void main(String[] args) throws Exception {
        File my_file = new File("pom.xml"); //просто связали переменную с именем файла
        BufferedReader br = new BufferedReader(new FileReader(my_file));
    }
}
