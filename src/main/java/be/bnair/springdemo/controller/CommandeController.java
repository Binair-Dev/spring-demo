package be.bnair.springdemo.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import be.bnair.springdemo.models.form.CommandeForm;
import be.bnair.springdemo.service.CommandeService;

@Controller
public class CommandeController {
    private CommandeService commandeService;

    public CommandeController(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    @GetMapping("commande/commandes")
    public String getAllCommandes(Model model){
        model.addAttribute("list", commandeService.getAll());
        return "commande/commandes";
    }

    @GetMapping("commande/commande-create")
    public String createCommande(Model model){
        model.addAttribute("form", new CommandeForm());
        return "commande/commande-create";
    }

    @PostMapping("commande/commande-create")
    public String processCreateCommande(@Valid CommandeForm form, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "commande/commande-create";
        }
        else commandeService.create(form);
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
