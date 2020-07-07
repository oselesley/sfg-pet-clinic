package lesley.springframework.sfgpetclinic.controllers;

import lesley.springframework.sfgpetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")
@Controller
public class OwnerController {
    private OwnerService ownerServiceMap;

    public OwnerController(OwnerService ownerServiceMap) {
        this.ownerServiceMap = ownerServiceMap;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String ownersPage (Model model) {
        model.addAttribute("owners", ownerServiceMap.findAll());

        return "owners/index";
    }

    @RequestMapping({"/find"})
    public String find() {
        return "notimplemented";
    }

}
