package alen.si.exercise1.controller;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public Map<String, Object> home()
    {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Welcome to the Taxation API!");
        response.put("availableEndpoints", new String[]{
                "/api/tax/general/rate",
                "/api/tax/general/fixed",
                "/api/tax/winnings/rate",
                "/api/tax/winnings/fixed"
        });
        return response;
    }

}
