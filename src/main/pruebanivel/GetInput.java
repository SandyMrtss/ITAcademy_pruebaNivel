package pruebanivel;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GetInput {
    private static Scanner in = new Scanner(System.in);

    public static int readInt(String message){
        while (true){
            System.out.printf(message);
            int i;
            try {
                i = in.nextInt();
                in.nextLine();
                return i;
            }
            catch(InputMismatchException ex) {
                System.out.println("Format error, please input an integer");
                in.nextLine();
            }
        }
    }
    public static double readDouble(String message){
        while (true){
            System.out.printf(message);
            double i;
            try {
                i = in.nextDouble();
                in.nextLine();
                return i;
            }
            catch(InputMismatchException ex) {
                System.out.println("Format error, please input an integer");
                in.nextLine();
            }
        }
    }
    public static String readString(String message){
        while (true){
            System.out.printf(message);
            String s;
            try {
                s = in.nextLine();
                if(s.chars().anyMatch(Character::isDigit)){
                    throw new Exception();
                }
                else {
                    return s;
                }
            }
            catch(Exception ex) {
                System.out.println("Format error, please input only letters");
            }
        }
    }
}
