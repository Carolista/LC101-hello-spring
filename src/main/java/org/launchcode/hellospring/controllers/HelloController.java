package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("/hello")
public class HelloController {

    // Handles request at ../hello
//    @GetMapping("hello") // tells it a specific path
//    @ResponseBody // only needed without template; indicates plain text response
//    public String hello() {
//        return "Hello, Spring!";
//    }

    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // Handles requests of the format /hello?name=LaunchCode
    @RequestMapping(method = { RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name, String language) {
        return createMessage(name,language);
    }

    // Handles requests of the form /hello/LaunchCode
//    @GetMapping("{name}")
//    public String helloWithPathParam(@PathVariable String name) {
//        return "Hello, " + name + "!";
//    }

    // Handles form-style requests
    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action='/hello'>" + // submit a request to /hello? above
                "<input type='text' name='name'>" +
                "<select name='language'>" +
                "<option value='English'>English</option>" +
                "<option value='Esperanto'>Esperanto</option>" +
                "<option value='French'>French</option>" +
                "<option value='Portuguese'>Portuguese</option>" +
                "<option value='Spanish'>Spanish</option>" +
                "</select>" +
                "<input type='submit' value='Greet Me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    public static String createMessage(String name, String language) {
        if (language.equals("English")) {
            return "<h1 style='color:darkblue'>Hello, " + name + "!</h1>";
        } else if (language.equals("Esperanto")) {
            return "<h1 style='color:darkred'>Saluton, " + name + "!</h1>";
        } else if (language.equals("French")) {
            return "<h1 style='color:darkgreen'>Bonjour, " + name + "!</h1>";
        } else if (language.equals("Portuguese")) {
            return "<h1 style='color:darkorange'>Oi, " + name + "!</h1>";
        } else {
            return "<h1 style='color:grey'>Hola, " + name + "!</h1>";
        }
    }

}
