package Ejemplo2.ElevadoresGrafico;

import java.util.LinkedList;
import java.util.Queue;

public class ElevatorControlGui {
    
    private static ElevatorControlGui instance = null;
    private Queue<Integer> elevatorQueue;
    static int current = 0;

    private ElevatorControlGui(){
        elevatorQueue = new LinkedList<>();
    }

    public static ElevatorControlGui getInstance(){
        if(instance == null){
            synchronized(ElevatorControlGui.class){
                if(instance == null){
                    instance = new ElevatorControlGui();
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
        current = elevatorQueue.peek();
        return elevatorQueue.poll();
    }

    public int peekNextFloor(){
        if(elevatorQueue.isEmpty()){
            return -1;
        }
        return elevatorQueue.peek();
    }

}
