package Task_1;

import javax.swing.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class MyTerminal implements Terminal{
    private int cash;
    private final String password;
    private boolean statusAccount = false;

//    JFrame jFrame;
//    JPanel jPanel;

    public MyTerminal(int cash, String password) {
        this.cash = cash;
        this.password = password;
//         jFrame = new JFrame();
//         jPanel = new JPanel();
//        jPanel.add(new JTextPane());
    }

    @Override
    public double checkCash() {
        return this.cash;
    }

    @Override
    public void withdraw(double cash) {

    }

    @Override
    public void topUpAnAccount(double cash) {

    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    private boolean entryPass()
    {
        int count = 0;
        int errorCount = 0;
        String str;
        Scanner scanner = new Scanner(System.in);

        while (count <4)
        {
            switch (count){
                case 0-> System.out.println("Введите первую цифру");
                case 1-> System.out.println("Введите вторую цифру");
                case 2-> System.out.println("Введите третью цифру");
                case 3-> System.out.println("Введите четвёртую цифру");
            }

            try {
//                str = scanner.findInLine("[0-9]");
                str = new Scanner(System.in).findInLine("[0-9]");
                if (Integer.parseInt(String.valueOf(password.charAt(count)))==Integer.parseInt(String.valueOf(str.charAt(0))))
                {
                    count++;
                }
                else {
                    try {
                        System.out.println("Неверная цифра, введите ещё раз");
                        ++errorCount;
                        if (errorCount==4)
                        {
                            errorCount=0;
                            throw new AutoBlockExeption("Аккаунт заблокирован");
                        }
                    }catch (AutoBlockExeption e)
                    {
                        System.out.println("Аккаунт будет разблокирован через " + e.getMessage() + " секунд");
                    }

                }
            }catch (NullPointerException e)
            {
                System.out.println("Вводите только цифры");
            }finally {
                continue;
            }

        }

        if (count==4)
        {
            return true;
        }
        return false;
    }

    public boolean getAccount()
    {
        boolean b;
        do {
            System.out.println("Введите Пароль из " + this.password.length() + " чисел");
            b = this.entryPass();
            if (b)
            {
                System.out.println("Акаунт разблокирован");
                statusAccount = true;
                return true;
            }
        }
        while (!b);

        return false;
    }

    public int addCash(int cash) throws NumberFormatException
    {
         try {
             if (statusAccount==false)
            throw new AutoBlockExeption();
        } catch (AutoBlockExeption autoBlockExeption) {
//            autoBlockExeption.printStackTrace();
             System.out.println(autoBlockExeption.getLocalizedMessage());
        }

         try {
             if (cash < 100 && cash%100 != 0)
             {
                 throw new MyNumberExeption();
             }
             else {
                 this.cash+=cash;
             }
         }catch (MyNumberExeption e)
         {
             e.getMessage();
         }


     return this.cash;
    }
    public int drawCash(int cash) throws NumberFormatException
    {
         try {
             if (statusAccount==false)
            throw new AutoBlockExeption();
        } catch (AutoBlockExeption autoBlockExeption) {
//            autoBlockExeption.printStackTrace();
             System.out.println(autoBlockExeption.getLocalizedMessage());
        }

         try {
             if (this.cash < 100) throw new MyNumberExeption();

             if (cash < 100 && cash%100 != 0)
             {
                 throw new MyNumberExeption();
             }
             else {
                 this.cash-=cash;
             }
         }catch (MyNumberExeption e)
         {
             e.getMessage();
         }


     return this.cash;
    }
}
