import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class Ex_100pairs {
    public static void main(String[] args) {
        /*1. Напиши небольшую программу, которая добавляет в
        словарь 100 случайных пар (предварительно в массив
        например ключи записываем)
        целый ключ + значение строка,
        затем считывает по ключам все значения и выводит, и затем
        удаляет все пары.*/

        //Генерация ключей
        ArrayList<Integer> keys = new ArrayList<>();
        int i;
        while(keys.size()!=10){
            i=ThreadLocalRandom.current().nextInt(10, 99 + 1);;
            if(!keys.contains(i)){
                keys.add(i);
            }
        }
        //System.out.println(keys);

        HashMap<Integer, String> pairs100 = new HashMap<Integer, String>();
        for (int j=0; j<keys.size(); j++){
            pairs100.put(keys.get(j), StringGen.generator(10));
        }
        //System.out.println(pairs100);

        //Считываем по ключам все значения
        for(Integer k : pairs100.keySet()) {
            System.out.println("key:" + k + " value:" + pairs100.get(k));
        }
        pairs100.clear(); //удаляем все пары
        System.out.println(pairs100);
    }
}
