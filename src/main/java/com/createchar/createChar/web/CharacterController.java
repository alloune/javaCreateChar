package com.createchar.createChar.web;

import com.createchar.createChar.form.CharForm;
import com.createchar.createChar.model.Character;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;


@Controller
public class CharacterController {

    private static final ArrayList<Character> charList = new ArrayList<Character>();

    static {

        charList.add(new Character(0, "Allan", "Voleur", 12));
        charList.add(new Character(1, "Loris", "Démoniste", 7));
        charList.add(new Character(2, "Martin", "Assassin", 2));

    }

    @RequestMapping(value = "/liste-des-personnages", method = RequestMethod.GET)
    public String charList(Model model) {

        model.addAttribute("characterList", charList);
        return "characterList";
    }

    @RequestMapping(value = "/creer-mon-personnage", method = RequestMethod.GET)
    public String createChar(Model model) {
        CharForm charForm = new CharForm();
        model.addAttribute("charForm", charForm);

        return "createChar";
    }

    @RequestMapping(value = "/creer-mon-personnage", method = RequestMethod.POST)
    public String storeCha(Model model,
        @ModelAttribute("charForm") CharForm charForm){

        String name = charForm.getName();
        String type = charForm.getType();
        int hp = 0;
        int lastId;

        switch (charForm.getType()){
            case "Paladin":
                hp = 12;
                break;
            case "Magicien" :
                hp = 6;
                break;
            case "Voleur" :
                hp = 8;
                break;
            case "Pecno" :
                hp = 3;
                break;
        }

        Character getLastChar = charList.get(charList.size() - 1);
        lastId = getLastChar.getId() + 1;

        Character newCharacter = new Character(lastId, name, type, hp);

        charList.add(newCharacter);

        return "redirect:/liste-des-personnages";
    }

    @RequestMapping(value = "/personnage/{id}", method = RequestMethod.GET)
    public String showCharacter(Model model, @PathVariable("id") long id){
        model.addAttribute("character",charList.stream().filter(elt -> elt.getId() == id).findFirst().orElse(null));
        return "showChar";
    }
}