package com.hurts;

import java.util.logging.Logger;

public class EligibilityService {

  boolean isTest;
  Logger logger = Logger.getLogger("EligibilityService");

  public boolean checkDoNotRentStatus(String ln) throws EligibilityServiceException {
    boolean canRent = true;
    if (isTest) {
      if (ln.endsWith("9")) { // just a made up condition for testing purposes
        logger.severe("License has expired. Will not rent.");
        throw new EligibilityServiceException("License has expired.");
      }
    } else {
      // Note: this block is commented out to keep the exercise simple & build time quick. You can assume it's working code:

      // String url = "https://api.hurts.com/license-service/validate/" + ln;
      // Response response = HttpRestClient.get(url);
      // if (response.getOutcome() == Outcome.DENIED)) {
      //   throw new EligibilityServiceException(response.message());
      // }
    }
    return canRent;
  }

}
