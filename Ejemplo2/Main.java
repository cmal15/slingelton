package Ejemplo2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ElevatorControl elevatorControl = ElevatorControl.getInstance();
        ArrayList<Floor> floors = new ArrayList<>();
        int op;

        for(int i = 0; i < 10; i++){
            floors.add(new Floor(i));
        }
        
        do{    

            do{
                System.out.println("Ingrese el piso desde el cual se llama al elevador(1-10):");
                System.out.println("-1 para salir");
                op = sc.nextInt();
                if(op == -1){
                    break;
                }
                try {
                    floors.get(op-1).callElevator();
                } catch (IndexOutOfBoundsException e) {
                    System.err.println("Piso invalido");
                }

            }while(op != -1);

            System.out.println("El elevador se movera a los siguientes pisos:");

            while(elevatorControl.peekNextFloor() != -1){
                System.out.println("Moviendose hacia: " + (elevatorControl.getNextFloor()+1 ));
            }

            System.out.println("Ya no hay llamadas a pisos pendientes");

            System.out.println("1. Hacer mas llamadas\t2.Salir");
            op = sc.nextInt();

        }while(op != 2);

        sc.close();
    }

}
