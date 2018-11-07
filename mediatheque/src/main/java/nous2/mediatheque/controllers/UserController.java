package nous2.mediatheque.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import nous2.mediatheque.dto.UserDTO;
import nous2.mediatheque.entities.*;
import nous2.mediatheque.services.IUserService;

@Controller
@RequestMapping("/users")
public class UserController extends BaseController {

    private final IUserService userService;

    @Autowired
    protected UserController(IUserService userService) {
	this.userService = userService;
    }

    @SuppressWarnings("unused")
    @GetMapping("/toCreate")
    public String toCreate(@ModelAttribute("user") User user, Model model) {
	populateModel(model);
	return "userCreate";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("user") User user,
	    BindingResult result, Model model) {
	if (validateAndSave(user, result)) {
	    model.addAttribute("user", new User());
	    return "redirect:/security/login";
	}
	populateModel(model);
	return "userCreate";
    }

    @GetMapping("/toUpdate")
    public String toUpdate(@RequestParam("id") Long id, Model model) {
	User user = userService.findById(id);
	model.addAttribute("user", user);
	populateModel(model);
	return "userUpdate";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("user") User user,
	    BindingResult result, Model model) {
	Role sessionUserRole = getUser().getRole();
	if (validateAndSave(user, result)) {
	    if (sessionUserRole != null
		    && sessionUserRole.equals(Role.ROLE_USER)) {
		return "redirect:/home/welcome";
	    }
	    if (sessionUserRole != null
		    && sessionUserRole.equals(Role.ROLE_ADMIN)) {
		populateUserModel(model);
		return "userList";
	    }
	}
	populateModel(model);
	return "userUpdate";
    }

    @GetMapping("/toList")
    public String toList(Model model) {
	populateUserModel(model);
	return "userList";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
	userService.deleteById(id);
	return "redirect:/users/toList";
    }

    private boolean validateAndSave(User user, BindingResult result) {
	validate(user, result);
	if (!result.hasErrors()) {
	    userService.save(user);
	    return true;
	}
	return false;
    }

    private void validate(User user, BindingResult result) {
	if (!userService.validateEmailAndPseudo(user)) {
	    result.rejectValue("email", "error.entities.user.duplicateEmail");
	}
    }

    private static void populateModel(Model model) {
	model.addAttribute("roles", Role.values());
    }

    private void populateUserModel(Model model) {
	List<UserDTO> users = userService.findAllAsDTO();
	model.addAttribute("users", users);
    }
}
