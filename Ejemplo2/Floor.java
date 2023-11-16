package Ejemplo2;

public class Floor {

    private int floor;

    public Floor(int floor){
        this.floor = floor;
    }

    public void callElevator(){
        ElevatorControl elevatorControl = ElevatorControl.getInstance();
        elevatorControl.addToQueue(floor);
    }
    
}
