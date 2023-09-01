package com.example.lab3.controlador;


import com.example.lab3.entidad.Jugador;
import com.example.lab3.repositorio.JugadorRepository;
import com.example.lab3.repositorio.SeleccionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/jugador")
public class JugadorController {

    final JugadorRepository jugadorRepository;
    final SeleccionRepository seleccionRepository;

    public JugadorController(JugadorRepository jugadorRepository, SeleccionRepository seleccionRepository) {
        this.jugadorRepository = jugadorRepository;
        this.seleccionRepository = seleccionRepository;
    }


    @GetMapping(value = "")
    public String listarJugadores(Model model) {
        model.addAttribute("lista", jugadorRepository.findAll());
        return "jugador/lista";
    }

    @GetMapping(value = "/nuevo")
    public String nuevoJugadorForm(Model model) {
        model.addAttribute("listaSelecciones", seleccionRepository.findAll());
        return "jugador/nuevo";
    }

    @PostMapping(value = "/guardar")
    public String nuevoJugador(Model model, Jugador jugador) {
        jugadorRepository.save(jugador);
        return "redirect:jugador/";
    }
}
