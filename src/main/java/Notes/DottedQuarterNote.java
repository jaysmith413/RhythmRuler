package Notes;

public class DottedQuarterNote extends Note {

    private final long defaultDuration = 1800;

    @Override
    public long getDefaultDurationInMs(){
        return defaultDuration;
    }
}
