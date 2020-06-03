package ca.meshcode.school.java.foundation.dependencies;

//EXTENDS means a subclass inherits attributes and methods from superclass,
// OVERRIDE is just an annotation for the compiler signalling that an inherited method is about to be overwritten and
// SUPER actually invokes the running of the superclass method.
//
//EXTEND:
//key concept: this class is an extension of base class from which it inherits
public class Client extends TrialClient {

    //OVERRIDE:
    //the inherited bought method will be overridden
    @Override
    public void bought() {
        //SUPER:
        //first thinig is that this method will inherit the
        super.bought();
        System.out.println("Three scoops.");
    }
}
