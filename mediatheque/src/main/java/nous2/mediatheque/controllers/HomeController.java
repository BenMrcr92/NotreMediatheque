package nous2.mediatheque.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import nous2.mediatheque.dto.FilmDTO;
import nous2.mediatheque.services.IFilmService;

@Controller
@RequestMapping("/home")
public class HomeController extends BaseController {

    private final IFilmService filmService;

    @Autowired
    protected HomeController(IFilmService filmService) {
	this.filmService = filmService;
    }

    @GetMapping("/welcome")
    public String welcome(Model model) {
	populateModel(model);
	return "welcome";
    }

    private void populateModel(Model model) {
	List<FilmDTO> films = filmService.findAllAsDTO(getAppLanguage());
	model.addAttribute("films", films);
    }
}
