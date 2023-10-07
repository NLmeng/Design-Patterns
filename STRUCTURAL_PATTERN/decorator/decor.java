// package decorator;

// using decorator:
// can wrap concretecomponents to perform its basic behavior
// can dynamically add extra behaviors on top using decorators
// both Decorator and SubComponent needs to extend Components in order to "wrap"
// allow extension to existing classes (extension > inheritance)
interface Component {
    public void action();
}
//
class ConcreteComponentA implements Component{
    public void action() {
        System.out.println("doing A");
    }
}
class ConcreteComponentB implements Component{
    public void action() {
        System.out.println("doing B");
    }
}
//
abstract class Decorator implements Component {
    Component wrapped;
    public Decorator(Component c) {
        // assume we pass in whatever we want to wrap
        wrapped = c;
    }
}
//
class ConcreteDecoratorA extends Decorator {
    public ConcreteDecoratorA(Component c) {
        super(c);
    }
    public void action() {
        System.out.println("decorating A");
        // (new ConcreteComponentA()).action();
        wrapped.action();
    }
}
class ConcreteDecoratorB extends Decorator {
    public ConcreteDecoratorB(Component c) {
        super(c);
    }
    public void action() {
        System.out.println("decorating B");
        // (new ConcreteComponentB()).action();
        wrapped.action();
    }
}
//
public class decor {
    public static void main(String[] args) {
        Component A = new ConcreteComponentA();
        Decorator B = new ConcreteDecoratorA(A);
        Decorator C = new ConcreteDecoratorB(B);
        C.action();
        // DecorateB -> DecorateA -> doA
    }
}
