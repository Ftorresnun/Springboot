package wordle.Repository;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("dificil")
@Component
public class NvlDif implements Game {
    final static String CorrectWord = "holgazan";
    final static int tries = 6;

     @Override
    public int getNumTries() {
        return tries;
    }

    @Override
    public String getNumAnswer() {
        return CorrectWord;
    }
}
