package Evalution_5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Functionality {


    String name;
    String email;

    String address;

    int adhaarNumber;

    String simtype;

    int initialBalance;

    int validity;

    int max=9;
    int min=0;

    Long mobileNo;
    Scanner sc = new Scanner(System.in);

    Random random = new Random();

    static List<Functionality> list = new ArrayList<>();

    Functionality(){

    }
    Functionality(String name, String email, String address, int adhaarNumber,String simtype, int initialBalance, long mobileNo){
        this.name = name;
        this.email = email;
        this.address = address;
        this.adhaarNumber= adhaarNumber;
        this.simtype = simtype;
        this.initialBalance=initialBalance;
        this.mobileNo = mobileNo;
    }

    public void prepaid()  {
        boolean flag=true;
        System.out.println("PLEASE ENTER THE PHONE NUMBER");
        boolean temp = false;
        long number = sc.nextLong();
        for(Functionality f : list){
            if(f.mobileNo==number){
                temp = true;
            }
        }
        if(temp){
            while (flag){
                System.out.println("1 for CHECK BALANCE AND VALIDITY\n1 FOR RECHARGE\n0 for EXIT");
                int c = sc.nextInt();
                switch (c){
                    case 1:
                        for(Functionality f : list){
                            if(f.mobileNo==number){
                                System.out.println("Name :"+ f.name);
                                System.out.println("Balance : "+f.initialBalance);
                                System.out.println("Validity :"+f.validity);
                            }
                        }
                        break;
                    case 2:
                        for(Functionality f : list){
                            if(f.mobileNo==number){
                                System.out.println("Enter the recharge amount");
                                sc.nextLine();
                                int recharge = sc.nextInt();

                                if(recharge<=0){
                                    try {
                                        throw new RechargeAmountTooLowException();
                                    } catch (RechargeAmountTooLowException e) {
                                        System.out.println(e);
                                    }
                                }else {
                                    f.initialBalance += recharge;
                                    f.validity += 1;
                                }
                            }
                        }
                        break;
                    case 0:
                        flag=false;
                        break;
                    default:
                        System.out.println("PLEASE SELECT FROM ABOVE OPTIONS");
                        break;
                }
            }
        }else{
            try {
                throw new UserDoesNotExist();
            } catch (UserDoesNotExist e) {
                System.out.println(e);
            }
        }


    }

    public void NewConnection(){
        System.out.println("Enter your name");
        name = sc.nextLine();
        System.out.println("Enter your email id");
        email = sc.nextLine();
        System.out.println("Enter your address");
        address = sc.next();
        System.out.println("Enter your addharr Number");
        adhaarNumber = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter your sim type");
        String str = sc.nextLine();
        simtype = str.toLowerCase();
        System.out.println("Enter your Intial balance");
        initialBalance = sc.nextInt();
        validity = 1;
        mobileNo = random.nextLong()%10000000000L;
        System.out.println("This is your mobile No "+mobileNo);

        list.add(new Functionality(name,email,address,adhaarNumber,simtype,initialBalance,mobileNo));


    }

    @Override
    public String toString() {
        return "Functionality{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", adhaarNumber=" + adhaarNumber +
                ", simtype='" + simtype + '\'' +
                ", initialBalance=" + initialBalance +
                ", validity=" + validity +
                ", max=" + max +
                ", min=" + min +
                ", mobileNo=" + mobileNo +
                ", sc=" + sc +
                ", random=" + random +
                '}';
    }
}
