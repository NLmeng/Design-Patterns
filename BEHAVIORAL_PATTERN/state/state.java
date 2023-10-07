// package state;

// pre-state:
// class Skyline {
//     private String currentPhase = "";
//     // the fields below are used in other methods not shown public String city;
//     public boolean isCloudy;
//     public Skyline(String phase) {
//         this.currentPhase = phase;
//     }
//     public void takePhoto() { 
//         if(currentPhase.equals("sunrise"))
//             System.out.println("Taking a nice photo of the sunrise!"); 
//         else if(currentPhase.equals("sunset"))
//             System.out.println("Taking an awesome photo of the sunset!"); 
//         else
//             System.out.println("Nothing to take a photo of yet");
//     }
//     public void forwardTime() { 
//         System.out.println("MOVING FORWARD"); 
//         if(currentPhase.equals("sunrise"))
//             currentPhase = "day";
//         else if(currentPhase.equals("day"))
//             currentPhase = "sunset";
//         else if(currentPhase.equals("sunset"))
//             currentPhase = "night"; else currentPhase = "sunrise";
//     }
//     public void applySunscreen() {
//         /* similar switch statement with behaviours for each event */ 
//     } 
//     public void adjustLighting() {
//         /* similar switch statement with behaviours for each event */ 
//     }
// }

// applying state:
// Client uses Context that delegates the currentPhase
// use delegation to invoke behvaiors on the State currently instantiated
// self-changing, State dynamically knows its own State by Context
// & State must create new instantiation of subsequent State (or keep a list of instantiated States)
// Context/Skyline that delegates the State to dynamically allow transitions
class Skyline {
    public PhaseState currentPhase;
    public Skyline() {
        // assume we start with Sunrise
        this.setPhase(new SunrisePhase());
    }
    public void takePhoto() {
        currentPhase.takePhoto();
    }
    public void forwardTime() {
        currentPhase.forwardTime(this);
    }
    public void setPhase(PhaseState nextState) {
        currentPhase = nextState;
    }
    // some other functions
}
// abstract PhaseState / easier to extend, supports OCP and SRP
abstract class PhaseState {
    public Skyline context;
    public abstract void takePhoto();
    public void forwardTime(Skyline context) {
        System.out.println("MOVING FORWARD"); 
    }
    // some other functions
}
// concrete Phases
class SunrisePhase extends PhaseState {
    public void takePhoto() {
        System.out.println("Taking a nice photo of the sunrise!"); 
    }
    @Override
    public void forwardTime(Skyline context) {
        super.forwardTime(context);
        System.out.println(" from Sunrise");
        context.setPhase(new DayPhase());
    }
}
class DayPhase extends PhaseState {
    public void takePhoto() {
        System.out.println("Nothing to take a photo of yet");
    }
    @Override
    public void forwardTime(Skyline context) {
        super.forwardTime(context);
        System.out.println(" from Day");
        context.setPhase(new SunsetPhase());
    }
}
class SunsetPhase extends PhaseState {
    public void takePhoto() {
        System.out.println("Taking an awesome photo of the sunset!");
    }
    @Override
    public void forwardTime(Skyline context) {
        super.forwardTime(context);
        System.out.println(" from Sunset");
        context.setPhase(new NightPhase());
    }
}
class NightPhase extends PhaseState {
    public void takePhoto() {
        System.out.println("Nothing to take a photo of yet");
    }
    @Override
    public void forwardTime(Skyline context) {
        super.forwardTime(context);
        System.out.println(" from Night");
        context.setPhase(new SunrisePhase());
    }
}
//
public class state {
    public static void main(String[] args) {
        // Skyline sl = new Skyline("sunrise");
        // for (int i = 0; i < 6; i++) {
        //     sl.takePhoto();
        //     sl.forwardTime();
        // }
        Skyline sl = new Skyline();
        for (int i = 0; i < 6; i++) {
            sl.takePhoto();
            sl.forwardTime();
        }
    }
}
