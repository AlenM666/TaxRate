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
        /*
        response.put("make POST req CURL", new String[]{
                "curl -X POST" ,
                        "-H \"Content-Type: application/json\"\" ,
                        "-d '{\"traderId\":1,\"playedAmount\":8.2,\"odd\":5.2}'" ,
                        "http://localhost:8080/api/tax/general/fixed\n"
        });

         */
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
