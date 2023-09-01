package com.example.lab3.controlador;


import com.example.lab3.entidad.Jugador;
import com.example.lab3.repositorio.JugadorRepository;
import com.example.lab3.repositorio.SeleccionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

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
    @GetMapping("/borrar")
    public String borrarJugador(@RequestParam("id") int id) {

        Optional<Jugador> optional = jugadorRepository.findById(id);

        if (optional.isPresent()) {
            jugadorRepository.deleteById(id);
        }
        return "redirect:/jugador";
    }

    @PostMapping(value = "/guardar")
    public String nuevoJugador(Model model, Jugador jugador) {
        System.out.println("nombre: "+jugador.getNombre());
        System.out.println("club: "+jugador.getClub());
        System.out.println(jugador.getIdSeleccion());
        jugadorRepository.save(jugador);
        return "redirect:/jugador";
    }
}
