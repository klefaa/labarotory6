import java.lang.reflect.Method;

public class Validator {
    public static void validate(Object obj, Class<?> testClass) {
        try {
            Object testInstance = testClass.getDeclaredConstructor().newInstance();

            Method[] methods = testClass.getDeclaredMethods();

            for (Method method : methods) {
                // вызов метода теста с передачей тестируемого объекта
                Object result = method.invoke(testInstance, obj);

                // проверка результата
                if (result instanceof Boolean && !(Boolean) result) {
                    throw new ValidateException("Ошибка в тесте " + method.getName());
                }
            }
        } catch (Exception e) {
            // Ошибка выполнения + переброс ошибки выше
            throw new ValidateException("Ошибка валидации: " + e.getMessage(), e);
        }
    }
}
