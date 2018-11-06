package nous2.mediatheque.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import nous2.mediatheque.dto.LivreDTO;
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

    @GetMapping("/toUpdate")
    public String toUpdate(@RequestParam("id") Long id, Model model) {
	Livre livre = livreService.findById(id);
	model.addAttribute("livre", livre);
	return "livreUpdate";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("livre") Livre livre,
	    BindingResult result) {
	if (validateAndSave(livre, result)) {
	    return "redirect:/livres/toList";
	}
	return "livreUpdate";
    }

    @GetMapping("/toList")
    public String toList(Model model) {
	populateModel(model);
	return "livreList";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
	livreService.deleteById(id);
	return "redirect:/livres/toList";
    }

    private boolean validateAndSave(Livre livre, BindingResult result) {
	if (!result.hasErrors()) {
	    livreService.save(livre);
	    return true;
	}
	return false;
    }

    private void populateModel(Model model) {
	List<LivreDTO> livres = livreService.findAllAsDTO();
	model.addAttribute("livres", livres);
    }
}
