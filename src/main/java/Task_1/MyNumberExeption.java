package Task_1;

public class MyNumberExeption extends ArithmeticException{
    int cash;

    public MyNumberExeption() {
    }

    public MyNumberExeption(int cash) {
        this.cash = cash;
    }

    @Override
    public String getMessage() {
        return "Можно класть/вычитать только кратное 100";
    }
    public String getMessage(int cash) {
        return String.valueOf(cash);
    }
}
