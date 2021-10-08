package Task_2;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите URL");

        try {
            String myUrl = scanner.nextLine();
            if (myUrl.matches("^(https?|ftp|http)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]"))
            {
                URLConnection urlConnection = new URL(myUrl).openConnection();
                if (urlConnection.getContentLength() == -1) throw new MyValidExeption("Такого сайта нет");
            }
            else {
                throw new MyValidExeption("Не вверно введён URL");
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (MyValidExeption exception) {
            System.out.println(exception.getMessage());
        }catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
