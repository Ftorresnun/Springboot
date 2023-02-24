package wordle.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.apache.logging.log4j.message.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import wordle.Model.Info;
import wordle.Repository.Game;
import java.util.stream.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WordleController {
    List<String> wordsPlayed = new ArrayList<>();
    @Autowired
    Info info;

    @Autowired
    Game game;

    @PostMapping("/searchTry")
    public ModelAndView search(Info info, ModelAndView modelAndView){
        if((info.getNumJugada()-1)>=0){
            String jugada = wordsPlayed.get(info.getNumJugada()-1);
            info.setMessage(jugada);
        }
        else{
            info.setMessage(wordsPlayed.stream().collect(Collectors.joining(" ")));
        }
        modelAndView.setViewName("fin");
        modelAndView.addObject("info", info);
        modelAndView.addObject("game", game);
        return modelAndView;
    }

    @GetMapping("/")
    public ModelAndView goToIndexPage() {
        ModelAndView modelAndView = new ModelAndView("wordle");
        int numJugadas = wordsPlayed.isEmpty() ? 0 : wordsPlayed.size();
        modelAndView.addObject("wordsPlayed", numJugadas);
        modelAndView.addObject("info", info);
        modelAndView.addObject("game", game);
        return modelAndView;
    }
    
    @PostMapping("/play")
    public ModelAndView play(Info info, ModelAndView modelAndView) {
        String pageToReturn = "wordle";
        char[] respuesta = game.getNumAnswer().toCharArray();
        char[] jugada = info.getWordToPlay().toCharArray();
        if(game.getNumAnswer().length() != info.getWordToPlay().length()) {
            info.setErrorMessage("error tamaño jugada");
            for(int i = 0; i < jugada.length; i++){
                info.getAnswer().add("white");
            }
        }
        else{
            if(!game.getNumAnswer().equals(info.getWordToPlay())){
                for(int i = 0; i < jugada.length; i++) {
                    char c = jugada[i];
                    if(respuesta[i] == c) {
                        info.getAnswer().add("green");
                    }
                    else if(game.getNumAnswer().contains(Character.toString(c))){
                        info.getAnswer().add("yellow");
                    }
                    else{
                        info.getAnswer().add("red");
                    }
                }
                if(((game.getNumTries() -1) - wordsPlayed.size()) == 0){
                    info.setMessage("Perdiste, la palabra era: " + game.getNumAnswer());
                    pageToReturn = "fin";
                }
                else if(((game.getNumTries() -1) - wordsPlayed.size()) == 1){
                    info.setMessage("le queda "+ ((game.getNumTries() -1) - wordsPlayed.size()) + " intento");
                }
                else if(((game.getNumTries() -1) - wordsPlayed.size()) > 1){
                    info.setMessage("le quedan "+ ((game.getNumTries() -1) - wordsPlayed.size()) + " intentos");
                }
            }
            else{
                info.setMessage("Ya ganaste.\nDale boludo buscá otro juego");
                pageToReturn = "fin";
            }
            wordsPlayed.add(info.getWordToPlay());
        }
        modelAndView.setViewName(pageToReturn);
        int numJugadas = wordsPlayed.isEmpty() ? 0 : wordsPlayed.size();
        modelAndView.addObject("wordsPlayed", numJugadas);
        modelAndView.addObject("palabraJugada", jugada);
        modelAndView.addObject("info", info);
        modelAndView.addObject("game", game);
        return modelAndView;
    }
}
