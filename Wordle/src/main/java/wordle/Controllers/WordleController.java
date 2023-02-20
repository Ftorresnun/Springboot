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

    @GetMapping("/searchtry")
    public ModelAndView search(Info info){
        if(info.getNumJugada()!=0){
            String jugada = wordsPlayed.get(info.getNumJugada());
            info.setMessage(jugada);
        }
        else{
            info.setMessage(wordsPlayed.stream().collect(Collectors.joining(" ")));
        }
        ModelAndView modelAndView = new ModelAndView("fin");
        modelAndView.addObject("info", info);
        return modelAndView;
    }

    @GetMapping("/")
    public ModelAndView goToIndexPage() {
        ModelAndView modelAndView = new ModelAndView("wordle");
        modelAndView.addObject("info", info);
        return modelAndView;
    }
    
    @PostMapping("/play")
    public ModelAndView play(Info info, ModelAndView modelAndView) {
        String pageToReturn = "wordle";
        wordsPlayed.add(info.getWordToPlay());
        char[] respuesta = game.getNumAnswer().toCharArray();
        char[] jugada = info.getWordToPlay().toCharArray();

        if(game.getNumAnswer().length() != info.getWordToPlay().length()) {
            info.setMessage("error tamaño jugada");
        }
        if(game.getNumAnswer().equals(info.getWordToPlay())){
            for(int i = 0; i < jugada.length; i++) {
                char c = jugada[i];
                if(respuesta[i] == c) {
                    info.getAnswer().add("verde");
                }
                else if(game.getNumAnswer().contains(Character.toString(c))){
                    info.getAnswer().add("amarillo");
                }
                else{
                    info.getAnswer().add("rojo");
                }
            }
        }
        else{
            pageToReturn = "fin";
            info.setWordToPlay(" ");
        }

        info.setMessage("ke quedan "+ (game.getNumTries() - wordsPlayed.size()) + " intentos");
        modelAndView.setViewName(pageToReturn);
        modelAndView.addObject("info", info);
        return modelAndView;
    }
}
