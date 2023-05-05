package cz.cvut.fel.omo;

import cz.cvut.fel.omo.event.EventGenerator;
import cz.cvut.fel.omo.model.parts.House;
import cz.cvut.fel.omo.model.parts.HouseCreator;
import cz.cvut.fel.omo.visitor.CustomVisitor;
import cz.cvut.fel.omo.visitor.ReportVisitor;

public class Main {
    public static void main(String[] args) {
        House house1 = HouseCreator.getInstance().basicHouseCreation();
        House house2 = HouseCreator.getInstance().enhancedHouseCreation();
        /**
         * house 1 - simple configuration
         * house 2 - hard configuration
         */
        selectHouse(house1);
    }

    private static void selectHouse(House house){
        CustomVisitor visitor = new ReportVisitor();
        house.accept(visitor);
        EventGenerator.getInstance().setHouse(house);
        EventGenerator.getInstance().generateLifeEvents();
    }
}