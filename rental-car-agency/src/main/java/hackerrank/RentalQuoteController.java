package hackerrank;

public class RentalQuoteController {


  public RentalQuoteController() {

    EligibilityService eligibilityService = new EligibilityService();
    PricingService pricingService = new PricingService(eligibilityService);
  }


}
