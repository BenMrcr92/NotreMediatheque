package nous2.mediatheque.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import nous2.mediatheque.entities.Livre;
import nous2.mediatheque.services.ILivreService;

@Controller
@RequestMapping("/livres")
public class LivreController extends BaseController {

    private final ILivreService livreService;

    @Autowired
    protected LivreController(ILivreService livreService) {
	this.livreService = livreService;
    }

    @SuppressWarnings("unused")
    @GetMapping("/toCreate")
    public String toCreate(@ModelAttribute("livre") Livre livre) {
	return "livreCreate";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("livre") Livre livre,
	    BindingResult result, Model model) {
	if (validateAndSave(livre, result)) {
	    model.addAttribute("livre", new Livre());
	}
	return "livreCreate";
    }

    private boolean validateAndSave(Livre livre, BindingResult result) {
	if (!result.hasErrors()) {
	    livreService.save(livre);
	    return true;
	}
	return false;
    }
}
