package cz.cvut.fel.omo.model.parts;

import cz.cvut.fel.omo.event.HistoryOfEvents;
import cz.cvut.fel.omo.model.devices.*;
import cz.cvut.fel.omo.model.pets.Cat;
import cz.cvut.fel.omo.model.pets.Dog;
import cz.cvut.fel.omo.model.pets.Parrot;
import cz.cvut.fel.omo.model.signalization.*;
import cz.cvut.fel.omo.model.transport.Bike;
import cz.cvut.fel.omo.model.transport.Car;
import cz.cvut.fel.omo.model.transport.Ski;
import cz.cvut.fel.omo.model.users.Account;

import java.util.Arrays;

public class HouseCreator {
    private static HouseCreator instance = null;

    public static HouseCreator getInstance() {
        if (instance == null) {
            instance = new HouseCreator();
        }
        return instance;
    }

    private HouseCreator(){}

    public House basicHouseCreation() {
        Account father = new Account("Father", 50, "123",
                "+420777111222", "Alex50");
        Account mother = new Account("Mother", 51, "234",
                "+420777222333", "Maria51");
        Account grandmother = new Account("Grandmother", 75, "345",
                "+420777333444", "Ksenia75");
        Account grandfather = new Account("Grandfather", 76, "456",
                "+420777444555", "Vlad76");
        Account son = new Account("Son", 14, "567",
                "+420555666", "Max14");
        Account daughter = new Account("Daughter", 10, "678",
                "+420777666777", "Ira10");

        Dog dog = new Dog("Rex");
        Cat cat = new Cat("Loki");
        Parrot parrot = new Parrot("Lola");

        Level firstLvl = new Level(1);
        Level secondLvl = new Level(2);

        FireSignalization fireSignalization = new FireSignalization();
        GasLeakSignalization gasLeakSignalization = new GasLeakSignalization();
        PowerOutagesSignalization powerOutagesSignalization = new PowerOutagesSignalization();
        WaterLeakSignalization waterLeakSignalization = new WaterLeakSignalization();

        Room hallway = new Room(10, 15.0, secondLvl, "Hallway");
        Room showerRoom = new Room(4, 11.2, secondLvl, "ShowerRoom");
        Room kitchen = new Room(4, 10.7, secondLvl, "Kitchen");
        Room livingRoom = new Room(12, 36.6, secondLvl, "LivingRoom");
        Room bedroomForParents = new Room(6, 14.9, secondLvl, "BedroomForParents");
        Room bedroomForGrands = new Room(6, 13.9, secondLvl, "BedroomForGrands");
        Room childRoom = new Room(4, 10.0, secondLvl, "ChildRoom");
        Garage garage = new Garage(15, 25.0, firstLvl, "Garage");
        Outdoor outside = new Outdoor(600.0, firstLvl);

        // Setting Floors
        firstLvl.setRooms(Arrays.asList(garage, outside));
        secondLvl.setRooms(Arrays.asList(hallway, showerRoom, kitchen, livingRoom, bedroomForParents, bedroomForGrands));

        // Devices
        AirCleaner airCleaner_livingRoom = new AirCleaner("Boneco P700", livingRoom, 3);
        AirCleaner airCleaner_bedroomForParents = new AirCleaner("Boneco P700", bedroomForParents, 3);
        AirCleaner airCleaner_bedroomForGrands = new AirCleaner("Boneco P700", bedroomForGrands, 3);

        Fridge fridge_kitchen = new Fridge("Fridge LG", kitchen, 5);

        BabyMonitor babyMonitor_childRoom = new BabyMonitor("BabyMonitor", childRoom, 1);
        BabyMonitor babyMonitor_bedroomForParents = new BabyMonitor("BabyMonitor", bedroomForParents, 1);

        Computer computer_bedroomForParents = new Computer("MacBook", bedroomForParents, 1);
        Computer computer_livingRoom = new Computer("Dell", livingRoom, 1);

        Conditioner conditioner_livingRoom = new Conditioner("Mitsubishi Electric", livingRoom, 2);
        Conditioner conditioner_bedroomForParents = new Conditioner("Mitsubishi Electric", bedroomForParents, 2);
        Conditioner conditioner_bedroomForGrands = new Conditioner("Mitsubishi Electric", bedroomForGrands, 2);
        Conditioner conditioner_childRoom = new Conditioner("Mitsubishi Electric", childRoom, 2);

        GasCooker gasCooker_kitchen_1 = new GasCooker("Beko", kitchen, 7, 0.35);
        GasCooker gasCooker_kitchen_2 = new GasCooker("Beko", kitchen, 7, 0.5);

        Humidifier humidifier_livingRoom = new Humidifier("Boneco U700", livingRoom, 1);
        Humidifier humidifier_bedroomForParents = new Humidifier("Boneco U700", bedroomForParents, 1);
        Humidifier humidifier_bedroomForGrands = new Humidifier("Boneco U700", bedroomForGrands, 1);
        Humidifier humidifier_childRoom = new Humidifier("Boneco U700", childRoom, 1.4);

        Light light_hallway = new Light("Light", hallway);
        Light light_showerRoom = new Light("Light", showerRoom);
        Light light_kitchen = new Light("Light", kitchen);
        Light light_livingRoom = new Light("Light", livingRoom);
        Light light_bedroomForParents = new Light("Light", bedroomForParents);
        Light light_bedroomForGrands = new Light("Light", bedroomForGrands);
        Light light_childRoom = new Light("Light", hallway);
        Light light_garage = new Light("Light", garage);
        Light light_outside = new Light("Light", outside);


        Window window_hallway = new Window("Window", hallway);
        Window window_showerRoom = new Window("Window", showerRoom);
        Window window_kitchen = new Window("Window", kitchen);
        Window window_livingRoom = new Window("Window", livingRoom);
        Window window_bedroomForParents = new Window("Window", bedroomForParents);
        Window window_bedroomForGrands = new Window("Window", bedroomForGrands);
        Window window_childRoom = new Window("Window", hallway);
        Window window_garage = new Window("Window", garage);


        Multicooker multicooker_kitchen = new Multicooker("Tefal", kitchen, 2.01);

        RobotVacuumCleaner robotVacuumCleaner_livingRoom = new RobotVacuumCleaner("Dyson", livingRoom, 1);
        RobotVacuumCleaner robotVacuumCleaner_bedroomForParents = new RobotVacuumCleaner("Dyson", bedroomForParents, 1);
        RobotVacuumCleaner robotVacuumCleaner_bedroomForGrands = new RobotVacuumCleaner("Dyson", bedroomForGrands, 1);
        RobotVacuumCleaner robotVacuumCleaner_childRoom = new RobotVacuumCleaner("Dyson", childRoom, 1);

        // Smartphone

        Teapot teapot_kitchen = new Teapot("Bork", kitchen, 1);

        TV tv_livingRoom = new TV("Samsung", livingRoom, 1);
        TV tv_bedroomForParents = new TV("Samsung", bedroomForParents, 1);
        TV tv_bedroomForGrands = new TV("Samsung", bedroomForGrands, 1);

        WashingMachine washingMachine_showerRoom_1 = new WashingMachine("Samsung Washing", showerRoom, 1, 0.8);
        WashingMachine washingMachine_showerRoom_2 = new WashingMachine("Samsung Washing", showerRoom, 1, 0.45);

        //Transport
        Car car_1 = new Car(4, 4, garage);
        Car car_2 = new Car(2, 3, garage);
        Bike bike_1 = new Bike(garage);
        Bike bike_2 = new Bike(garage);
        Ski ski_1 = new Ski(garage);
        Ski ski_2 = new Ski(garage);
        Ski ski_3 = new Ski(garage);

        garage.setTransport(Arrays.asList(car_1, car_2, bike_1, bike_2, ski_1, ski_2, ski_3));

        // Connecting Devices to Rooms
        livingRoom.setDevices(Arrays.asList(tv_livingRoom, airCleaner_livingRoom, computer_livingRoom, conditioner_livingRoom, humidifier_livingRoom, light_livingRoom, robotVacuumCleaner_livingRoom, window_livingRoom));
        hallway.setDevices(Arrays.asList(light_hallway, window_hallway));
        showerRoom.setDevices(Arrays.asList(light_showerRoom, washingMachine_showerRoom_1, washingMachine_showerRoom_2, window_showerRoom));
        kitchen.setDevices(Arrays.asList(fridge_kitchen, gasCooker_kitchen_1, gasCooker_kitchen_2, light_kitchen, multicooker_kitchen, teapot_kitchen, window_kitchen));
        bedroomForParents.setDevices(Arrays.asList(tv_bedroomForParents, airCleaner_bedroomForParents, babyMonitor_bedroomForParents, computer_bedroomForParents, conditioner_bedroomForParents, humidifier_bedroomForParents, light_bedroomForParents, robotVacuumCleaner_bedroomForParents, window_bedroomForParents));
        bedroomForGrands.setDevices(Arrays.asList(tv_bedroomForGrands, airCleaner_bedroomForGrands, conditioner_bedroomForGrands, humidifier_bedroomForGrands, light_bedroomForGrands, robotVacuumCleaner_bedroomForGrands, window_bedroomForGrands));
        childRoom.setDevices(Arrays.asList(babyMonitor_childRoom, conditioner_childRoom, humidifier_childRoom, light_childRoom, robotVacuumCleaner_childRoom, window_childRoom));
        garage.setDevices(Arrays.asList(light_garage, window_garage));
        outside.setDevices(Arrays.asList(light_outside));

        powerOutagesSignalization.subscribe(livingRoom);
        House returningHouse = new House("Technicka 2", father, Arrays.asList(firstLvl, secondLvl), outside, powerOutagesSignalization, waterLeakSignalization, gasLeakSignalization, fireSignalization, Arrays.asList(father, mother, grandfather, grandmother, son, daughter), Arrays.asList(dog, cat, parrot));
        firstLvl.setHouse(returningHouse);
        secondLvl.setHouse(returningHouse);
        fireSignalization.setHouse(returningHouse);

        for (Level lvl : returningHouse.getLevels()) {
            for (Room currentRoom : lvl.getRooms()) {
                powerOutagesSignalization.subscribe(currentRoom);
                for (Device currentDevice : currentRoom.getDevices()) {
                    powerOutagesSignalization.subscribe(currentDevice);
                    if (currentDevice instanceof GasDevice) {
                        gasLeakSignalization.subscribe(currentDevice);
                    }
                    if (currentDevice instanceof WaterDevice) {
                        waterLeakSignalization.subscribe(currentDevice);
                    }
                }
            }
        }
        return returningHouse;
    }

