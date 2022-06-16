//описание класса "ручное оружие"
class handWeapon {
    int defeatRadius; //радиус поражения
    double spread; //разброс
    int roundsCurrent; //текущее число патронов в обойме
    int roundsInMagazine; //емкость обоймы
    int roundsTotal; //патронов всего
    int shotsPerMinute; //темп стрельбы, выстрелов в минуту
    String typeOfGun; //тип оружия
    int reloadTime; //время перезарядки

//конструктор класса "ручное оружие" с параметрами
handWeapon (int dR, double s, int rC, int rIM, int rT, int sPM, String tG, int rel){
    defeatRadius = dR;
    spread = s;
    roundsCurrent = rC;
    roundsInMagazine = rIM;
    roundsTotal = rT;
    shotsPerMinute = sPM;
    typeOfGun = tG;
    reloadTime = rel;
}

//метод класса "ручное оружие" - выстрел
void shot() {
    roundsCurrent -= 1;
    roundsTotal -= 1;
}

//метод класса "ручное оружие" - стрельба залпом
void doubleShot() {
    roundsCurrent -= 2;
    roundsTotal -=2;
}

//метод класса "ручное оружие" - перезарядка
void reload() {
    if (roundsTotal > roundsInMagazine) { //если в запасе больше одной полной обоймы
        roundsTotal -= roundsInMagazine - roundsCurrent;
        roundsCurrent = roundsInMagazine;
    }
    if (roundsTotal < roundsInMagazine) {
        roundsCurrent += roundsTotal; //если патронов нет на полную обойму
     } 
}

//метод класса "ручное оружие" - пополнение боеприпаса
void getAmmo(int crates) { //crates - число ящиков с боеприпасами
    roundsTotal += crates * roundsInMagazine * 3; //предположим, что в ящике с патронами 3 полных обоймы
}
}

//описание класса "червячок"
class worm {
    String name; //имя червяка
    String team; //команда червяка
    int health; //здоровье
    double speed; //скорость передвижения
    String lang; //используемый язык озвучки
    String grave; //могилка
    double jumpHeight; //высота прыжка
    double jumpDistance; //длина прыжка
    int weight; //вес

    //конструктор класса "червячок" с параметрами
    worm (String w_name, String w_team, int w_health, double w_speed, String w_lang, String w_grave,
          double w_jumpHeight, double w_jumpDistance, int w_weight){
            name = w_name;
            team = w_team;
            health = w_health;
            speed = w_speed;
            lang = w_lang;
            grave = w_grave;
            jumpHeight = w_jumpHeight;
            jumpDistance = w_jumpDistance;
            weight = w_weight;
    }

    

}

public class oop_part2_ex1 {
    public static void main(String args[]) {

        //создание объектов класса "ручное оружие"
        handWeapon pistol = new handWeapon(100, 1, 5, 5, 25, 70, "manual", 2);
        handWeapon shotgun = new handWeapon(60, 10, 2, 2, 10, 30, "manual", 5);
        handWeapon uzi = new handWeapon(90, 30, 30, 30, 150, 900, "automatic", 3);

        //подняли 2 ящика с патронами для дробовика
        int crates = 2;
        shotgun.getAmmo(crates);

        //сколько стало патронов на дробовик
        System.out.println("Всего патронов на дробовик после подъема 3-х ящиков - " + shotgun.roundsTotal);

        //сделали 3 выстрела из пистолета
        for (int i = 0; i < 3; i++) {
            pistol.shot();
        }
        System.out.println("Осталось патронов в обойме пистолета после 3-х выстрелов - " + pistol.roundsCurrent 
        + "\n" + "Всего осталось " + pistol.roundsTotal + " патронов на пистолет."); 

        //перезарядили пистолет
        pistol.reload();

        System.out.println("Патронов в обойме пистолета после перезарядки - " + pistol.roundsCurrent + "\n"
                           + "Всего патронов на пистолет осталось - " + pistol.roundsTotal);

        System.out.println("При полной загрузке на старте у нас " + uzi.roundsTotal / uzi.roundsInMagazine + " обойм на узи");
    }
}
