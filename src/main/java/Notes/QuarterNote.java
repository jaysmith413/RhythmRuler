package Notes;

import Notes.Note;

public class QuarterNote extends Note {

    private final long defaultDuration = 1200;

    @Override
    public long getDefaultDurationInMs(){
        return defaultDuration;
    }
}
