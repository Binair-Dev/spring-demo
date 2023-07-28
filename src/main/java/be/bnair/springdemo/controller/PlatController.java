package be.bnair.springdemo.controller;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import be.bnair.springdemo.models.dto.PlatDTO;
import be.bnair.springdemo.models.form.IngredientForm;
import be.bnair.springdemo.models.form.PlatDrawForm;
import be.bnair.springdemo.models.form.PlatForm;
import be.bnair.springdemo.service.IngredientService;
import be.bnair.springdemo.service.PlatService;

@Controller
public class PlatController {
    private PlatService platService;
    private IngredientService ingredientService;

    public PlatController(PlatService platService, IngredientService ingredientService) {
        this.platService = platService;
        this.ingredientService = ingredientService;
    }

    @GetMapping("plat/plats")
    public String getAllPlats(Model model){
        model.addAttribute("list", platService.getAll());
        return "plat/plats";
    }

    @GetMapping("plat/plat/{id:[0-9]+}")
    public String displayOne(Model model, @PathVariable long id){
        PlatDTO choosenOne = platService.getOne(id);
        model.addAttribute("plat", choosenOne);
        return "plat/plat";
    }

    @GetMapping("plat/plat-create")
    public String createPlat(Model model){
        model.addAttribute("form", new PlatForm());
        return "plat/plat-create";
    }

    @PostMapping("plat/plat-create")
    public String processCreatePlat(@Valid PlatForm form, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "plat/plat-create";
        }
        else platService.create(form);
        return "redirect:/plat/plats";
    }

    @GetMapping("plat/plat-edit/{id:[0-9]+}")
    public String editPlat(Model model, @PathVariable long id){
        PlatDrawForm form = new PlatDrawForm();

        PlatDTO plat = platService.getOne(id);
        form.setNom(plat.getNom());
        form.setIngredients(plat.getIngredients().stream()
        .map(ing -> new IngredientForm(ing.getId(), ing.getName(), ing.getQuantity(), true))
        .collect(Collectors.toList()));

        model.addAttribute("form",form);
        model.addAttribute("id",id);
        return "plat/plat-edit";
    }
    
    @PostMapping("plat/plat-edit/{id:[0-9]+}")
    public String processUpdatePlat(PlatDrawForm form, BindingResult bindingResult, @PathVariable long id) {
        if(bindingResult.hasErrors()) {
            return "plat/plat-create";
        } else {
            PlatForm platForm = new PlatForm();
            platForm.setNom(form.getNom());
            platForm.setIngredients(
                form.getIngredients().stream()
                .map(ing -> ing.getId())
            .collect(Collectors.toList()));

            platService.update(platForm, id);
        }
        return "redirect:/plat/plats";
    }
}
