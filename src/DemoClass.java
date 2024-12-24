@Cache({"property1", "property2"})
@Default(value = Object.class)
@ToString(value = ToString.Value.YES)
@Two(first = "example", second = 42)
@Validate({String.class, Integer.class})
public class DemoClass {

    private String field;

    @Invoke
    public void annotatedMethod() {

    }
}
