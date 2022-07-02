import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {
    private static Logger logMain = Logger.getLogger(Main.class.getName()); //логгер для текущего класса
    public static void main(String[] args) throws IOException {

        LogManager.getLogManager().readConfiguration(Main.class.getResourceAsStream("logging.properties"));

        try {
            StringGen gen = new StringGen();
            String str1 = gen.generator(30);
            String str2 = gen.generator(5);

            SubStrMethod subSearch = new SubStrMethod();
            System.out.println(subSearch.searchMethod(str1, str2));
            System.out.println(subSearch.searchMethod("", ""));
            throw new Exception("some exception from main");
        } catch (Exception ex) {
            logMain.logp(Level.SEVERE, "Main", "trying to generate strings and get results",
                    "Exception - " + ex);
        }
    }
}
