package Evalution_5;

import java.util.Scanner;

public class MainFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("WELCOME TO SIM COMPANY CALL CENTER");
        Boolean flag = true;
        Functionality functionality = new Functionality();
        while (flag){
            System.out.println("0 FOR EXIT\n1 FOR PREPAID USER\n2 FOR NEW CONNECTION\n3 FOR VIEW ALL USERS");
            int ch = sc.nextInt();

            switch (ch){
                case 0:
                    break;
                case 1:
                    functionality.prepaid();
                    break;
                case 2:
                    functionality.NewConnection();
                    break;
                case 3:
                    System.out.println(functionality.toString());
                    break;
                default:
                    System.out.println("PLEASE SELECT FROM ABOVE OPTIONS");
                    break;

            }

        }
    }
}
