import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java_Stream_API {
    public static void main(String[] args) throws IOException {
        Integer[] intArray = {5, 10, 70, 39, 10, 7}; //сделали массив
        ArrayList<Integer> intList = new ArrayList<>();
        intList.addAll(Arrays.asList(intArray)); //перенесли массив в список

        //найти сумму всех нечетных в списке
        int sum = 0;
        for (Integer i : intList) {
            if (i % 2 != 0) { //нечетные
                sum += i;
            }
        }
        System.out.println("сумма всех нечетных - " + sum);

        /*То же самое в Stream API*/
        Integer StreamSum = intList.stream().filter(o -> o % 2 != 0).reduce((s1, s2) -> s1 + s2).orElse(0);
        System.out.println("сумма всех нечетных через Stream = " + StreamSum);

        /*То же самое с parallel stream*/
        Integer StreamSumPar = intList.parallelStream().filter(o -> o % 2 != 0).reduce((s1, s2) -> s1 + s2).orElse(0);
        System.out.println("сумма всех нечетных через Parallel Stream = " + StreamSumPar);

        /*Способы создания стримов*/

        //1. Классический. Создание стрима из коллекции
        Collection<String> collection = Arrays.asList("a1", "a2", "a3");
            Stream<String> streamCollection = collection.stream();

        //2. Создание стрима из значений
        Stream<String> streamFromValues = Stream.of("a1", "a2", "a3");

        //3. Создание стрима из массива
        String[] StringArray = {"a1", "a2", "a3"};
            Stream<String> streamFromArray = Arrays.stream(StringArray);

        //4. Создание стрима из файла (каждая строка в файле будет отдельным элементом в стриме)
        Stream<String> streamFromFile = Files.lines(Paths.get("pom.xml"));
        System.out.println(streamFromFile.toList()); //вывели на печать содержимое стрима

        //5. Создание стрима из строки
        IntStream streamFromString = "12345".chars();

        //6. С помощью Stream.builder
        Stream.builder().add("a1").add("a2").add("a3").build();

        //7. Создание параллельного стрима
        Stream<String> stream = collection.parallelStream();

        //8. Создание бесконечного стрима с помощью Stream.iterate
        Stream<Integer> streamFromIterate = Stream.iterate(1, n -> n + 1);

        //9. Создание бесконечного стрима с помощью Stream.generate
        Stream<String> streamFromGenerate = Stream.generate(() -> "a1");


    }
}
