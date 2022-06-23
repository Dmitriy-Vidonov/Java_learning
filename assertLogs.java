import java.util.logging.*;

public class assertLogs {

    public static void main(String[] args){

        Logger LOGGER_A = Logger.getLogger(assertLogs.class.getName());
        LOGGER_A.setLevel(Level.INFO);

        ConsoleHandler ch = new ConsoleHandler();
        LOGGER_A.addHandler(ch);

        SimpleFormatter sf = new SimpleFormatter();
        ch.setFormatter(sf);
        
        Catto kot = new Catto(5, 1, 5, 100, "млекопитающее", 50, "Котовский");

        System.out.println("Кот по имени " + kot.getName() + " мурчит с частотой " + kot.getFq() + " герц.");
        kot.Roar();

        LOGGER_A.info("Вывод работы метода getKinetic()");
        System.out.println(kot.getKinetic(kot.getSpeed(), kot.getWeight()));
    
    }
}

class Animalis {
    private int weight;
    private int height;
    private int age;
    int speed;
    private String type; //тип - млекопитающие или рыбы например

Animalis(int weight, int height, int age, int speed, String type){
    this.weight = weight;
    this.height = height;
    this.age = age;
    this.speed = speed;
    this.type = type;
}

    public int getWeight() { return weight; }
    public int getHeight() { return height; }
    public int getAge() { return age; }
    public int getSpeed() { return speed; }
    public String  getType() { return type; }

    public void setWeight(int weight) {  if(weight > 0 && weight < 100000) {}  this.weight = weight; }
    public void setHeight(int height) { if(height > 0 && height < 50) { this.height = height; } }
    public void setAge(int age) { if(age > 0 && age < 500) { this.age = age; } }
    public void setType(String type) { this.type = type; }

    public void Run(int speed) { 
        if (speed > 0 && speed < 400) {
            this.speed = speed;
        }
     }

     public void Stop() {
        speed = 0;
     }

    public void Roar() {
        System.out.println("Какое-то рычание, не понятно");
    }
}

class Catto extends Animalis {
    private int fq;
    private String name;

    Catto(int weight, int height, int age, int speed, String type, int fq, String name) {
        super(weight, height, age, speed, type);
        this.fq = fq;
        this.name = name;
    }
    
    public int getFq() { return fq; }
    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public void purr(int fq) { if(fq > 0 && fq < 300) { this.fq = fq; } }

    @Override
    public void Roar() {
        System.out.println("Ну мяу! Ну чего тебе еще надо?");
    }

    public int getKinetic(int speed, int weight) {
        int res = 0;
        res = weight * (int)Math.pow(speed, 2);
        assert res > 0 && res < 10000;
        return res;
    }
}

/*
 Запуск скрипта с ключом -ea при параметрах - "скорость кота 5, вес кота - 10"

 $ java -ea assertLogs.java
Кот по имени Котовский мурчит с частотой 50 герц.
Ну мяу! Ну чего тебе еще надо?
июн. 23, 2022 3:38:35 PM assertLogs main
INFO: Вывод работы метода getKinetic()
июн. 23, 2022 3:38:35 PM assertLogs main
INFO: Вывод работы метода getKinetic()
500

Запуск скрипта с ключом -ea при параметрах - "скорость кота 100, вес кота - 5"

$ java -ea assertLogs.java
Кот по имени Котовский мурчит с частотой 50 герц.
Ну мяу! Ну чего тебе еще надо?
июн. 23, 2022 3:42:04 PM assertLogs main
INFO: Вывод работы метода getKinetic()
июн. 23, 2022 3:42:04 PM assertLogs main
INFO: Вывод работы метода getKinetic()
Exception in thread "main" java.lang.AssertionError
	at Catto.getKinetic(assertLogs.java:93)
	at assertLogs.main(assertLogs.java:22)

 */