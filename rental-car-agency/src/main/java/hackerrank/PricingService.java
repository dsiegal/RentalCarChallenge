package hackerrank;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

public class PricingService {

  private final EligibilityService eligibilityService;
  private Logger log = Logger.getLogger("EligibilityService");

  PricingService(EligibilityService eligibilityService) {
    this.eligibilityService = eligibilityService;
  }

  public double calculation(PriceRequest req) {
    double price = 0;
    try {
      for (int i = 0; i < req.getDriversLicenseNumbers().size(); i++) {
        String ln = (String) req.getDriversLicenseNumbers().get(i);
        eligibilityService.checkDoNotRentStatus(ln);
      }

      if (req.getLength() >= 7) {
        if (req.getTier() == "economy") {
          price = 35.99 * req.getLength();
        } else if (req.getTier() == "regular") {
          price = 49.99 * req.getLength();
        } else if (req.getTier() == "premium"){
          price = 79.99 * req.getLength();
        }
      } else {

        for (int i = 0; i < req.getLength(); i++) {

          int day = (req.getStart().getDay() + i) % 7;
          if (day == 0 || day == 6 || day == 7) {
            if (req.getTier() == "economy") {
              price += 35.99 * 1.5;
            } else if (req.getTier() == "regular") {
              price += 49.99 * 1.5;
            } else if (req.getTier() == "premium") {
              price += 79.99 * 1.5;
            }
          } else {
            if (req.getTier() == "economy") {
              price += 35.99;
            } else if (req.getTier() == "regular") {
              price += 49.99;
            } else if (req.getTier() == "premium") {
              price += 79.99;
            }
          }
        }
      }
      if (req.isOptionalInsurance()) {
        double surcharge = 1.1;
        for (int i = 0; i < req.getDriversBirthDates().size(); i++) {
          String bd = (String) req.getDriversBirthDates().get(i);
          Date d = SimpleDateFormat.getInstance().parse(bd);
          long age = (new Date().getTime() - d.getTime()) / (1000 * 60 * 60 * 24 * 365L);
          if ( age < 25 || age > 75 ) {
            surcharge = 1.5;
          }
          price *= surcharge;
        }
      }

    } catch (Exception e) {
      System.out.println("req failed");
      return 0;
    }
    log.info("Customer " + req.getCustomerId() + " requesting " + req.getTier() + " car for pickup on " + req.getStart() + req.getTimeZone() +
        " and return by " + req.getEnd() + req.getTimeZone() + (req.isOptionalInsurance() ? "without" : "with" ) + " optional insurance" + "for $" + price);
    return price;
  }
}
