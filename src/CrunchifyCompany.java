/**
 * Created by prasanthnair on 1/3/16.
 */
class CrunchifyCompany extends Company {
    /*
     * static method of same name and method signature as existed in super
     * class, this is not method overriding instead this is called method hiding
     * in Java
     */
    public static void staticMethod() {
        System.out.println("CrunchifyCompany: Overridden Static Instance method");
    }

    // non static method
    public void nonStaticMethod() {
        System.out.println("CrunchifyCompany: non-Static method");
    }
}