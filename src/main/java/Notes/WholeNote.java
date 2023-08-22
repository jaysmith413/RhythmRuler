package Notes;

import Notes.Note;

public class WholeNote extends Note {

    private final long defaultDuration = 4800;

    @Override
    public long getDefaultDurationInMs(){
        return defaultDuration;
    }
}
