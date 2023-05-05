package cz.cvut.fel.omo.model.transport;

import cz.cvut.fel.omo.model.parts.Garage;

public class Bike extends Transport {
    public Bike(Garage garage) {
        super(1, 1, garage);
    }
}