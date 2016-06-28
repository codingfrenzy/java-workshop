/**
 * Created by prasanthnair on 1/3/16.
 */
public class Company {
    // public static method which can not be overridden in Java
    public static void staticMethod() {
        System.out.println("Company: Static Instance method");
    }

    // non static method
    public void nonStaticMethod() {
        System.out.println("Company: non-Static method");
    }
}
