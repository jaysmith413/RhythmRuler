package Notes;

public class DottedHalfNote extends Note {

    private final long defaultDuration = 3600;

    @Override
    public long getDefaultDurationInMs(){
        return defaultDuration;
    }
}
