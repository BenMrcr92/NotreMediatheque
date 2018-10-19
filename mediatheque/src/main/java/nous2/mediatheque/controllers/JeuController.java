package nous2.mediatheque.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import nous2.mediatheque.entities.Jeu;
import nous2.mediatheque.services.IJeuService;

@Controller
@RequestMapping("/jeux")
public class JeuController extends BaseController {

    private final IJeuService jeuService;

    @Autowired
    protected JeuController(IJeuService jeuService) {
	this.jeuService = jeuService;
    }

    @SuppressWarnings("unused")
    @GetMapping("/toCreate")
    public String toCreate(@ModelAttribute("jeu") Jeu jeu) {
	return "jeuCreate";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("jeu") Jeu jeu,
	    BindingResult result, Model model) {
	if (validateAndSave(jeu, result)) {
	    model.addAttribute("jeu", new Jeu());
	}
	return "jeuCreate";
    }

    private boolean validateAndSave(Jeu jeu, BindingResult result) {
	if (!result.hasErrors()) {
	    jeuService.save(jeu);
	    return true;
	}
	return false;
    }
}
