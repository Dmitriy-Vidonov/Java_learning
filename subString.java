package substringsearch;
import java.util.Arrays;

public class subString {
    public static void main(String[] args) {

        String stroka = "авангардная"; //исходная строка
        String podStroka = "ванга"; //подстрока

        char[] massivStroka = stroka.toCharArray(); //массив для исходной строки
        char[] massivPodStroka = podStroka.toCharArray(); //массив для подстроки
        char[] massivRes = new char[podStroka.length()]; //контрольный массив

        int res = 0;
       
        if(podStroka.length() <= stroka.length()) {
            for (int j = 0; j < podStroka.length(); j++) {
                for (int i = 0; i < stroka.length(); i++) {
                    if(massivPodStroka[j] == massivStroka[i]) {
                        massivRes[res] = massivPodStroka[j];
                        res += 1;
                        break;
                    }
                }
            }
        } 
            if (Arrays.equals(massivRes, massivPodStroka)) { System.out.println("Подстрока найдена!"); }
            else { System.out.println("Подстрока не найдена!"); }
    }
}
