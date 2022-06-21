//описание класса "Подводные суда"
class UnderWaterVessel {
    private int depthOfImmersion; //глубина погружения
    private int autonomyHours; //автономность в часах
    private int displacement; //водоизмещение
    private int radiusOfOperation; //радиус действия

    //Описание параметризированного конструктора
    UnderWaterVessel(int depthOfImmersion, int autonomyHours, int displacement, int radiusOfOperation) {
        this.depthOfImmersion = depthOfImmersion;
        this.autonomyHours = autonomyHours;
        this.displacement = displacement;
        this.radiusOfOperation = radiusOfOperation;
    }

    //геттеры класса - получаем значения изначально скрытых полей
    public int getDepthOfImmersion() { return depthOfImmersion; }
    public int getAutonomyHours() { return autonomyHours; }
    public int getDisplacement() { return displacement; }
    public int getRadiusOfOperation() { return radiusOfOperation; }
    
    //сеттеры класса - методы для установки новых значений для изначально скрытых полей
    public void setDepthOfImmersion(int depthOfImmersion) { this.depthOfImmersion = depthOfImmersion; }
    public void setAutonomyHours(int autonomyHours) { this.autonomyHours = autonomyHours; }
    public void setDisplacement(int displacement) { this.displacement = displacement; }
    public void setRadiusOfOperation(int radiusOfOperation) { this.radiusOfOperation = radiusOfOperation; }

    //уникальные методы, присущие исключительно данному классу
    public void upward() { System.out.println("Процесс всплытия запущен!"); }
    public void downward() { System.out.println("Процесс погружения запущен!"); }

    public void foo() {
        System.out.println("Метод foo для класса UnderWaterVessel");
    }
}

//описание класса DroneUW, который является потомком класса UnderWaterVessel
class DroneUW extends UnderWaterVessel {
    private String name; //имя дрона
    private int cableLen; //длина кабеля
    private boolean isIRsensor; //наличие ИК-датчика

    //описание параметризированного класса с наследованием полей от родительского класса через конструкцию super()
    DroneUW(int depthOfImmersion, int autonomyHours, int displacement, int radiusOfOperation, String name, 
            int cableLen, boolean isIRsensor) {
        super(depthOfImmersion, autonomyHours, displacement, radiusOfOperation);
        this.name = name;
        this.cableLen = cableLen;
        this.isIRsensor = isIRsensor;
    }
    
    //геттеры класса-потомка
    public String getName() { return name; }
    public int getCableLen() { return cableLen; }
    public boolean getIsIRsensor() { return isIRsensor; }

    //сеттеры класса-потомка
    public void setName(String name) { this.name = name; }
    public void setCableLen(int cableLen) { this.cableLen = cableLen; }
    public void setIsIRsensor(boolean isIRsensor) { this.isIRsensor = isIRsensor; }

    //уникальные методы класса-потомка
    public void cableEject() {
        System.out.println("Разматываем кабель!");
    }

    public void switchOnIRsensor() {
        if (isIRsensor = true) System.out.println("ИК - режим активирован!");
    }

    @Override //переопределение метода foo()
    public void foo() {
        System.out.println("Метод foo для класса DroneUW");
    }
}

//описание класса "Боевая подлодка", который является потомком класса "Подводные суда"
class BattleSubm extends UnderWaterVessel {
    private int torpedoesMax; //максимальное число торпед
    private int bombMax; //максимальное число бомб
    private int sonarRange; //зона действия сонара в метрах
    private String model; //модель подлодки

    //описание параметризированного конструктора для класса
    BattleSubm(int depthOfImmersion, int autonomyHours, int displacement, int radiusOfOperation,
                    int torpedoesMax, int bombMax, int sonarRange, String model) {
        super(depthOfImmersion, autonomyHours, displacement, radiusOfOperation);
        this.torpedoesMax = torpedoesMax;
        this.bombMax = bombMax;
        this.sonarRange = sonarRange;
        this.model = model;
    }

    //геттеры для класса - получаем значения скрытых полей
    public int getTorpedoesMax() { return torpedoesMax; }
    public int getBombMax() { return bombMax; }
    public int getSonarRange() { return sonarRange; }
    public String getModel() { return model; }
    
    //сеттеры для класа - задаем значения скрытым полям
    public void setTorpedoesMax(int torpedoesMax) { this.torpedoesMax = torpedoesMax; }
    public void setBombMax(int bombMax) { this.bombMax = bombMax; }
    public void setSonarRange(int sonarRange) { this.sonarRange = sonarRange; }

    //уникальные методы для класса
    public void torpedoeLaunch(){
        System.out.println("Пуск торпеды!");
    }

    public void bombSet(){
        System.out.println("Бомба установлена!");
    }

    @Override //переопределение метода foo()
    public void foo(){
        System.out.println("Метод foo для класса BattleSubmarine");
    }
}

public class tri_kita_part2_ex2 {
    public static void main(String args[]) {
        //создаем массив объектов fleet родительского класса UnderWaterVessel
        UnderWaterVessel[] fleet = new UnderWaterVessel[500];

        //заполняем массив либо дронами либо подводными лодками
        for (int i = 0; i < fleet.length; i++) {
            int count = (int)(Math.random()*(3 - 1)) + 1; //генерируем рандомное целое число - 1 или 2

            if (count == 1) { fleet[i] = new DroneUW(500, 10, 500, 500, "дрон" + i, 
                1000, true); } //если выпало число 1 - создаем объект от DroneUW
            if (count == 2) { fleet[i] = new BattleSubm(3000, 1000, 5000, 50000,
                20, 10, 15000, "sub_n" + i); } //если выпало число 2 - создаем объект от BattleSubmarine
        }

        //берем 10 элементов массива и выводим результат метода foo() для каждого элемента
        //хоть метод и один на всех, но у каждого потомка он переопределен, поэтому значения разные
        for (int i = 0; i < 10; i++) {
            fleet[i].foo(); //вызов метода foo() потомков класса
        }
    }
}

/*РЕЗУЛЬТАТ РАБОТЫ ПРОГРАММЫ

 Метод foo для класса DroneUW
Метод foo для класса BattleSubmarine
Метод foo для класса BattleSubmarine
Метод foo для класса BattleSubmarine
Метод foo для класса DroneUW
Метод foo для класса BattleSubmarine
Метод foo для класса DroneUW
Метод foo для класса DroneUW
Метод foo для класса DroneUW
Метод foo для класса BattleSubmarine
*/
