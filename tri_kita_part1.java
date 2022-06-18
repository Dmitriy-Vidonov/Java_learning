//объявление класса-предка MotorBoats
class MotorBoats {
    private int length; //длина
    private int width; //ширина
    private int displacement; //водоизмещение
    private int draught; //осадка
    private int payload; //полезная нагрузка
    private int maxSpeed; //макс. скорость
    private int currSpeed; //текущая скорость
    private String name; //наименование судна

    //конструктор с параметрами класса-предка MotorBoats
    MotorBoats(int len, int wid, int dis, int dr, int pay, int mS, int cS, String n) {
        length = len;
        width = wid;
        displacement = dis;
        draught = dr;
        payload = pay;
        maxSpeed = mS;
        currSpeed = cS;
        name = n;
    }

    //геттеры класса-предка MotorBoats
    int getLength() { return length; }
    int getWidth() { return width; }
    int getDisplacement() { return displacement; }
    int getDraught() { return draught; }
    int getPayload() { return payload; }
    int getmMaxSpeed() { return maxSpeed; }
    int getCurrSpeed() { return currSpeed; }
    String getName() { return name; }

    //сеттеры класса-предка MotorBoats
    void setLength(int l) { 
        if (l > 0 && l < 100000) {
            length = l;
        }
     }
    void setWidth(int w) { 
        if (w > 0 && w < 50000) {
            width = w;
        }
    }
    void setDisplacement(int dis) { 
        if (dis > 0 && dis < 1000) {
            displacement = dis; 
        }
    }
    void setDraught(int drau) { 
        if (drau > 0 && drau < 10)    
        draught = drau; 
    }
    void setPayload(int payl) { 
        if(payl > 0 && payl < 10000) {
            payload = payl; 
        }
    }
    void setMaxSpeed(int maxS) { 
        if (maxS > 0 && maxS < 200) {
            maxSpeed = maxS;
        }
    }
    void setCurrSpeed(int currS) { 
        if (currS > 0 && currS <= maxSpeed) {
            currSpeed = currS;
        }     
    }

    void stop() {
        currSpeed = 0;
    }
}

//определение класса-потомка от MotorBoats - спасательная шлюпка
class LifeBoat extends MotorBoats {
    private int lifelines; //число спасательных кругов на шлюпке
    private int medKits; //число аптечек
    private int ropeLen; //длина спасательной веревки

    //конструктор с параметрами класса-потомка LifeBoat
    LifeBoat(int len, int wid, int dis, int dr, int pay, int mS, int cS, String n, int ll, int mK, int rL) {
        super(len, wid, dis, dr, pay, mS, cS, n);
        lifelines = ll;
        medKits = mK;
        ropeLen = rL;
    }

    //геттеры класса-потомка LifeBoat
    int getLifeLines() { return lifelines; }
    int getMedKits() { return medKits; }
    int getRopeLen() { return ropeLen; }

    //сеттеры класса-потомка LifeBoat
    void setLifeLines(int newLL) { 
        if (lifelines > 0 && lifelines < 100) {
            lifelines = newLL; 
        }
    }
    void setMedkits(int newMK) { 
        if (newMK > 0 && newMK < 1000) {
            medKits = newMK;
        }
    }
    void setRopeLen(int newRL) { 
        if (newRL > 0 && newRL < 1000) {
            ropeLen = newRL;
        } 
    }

    //уникальный метод класса LifeBoat - выброс спасательных кругов
    void lifeLinesEject(int ejectCount) {
        if (ejectCount > 0 && ejectCount <= lifelines) {
            lifelines -= ejectCount;
        }
    }

    //уникальный метод класса LifeBoat - лечение людей
    int healthBoost(int peopleCount) {
        int result = 0;
        if (medKits >= peopleCount) {
            result = peopleCount;
        }
        if (peopleCount > medKits) {
            result = medKits;
        }
        return result;
    }

    //уникальный метод класса LifeBoat - возможность вытянуть утопающего
    String isExtractFromWaterPossible(int howFar) {
        String result = "";
        if (ropeLen >= howFar) {
            result = "Есть возможность спасения утопающего";
        }
        else { result = "Спасение невозможно, требуется подойти ближе"; }
        return result;
    }
}

//объявление класса-потомка FishingBoat от предка MotorBoat
class FishingBoat extends MotorBoats {
    private int netsCount; //число сетей на борту
    private boolean isLiftingCrane; //есть ли на борту подъемный кран
    private double echoSounderRange; //дальность эхолота в метрах

