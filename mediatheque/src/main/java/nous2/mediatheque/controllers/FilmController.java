package nous2.mediatheque.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import nous2.mediatheque.entities.Film;
import nous2.mediatheque.services.IFilmService;

@Controller
@RequestMapping("/films")
public class FilmController extends BaseController {

    private final IFilmService filmService;

    @Autowired
    protected FilmController(IFilmService filmService) {
	this.filmService = filmService;
    }

    @SuppressWarnings("unused")
    @GetMapping("/toCreate")
    public String toCreate(@ModelAttribute("film") Film film) {
	return "filmCreate";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("film") Film film,
	    BindingResult result, Model model) {
	if (validateAndSave(film, result)) {
	    model.addAttribute("film", new Film());
	}
	return "filmCreate";
    }

    @GetMapping("/toUpdate")
    public String toUpdate(@RequestParam("id") Long id, Model model) {
	Film film = filmService.findById(id);
	model.addAttribute("film", film);
	return "filmUpdate";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("film") Film film,
	    BindingResult result) {
	if (validateAndSave(film, result)) {
	    return "redirect:/home/welcome";
	}
	return "filmUpdate";
    }

    private boolean validateAndSave(Film film, BindingResult result) {
	if (!result.hasErrors()) {
	    filmService.save(film);
	    return true;
	}
	return false;
    }
}
