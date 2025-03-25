package alen.si.exercise1.controller;

import alen.si.exercise1.dto.TaxRequestDTO;
import alen.si.exercise1.dto.TaxResponseDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tax")
public class TaxController {

    // example config
    public static final double GENERAL_RATE = 0.1; // for 10% general tax
    public static final double GENERAL_FIXED_TAX = 2.0; // for 2 EUR fixed
    public static final double WINNINGS_RATE = 0.1; //10% win tax
    public static final double WINNINGS_FIXED_TAX = 1.0; // 1EUR fixed tax



    //general tax wiht rate %
    @PostMapping("general/rate")
    public TaxResponseDTO generateTaxRate(@RequestBody TaxRequestDTO request)
    {
        TaxResponseDTO response = new TaxResponseDTO();
        double groseReturn = request.getPlayedAmount() * request.getOdd(); //Q
        double taxAmount = groseReturn * GENERAL_RATE;
        response.setPossibleReturnAmount(groseReturn);
        response.setPossibleReturnAmountBefTax(groseReturn);
        //response.setPossibleReturnAmountAfterTax(groseReturn/texAmount);
        response.setPossibleReturnAmountAfterTax(groseReturn-taxAmount);
        //response.setTaxRate(GENERAL_RATE);
        response.setTaxRate("10%");
        response.setTaxAmount(taxAmount);
        return response;
    }


    //Tax using fixed amount
    @PostMapping("general/fixed")
    public TaxResponseDTO generateTaxFixed(@RequestBody TaxRequestDTO request)
    {
        TaxResponseDTO response = new TaxResponseDTO();
        double grossReturn = request.getPlayedAmount() * request.getOdd();
        double taxAmount = GENERAL_FIXED_TAX;
        response.setPossibleReturnAmount(grossReturn);
        response.setPossibleReturnAmountBefTax(grossReturn);
        response.setPossibleReturnAmountAfterTax(grossReturn - taxAmount);
        response.setTaxRate("Fixed (" + GENERAL_FIXED_TAX + " EUR)");
        response.setTaxAmount(taxAmount);
        return response;
    }

    //WIn tax rate
    @PostMapping("/winnings/rate")
    public TaxResponseDTO winningsTaxRate(@RequestBody TaxRequestDTO request) {
        TaxResponseDTO response = new TaxResponseDTO();
        double grossReturn = request.getPlayedAmount() * request.getOdd();
        double winnings = grossReturn - request.getPlayedAmount();
        double taxAmount = winnings * WINNINGS_RATE;
        response.setPossibleReturnAmount(grossReturn);
        // For winnings taxation, we show the taxable base as the winnings.
        response.setPossibleReturnAmountBefTax(winnings);
        response.setPossibleReturnAmountAfterTax(grossReturn - taxAmount);
        response.setTaxRate("10%");
        response.setTaxAmount(taxAmount);
        return response;
    }

    // Winnings tax fixed
    @PostMapping("/winnings/fixed")
    public TaxResponseDTO winningsTaxFixed(@RequestBody TaxRequestDTO request) {
        TaxResponseDTO response = new TaxResponseDTO();
        double grossReturn = request.getPlayedAmount() * request.getOdd();
        double winnings = grossReturn - request.getPlayedAmount();
        double taxAmount = WINNINGS_FIXED_TAX;
        response.setPossibleReturnAmount(grossReturn);
        response.setPossibleReturnAmountBefTax(winnings);
        response.setPossibleReturnAmountAfterTax(grossReturn - taxAmount);
        response.setTaxRate("Fixed (" + WINNINGS_FIXED_TAX + " EUR)");
        response.setTaxAmount(taxAmount);
        return response;
    }


}
