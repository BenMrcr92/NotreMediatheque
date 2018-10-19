package nous2.mediatheque.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import nous2.mediatheque.entities.Cd;
import nous2.mediatheque.services.ICdService;

@Controller
@RequestMapping("/cds")
public class CdController extends BaseController {

    private final ICdService cdService;

    @Autowired
    protected CdController(ICdService cdService) {
	this.cdService = cdService;
    }

    @SuppressWarnings("unused")
    @GetMapping("/toCreate")
    public String toCreate(@ModelAttribute("cd") Cd cd) {
	return "cdCreate";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("cd") Cd cd,
	    BindingResult result, Model model) {
	if (validateAndSave(cd, result)) {
	    model.addAttribute("cd", new Cd());
	}
	return "cdCreate";
    }

    private boolean validateAndSave(Cd cd, BindingResult result) {
	if (!result.hasErrors()) {
	    cdService.save(cd);
	    return true;
	}
	return false;
    }
}