    //конструктор с параметрами класса-потомка LifeBoat
    FishingBoat (int len, int wid, int dis, int dr, int pay, int mS, int cS, String n, int nC, boolean isCr, double eSR) {
        super(len, wid, dis, dr, pay, mS, cS, n);
        netsCount = nC;
        isLiftingCrane = isCr;
        echoSounderRange = eSR;
    }

    //геттеры класса-потомка FishingBoat
    int getNetsCount() { return netsCount; }
    boolean getIsLiftingCrane() { return isLiftingCrane; }
    double getEchoSounderRange() { return echoSounderRange; }

    //сеттеры класса-потомка FishingBoat
    void setNetsCount(int newNetsC) {
        if (newNetsC > 0 && newNetsC < 50) {
            netsCount = newNetsC;
        }
    }

    void setLiftCrane(boolean isCrane) { isLiftingCrane = isCrane; }

    void echoSounderRange(int newEchRange) {
        if (newEchRange > 0 && newEchRange < 1000) {
            echoSounderRange = newEchRange;
        }
    }

    //уникальный метод класса-потомка FishingBoat - выброс сетей
    int netsEject(int howMuchNetsEject) {
        if (howMuchNetsEject <= netsCount) {
            netsCount -= howMuchNetsEject;
        }
        else {
            netsCount = 0;
        }
        return netsCount;
    }

    //уникальный метод класса-потомка FishingBoat - подъем груза
    String isLiftPossible(boolean isCraneEx) {
        String message = "";
        if (isCraneEx == true) {
            message = "Возможно использование подъемного крана";
        }
        else {
            message = "Подъем грузов невозможен! Требуется установить кран!";
        }
        return message;
    }

    //уникальный метод класса-потомка FishingBoat - анализ эффективности эхолота в зависимости от глубины
    String echoSounderEfficiency (int depth) {
        String msg = "";
        if (depth >= echoSounderRange) {
            msg = "Эхолот используется на весь свой потенциал. Подходящая глубина.";
        }
        else {
            msg = "Эхолот используется не в полную силу. Возможно стоит отойти на более глубокое место.";
        }
        return msg;
    }
}

//описание класса-потомка PleasureBoat от предка MotorBoat
class PleasureBoat extends MotorBoats {
    private int alcohol; //Сколько алкоголя на борту
    private int wattsOfSound; //Мощность аудиосистемы
    private int additionalStaff; //Число доп. персонала на катере 

    //конструктор с параметрами класса-потомка PleasureBoat
    PleasureBoat(int len, int wid, int dis, int dr, int pay, int mS, int cS, String n, int alc, int watt, int staff) {
        super(len, wid, dis, dr, pay, mS, cS, n);
        alcohol = alc;
        wattsOfSound = watt;
        additionalStaff = staff;
    }

    //Геттеры класса-потомка PleasureBoat
    int getAlcohol() { return alcohol; }
    int getWattsOfSound() { return wattsOfSound; }
    int getAdditionalStaff() { return additionalStaff; }

    //Сеттеры класса-потомка PleasureBoat
    void setAlcohol(int newAlco) {
        if (newAlco > 0 && newAlco < 1000) {
            alcohol = newAlco;
        }
    }

    void setWattsOfSound(int newWatts) {
        if (newWatts > 0 && newWatts < 100000) {
            wattsOfSound = newWatts;
        }
    } 

    void setAdditionalStaff(int newStaff) {
        if (newStaff > 0 && newStaff < 10) {
            additionalStaff = newStaff;
        }
    }

    //Уникальный метод класса-потомка PleasureBoat - сила мини-бара
    String powerOfMiniBar(int people) {
        int result = 0;
        String msg = "";
        result = alcohol / people; 
            if (result > 0 && result < 2) {
                msg = "Господа слегка прибухнут и не более.";
            }
            else if (result > 2 && result < 3) {
                msg = "Господа будут подшофе, но еще на ногах...";
            }
            else if (result > 3) {
                msg = "Господа могут быть в слюни, следите за ними!";
            }
            return msg;
        }

    //Уникальный метод класса-потомка PleasureBoat - определение расстояния слышимости звука бортовой аудиосистемы
    int areaOfLoudMusic() {
        return wattsOfSound / 100 + 50;
    }

