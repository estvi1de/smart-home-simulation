package cz.cvut.fel.omo.model.devices;

import cz.cvut.fel.omo.model.parts.Room;

public class Fridge extends Device {
    private Integer foodEnergy;

    public Fridge(String name, Room room, double periodicalElectricityConsumption) {
        super(false, name, room, periodicalElectricityConsumption);
        this.foodEnergy = 0;
    }

    public Fridge(String name, Room room, Integer food, double periodicalElectricityConsumption) {
        super(false, name, room, periodicalElectricityConsumption);
        this.foodEnergy = food;
    }

    public void setFoodEnergy(Integer foodEnergy) {
        this.foodEnergy = foodEnergy;
    }

    public Integer getFoodEnergy() {
        return foodEnergy;
    }
}