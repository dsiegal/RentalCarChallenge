package com.hurts;

import java.util.logging.Logger;

public class EligibilityService {

  boolean isTest;
  Logger logger = Logger.getLogger("EligibilityService");

  public boolean checkDoNotRentStatus(String ln) throws EligibilityServiceException {
    boolean canRent = false;
    if (isTest) {
      if (ln.endsWith("9")) { // just a made up condition for testing purposes
        logger.severe("License is suspended. Do not rent");
        throw new EligibilityServiceException("License is suspended. Do not rent");
      } else {
        canRent = true;
      }
    } else {
      // Implement once we get contract with 3rd party background check service.
      canRent = true;
    }
    return canRent;
  }

}
