// package observer;
import java.util.List;
import java.util.ArrayList;

// using observer:
// use for 1-to-many dependency
// we want to make changes to many dependency when 1 thing canges
// use interfaces/abstractions to apply obliviousness
// can avoid switch-on-types
// Interface Observer that will update() everytime it's notified(sth chaned in Subject)
interface Watcher {
    public void update();
    // some other functions
}
// concrete Observers
class WatcherA implements Watcher {
    public void update() {
        System.out.println("updating from A");
    }
    // some other functions
}
class WatcherB implements Watcher {
    public void update() {
        System.out.println("updating from B");
    }
    // some other functions
}
// Subject that will be observed and notify whenver there is changes
class Subject {
    List<Watcher> observers;
    // assign observers to watch this Subject
    public Subject(List<Watcher> watchers) {
        observers = watchers;
    }
    public void notifyObservers() {
        for(int i = 0; i < observers.size(); i++) {
            observers.get(i).update();
        }
    }
}
//
public class observer {
    public static void main(String[] args) {
        List<Watcher> observers = new ArrayList<>();
        // arbitarily assign 5 watchers
        for(int i = 0; i < 5; i++) {
            if (i%2==0)
                observers.add(new WatcherA());
            else
                observers.add(new WatcherB());
        }
        Subject sj = new Subject(observers);
        sj.notifyObservers();
    }
}
