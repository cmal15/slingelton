package Ejemplo2;

import java.util.LinkedList;
import java.util.Queue;

public class ElevatorControl {
    
    private static ElevatorControl instance = null;
    private Queue<Integer> elevatorQueue;

    private ElevatorControl(){
        elevatorQueue = new LinkedList<>();
    }

    public static ElevatorControl getInstance(){
        if(instance == null){
            synchronized(ElevatorControl.class){
                if(instance == null){
                    instance = new ElevatorControl();
                }
            }
        }
        return instance;
    }

    public void addToQueue(int floor){
        elevatorQueue.add(floor);
    }

    public int getNextFloor(){
        if(elevatorQueue.isEmpty()){
            return -1;
        }
        return elevatorQueue.poll();
    }

    public int peekNextFloor(){
        if(elevatorQueue.isEmpty()){
            return -1;
        }
        return elevatorQueue.peek();
    }

}
