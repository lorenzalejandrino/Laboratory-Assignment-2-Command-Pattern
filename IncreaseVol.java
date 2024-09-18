public class IncreaseVol implements Command {
    private Speaker speaker;

    public IncreaseVol(Speaker speaker){
        this.speaker = speaker;
    }

    @Override
    public void execute() {
        speaker.increaseVol();
    }
}