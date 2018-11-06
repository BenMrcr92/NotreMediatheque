package nous2.mediatheque.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import nous2.mediatheque.dto.JeuDTO;
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
	    return "redirect:/jeux/toList";
	}
	return "jeuCreate";
    }

    @GetMapping("/toUpdate")
    public String toUpdate(@RequestParam("id") Long id, Model model) {
	Jeu jeu = jeuService.findById(id);
	model.addAttribute("jeu", jeu);
	return "jeuUpdate";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("jeu") Jeu jeu,
	    BindingResult result) {
	if (validateAndSave(jeu, result)) {
	    return "redirect:/jeux/toList";
	}
	return "jeuUpdate";
    }

    @GetMapping("/toList")
    public String toList(Model model) {
	populateModel(model);
	return "jeuList";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
	jeuService.deleteById(id);
	return "redirect:/jeux/toList";
    }

    private boolean validateAndSave(Jeu jeu, BindingResult result) {
	if (!result.hasErrors()) {
	    jeuService.save(jeu);
	    return true;
	}
	return false;
    }

    private void populateModel(Model model) {
	List<JeuDTO> jeux = jeuService.findAllAsDTO();
	model.addAttribute("jeux", jeux);
    }
}
