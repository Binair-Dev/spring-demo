package be.bnair.springdemo.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import be.bnair.springdemo.models.entities.Commande;
import be.bnair.springdemo.models.entities.Ingredient;
import be.bnair.springdemo.models.entities.Plat;
import be.bnair.springdemo.models.entities.User;
import be.bnair.springdemo.repository.CommandeRepository;
import be.bnair.springdemo.repository.PlatRepository;
import be.bnair.springdemo.repository.UserRepository;

@Component
public class DataInit implements InitializingBean {

    private final UserRepository userRepository;
    private final PlatRepository platRepository;
    private final CommandeRepository commandeRepository;

    public DataInit(UserRepository userRepository, PlatRepository platRepository, CommandeRepository commandeRepository) {
        this.userRepository = userRepository;
        this.platRepository = platRepository;
        this.commandeRepository = commandeRepository;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        //Users
        User brian = new User("Van Bellinghen", "Brian", LocalDate.of(1997, 9, 8));
        User julie = new User("Frazelle", "Julie", LocalDate.of(1988, 4, 30));
        userRepository.save(brian);
        userRepository.save(julie);
        userRepository.save(new User("Hendriks", "Louis", LocalDate.of(2000, 1, 8)));
        userRepository.save(new User("Hervé", "ChezPlus", LocalDate.of(1987, 6, 14)));
    
        //Ingredients et Plats
        Ingredient poivre = new Ingredient("Poivre", 1);
        Ingredient tomate = new Ingredient("Tomates", 4);
        Ingredient pates = new Ingredient("Pates", 250);
        Ingredient sel = new Ingredient("Sel", 1);
        Ingredient haches = new Ingredient("Hachés", 150);
        List<Ingredient> ingredients1 = new ArrayList<Ingredient>();
        ingredients1.add(poivre);
        ingredients1.add(tomate);
        ingredients1.add(pates);
        ingredients1.add(sel);
        ingredients1.add(haches);

        Plat plat1 = new Plat("Pâtes sauce tomate", ingredients1);
        platRepository.save(plat1);

        Ingredient patesPoivre = new Ingredient("Pâtes", 300);
        Ingredient cremePoivre = new Ingredient("Creme au poivre", 100);
        List<Ingredient> ingredients2 = new ArrayList<Ingredient>();
        ingredients2.add(cremePoivre);
        ingredients2.add(patesPoivre);

        Plat plat2 = new Plat("Pâtes sauve au poivre", ingredients2);
        platRepository.save(plat2);

        //Commandes
        Commande commande1 = new Commande(brian, plat1);
        commandeRepository.save(commande1);
        brian.addCommande(commande1);

        Commande commande2 = new Commande(julie, plat2);
        commandeRepository.save(commande2);
        julie.addCommande(commande2);
    }
    
}
