package Notes;

public class HalfNote extends Note {

    private final long defaultDuration = 2400;

    @Override
    public long getDefaultDurationInMs(){
        return defaultDuration;
    }
}
