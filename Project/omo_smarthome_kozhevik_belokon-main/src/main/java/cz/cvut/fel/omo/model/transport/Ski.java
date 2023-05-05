package cz.cvut.fel.omo.model.transport;

import cz.cvut.fel.omo.model.parts.Garage;

public class Ski extends Transport {
    public Ski(Garage garage) {
        super(1, 0, garage);
    }
}