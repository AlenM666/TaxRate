package alen.si.exercise1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/tax")
public class GetControllers {

    @GetMapping("/winnings/rate")
    public Map<String, Object> getWinningsRate()
    {
        double playedAmount = 5;
        double odd = 3.2;
        double possibleReturnAmount = playedAmount * odd;
        double winnings = possibleReturnAmount - playedAmount;
        double taxRate = 0.10;
        double taxAmount = winnings * taxRate;
        double possibleReturnAmountAfterTax= possibleReturnAmount - taxAmount;

        //create response
        Map<String, Object> response = new HashMap<>();
        response.put("possibleReturnAmount", possibleReturnAmount);
        response.put("possibleReturnAmountBefTax", possibleReturnAmount);
        response.put("possibleReturnAmountAfterTax", possibleReturnAmountAfterTax);
        response.put("taxRate", taxRate * 100); // Convert to percentage
        response.put("taxAmount", taxAmount);

        return response;

    }


    /*
    @GetMapping("/winnings/fixed")
    public Map<String, Object> getWinningsFixed()
    {

    }

     */
}
