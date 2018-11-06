package nous2.mediatheque.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import nous2.mediatheque.dto.CdDTO;
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
	    return "redirect:/cds/toList";
	}
	return "cdCreate";
    }

    @GetMapping("/toUpdate")
    public String toUpdate(@RequestParam("id") Long id, Model model) {
	Cd cd = cdService.findById(id);
	model.addAttribute("cd", cd);
	return "cdUpdate";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("cd") Cd cd,
	    BindingResult result) {
	if (validateAndSave(cd, result)) {
	    return "redirect:/cds/toList";
	}
	return "cdUpdate";
    }

    @GetMapping("/toList")
    public String toList(Model model) {
	populateModel(model);
	return "cdList";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
	cdService.deleteById(id);
	return "redirect:/cds/toList";
    }

    private boolean validateAndSave(Cd cd, BindingResult result) {
	if (!result.hasErrors()) {
	    cdService.save(cd);
	    return true;
	}
	return false;
    }

    private void populateModel(Model model) {
	List<CdDTO> cds = cdService.findAllAsDTO();
	model.addAttribute("cds", cds);
    }
}
