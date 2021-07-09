package final_project;

import java.util.List;

class Cell {
    private Coordinates coordinate;
    private Status status;
    private List<Coordinates> ship;

    public Cell(Coordinates coordinate, Status status) {
        this.coordinate = coordinate;
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Coordinates> getShip() {
        return ship;
    }

    public void setShip(List<Coordinates> ship) {
        this.ship = ship;
    }

}
