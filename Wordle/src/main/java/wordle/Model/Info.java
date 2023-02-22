package wordle.Model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class Info {
    String message;
    private String wordToPlay;
    int numJugada = 0;
    List<String> answer = new ArrayList<>();
    String errorMessage;

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    
    public int getNumJugada() {
        return this.numJugada;
    }

    public void setNumJugada(int numJugada) {
        this.numJugada = numJugada;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getWordToPlay() {
        return this.wordToPlay;
    }

    public void setWordToPlay(String wordToPlay) {
        this.wordToPlay = wordToPlay;
    }

    public List<String> getAnswer() {
        return this.answer;
    }

    public void setAnswer(List<String> answer) {
        this.answer = answer;
    }
}
