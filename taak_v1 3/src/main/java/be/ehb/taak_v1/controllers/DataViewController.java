package be.ehb.taak_v1.controllers;

import be.ehb.taak_v1.models.DataAO;
import be.ehb.taak_v1.models.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class DataViewController {
    private DataAO dataAO;
    @Autowired
    public DataViewController(DataAO dataAO) {
        this.dataAO = dataAO;
    }
    // redirecten naar home
    @RequestMapping(value = {"/index", "/"}, method = RequestMethod.GET)
    public String indexMove(ModelMap map){
        return "index";
    }
    @ModelAttribute("alles")
    public Iterable<Data> getAllProducts(){
        return dataAO.findAll();
    }

    @ModelAttribute("new_product")
    public Data createNewProduct(){
        return new Data();
    }

    @RequestMapping(value = { "/form"}, method = RequestMethod.POST)
    public String saveForm(@ModelAttribute("new_product") @Valid Data data, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "form";
        }

        dataAO.save(data);
        return "redirect:/index";
    }


    // redirecten naar about page
    @GetMapping("/about")
    public String redirectToAbout(){
        return "about";
    }

    // redirecten naar about page
    @GetMapping("/form")
    public String redirectToForm(){
        return "form";
    }

    // redirecten naar privacy page
    @GetMapping("/privacy")
    public String redirectToPrivacy(){
        return "privacy";
    }

    // redirecten naar geldzaken page
    @GetMapping("/geldzaken")
    public String redirectToGeldzaken(){
        return "geldzaken";
    }

    // redirecten naar contact page
    @GetMapping("/contact")
    public String redirectToContact(){
        return "contact";
    }
    
}
