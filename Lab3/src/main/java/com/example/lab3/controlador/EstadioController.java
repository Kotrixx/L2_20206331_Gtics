package com.example.lab3.controlador;

import com.example.lab3.entidad.Estadio;
import com.example.lab3.entidad.Jugador;
import com.example.lab3.repositorio.EstadioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping(value = "/estadio")
public class EstadioController {

    final EstadioRepository estadioRepository;

    public EstadioController(EstadioRepository estadioRepository) {
        this.estadioRepository = estadioRepository;
    }

    @GetMapping(value = "")
    public String listarJugadores(Model model) {
        model.addAttribute("lista", estadioRepository.findAll());
        return "estadio/lista";
    }

    @GetMapping(value = "/nuevo")
    public String nuevoJugadorForm(Model model) {
        return "estadio/nuevo";
    }
    @GetMapping("/borrar")
    public String borrarJugador(@RequestParam("id") int id) {

        Optional<Estadio> optional = estadioRepository.findById(id);

        if (optional.isPresent()) {
            estadioRepository.deleteById(id);
        }
        return "redirect:/estadio";
    }

    @PostMapping(value = "/guardar")
    public String nuevoJugador(Model model, Estadio estadio) {
        estadioRepository.save(estadio);
        return "redirect:estadio/";
    }

}
