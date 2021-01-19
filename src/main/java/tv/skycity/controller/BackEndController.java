package tv.skycity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BackEndController {
    @RequestMapping("/backend")
    public String login(){
        return "backend";
    }

    @RequestMapping("/backend/data")
    public String data(){
        return "backend/data";
    }
}
