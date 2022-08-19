import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class hashN {
    public static ArrayList<Integer> hashN(ArrayList<Integer> arrList, int N){
        //задаем итоговый список для вывода результата работы метода
        ArrayList<Integer> finList = new ArrayList<>();
            try{
                //задаем словарь для хранения числа вхождений элементов в список
                HashMap<Integer, Integer> hashM = new HashMap<>();
                for(Integer counter : arrList) {
                    if (!hashM.containsKey(counter)) { //если элемента еще нет в словаре - добавляем пару со значением 1
                        hashM.put(counter, 1);
                    } else { //если элемент уже есть в словаре - обновляем текущее значение на 1
                        hashM.put(counter, hashM.get(counter) + 1);
                    }
                }
                //задаем цикл по entrySet() для проверки всех элементов словаря
                for (Map.Entry<Integer, Integer> searchKeys: hashM.entrySet()) {
                    if (searchKeys.getValue() >= N) { //если значение соответствует условию,
                        finList.add(searchKeys.getKey()); //получаем ключ пары
                    }
                }
            } catch (Exception ex) {
                System.out.println("Exception during work with hashmap - " + ex);
            }
        return finList;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arrInt = new ArrayList<>();
        //заполнили список рандомными значениями от 1 до 10
        for (int i=0; i<100; i++) {
            arrInt.add(ThreadLocalRandom.current().nextInt(1, 10 + 1));
        }

        System.out.println(Arrays.asList(hashN(arrInt, 10)));
    }
}

