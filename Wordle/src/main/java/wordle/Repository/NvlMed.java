package wordle.Repository;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("medio")
@Component
public class NvlMed implements Game {
    final static String CorrectWord = "canoa";
    final static int tries = 10;

    @Override
    public int getNumTries() {
        return tries;
    }

    @Override
    public String getNumAnswer() {
        return CorrectWord;
    }
}
