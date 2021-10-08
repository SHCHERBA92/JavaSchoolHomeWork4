package Task_1;

import java.io.IOException;

public class AutoBlockExeption extends IOException {
    public int time ;
    public final String BLOCK_ACCOUNT = "Аккаунт заблокирован";


    public AutoBlockExeption(String message) {
        super(message);

        System.out.println("Аккаунт заблокирован на 10 секунд");

        for (time = 10; time > 0; time--) {
            try {
                Thread.sleep(1000);
                System.out.println("Аккаунт будет разблокирован через " + this.time + " секунд");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public AutoBlockExeption() {
        System.out.println(BLOCK_ACCOUNT);
    }

    @Override
    public String getMessage() {
        return "Аккаунт будет разблокирован через " + this.time + " секунд";
    }

    @Override
    public String getLocalizedMessage() {
        return super.getLocalizedMessage() + " " + BLOCK_ACCOUNT;
    }
}
