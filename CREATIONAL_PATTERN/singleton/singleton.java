// package singleton;

// using singleton:
// use when we want to allow only A SINGLE INSTANCE of an object
// lazy loaded: instantiated ONLY once when needed, has private constructor and use getInstance()
// mostly static, except the private constructor
class aSingleton {
    private static aSingleton self = null;
    private aSingleton() {
        System.out.println("creating Singleton");
    }
    public static aSingleton getInstance() {
        if (self == null)
            self = new aSingleton();
        else
            System.out.println("returning a previous instance");
        return self;
    }
}
//
public class singleton {
    public static void main(String[] args) {
        // cannot use constructor
        // Singleton instance = new Singelton();
        aSingleton instance  = aSingleton.getInstance();
        // attempt to get new instances would only refer to the previous one
        aSingleton instance2 = aSingleton.getInstance();
        aSingleton instance3 = aSingleton.getInstance();
    }
}
