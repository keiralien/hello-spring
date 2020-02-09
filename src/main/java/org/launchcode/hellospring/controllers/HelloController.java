package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("hello")
public class HelloController {

    // Handles request at localhost:8080/hello
//    @GetMapping ("hello")
//    public String hello() {
//        return "Hello, Spring!";
//    }

    @GetMapping ("goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // Handles request of the form /hello?name=LaunchCode
    @RequestMapping (method = {RequestMethod.GET, RequestMethod.POST})
        public String helloWithQueryParam(@RequestParam String name, Model model) {
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    //Handles requests of the form /hello/LaunchCode
    @GetMapping ("{name}")
    @ResponseBody
    public String helloWithPathParam (@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("form")
    public String helloForm() {
        return "form";
    }

    @PostMapping("lang")
    @ResponseBody
    public static String createMessage(@RequestParam String name, @RequestParam String language) {
        if (language.equals("en")) {
            return "Hello " + name;
        } else if (language.equals("sp")) {
            return "Hola " + name;
        } else if (language.equals("fr")) {
            return "Bonjour " + name;
        } else if (language.equals("ge")) {
            return "Guten Tag " + name;
        } else if (language.equals("ja")) {
            return "Konichiwa " + name;
        } else {
            System.out.println(language);
            return "I've got a lovely bunch of coconuts!";
        }
    }

    @GetMapping("hello-names")
    public String helloNames(Model model) {
        List<String> names = new ArrayList();
        names.add("LaunchCode");
        names.add("Java");
        names.add("JavaScript");
        model.addAttribute("names", names);
        return "hello-list";
    }
}
