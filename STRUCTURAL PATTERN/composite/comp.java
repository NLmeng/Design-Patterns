// package composite;
import java.util.*;

// using composite:
// abstract tree structure that can unify individual objects with a group of it
// reduce a lot of duplications using poly. and can easily traverse the tree
// allow extra behavior on groups and same behaviors for each individual
interface Component {
    public void operation();
}
// concrete Leaf (individuals) and Composite (groups)
class Leaf implements Component {
    public void operation() {
        System.out.println("performing at Leaf");
    }
}
class Composite implements Component {
    List<Component> children;
    public Composite() {
        children = new ArrayList<>();
    }
    public void operation() {
        System.out.println("performing at Composite");
        for (Component nextChild : children) {
            nextChild.operation();
        }
    }
    public void add(Component child) {
        children.add(child);
    }
    public void remove(Component child) {
        // allow some form of removal
    }
    public void child(Component child) {
        // allow some form of getter
    }
}
//
public class comp {
    public static void main(String[] args) {
        Composite c1 = new Composite();
        c1.add(new Leaf());
        Composite c2 = new Composite();
        c2.add(new Leaf());
        c2.add(c1);
        c2.add(new Leaf());
        c2.add(new Leaf());
        c2.operation();
    }
}
