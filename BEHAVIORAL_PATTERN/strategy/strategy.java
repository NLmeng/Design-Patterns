// package strategy;

// using strategy:
// use delegation in a static manner / Strategy isn't aware of its own state/Context
// allow Clients to "choose" the type of Strategy and Context will "use" it -> SRP
// Client is only coupled to Context and to 1 chosen Strategy
class Context {
    STR str;
    public Context() {
        // assume arbitrarily
        this.str = new Strategy1();
    }
    public void changeStrategy(STR next) {
        this.str = next;
    }
    public void perform() {
        // perform the behavior based on the instantiated Strategy
        this.str.algorithm();
    }
    // some other functions
}
// Interface Strategy / easier to extend, supports OCP
interface STR {
    public void algorithm();
    // some other functions
}
// concrete Stategys
class Strategy1 implements STR {
    public Strategy1() {};
    public void algorithm() {
        System.out.println("performing algorithm 1"); 
    }
    // some other functions
}
class Strategy2 implements STR {
    public Strategy2() {};
    public void algorithm() {
        System.out.println("performing algorithm 2"); 
    }
    // some other functions
}
//
public class strategy {
    public static void main(String[] args) {
        Context strat = new Context();
        strat.perform();
        strat.changeStrategy(new Strategy2());
        strat.perform();
    }
}
