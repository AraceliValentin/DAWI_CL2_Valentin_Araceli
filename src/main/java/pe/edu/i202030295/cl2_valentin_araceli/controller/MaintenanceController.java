package pe.edu.i202030295.cl2_valentin_araceli.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.i202030295.cl2_valentin_araceli.dto.FilmDetailDto;
import pe.edu.i202030295.cl2_valentin_araceli.dto.FilmDto;
import pe.edu.i202030295.cl2_valentin_araceli.service.MaintenanceService;

import java.util.List;

@Controller
@RequestMapping("/maintenance")
public class MaintenanceController {

    @Autowired
    MaintenanceService maintenanceService;

    @GetMapping("/start")
     public String start(Model model) {
         List<FilmDto> films = maintenanceService.getAllFilms();
        System.out.println(films); // Obtiene la lista de películas
         model.addAttribute("films", films); // Agrega la lista al modelo
          return "maintenance"; // Retorna la vista
        }


    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        FilmDetailDto filmDetailDto = maintenanceService.getFilmById(id);
        model.addAttribute("film", filmDetailDto);
        return "maintenance-detail";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        FilmDetailDto filmDetailDto = maintenanceService.getFilmById(id);
        model.addAttribute("film", filmDetailDto);
        return "maintenance-edit";
    }

    @PostMapping("/edit-confirm")
    public String edit(@ModelAttribute FilmDetailDto filmDetailDto) {
        maintenanceService.updateFilm(filmDetailDto);
        return "redirect:/maintenance/start";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        FilmDetailDto filmDetailDto = maintenanceService.getFilmById(id);
        if (filmDetailDto == null) {
            return "redirect:/maintenance/start";
        }
        model.addAttribute("film", filmDetailDto);
        return "maintenance-delete-confirm";
    }

    @PostMapping("/delete-confirm/{id}")
    public String deleteConfirm(@PathVariable Integer id) {
        maintenanceService.deleteFilm(id);
        return "redirect:/maintenance/start";
    }

    @GetMapping("/create")
    public String create(Model model) {
        return "mantenimiento_crear";  // Retorna la vista del formulario de creación
    }

    @PostMapping("/create-confirm")
    public String createConfirm(@ModelAttribute FilmDetailDto filmDetailDto) {
        maintenanceService.createFilm(filmDetailDto);
        return "redirect:/maintenance/start";
    }


}
