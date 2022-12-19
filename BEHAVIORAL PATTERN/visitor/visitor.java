// package visitor;

// pre-visitor:
// class Thing2 { 
//     public void sayGoodbye() {
//         System.out.println("Goodbye"); 
//     }    
// }

// class Thing1 {
//     Thing2 thing2 = new Thing2(); 
    
//     public void printHello() {
//         System.out.println("Hello"); 
//     }
//     public void sayHello()  { 
//         printHello();
//         thing2.sayGoodbye(); 
//     }
// }

// applying visitor:
// visitor that will visit and perform based on parameter passed in
// now all "hello" "goodbye" behaviors in one place
class HelloGoodbyeVisitor {
    // visit and perform Thing1
    public void visit(Thing1 t1) {
        System.out.println("Hello");
        Thing2 t2 = new Thing2();
        t2.accept(this);
    }
    // visit and perform Thing2
    public void visit(Thing2 t2) {
        System.out.println("Goodbye");
    }
}
// IThing
interface Thing {
    public void accept(HelloGoodbyeVisitor hgv);
}
// Thing1 accepts then dispatches itself to be visited
class Thing1 implements Thing {
    public void accept(HelloGoodbyeVisitor hgv) {
        hgv.visit(this);
    }
}
// Thing2 accepts then dispatches itself to be visited
class Thing2 implements Thing {
    public void accept(HelloGoodbyeVisitor hgv) {
        hgv.visit(this);
    }
}
//
public class visitor {
    public static void main(String[] args) { 
        // Thing1 t1 = new Thing1(); 
        // t1.sayHello();

        // creates a visitor and the thing to visit
        HelloGoodbyeVisitor visitor = new HelloGoodbyeVisitor();
        Thing1 t1 = new Thing1();
        // double dispatch using parameter (instead of just receiver(t1))
        t1.accept(visitor);
    }
}