    //Уникальный метод класса-потомка PleasureBoat
    String indexOfHappines (int pplOnBoard) {
        String res = "";
        if ((pplOnBoard / additionalStaff >= 2) && (pplOnBoard / additionalStaff <= 5)) {
            res = "Господа довольны, все хорошо.";
        }
        if (pplOnBoard / additionalStaff <= 1) {
            res = "Господа вопрошают - " + "\"" + "Помилуйте, на кой нам столько персонала?" + "\"";
        }
        if (pplOnBoard / additionalStaff > 5) {
            res = "Господа недовольны - " + "\"" + "где наша обслуга?" + "\"";
        }
        return res;
    }
}

//Описываем родительский класс - Подводные суда - UnderWaterVessels
class UnderWaterVessels {
    private int length; //длина судна
    private int width; //ширина судна
    private int autonomyHours; //автономность в часах
    private int displacement; //водоизмещение
    private int depthOfImmersion; //глубина погружения судна
    private int currSpeed; //текущая скорость
    private String name; //наименование судна

    //Конструктор с параметрами родительского класса UnderWaterVessels
    UnderWaterVessels(int ulen, int uwid, int uauto, int udispl, int udep, int ucurS, String un) {
        length = ulen;
        width = uwid;
        autonomyHours = uauto;
        displacement = udispl;
        depthOfImmersion = udep;
        currSpeed = ucurS;
        name = un;
    }

    //Геттеры родительского класса
    int getLength() { return length; }
    int getWidth() { return width; }
    int getAutonomyHours() { return autonomyHours; }
    int getDisplacement() { return displacement; }
    int getDepthOfImmersion() { return depthOfImmersion; }
    int getCurrSpeed() { return currSpeed; }
    String getName() { return name; }

    //Сеттеры родительского класса
    void setLength(int newLen) { 
        if (newLen > 0 && newLen < 1000) {
            length = newLen;
        }
     }

     void setWidth(int newWid) {
        if (newWid > 0 && newWid < 100) {
            width = newWid;
        }
     }

     void setAutonomyHours(int newAutoH) {
        if (newAutoH > 0 && newAutoH < 10000) {
            autonomyHours = newAutoH;
        }
     }

     void setDisplacement(int newDispl) {
        if (newDispl > 0 && newDispl < 100000000) {
            displacement = newDispl;
        }
     }

     void setDepthOfImmersion(int newDepth) {
        if (newDepth > 0 && newDepth < 11000) {
            depthOfImmersion = newDepth;
        }
     }

     void setCurrSpeed(int newSp) {
        if (newSp > 0 && newSp < 200) {
            currSpeed = newSp;
        }
     }

     void setname(String newN) {
        if (newN.length() > 0) {
            name = newN;
        }
     }

     //Методы родительского класса UnderWaterVessels
     void stop() { //остановка судна
        currSpeed = 0;
     }

     void upward(int upMeters) { //всплытие судна
        if (upMeters > 0 && upMeters <= depthOfImmersion) {
            depthOfImmersion -= upMeters;
        }
     }

     void downward(int downMeters) { //погружение судна
        if (downMeters > 0 && ((depthOfImmersion + downMeters) < 11000)) {
            depthOfImmersion += downMeters;
        }
     }
}

//Описание класса-потомка ResearchDrone от родителя UnderWaterVessels  
class ResearchDrone extends UnderWaterVessels {
    private int cableLen;
    private int numOfWebCam;
    private int numOfIRsensor;

    //конструктор с параметрами класса-потомка ResearchUnderWaterDrone
    ResearchDrone(int ulen, int uwid, int uauto, int udispl, int udep, int ucurS, String un, int cabL, int webC, int IR) {
        super(ulen, uwid, uauto, udispl, udep, ucurS, un);
        cableLen = cabL;
        numOfWebCam = webC;
        numOfIRsensor = IR;
    }

    //Геттеры класса-потомка ResearchUnderWaterDrone
    int getCableLen() { return cableLen; }
    int getnumOfWebCam() { return numOfWebCam; }
    int getnumOfIRsensor() { return numOfIRsensor; }

    //Сеттеры класса-потомка ResearchUnderWaterDrone
    void setCableLen(int newCabLen) {
        if (newCabLen > 0 && newCabLen < 1000) {
            cableLen = newCabLen;
        }
    }

    void setnumOfWebCam(int newNumWeb) {
        numOfWebCam = newNumWeb;
    }

    void setnumOfIRsensor(int newnumIR) {
        numOfIRsensor = newnumIR;
    }

    //Уникальный метод класса ResearchDrone
    void cableCheck(int radius) { //проверка возможности исследования на заданный радиус
        if (cableLen >= radius) {
            System.out.println("Исследование на заданный радиус возможно");
        }
        else {
            System.out.println("Исследование невозможно! Необходимо использовать более длинный кабель!");
        }
    }

