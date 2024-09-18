public class DecreaseVol implements Command {
    private Speaker speaker;

    public DecreaseVol(Speaker speaker){
        this.speaker = speaker;
    }

    @Override
    public void execute() {
        speaker.decreaseVol();
    }
}