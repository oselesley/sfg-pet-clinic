package lesley.springframework.sfgpetclinic.controllers;

import lesley.springframework.sfgpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/vets")
@Controller
public class VetController {

    private VetService vetServiceMap;

    public VetController(@Qualifier("vetServiceMap") VetService vetServiceMap) {
        this.vetServiceMap = vetServiceMap;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String vetpage(Model model) {
        model.addAttribute("vets", vetServiceMap.findAll());

        return "vets/index";
    }
}