    //Уникальный метод класса ResearchDrone
    void cameraCheck() {
        if (numOfWebCam <= 0) {
            System.out.println("Съемка невозможна! Не установлена ни одна камера!");
        } 
        if (numOfWebCam == 1) {
            System.out.println("Возможна съемка в моно режиме.");
        }
        if (numOfWebCam > 1) {
            System.out.println("Возможна съемка в стерео режиме ");
        }
    }

    //Уникальный метод класса ResearchDrone
    void IRsensorCheck() {
        if (numOfIRsensor <= 0) {
            System.out.println("Получение ИК-данных невозможно! Не установлен ни один ИК-датчик!");
        } 
        if (numOfIRsensor == 1) {
            System.out.println("Возможно получение ИК-данных в моно-режиме.");
        }
        if (numOfIRsensor > 1) {
            System.out.println("Возможно получение ИК-данных в стерео-режиме.");
        }
    }
}

//Описание класса-потомка ScientificBathyscaphe
class ScientificBathyscaphe extends UnderWaterVessels {
    private double samplesWeight; //вес взятых образцов грунта, камней, etc.
    private String manipulatorType; //тип манипуляторо для взятия образцов
    private int searchLightPower; //мощность прожектора в Ваттах

    //Описание конструктора с параметрами для класса-потомка ScientificBathyscaphe
    ScientificBathyscaphe(int ulen, int uwid, int uauto, int udispl, int udep, int ucurS, String un,
                          double sampleW, String manT, int lightP) {
        super(ulen, uwid, uauto, udispl, udep, ucurS, un);
        samplesWeight = sampleW;
        manipulatorType = manT;
        searchLightPower = lightP;
    }

    //Геттеры класса-потомка ScientificBathyscaphe
    double getSamplesWeight() { return samplesWeight; }
    String getManipulatorType() { return manipulatorType; }
    int getSearchLightPower() { return searchLightPower; }

    //Сеттеры класса-потомка ScientificBathyscaphe
    void setManipulatorType(String newManType) {
        manipulatorType = newManType;
    }

    void setSearchLightPower(int newSLightP) {
        if (newSLightP > 0 && newSLightP < 10000) {
            searchLightPower = newSLightP;
        }
    }

    //Уникальный метод класса-потомка ScientificBathyscaphe
    void samplegrab(double sampleW) { //функция захвата образцов
        if (sampleW > 0 && sampleW <= 10 && samplesWeight + sampleW < 100) {
            samplesWeight += sampleW;
        }
    }

    //Уникальный метод класса-потомка ScientificBathyscaphe
    void lightRadius() {
        double lightRad = 0;
        lightRad = searchLightPower / 100 * 1.2;
        System.out.println("При мощности " + searchLightPower + " Вт., освещение возможно до " + lightRad + " метров.");
    }
}

//Описание класса-потомка BattleSubmarine
class BattleSubmarine extends UnderWaterVessels {
    private int torpedoes; //число торпед
    private int bombs; //число бомб
    private int sonarRange;

    //Описание класса-потомка BattleSubmarine с параметрами
    BattleSubmarine(int ulen, int uwid, int uauto, int udispl, int udep, int ucurS, String un,
                    int torp, int bomb, int sonRan) {
        super(ulen, uwid, uauto, udispl, udep, ucurS, un);
        torpedoes = torp;
        bombs = bomb;
        sonarRange = sonRan;
    }

    //Геттеры класса-потомка BattleSubmarine
    int getTorpedoes() { return torpedoes; }
    int getBombs() { return bombs; }
    int getSonarRange() { return sonarRange; }

    //Сеттеры класса-потомка BattleSubmarine
    void setSonarRange(int newSonRan) {
        if (newSonRan > 0 && newSonRan < 50000) {
            sonarRange = newSonRan;
        }
    }

    //Уникальный метод класса-потомка BattleSubmarine
    void bombsLoad(int addBombs) {
        if (addBombs > 0 && (bombs + addBombs) <= 20) {
            bombs += addBombs;
        }
    }

    //Уникальный метод класса-потомка BattleSubmarine
    void torpedoesLoad(int addTorp) {
        if (addTorp > 0 && (torpedoes + addTorp) <= 30) {
            torpedoes += addTorp;
        }
    }
}

public class tri_kita_part1 {
    public static void main(String agrs[]) {
    }    
}
