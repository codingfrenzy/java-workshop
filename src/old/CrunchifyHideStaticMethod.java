/**
 * Created by prasanthnair on 1/3/16.
 */
public class CrunchifyHideStaticMethod {
    public static void main(String args[]) {
        CrunchifyCompany cmp = new CrunchifyCompany();
        // if we can override static, this should call method from Child class
        cmp.staticMethod(); // Eclipse should show warning: The static method
        // staticMethod() from the type Company should be
        // accessed in a static way
        cmp.nonStaticMethod();
    }
}
