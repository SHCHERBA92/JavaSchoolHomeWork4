package Task_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MyTerminal myTerminal = new MyTerminal(5000,"2342");
        System.out.println(myTerminal.getAccount());

        System.out.println("1.\tПоложить средства");
        System.out.println("2.\tСнять средства");
        System.out.println("3.\tПроверить средства");

        switch (new Scanner(System.in).nextInt()){
            case 1:
                System.out.println(myTerminal.getCash());
                System.out.println("Введите сумму для зачисления");
                int myCash = myTerminal.addCash(new Scanner(System.in).nextInt());
                System.out.println(myTerminal.getCash());
                break;
            case 2:
                System.out.println(myTerminal.getCash());
                System.out.println("Введите сумму для снятия");
                int myCash1 = myTerminal.drawCash(new Scanner(System.in).nextInt());
                System.out.println(myTerminal.getCash());
                break;
            case 3:
                System.out.println("На вашем счёте \n \t" + myTerminal.checkCash());
            default:break;
        }


    }
}
