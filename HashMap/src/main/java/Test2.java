import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Test2 {
    public static void main(String[] args) {
        //создали список
        ArrayList<Integer> arrInt = new ArrayList<>();
        //заполнили список рандомными значениями от 1 до 10
        for (int i=0; i<100; i++) {
            arrInt.add(ThreadLocalRandom.current().nextInt(1, 10 + 1));
        }
        //System.out.println(Arrays.asList(arrInt)); //вывели содержимое списка на экран

        HashMap<Integer, Integer> hashM = new HashMap<>(); //создали словарь для хранения карты значений
        /*смотрим - есть ли уже такой ключ, какой мы хотим добавить. если нет - добавляем со значением 1
         если есть - получаем значение и добавляем заново со значнием +1 */
        for(Integer counter : arrInt) {
            if (!hashM.containsKey(counter)) {
                hashM.put(counter, 1);
            } else {
                hashM.put(counter, hashM.get(counter) + 1);
            }
        }
        System.out.println(hashM);

        int N = 10;
        /*Пройтись по всему словарю и вывести в список только те ключи, значения которых равны или больше N*/
        ArrayList<Integer> finList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> searchKeys: hashM.entrySet()) {
            if (searchKeys.getValue() >= N) {
                //System.out.println(searchKeys.getKey());
                finList.add(searchKeys.getKey());
            }
        }
        System.out.println(Arrays.asList(finList));
    }
}
