//класс - моторные лодки
class MotorBoat { 
    private String model;
    private int serialNumber;

    MotorBoat(String model, int serialNumber) {
        this.model = model;
        this.serialNumber = serialNumber;
    }

    String getModel() { return model; }
    int getSerialNumber() { return serialNumber; }

    void setModel(String model) { this.model = model; } 
    void setSerialNumber(int serialNumber) { this.serialNumber = serialNumber; }
        
    }

//класс - подводные суда
class UnderWVessels {
    private int depthOfImmersion; //глубина погружения судна
    private int autonomyHours; //автономность в часах
    private int displacement; //водоизмещение

    UnderWVessels(int depthOfImmersion, int autonomyHours, int displacement) {
        this.depthOfImmersion = depthOfImmersion;
        this.autonomyHours = autonomyHours;
        this.displacement = displacement;
    }

    public int getDepthOfImmersion() { return depthOfImmersion; }
    public int getAutonomyHours() { return autonomyHours; }
    public int getDisplacement() { return displacement; }

    public void setDepthOfImmersion(int depthOfImmersion) { this.depthOfImmersion = depthOfImmersion; }
    public void setAutonomyHours(int autonomyHours) { this.autonomyHours = autonomyHours; }
    public void setDisplacement(int displacement) { this.displacement = displacement; }

    public void downward() { System.out.println("Погружение началось"); }
    public void upward() { System.out.println("Всплытие началось");  } 
        
}


//класс торпеды
class Torpedoe {
    private String tModel;
    private int tPower;
    private int tWeight;
    private int tMaxSpeed;

    Torpedoe(String tModel, int tPower, int tWeight, int tMaxSpeed) {
        this.tModel = tModel;
        this.tPower = tPower;
        this.tWeight = tWeight;
        this.tMaxSpeed = tMaxSpeed;
    }

    public String getTorpedoeModel() { return tModel; }
    public int getTorpedoePower() { return tPower; }
    public int getTorpedoeWeight() { return tWeight; }
    public int getTorpedoeMaxSpeed() { return tMaxSpeed; }

    public void setTorpedoeModel(String tModel) { this.tModel = tModel; }
    public void setTorpedoePower(int tPower) { this.tPower = tPower; }
    public void setTorpedoeWeight(int tWeight) { this.tWeight = tWeight; }
    public void setTorpedoeMaxSpeed(int tMaxSpeed) { this.tMaxSpeed = tMaxSpeed; }

    public void launch() { System.out.println("Торпеда запущена!"); }
}

//класс бомбы
class Bomb {
    private String bModel;
    private int bPower;
    private int bWeight;
    private int bdestRadius;

    Bomb(String bModel, int bPower, int bWeight, int bdestRadius) {
        this.bModel = bModel;
        this.bPower = bPower;
        this.bWeight = bWeight;
        this.bdestRadius = bdestRadius;
    }

    public String getBombModel() { return bModel; }
    public int getBombePower() { return bPower; }
    public int getBombeWeight() { return bWeight; }
    public int getBombDestroyRadius() { return bdestRadius; }

    public void setBombModel(String bModel) { this.bModel = bModel; }
    public void setBombPower(int bPower) { this.bPower = bPower; }
    public void setBombWeight(int bWeight) { this.bWeight = bWeight; }
    public void setBombDestroyRadius(int bdestRadius) { this.bdestRadius = bdestRadius; }

    public void launch() { System.out.println("Бомба запущена!"); }
}

//класс аптечка
class Medkit {
    private int weight;
    private String name;

    Medkit(int weight, String name) {
        this.weight = weight;
        this.name = name;
    }

    int getWeight() {
        return weight;
    }

    String getName() {
        return name;
    }

    void setWeight(int weight) { this.weight = weight; }
    void setName(String name) { this.name = name; }

    void heal() { System.out.println("Полечено аптечкой"); }
} 

//класс - двигатель
class EngineB {
    private int engWeight;
    private int engHorsePower;
    private String engModel;

    EngineB(int engWeight, int engHorsePower, String engModel) {
        this.engWeight = engWeight;
        this.engHorsePower = engHorsePower;
        this.engModel = engModel;
    } 
    
    public int getEngWeight() { return engWeight; }
    public int getEngineHorsePower() { return engHorsePower; }
    public String getEngineModel() { return engModel; }

