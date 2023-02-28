package HardwareBuilder;

import Hardware.Controller.*;
import Hardware.Display.*;
import Hardware.Hardware;
import Hardware.Identification.*;
import Hardware.InternetFactory.*;
import Hardware.Microcontroller.*;
import Hardware.Storage.*;
import Hardware.WeightMeasurement.*;

public class HardwareBuilder {
    Hardware hardware = new Hardware();
    InternetFactory internetFactory = new InternetFactory();

    public Hardware buildSilverPackage(String connectionType){
        if(connectionType.equalsIgnoreCase("Ethernet"))
        {
            System.out.println("Internet type not suitable");
            return null;
        }

        hardware.addComponents("Microcontroller", new ATMega32());
        hardware.addComponents("Weight Measurement", new LoadSensor());
        hardware.addComponents("Identification", new RFIDcard());
        hardware.addComponents("Storage", new SDcard());
        hardware.addComponents("Display", new LCD());
        hardware.addComponents("Internet", internetFactory.getInternet(connectionType));
        hardware.addComponents("Controller", new Button());
        return hardware;

    }

    public Hardware buildGoldPackage(String connectionType){

        if(connectionType.equalsIgnoreCase("Ethernet"))
        {
            System.out.println("Internet type not suitable");
            return null;
        }


        hardware.addComponents("Microcontroller", new ArduinoMega());
        hardware.addComponents("Weight Measurement", new WeightModule());
        hardware.addComponents("Identification", new RFIDcard());
        hardware.addComponents("Storage", new SDcard());
        hardware.addComponents("Display", new LED());
        hardware.addComponents("Internet", internetFactory.getInternet(connectionType));
        hardware.addComponents("Controller", new Button());
        return hardware;

    }

    public Hardware buildDiamondPackage(String connectionType){


        hardware.addComponents("Microcontroller", new RaspberryPi());
        hardware.addComponents("Weight Measurement", new LoadSensor());
        hardware.addComponents("Identification", new NFCcard());
        hardware.addComponents("Storage", new InternalStorage());
        hardware.addComponents("Display", new TouchScreen());
        hardware.addComponents("Internet", internetFactory.getInternet(connectionType));
        hardware.addComponents("Controller", new TouchScreenController());
        return hardware;

    }

    public Hardware buildPlatinumPackage(String connectionType){

        hardware.addComponents("Microcontroller", new RaspberryPi());
        hardware.addComponents("Weight Measurement", new WeightModule());
        hardware.addComponents("Identification", new NFCcard());
        hardware.addComponents("Storage", new InternalStorage());
        hardware.addComponents("Display", new TouchScreen());
        hardware.addComponents("Internet", internetFactory.getInternet(connectionType));
        hardware.addComponents("Controller", new TouchScreenController());
        return hardware;

    }
}
