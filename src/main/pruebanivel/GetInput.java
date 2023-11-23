package pruebanivel;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GetInput {
    static Scanner in = new Scanner(System.in);

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
    public static String readString(String message){
        while (true){
            System.out.printf(message);
            String s;
            try {
                s = in.nextLine();
                boolean allDigits = true;
                for(int i = 0; i < s.length(); ++i) {
                    char c = s.charAt(i);
                    if(Character.isAlphabetic(c)){
                        allDigits = false;
                    }
                }
                if(allDigits){
                    throw new Exception();
                }
                return s;
            }
            catch(Exception ex) {
                System.out.println("Format error, please input only alphabetic characters");
            }
        }
    }
}
