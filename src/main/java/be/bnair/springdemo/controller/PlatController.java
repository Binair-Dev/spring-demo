package be.bnair.springdemo.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import be.bnair.springdemo.models.dto.IngredientDTO;
import be.bnair.springdemo.models.dto.PlatDTO;
import be.bnair.springdemo.models.form.IngredientForm;
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
        model.addAttribute("ingredients", ingredientService.getAll().stream()
                .map(i -> new IngredientForm(i.getId(), i.getName(), i.getQuantity(), false))
                .toList());
        model.addAttribute("form", new PlatForm());
        return "plat/plat-create";
    }

    @PostMapping("plat/plat-create")
    public String processCreatePlat(@Valid PlatForm form, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "plat/plat-create";
        }
        else {
            form.setIngredients(new ArrayList<>());

            for (Long ingredientId : form.getIngredients()) {
                IngredientDTO ingredient = ingredientService.getOne(ingredientId);
                form.addIngredient(ingredient.getId());
            }
            platService.create(form);
        }
        return "redirect:/plat/plats";
    }

    @GetMapping("plat/plat-edit/{id:[0-9]+}")
    public String editPlat(Model model, @PathVariable long id){
        PlatForm form = new PlatForm();

        PlatDTO plat = platService.getOne(id);
        form.setNom(plat.getNom());
        form.setIngredients(plat.getIngredients().stream()
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
        return "plat/plat-edit";
    }

    @PostMapping("plat/plat-edit/{id:[0-9]+}")
    public String processUpdatePlat(@ModelAttribute("form") PlatForm form, @PathVariable long id) {
        PlatDTO plat = platService.getOne(id);

        plat.setNom(form.getNom());
        plat.setIngredients(new ArrayList<>());

        for (Long ingredientId : form.getIngredients()) {
            IngredientDTO ingredient = ingredientService.getOne(ingredientId);
            plat.addIngredient(ingredient);
        }

        PlatForm platForm = new PlatForm();
        platForm.setNom(plat.getNom());
        platForm.setIngredients(plat.getIngredients().stream().map(IngredientDTO::getId).toList());
        platService.update(platForm, id);

        return "redirect:/plat/plats";
    }
}
