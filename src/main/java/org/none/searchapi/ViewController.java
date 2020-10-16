package org.none.searchapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

/**
 * @author ArtSCactus
 * @version 1.0
 */
@Controller
public class ViewController {
    @Autowired
    private SearchService service;

    @GetMapping(path = "/find")
    public String template(Model model){
        model.addAttribute("params", new RequestParams());
        return "index";
    }

    @PostMapping(path="/find")
    public String templateWithResults(@ModelAttribute(name="params") RequestParams params, Model model) throws IOException {
       SearchResponse response =  service.search(params);
       model.addAttribute("amount", response.getAmountOfResults());
       model.addAttribute("list", response.getItems());
        return "index";
    }

}
