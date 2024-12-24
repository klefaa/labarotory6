import java.lang.reflect.Method;

public class ValidatorVersion2 {

    public static void validate(Object... objs) {

        for (Object obj : objs) {
            Class<?> objClass = obj.getClass();

            // проверка есть ли над классом аннотация
            if (!objClass.isAnnotationPresent(Validate.class)) {
                throw new ValidateException("Класс " + objClass.getName() + " не аннотирован @Validate");
            }

            // получение данных из аннотации
            Validate validateAnnotation = objClass.getAnnotation(Validate.class);
            Class<?>[] testClasses = validateAnnotation.value();

            try {
                System.out.println("Тестирование для " + obj + " началось");

                for (Class<?> testClass : testClasses) {
                    // создание экземпляра тестового класса для прогона тестов
                    Object testInstance = testClass.getDeclaredConstructor().newInstance();

                    // получение тестовых методов
                    Method[] methods = testClass.getDeclaredMethods();

                    for (Method method : methods) {
                        // вызов методов
                        Object result = method.invoke(testInstance, obj);

                        // тест возвращает false, бросаем исключение
                        if (result instanceof Boolean && !(Boolean) result) {
                            throw new ValidateException("Ошибка в тесте " + method.getName());
                        }
                    }

                }
                System.out.println("Все тесты для " + obj + " прошли");
                System.out.println();

            } catch (ReflectiveOperationException e) {
                throw new RuntimeException("Ошибка при вызове метода тестирования: " + e.getMessage(), e);
            }
        }
    }
}