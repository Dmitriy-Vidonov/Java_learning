import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class hashN {
    public static ArrayList<Integer> hashN(ArrayList<Integer> arrList, int N){
        //задаем итоговый список для вывода результата работы метода
        ArrayList<Integer> finList = new ArrayList<>();
            try{
                //задаем словарь для хранения числа вхождений элементов в список
                HashMap<Integer, Integer> hashM = new HashMap<>();
                int value = 1;
                //заполнение словаря, где ключ - элемент списка, значение - число вхождения элемента в список
                for(Integer counter : arrList) {
                    if (!hashM.containsKey(counter)) {
                        hashM.put(counter, 1);
                    }
                    else {
                        value = hashM.get(counter) + 1;
                        hashM.put(counter, value);
                        //проверка значений пар на соответствие условию >= N
                        if (value >= N && !finList.contains(counter)) {
                            finList.add(counter);
                        }
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

