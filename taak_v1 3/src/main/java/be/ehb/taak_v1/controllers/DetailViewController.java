package be.ehb.taak_v1.controllers;

import be.ehb.taak_v1.models.Data;
import be.ehb.taak_v1.models.DataAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;
@Controller
public class DetailViewController {
    DataAO dataAO;
    @Autowired
    public DetailViewController(DataAO dataAO) {
        this.dataAO = dataAO;
    }
    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    public String showDetailsById(ModelMap map, @PathVariable(value = "id") int id) {
        Optional<Data> optional = dataAO.findById(id);
        if (optional.isPresent()) {
            map.addAttribute("data", optional.get());
            return "details";
        }
        return "redirect:../index";
    }

    // redirecten naar contact page
    @GetMapping("/afrekening")
    public String redirectToPayment(){
        return "afrekening";
    }
}
