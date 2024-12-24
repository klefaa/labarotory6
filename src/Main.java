import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice != 0) {
            System.out.println("Выберите задачу:");
            System.out.println("1. (1.2) Валидация");
            System.out.println("3. (3.2) Новая валидация");
            choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("Тестирование для числа 1");
                    System.out.println("Validator.validate(1, IntTester.class)");
                    Validator.validate(1, IntTester.class);
                    System.out.println();
                    System.out.println("Тестирование для числа 0");
                    System.out.println("Validator.validate(0, IntTester.class)");
                    Validator.validate(0, IntTester.class);
                    break;
                }
                case 3: {
                    ValidatorVersion2.validate(new MyClass(2), new MyClass(3));
                }

            }
        }

    }
}