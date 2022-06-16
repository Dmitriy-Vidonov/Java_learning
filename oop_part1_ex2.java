class keyboard { //объявление класса "клавиатура"
    String keycapsMaterial;
    String size;
    int weightGr;
    String backLight;
    String keycapType;
    String switchType;
    String layout;
    int numberOfKeys;
    String cableType;
    String keycapsLanguage;
    String manufacturerCountry;
    String name;
    int price;
}

class laptop { //объявление класса "ноутбук"
    double diagonal;
    int numberOfKeys;
    double autonomyTimeHours;
    boolean isWebcamExist;
    String processor;
    String graphicCard;
    String caseMaterial;
    String installedOS;
    String name;
    String manufacturerCountry;
    String ramType;
    int ramAmountGb;
    String hddType;
    int hddAmountGb;
    String PortsType;
    int price;
}

public class oop_part1_ex2 {
    public static void main(String args[]) {

        /*Создание объекта varmilo108 класса keyboard*/
        keyboard varmilo108 = new keyboard();

        varmilo108.keycapsMaterial = "PBT";
        varmilo108.size = "100%";
        varmilo108.weightGr = 1100;
        varmilo108.backLight = "None";
        varmilo108.keycapType = "Cherry";
        varmilo108.switchType = "Cherry MX Brown";
        varmilo108.layout = "US(ANSI)";
        varmilo108.numberOfKeys = 108;
        varmilo108.cableType = "USB Type-C";
        varmilo108.keycapsLanguage = "RU/EN";
        varmilo108.manufacturerCountry = "China";
        varmilo108.name = "Varmilo VEA108 Vintage Days";
        varmilo108.price = 16690;

        /*Создание объекта vortexCoreRGB класса keyboard*/
        keyboard vortexCoreRGB = new keyboard();

        vortexCoreRGB.keycapsMaterial = "PBT";
        vortexCoreRGB.size = "40%";
        vortexCoreRGB.weightGr = 400;
        vortexCoreRGB.backLight = "RGB";
        vortexCoreRGB.keycapType = "DSA";
        vortexCoreRGB.switchType = "Cherry MX Blue";
        vortexCoreRGB.layout = "US(ANSI)";
        vortexCoreRGB.numberOfKeys = 47;
        vortexCoreRGB.cableType = "Micro-USB";
        vortexCoreRGB.keycapsLanguage = "EN";
        vortexCoreRGB.manufacturerCountry = "Taiwan";
        vortexCoreRGB.name = "Vortex Core RGB";
        vortexCoreRGB.price = 12990;

        /*Создание объекта acer571G класса laptop*/
        laptop acer571G = new laptop();

        acer571G.diagonal = 15.3;
        acer571G.numberOfKeys = 108;
        acer571G.autonomyTimeHours = 3.5;
        acer571G.isWebcamExist = true;
        acer571G.processor = "Intel Core i7 1,7 GHz";
        acer571G.graphicCard = "NVIDIA GEFORCE 710M + Intel 4000";
        acer571G.caseMaterial = "plastic";
        acer571G.installedOS = "Win 8.1 + Ubuntu 20.04";
        acer571G.name = "Acer Aspire V3-571G";
        acer571G.manufacturerCountry = "China";
        acer571G.ramType = "DDR3";
        acer571G.ramAmountGb = 6;
        acer571G.hddType = "SSD";
        acer571G.hddAmountGb = 512;
        acer571G.PortsType = "USB 2.0, USB 3.0, HDMI, VGA";
        acer571G.price = 15000;

        /*Создание объекта huaweiMate класса laptop*/
        laptop huaweiMate = new laptop();

        huaweiMate.diagonal = 14;
        huaweiMate.numberOfKeys = 96;
        huaweiMate.autonomyTimeHours = 7;
        huaweiMate.isWebcamExist = true;
        huaweiMate.processor = "AMD Ryzen 5 5500U 2,1 GHz";
        huaweiMate.graphicCard = "AMD RADEON";
        huaweiMate.caseMaterial = "Metal";
        huaweiMate.installedOS = "Win 10 Home";
        huaweiMate.name = "Huawei MateBook";
        huaweiMate.manufacturerCountry = "China";
        huaweiMate.ramType = "DDR4";
        huaweiMate.ramAmountGb = 16;
        huaweiMate.hddType = "SSD";
        huaweiMate.hddAmountGb = 512;
        huaweiMate.PortsType = "USB 3.0, USB Type-C, HDMI";
        huaweiMate.price = 79990;

        var price = varmilo108.price + vortexCoreRGB.price + acer571G.price + huaweiMate.price;

        System.out.println("Наименования клавиатур в наличии: " + varmilo108.name + ", " + vortexCoreRGB.name);
        System.out.println("Наименования ноутбуков в наличии: " + acer571G.name + ", " + huaweiMate.name);
        System.out.println("Общая стоимость всех товаров: " + price + " руб.");
        
    }
}
