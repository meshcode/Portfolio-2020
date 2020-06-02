package ca.meshcode;

//this client class inherits from previous two
public class PremiumClient extends Client {

    @Override
    public void bought() {
        super.bought();
        System.out.println("Cherry topping.");
    }
}
