@Validate({MyClassTester1.class, MyClassTester2.class})
public class MyClass {

    int a;

    public MyClass(int a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "a=" + a +
                '}';
    }
}