    public House enhancedHouseCreation() {
        // family
        Account father = new Account("Father", 50, "123",
                "+420777111222", "Alex50");
        Account mother = new Account("Mother", 51, "234",
                "+420777222333", "Maria51");
        Account grandmother = new Account("Grandmother", 75, "345",
                "+420777333444", "Ksenia75");
        Account grandfather = new Account("Grandfather", 76, "456",
                "+420777444555", "Vlad76");
        Account son = new Account("Son", 14, "567",
                "+420555666", "Max14");
        Account daughter = new Account("Daughter", 10, "678",
                "+420777666777", "Ira10");

        // guests
        Account guest1 = new Account("Guest1", 10, "123",
                "+420777111222", "Guest1");
        Account guest2 = new Account("Guest2", 20, "123",
                "+420777111222", "Guest2");
        Account guest3 = new Account("Guest3", 30, "123",
                "+420777111222", "Guest3");
        Account guest4 = new Account("Guest4", 40, "123",
                "+420777111222", "Guest4");
        Account guest5 = new Account("Guest5", 50, "123",
                "+420777111222", "Guest5");
        Account guest6 = new Account("Guest6", 5, "123",
                "+420777111222", "Guest6");
        Account guest7 = new Account("Guest7", 15, "123",
                "+420777111222", "Guest7");
        Account guest8 = new Account("Guest8", 25, "123",
                "+420777111222", "Guest8");
        Account guest9 = new Account("Guest9", 35, "123",
                "+420777111222", "Guest9");
        Account guest10 = new Account("Guest10", 45, "123",
                "+420777111222", "Guest10");

        Dog dog = new Dog("Rex");
        Cat cat = new Cat("Loki");
        Parrot parrot = new Parrot("Lola");

        Level firstLvl = new Level(1);
        Level secondLvl = new Level(2);

        FireSignalization fireSignalization = new FireSignalization();
        GasLeakSignalization gasLeakSignalization = new GasLeakSignalization();
        PowerOutagesSignalization powerOutagesSignalization = new PowerOutagesSignalization();
        WaterLeakSignalization waterLeakSignalization = new WaterLeakSignalization();

        Room hallway = new Room(10, 15.0, secondLvl, "Hallway");
        Room showerRoom = new Room(4, 11.2, secondLvl, "ShowerRoom");
        Room kitchen = new Room(4, 10.7, secondLvl, "Kitchen");
        Room livingRoom = new Room(12, 36.6, secondLvl, "LivingRoom");
        Room bedroomForParents = new Room(6, 14.9, secondLvl, "BedroomForParents");
        Room bedroomForGrands = new Room(6, 13.9, secondLvl, "BedroomForGrands");
        Room childRoom = new Room(4, 10.0, secondLvl, "ChildRoom");
        Garage garage = new Garage(20, 40.0, firstLvl, "Garage");
        Outdoor outside = new Outdoor(600.0, firstLvl);

        // Setting Floors
        firstLvl.setRooms(Arrays.asList(garage, outside));
        secondLvl.setRooms(Arrays.asList(hallway, showerRoom, kitchen, livingRoom, bedroomForParents, bedroomForGrands));

        // Devices
        AirCleaner airCleaner_livingRoom = new AirCleaner("Boneco P700", livingRoom, 1);
        AirCleaner airCleaner_bedroomForParents = new AirCleaner("Boneco P700", bedroomForParents, 1);
        AirCleaner airCleaner_bedroomForGrands = new AirCleaner("Boneco P700", bedroomForGrands, 1);

        Fridge fridge_kitchen = new Fridge("Fridge LG", kitchen, 1);

        BabyMonitor babyMonitor_childRoom = new BabyMonitor("BabyMonitor", childRoom, 1);
        BabyMonitor babyMonitor_bedroomForParents = new BabyMonitor("BabyMonitor", bedroomForParents, 0.9);

        Computer computer_bedroomForParents = new Computer("MacBook", bedroomForParents, 1.2);
        Computer computer_livingRoom = new Computer("Dell", livingRoom, 1.7);

        Conditioner conditioner_livingRoom = new Conditioner("Mitsubishi Electric", livingRoom, 1.09);
        Conditioner conditioner_bedroomForParents = new Conditioner("Mitsubishi Electric", bedroomForParents, 0.75);
        Conditioner conditioner_bedroomForGrands = new Conditioner("Mitsubishi Electric", bedroomForGrands, 0.99);
        Conditioner conditioner_childRoom = new Conditioner("Mitsubishi Electric", childRoom, 1.05);

        GasCooker gasCooker_kitchen_1 = new GasCooker("Beko", kitchen, 1.9, 0.28);
        GasCooker gasCooker_kitchen_2 = new GasCooker("Beko", kitchen, 9.2, 1.02);

        Humidifier humidifier_livingRoom = new Humidifier("Boneco U700", livingRoom, 2);
        Humidifier humidifier_bedroomForParents = new Humidifier("Boneco U700", bedroomForParents, 1);
        Humidifier humidifier_bedroomForGrands = new Humidifier("Boneco U700", bedroomForGrands, 0.3);
        Humidifier humidifier_childRoom = new Humidifier("Boneco U700", childRoom, 0.9);

        Light light_hallway = new Light("Light", hallway);
        Light light_showerRoom = new Light("Light", showerRoom);
        Light light_kitchen = new Light("Light", kitchen);
        Light light_livingRoom = new Light("Light", livingRoom);
        Light light_bedroomForParents = new Light("Light", bedroomForParents);
        Light light_bedroomForGrands = new Light("Light", bedroomForGrands);
        Light light_childRoom = new Light("Light", hallway);
        Light light_garage = new Light("Light", garage);
        Light light_outside = new Light("Light", outside);

        Window window_hallway = new Window("Window", hallway);
        Window window_showerRoom = new Window("Window", showerRoom);
        Window window_kitchen = new Window("Window", kitchen);
        Window window_livingRoom = new Window("Window", livingRoom);
        Window window_bedroomForParents = new Window("Window", bedroomForParents);
        Window window_bedroomForGrands = new Window("Window", bedroomForGrands);
        Window window_childRoom = new Window("Window", hallway);
        Window window_garage = new Window("Window", garage);

        Multicooker multicooker_kitchen = new Multicooker("Tefal", kitchen, 0.8);

        RobotVacuumCleaner robotVacuumCleaner_livingRoom = new RobotVacuumCleaner("Dyson", livingRoom, 0.9);
        RobotVacuumCleaner robotVacuumCleaner_bedroomForParents = new RobotVacuumCleaner("Dyson", bedroomForParents, 0.7);
        RobotVacuumCleaner robotVacuumCleaner_bedroomForGrands = new RobotVacuumCleaner("Dyson", bedroomForGrands, 1.2);
        RobotVacuumCleaner robotVacuumCleaner_childRoom = new RobotVacuumCleaner("Dyson", childRoom, 1.14);

        // Smartphone

        Teapot teapot_kitchen = new Teapot("Bork", kitchen, 1);

        TV tv_livingRoom = new TV("Samsung", livingRoom, 1);
        TV tv_bedroomForParents = new TV("Samsung", bedroomForParents, 2);
        TV tv_bedroomForGrands = new TV("Samsung", bedroomForGrands, 1.3);

        WashingMachine washingMachine_showerRoom_1 = new WashingMachine("Samsung Washing", showerRoom, 3, 1);
        WashingMachine washingMachine_showerRoom_2 = new WashingMachine("Samsung Washing", showerRoom, 4.1, 1.4);

        //Transport
        Car car_1 = new Car(4, 4, garage);
        Car car_2 = new Car(2, 3, garage);
        Bike bike_1 = new Bike(garage);
        Bike bike_2 = new Bike(garage);
        Ski ski_1 = new Ski(garage);
        Ski ski_2 = new Ski(garage);
        Ski ski_3 = new Ski(garage);

        garage.setTransport(Arrays.asList(car_1, car_2, bike_1, bike_2, ski_1, ski_2, ski_3));

        // Connecting Devices to Rooms
        livingRoom.setDevices(Arrays.asList(tv_livingRoom, airCleaner_livingRoom, computer_livingRoom, conditioner_livingRoom, humidifier_livingRoom, light_livingRoom, robotVacuumCleaner_livingRoom, window_livingRoom));
        hallway.setDevices(Arrays.asList(light_hallway, window_hallway));
        showerRoom.setDevices(Arrays.asList(light_showerRoom, washingMachine_showerRoom_1, washingMachine_showerRoom_2, window_showerRoom));
        kitchen.setDevices(Arrays.asList(fridge_kitchen, gasCooker_kitchen_1, gasCooker_kitchen_2, light_kitchen, multicooker_kitchen, teapot_kitchen, window_kitchen));
        bedroomForParents.setDevices(Arrays.asList(tv_bedroomForParents, airCleaner_bedroomForParents, babyMonitor_bedroomForParents, computer_bedroomForParents, conditioner_bedroomForParents, humidifier_bedroomForParents, light_bedroomForParents, robotVacuumCleaner_bedroomForParents, window_bedroomForParents));
        bedroomForGrands.setDevices(Arrays.asList(tv_bedroomForGrands, airCleaner_bedroomForGrands, conditioner_bedroomForGrands, humidifier_bedroomForGrands, light_bedroomForGrands, robotVacuumCleaner_bedroomForGrands, window_bedroomForGrands));
        childRoom.setDevices(Arrays.asList(babyMonitor_childRoom, conditioner_childRoom, humidifier_childRoom, light_childRoom, robotVacuumCleaner_childRoom, window_childRoom));
        garage.setDevices(Arrays.asList(light_garage, window_garage));
        outside.setDevices(Arrays.asList(light_outside));

        powerOutagesSignalization.subscribe(livingRoom);
        House returningHouse = new House("Technicka 2", father, Arrays.asList(firstLvl, secondLvl), outside, powerOutagesSignalization, waterLeakSignalization, gasLeakSignalization, fireSignalization, Arrays.asList(father, mother, grandfather, grandmother, son, daughter, guest1, guest2, guest3, guest4, guest5, guest6, guest7, guest8, guest9, guest10), Arrays.asList(dog, cat, parrot));
        firstLvl.setHouse(returningHouse);
        secondLvl.setHouse(returningHouse);
        fireSignalization.setHouse(returningHouse);

        for (Level lvl : returningHouse.getLevels()) {
            for (Room currentRoom : lvl.getRooms()) {
                powerOutagesSignalization.subscribe(currentRoom);
                for (Device currentDevice : currentRoom.getDevices()) {
                    powerOutagesSignalization.subscribe(currentDevice);
                    if (currentDevice instanceof GasDevice) {
                        gasLeakSignalization.subscribe(currentDevice);
                    }
                    if (currentDevice instanceof WaterDevice) {
                        waterLeakSignalization.subscribe(currentDevice);
                    }
                }
            }
        }
        return returningHouse;
    }
}