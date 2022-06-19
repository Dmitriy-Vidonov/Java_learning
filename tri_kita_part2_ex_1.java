//описание родительского класса MotorBoats
class MotorBoats {
    private int freePayLoad; //свободная полезная нагрузка - сколько можно нагрузить на лодку
    private int currSpeed; //текущая скорость
    private int maxSpeed; //максимальная скорость

    //конструктор с параметрами класса-предка MotorBoats
    MotorBoats(int freePayLoad, int currSpeed, int maxSpeed) {
        this.freePayLoad = freePayLoad;
        this.currSpeed = currSpeed;
        this.maxSpeed = maxSpeed;
    }

    //геттеры класса-предка MotorBoats
    public int getFreePayload() { return freePayLoad; }
    public int getCurrSpeed() { return currSpeed; }
    public int getMaxSpeed() { return maxSpeed; }

    //сеттеры класса-предка MotorBoats
    public void setFreePayload(int freePayLoad) { if(freePayLoad > 0 && freePayLoad < 10000) this.freePayLoad = freePayLoad; }
    public void setCurrSpeed(int currSpeed) { if (currSpeed > 0) this.currSpeed = currSpeed; }
    public void setMaxSpeed(int maxSpeed) { if (maxSpeed > 0 && maxSpeed < 300) this.maxSpeed = maxSpeed; }

    public void stop() { currSpeed = 0; }
}

//Описание класса-компонента для SafeBoat - корпус
class BoatBody {
    private int length; //длина
    private int width; //ширина
    private int displacement; //водоизмещение
    private int draught; //осадка
    private String material; //материал корпуса
    private int payload; //величина полезной нагрузки - сколько можно нагрузить на корпус

    //параметризированный конструктор
    BoatBody(int length, int width, int displacement, int draught, String material, int payload) {
        this.length = length;
        this.width = width;
        this.displacement = displacement;
        this.draught = draught;
        this.material = material;
        this.payload = payload;
    }

    //геттеры
    public int getLength() { return length; }
    public int getWidth() { return width; }
    public int getDisplacement() { return displacement; }
    public int getDraught() { return draught; }
    public String getMaterial() { return material; }
    public int getPayload() { return payload; }

    //сеттеры
    public void setLength(int length) { if (length > 0 && length < 10000) this.length = length; }
    public void setWidth(int width) { if (width > 0 && width < 5000) this.width = width; }
    public void setDisplacement(int displacement) { if (displacement > 0 && displacement < 100000) 
        this.displacement = displacement; }
    public void setDraught(int draught) { if (draught > 0 && draught < 100000) this.draught = draught; }
    public void setMaterial(String material) { this.material = material; }
    
    //метод загрузки оборудования
    public void setPayload(int loadWeight) { if (loadWeight > 0 && loadWeight <= payload) this.payload -= loadWeight; }
}

//Описание класса-компонента для SafeBoat - двигатель
class Engine {
    private int engineWeight;
    private int engineWidth;
    private int engineLength;
    private int engineHorsePower;

    Engine(int engineWeight, int engineWidth, int engineLength, int engineHorsePower) {
        this.engineWeight = engineWeight;
        this.engineWidth = engineWidth;
        this.engineLength - engineLength;
        this.engineHorsePower = engineHorsePower;
    }

    public int getEngineWeight() { return engineWeight; }
    public int getEngineWidth() { return engineWidth; }
    public int getEngineLength() { return engineLength; }
    public int getEngineHorsePower() { return engineHorsePower; }

    public void setEngineWeight(int engineWeight) {  if (engineWeight > 0 && engineWeight < 100000) 
        this.engineWeight = engineWeight; }
    public void setEngineWidth(int engineWidth) { if (engineWidth > 0 && engineWidth < 1000) 
        this.engineWidth = engineWidth; }
    public void setEngineLength(int engineLength) { if (engineLength > 0 && engineLength < 1000) 
        this.engineLength = engineLength; }
    public void setEngineHorsePower(int engineHorsePower) { if (engineHorsePower > 0 && engineHorsePower < 100000) 
        this.engineHorsePower = engineHorsePower; }
}

//Описание класса-компонента для SafeBoat - спасательный круг
class Safeline {
    private int safeLineWeight;
    
    Safeline(int safeLineWeight) { this.safeLineWeight = safeLineWeight; }

    public int getSafeLineWeight() { return safeLineWeight; }

    public void setSafeLineWeight(int safeLineWeight) { if (safeLineWeight > 0 && safeLineWeight < 10) 
        this.safeLineWeight = safeLineWeight; }
}

//описание класса-компонента для SafeBoat - аптечка
class Medkit {
    private int medkitWeight;
    
    Medkit(int medkitWeight) { this.medkitWeight = medkitWeight; }

    public int getMedkitWeight() { return medkitWeight; }

    public void setMedkitWeight(int medkitWeight) { if (medkitWeight > 0 && medkitWeight < 2) 
        this.medkitWeight = medkitWeight; }
}

//описание класса-компонента для SafeBoat - веревка
class Rope {
    private int ropeWeight;
    private int ropeLength;
    
    Rope(int ropeWeight, int ropeLength) { this.ropeWeight = ropeWeight; this.ropeLength = ropeLength; }

    public int getRopeWeight() { return ropeWeight; }
    public int getRopeLength() { return ropeLength; }

    public void setRopeWeight(int ropeWeight) { if (ropeWeight > 0 && ropeWeight < 100) 
        this.ropeWeight = ropeWeight; }
    
    public void setRopeLength(int ropeLength) { if (ropeLength > 0 && ropeLength < 3000) this.ropeLength = ropeLength; }
}

class SafeBoat {
    private String name;

    private BoatBody lfboat_body; //присвоили корпус
    private Engine lfboat_engine; //присвоили двигатель
    private Safeline lf_safeline; //присвоили спасательный круг
    private Medkit lf_medkit; //присвоили аптечку
}

public class tri_kita_part2_ex_1 {
    public static void main(String args[]) {
        SafeBoat sfboat1 = new SafeBoat();
        
    }
}
