class Koshka {
    private String name;
    private int age;
    private int weight;

    Koshka(String name, int age, int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public int getWeight() { return weight; }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setWeight(int weight) { this.weight = weight; }
    
    public void foo(int fq, int hours) {
        System.out.println("За " + hours + " часа при частоте " + fq + " герц, мурчало кота сделает " 
                          + fq * hours * 3600 + " колебаний!");
    }

    public void foo(String city) {
        System.out.println("Кот " + getName() + " квартируется в городе " + city + ".");
    }

    public void foo(int speed) {
        System.out.println("При массе " + getWeight() + " кг" + " и скорости " + speed + " м/c," + " кот " + getName()
                          + " обладает кинетической энергией в " + getWeight() * (int)Math.pow(speed, 2) 
                          + " джоулей!");
    }
}

public class tri_kita_part2_ex3 {
    public static void main(String args[]){
        Koshka kotik = new Koshka("Дзержинский", 5, 10); 
        kotik.foo("Москва"); //метод foo с указанием города
        kotik.foo(50, 4); //метод foo с указанием частоты мурчания и времени в часах
        kotik.foo(10); //метод foo с указанием скорости и расчетом кинетической энергии
    }
}

/*РЕЗУЛЬТАТ РАБОТЫ ПРОГРАММЫ
Кот Дзержинский квартируется в городе Москва.
За 4 часа при частоте 50 герц, мурчало кота сделает 720000 колебаний!
При массе 10 кг и скорости 10 м/c, кот Дзержинский обладает кинетической энергией в 1000 джоулей!
*/
