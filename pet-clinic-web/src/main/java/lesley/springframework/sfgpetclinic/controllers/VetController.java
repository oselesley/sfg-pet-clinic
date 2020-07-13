package lesley.springframework.sfgpetclinic.controllers;

import lesley.springframework.sfgpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {

    private VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"", "/vets", "/vets/index", "/vets/index.html", "/vets.html"})
    public String vetpage(Model model) {
        System.out.println("In Vets");
        model.addAttribute("vets", vetService.findAll());

        return "vets/index";
    }
}