    public void setEngineWeight(int engineWeight) { this.engWeight = engineWeight; }
    public void setEngineHorsePower(int engineHorsePower) { this.engHorsePower = engineHorsePower; }
    public void setEngineModel(String engModel) { this.engModel = engModel; }

    public void engStart() { System.out.println("Дигатель включен"); }
    public void engStop() { System.out.println("ДВигатель выключен"); }
}

//класс - спасательный круг
class Safelines {
    private int safeLineWeight; 
    private String safeLineModel;
    
    Safelines(int safeLineWeight, String safeLineModel) { this.safeLineWeight = safeLineWeight; this.safeLineModel = safeLineModel;}

    public int getSafeLineWeight() { return safeLineWeight; }
    public String getSafeLineModel() { return safeLineModel; }

    public void setSafeLineWeight(int safeLineWeight) { if (safeLineWeight > 0 && safeLineWeight < 10) 
        this.safeLineWeight = safeLineWeight; }

    public void setSafeLineModel(String safeLineModel) { this.safeLineModel = safeLineModel; }
}

//класс LBoat - потомок класса MotorBoat
class LBoat extends MotorBoat {
    private String boatname;
    private Medkit medkit;
    private EngineB engine;
    private Safelines safeline;

    //параметризированный конструктор
    LBoat(String model, int serialNumber, String boatname){
        super(model, serialNumber);
        this.boatname = boatname;
    }

    String getName() { return boatname; }
    void setName(String boatname) { this.boatname = boatname; }

    //задаем аптечку, если таковой не было ранее
    public Medkit getMedkit() {
        if (medkit == null) {
            medkit = new Medkit(1, "medkit");
        }
        return medkit;
    }
    
    //задаем двигатель, если ранее он не был установлен
    public EngineB getEngine() {
        if (engine == null) {
            engine = new EngineB(500, 1000, "engine_model_1");
        }
        return engine;
    }

    //задаем спасательный круг, если ранее его не было
    public Safelines getSafeline() {
        if (safeline == null) {
            safeline = new Safelines(2, "safeline_model_3");
        }
        return safeline;
    }
}

//класс - BattleSub - потомок класса UnderWVessels
class BattleSub extends UnderWVessels {
    private String subName;
    private int payload; //лимит загрузки
    private EngineB engine;
    private Torpedoe torpedoe;
    private Bomb bomb;
    
    BattleSub(int depthOfImmersion, int autonomyHours, int displacement, String subName, int payload) {
        super(depthOfImmersion, autonomyHours, displacement);
        this.subName = subName;
        this.payload = payload;
    }
    
    public String getSubName() { return subName; }

    public void setSubName(String subName) { this.subName = subName; }

    public EngineB getSubEngine() {
        if (engine == null) {
            engine = new EngineB(10000, 20000, "SubMarine engine model 5");
        }
        return engine;
    }

    public Torpedoe getSubTorpedoe() {
        if (torpedoe == null) {
            torpedoe = new Torpedoe("torpedoe model KFB34", 3000, 1000, 250);
            payload -= torpedoe.getTorpedoeWeight();
        }
        return torpedoe;
    }

    public Bomb getSubBomb() {
        if (bomb == null) {
            bomb = new Bomb("bomb model BF3000", 3500, 800, 500);
            payload -= bomb.getBombeWeight();
        }
        return bomb;
    }

    public void payloadCheck() {
        System.out.println("На субмарину возможно погрузить еще " + payload + " кг.");
    }

} 

public class tri_kita_part2_ex1 {
    public static void main(String args[]) {
        LBoat lodka = new LBoat("model", 10, "lodka1");
        BattleSub sub1 = new BattleSub(3000, 10000, 15, 
                                   "Щука-2000", 3000);
        System.out.println("У нас есть лодка - " + lodka.getName());
        System.out.println("На лодке есть аптечка - " + lodka.getMedkit().getName());
        System.out.println("На лодке установлен двигатель - " + lodka.getEngine().getEngineModel());
        System.out.println("На лодке установлен спасательный круг весом - " + lodka.getSafeline().getSafeLineWeight() + " кг.");
        System.out.println("У нас есть боевая субмарина - " + sub1.getSubName());
        System.out.println("На субмарине установлена торпеда - " + sub1.getSubTorpedoe().getTorpedoeModel() + 
                            " + бомба - " + sub1.getSubBomb().getBombModel());
        sub1.payloadCheck();
        sub1.getSubEngine().engStart();


    }
}
