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
        /*for (int i=0; i<100; i++) {
            arrInt.add(ThreadLocalRandom.current().nextInt(1, 10 + 1));
        }*/
        Integer[] nums = {3, 5, 2, 5, 8, 10, 3, 8, 8, 6, 6, 2, 1, 1, 2, 5, 4, 9, 2, 9, 7, 4, 8, 3, 5, 6, 2, 9, 4, 5, 7, 5, 8, 7, 8, 3, 10, 2, 9, 8, 3, 4, 7, 6, 6, 10, 5, 10, 4, 7, 3, 6, 8, 1, 2, 8, 10, 1, 1, 4, 2, 5, 5, 2, 5, 7, 3, 5, 3, 4, 7, 1, 4, 8, 5, 10, 1, 6, 8, 5, 1, 4, 6, 2, 3, 9, 6, 3, 5, 8, 8, 7, 2, 1, 6, 2, 5, 3, 9, 10};
        ArrayList<Integer> aList = new ArrayList<Integer>(Arrays.asList(nums));

        System.out.println(Arrays.asList(aList));
        System.out.println(Arrays.asList(hashN(aList, 10)));
    }
}

