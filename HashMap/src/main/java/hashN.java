import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class hashN {
    public static ArrayList<Integer> hashN(ArrayList<Integer> arrList, int N){
        ArrayList<Integer> finList = new ArrayList<>();
        try {
            for (int i=0; i<100; i++) {
                arrList.add(ThreadLocalRandom.current().nextInt(1, 10 + 1));
            }
            HashMap<Integer, Integer> hashM = new HashMap<>();

            for(Integer counter : arrList) {
                if (!hashM.containsKey(counter)) {
                    hashM.put(counter, 1);
                } else {
                    hashM.put(counter, hashM.get(counter) + 1);
                }
            }
            for (Map.Entry<Integer, Integer> searchKeys: hashM.entrySet()) {
                if (searchKeys.getValue() >= N) {
                    finList.add(searchKeys.getKey());
                }
            }
        } catch (Exception ex) {
            System.out.println("Exception during hashmap operations - " + ex);
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

