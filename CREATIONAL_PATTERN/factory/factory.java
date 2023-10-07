// package factory;

import java.util.ArrayList;
import java.util.List;

// pre-factory
// class SalmonDinner { 
//     String salad;
//     String sauce;
//     String salmon;
//     public SalmonDinner(String allergy, int salmonWeight) { 
//         if (allergy.equals("Peanut Free"))
//             makePeanutFreeSalmon(salmonWeight);
//     }
//     public SalmonDinner(int salmonWeight) {
//         makeSalmon(salmonWeight);
//     }
//     public void makeSalmon(int salmonWeight) { 
//         // salmon = buySalmon(salmonWeight); 
//         // salad  = buySalad();
//         // sauce  = buyFlour();
//         System.out.println("buying regular for salmon weigh: " + salmonWeight);
//     }
//     public void makePeanutFreeSalmon(int salmonWeight) {
//         // salmon = buyOrganicSalmon(salmonWeight); 
//         // salad  = buyPeanutFreeSalad();
//         // sauce  = buyPeanutFreeFlour();
//         System.out.println("buying p-free for salmon weigh: " + salmonWeight);
//     }
//     // methods serve, buyFlour, buyFlour, buyPeanutFreeFlour,
//     // buyPeanutFreeSalad, buySalmon, buyOrganicSalmon are not shown
//     public void serve() {
//         System.out.println("done");
//     }
// }

// applying factory:
// use when constructors become complicated, so we can afford to move behaviors outside of constructors
// use when want obliviousness or not sure which subtype to instantiate at a particular time 
// remove concrete coupling for clients (only depend on Interface Product and Factory)
// interface for Product/SalmonDinner(s)
interface Servable {
    // String salad;
    // String sauce;
    // String salmon;
    // public void makeAppropriateSalmon(int weight);
    // use Factory to construct appropriate Servable instead of directly calling the constructors
    public void serve();
    // methods serve, buyFlour, buyFlour, buyPeanutFreeFlour,
    // buyPeanutFreeSalad, buySalmon, buyOrganicSalmon are not shown
}
// concrete Products
class RegularSalmonDinner implements Servable {
    // can move unwanted behaviors outside
    public RegularSalmonDinner(int salmonWeight) { 
        // salmon = buySalmon(salmonWeight); 
        // salad  = buySalad();
        // sauce  = buyFlour();
        System.out.println("buying regular for salmon weigh: " + salmonWeight);
    }
    public void serve() {
        System.out.println("done regular");
    }
    // methods serve, buyFlour, buyFlour, buyPeanutFreeFlour,
    // buyPeanutFreeSalad, buySalmon, buyOrganicSalmon are not shown
}
class PeanutFreeSalmonDinner implements Servable {
    // can move unwanted behaviors outside
    public PeanutFreeSalmonDinner(int salmonWeight) { 
        // salmon = buyOrganicSalmon(salmonWeight); 
        // salad  = buyPeanutFreeSalad();
        // sauce  = buyPeanutFreeFlour();
        System.out.println("buying p-free for salmon weigh: " + salmonWeight);
    }
    public void serve() {
        System.out.println("done p-free");
    }
    // methods serve, buyFlour, buyFlour, buyPeanutFreeFlour,
    // buyPeanutFreeSalad, buySalmon, buyOrganicSalmon are not shown
}
// interface for Factory/SalmonDinnerMaker(s)
interface SalmonDinnerMaker {
    public Servable constructAppropriateDinner(int weight);
}
// concrete Factorys
// will construct RegularSalmonDinner for client
class RegularSalmonDinnerMaker implements SalmonDinnerMaker {
    public RegularSalmonDinner constructAppropriateDinner(int weight) {
        return new RegularSalmonDinner(weight);
    }
}
// will construct PeanitFreeSalmonDinner for client
class PeanutFreeSalmonDinnerMaker implements SalmonDinnerMaker {
    public PeanutFreeSalmonDinner constructAppropriateDinner(int weight) {
        return new PeanutFreeSalmonDinner(weight);
    }
}
//
public class factory {
    public static class GuestList {
        private int size;
        public GuestList() {
            this.size = 10;
            // assume 10 guests
        }
        public List<String> getAllergies() { 
            List<String> list = new ArrayList<>();
            // append some guests' allergies
            // uncomment to assume  peanut allegy
            list.add("peanut");
            return list;
        } 
        public int size() {
            return this.size;
        }
    }
    public static GuestList getGuestList() { 
        GuestList list = new GuestList();
        // append some guests
        return list;
    } 
    
    public static SalmonDinnerMaker initFactory(GuestList gl) {
        if (gl.getAllergies().contains("peanut")) {
            return new PeanutFreeSalmonDinnerMaker();
        } else {
            return new RegularSalmonDinnerMaker();
        }
    }

    public static void main(String[] args) {
        // SalmonDinner dinner;
        // GuestList guestList = getGuestList();
        // if (guestList.getAllergies().contains("peanut")) {
        //     dinner = new SalmonDinner("Peanut Free", guestList.size()); 
        // } else {
        //     dinner = new SalmonDinner(guestList.size()); 
        // }
        // dinner.serve();
        Servable dinner;
        GuestList guestList = getGuestList();
        SalmonDinnerMaker dinnerMaker = initFactory(guestList);
        dinner = dinnerMaker.constructAppropriateDinner(guestList.size());
        dinner.serve();
    }
}
