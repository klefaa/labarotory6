public class IntTester {
    public boolean test1(Integer number) {
        System.out.println("Проверка, которая дает всегда true");
        return true;
    }

    public boolean checkNotZero(Integer number) {
        System.out.println("Проверка, что число не равно нулю началась");
        return number != 0;
    }
}
