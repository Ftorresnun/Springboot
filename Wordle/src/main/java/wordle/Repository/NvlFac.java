package wordle.Repository;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("facil")
@Component
public class NvlFac implements Game {
    final static String CorrectWord = "pan";
    final static int tries = 20;

    @Override
    public int getNumTries() {
        return tries;
    }

    @Override
    public String getNumAnswer() {
        return CorrectWord;
    }
}
