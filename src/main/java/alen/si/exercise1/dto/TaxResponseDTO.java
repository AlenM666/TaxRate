package alen.si.exercise1.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaxResponseDTO {
    public double possibleReturnAmount;         // Q: gross return (playedAmount * odd)
    public double possibleReturnAmountBefTax;     // W: base for tax calculation (either Q or winnings)
    public double possibleReturnAmountAfterTax;   // X: net payout after tax
    public String taxRate;                        // Y: either a percentage -> e.g., "10%" or fixed indicator
    public double taxAmount;                      // Z: computed amount
}
