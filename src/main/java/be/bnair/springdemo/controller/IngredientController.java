package be.bnair.springdemo.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import be.bnair.springdemo.models.dto.IngredientDTO;
import be.bnair.springdemo.models.form.IngredientForm;
import be.bnair.springdemo.models.form.UserForm;
import be.bnair.springdemo.service.IngredientService;

@Controller
public class IngredientController {
    private IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping("ingredient/ingredients")
    public String getAllIngredients(Model model){
        model.addAttribute("list", ingredientService.getAll());
        return "ingredient/ingredients";
    }

    @GetMapping("ingredient/ingredient/{id:[0-9]+}")
    public String displayOne(Model model, @PathVariable long id){
        IngredientDTO choosenOne = ingredientService.getOne(id);
        model.addAttribute("ingredient", choosenOne);
        return "ingredient/ingredient";
    }

    @GetMapping("ingredient/ingredient-create")
    public String createIngredient(Model model){
        model.addAttribute("form", new UserForm());
        return "ingredient/ingredient-create";
    }

    @PostMapping("ingredient/ingredient-create")
    public String processCreateIngredient(@Valid IngredientForm form, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "ingredient/ingredient-create";
        }
        else ingredientService.create(form);
        return "redirect:/ingredient/ingredients";
    }

    @GetMapping("ingredient/ingredient-edit/{id:[0-9]+}")
    public String editIngredient(Model model, @PathVariable long id){
        IngredientForm form = new IngredientForm();

        IngredientDTO ingredient = ingredientService.getOne(id);
        form.setName(ingredient.getName());
        form.setQuantity(ingredient.getQuantity());

        model.addAttribute("form",form);
        model.addAttribute("id",id);
        return "ingredient/ingredient-edit";
    }
    
    @PostMapping("ingredient/ingredient-edit/{id:[0-9]+}")
    public String processUpdateIngredient(@Valid IngredientForm form, BindingResult bindingResult, @PathVariable long id) {
        if(bindingResult.hasErrors()) {
            return "ingredient/ingredient-create";
        }
        else ingredientService.update(form, id);
        return "redirect:/ingredient/ingredients";
    }
}
