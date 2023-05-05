package cz.cvut.fel.omo.model.parts;

import cz.cvut.fel.omo.visitor.CustomVisitor;
import cz.cvut.fel.omo.visitor.Visit;

import java.util.List;

public class Level implements Visit {
    private Integer number;
    private List<Room> rooms;
    private House house;

    public Level(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number, House house) {
        this.number = number;
        this.house = house;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    @Override
    public void accept(CustomVisitor v) {
        v.visitLevel(this);
        for (Room currentRoom :
                rooms) {
            currentRoom.accept(v);
        }
    }
}