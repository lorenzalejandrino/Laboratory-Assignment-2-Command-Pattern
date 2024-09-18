public class Light{
    private Boolean isLightSwitchedOn = false;

    public void switchOn() {
        System.out.println("Lights are switched on!\n");
        isLightSwitchedOn = true;
    }

    public void switchOff(){
        System.out.println("Lights are switched off!\n");
        isLightSwitchedOn = false;
    }

    public boolean checkLightState(){
        return isLightSwitchedOn;
    }
}