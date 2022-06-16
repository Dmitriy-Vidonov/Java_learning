import javax.smartcardio.CardTerminal;

class cat { //создали простой класс "кот"
    int age;
    int weight;
    String fullName;
}


public class oop_part1_ex3 {
    public static void main(String args[]) {

        cat barsik = new cat(); //создали кота Барсика

        barsik.age = 3;
        barsik.weight = 4;
        barsik.fullName = "Барсик Почеширский";

        cat murzik = barsik; //создали Мурзика, ссылаясь на объект "Барсик"
        
        murzik.age = 10;
        murzik.weight = 5;
        murzik.fullName = "Мурзон Великолепный";

        System.out.println("Имя кота: " + barsik.fullName); //при использовании объекта barsik будет выведено имя, заданное
                                                            //в объекте murzik
        
    }
}
