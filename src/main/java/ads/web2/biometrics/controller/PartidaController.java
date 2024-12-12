package ads.web2.biometrics.controller;

import ads.web2.biometrics.model.Atleta;
import ads.web2.biometrics.model.AtletaRepository;
import ads.web2.biometrics.model.Partida;
import ads.web2.biometrics.model.PartidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;


@Controller
@RequestMapping("partida")
public class PartidaController {

    @Autowired
    private PartidaRepository partidaRepo;

    @GetMapping
    String registrarPartida(){
        return "partida/registrar";
    }

    @PostMapping
    @ResponseBody
    String salvarPartida(String local_partida,
                         @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") LocalDateTime inicio,
                         @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") LocalDateTime fim){
        //testar receber como string
        Partida a = new Partida(local_partida, inicio, fim);
        partidaRepo.save(a);
        return "Foi criado a partida do local: " + a.getLocalPartida();
    }

    @GetMapping("consultar")
    ModelAndView consultar(Long id){
        ModelAndView mv = new ModelAndView();
        Partida a = partidaRepo.getReferenceById(id);
        mv.addObject("partida", a);
        mv.setViewName("partida/exibir");
        return mv;
    }
}
