package Notes;

public class EighthNote extends Note {
    private final long defaultDuration = 600;

    @Override
    public long getDefaultDurationInMs(){
        return defaultDuration;
    }
}
