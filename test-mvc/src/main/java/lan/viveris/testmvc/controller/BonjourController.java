package lan.viveris.testmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/bonjour")
public class BonjourController {

    @RequestMapping(method = RequestMethod.GET)
    public String afficherBonjour(final ModelMap pModel, 
                @RequestParam(value="personne", defaultValue="toto") final String pPersonne) {

        pModel.addAttribute("personne", pPersonne);
        return "bonjour";
    }
}