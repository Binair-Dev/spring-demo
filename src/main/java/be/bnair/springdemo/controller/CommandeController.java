package be.bnair.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import be.bnair.springdemo.models.form.CommandeForm;
import be.bnair.springdemo.service.CommandeService;
import be.bnair.springdemo.service.PlatService;
import be.bnair.springdemo.service.UserService;

@Controller
public class CommandeController {
    private CommandeService commandeService;
    private PlatService platService;
    private UserService userService;

    public CommandeController(CommandeService commandeService, PlatService platService, UserService userService) {
        this.commandeService = commandeService;
        this.platService = platService;
        this.userService = userService;
    }

    @GetMapping("commande/commandes")
    public String getAllCommandes(Model model){
        model.addAttribute("list", commandeService.getAll());
        return "commande/commandes";
    }

    @GetMapping("/commande/commande-create")
    public String createCommandeForm(Model model) {
        CommandeForm commandeForm = new CommandeForm();
        model.addAttribute("commandeForm", commandeForm);
        model.addAttribute("plats", platService.getAll());
        model.addAttribute("users", userService.getAll());
        return "commande/commande-create";
    }

    @PostMapping("/commande/commande-create")
    public String processCreateCommandeForm(@ModelAttribute("commandeForm") CommandeForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "commande/commande-create";
        }

        commandeService.create(form);
        return "redirect:/commande/commandes";
    }

    /*
    @GetMapping("commande/commande-edit/{id:[0-9]+}")
    public String editCommande(Model model, @PathVariable long id){
        CommandeForm form = new CommandeForm();

        CommandeDTO commande = commandeService.getOne(id);
        form.setUser(commande.getUser().getId());
        form.setPlats(commande.getPlats().stream()
                .map(IngredientDTO::getId)
                .toList());

        model.addAttribute("ingredients", ingredientService.getAll().stream()
                .map(i -> form.getIngredients()
                        .contains(i.getId()) ?
                        new IngredientForm(i.getId(), i.getName(), i.getQuantity(), true) :
                        new IngredientForm(i.getId(), i.getName(), i.getQuantity(), false))
                .toList());
        model.addAttribute("form",form);
        model.addAttribute("id",id);
        return "commande/commande-edit";
    }

    @PostMapping("commande/commande-edit/{id:[0-9]+}")
    public String processUpdateCommande(@ModelAttribute("form") CommandeForm form, @PathVariable long id) {
        CommandeDTO commande = commandeService.getOne(id);

        commande.setNom(form.getNom());
        commande.setIngredients(new ArrayList<>());

        for (Long ingredientId : form.getIngredients()) {
            IngredientDTO ingredient = ingredientService.getOne(ingredientId);
            commande.addIngredient(ingredient);
        }

        CommandeForm commandeForm = new CommandeForm();
        commandeForm.setNom(commande.getNom());
        commandeForm.setIngredients(commande.getIngredients().stream().map(IngredientDTO::getId).toList());
        commandeService.update(commandeForm, id);

        return "redirect:/commande/commandes";
    }
    */
}
