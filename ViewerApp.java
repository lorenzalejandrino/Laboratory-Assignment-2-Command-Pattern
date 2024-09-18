import java.util.Scanner;

public class ViewerApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int choice;
        boolean cont = true;

        Light lights = new Light();
        Thermostat thermostat = new Thermostat();
        Speaker speaker = new Speaker();
        RemoteControl rc = new RemoteControl();

        while (cont) {
            System.out.print("\nChoose which appliance to control\n1. Lights\n2. Thermostat\n3. Speaker\n4. Exit\nChoice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    handleLightsControl(lights, rc, input);
                    break;

                case 2:
                    handleThermostatControl(thermostat, rc, input);
                    break;

                case 3:
                    handleSpeakerControl(speaker, rc, input);
                    break;

                case 4:
                    System.out.println("\nExiting...");
                    cont = false;
                    break;

                default:
                    System.out.println("Enter a valid choice!\n");
            }
        }
    }

    private static void handleLightsControl(Light lights, RemoteControl rc, Scanner input) {
        Command lightsPowerOff = new LightsPowerOff(lights);
        Command lightsPowerOn = new LightsPowerOn(lights);

        if (lights.checkLightState()) {
            System.out.println("Lights are currently off!\nSwitch it on?\n1. Yes\n2. No");
        } else {
            System.out.println("Lights are currently on!\nSwitch it off?\n1. Yes\n2. No");
        }

        int choice = input.nextInt();
        if (choice == 1) {
            rc.setCommand(lights.checkLightState() ? lightsPowerOn : lightsPowerOff);
            rc.clickButton();
        } else {
            System.out.println("No action taken.\n");
        }
    }

    private static void handleThermostatControl(Thermostat thermostat, RemoteControl rc, Scanner input) {
        Command thermostatPowerOff = new ThermostatPowerOff(thermostat);
        Command thermostatPowerOn = new ThermostatPowerOn(thermostat);
        Command decreaseTemperature = new DecreaseTemperature(thermostat);
        Command increaseTemperature = new IncreaseTemperature(thermostat);

        if (thermostat.checkThermostatState()) {
            System.out.println("\nThermostat is currently on!\nWhat do you want to do?\n1. Power off\n2. Decrease Temperature\n3. Increase Temperature\n4. Exit");
        } else {
            System.out.println("\nThermostat is currently off!\nWhat do you want to do?\n1. Power on\n2. Exit");
        }

        int choice = input.nextInt();
        if (thermostat.checkThermostatState()) {
            switch (choice) {
                case 1 -> rc.setCommand(thermostatPowerOff);
                case 2 -> rc.setCommand(decreaseTemperature);
                case 3 -> rc.setCommand(increaseTemperature);
                default -> System.out.println("No action taken.\n");
            }
        } else if (choice == 1) {
            rc.setCommand(thermostatPowerOn);
        }
        rc.clickButton();
    }

    private static void handleSpeakerControl(Speaker speaker, RemoteControl rc, Scanner input) {
        Command speakerPowerOff = new SpeakerPowerOff(speaker);
        Command speakerPowerOn = new SpeakerPowerOn(speaker);
        Command increaseVolume = new IncreaseVol(speaker);
        Command decreaseVolume = new DecreaseVol(speaker);

        if (speaker.checkSpeakerState()) {
            System.out.println("\nSpeaker is currently on!\nWhat do you want to do?\n1. Power off\n2. Increase Volume\n3. Decrease Volume\n4. Exit");
        } else {
            System.out.println("\nSpeaker is currently off!\nPower on?\n1. Yes\n2. Exit");
        }

        int choice = input.nextInt();
        if (speaker.checkSpeakerState()) {
            switch (choice) {
                case 1 -> rc.setCommand(speakerPowerOff);
                case 2 -> rc.setCommand(increaseVolume);
                case 3 -> rc.setCommand(decreaseVolume);
                default -> System.out.println("No action taken.\n");
            }
        } else if (choice == 1) {
            rc.setCommand(speakerPowerOn);
        }
        rc.clickButton();
    }
}
