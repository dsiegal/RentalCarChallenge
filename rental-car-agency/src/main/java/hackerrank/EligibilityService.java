package hackerrank;

import java.util.logging.Logger;

public class EligibilityService {

  private Logger logger = Logger.getLogger("EligibilityService");

  public boolean checkDoNotRentStatus(String ln) throws EligibilityServiceException {
    // Stubbed out for now. No need to change, but assume this will be replaced with a legit
    // networked service call that will throw EligibilityServiceException if it fails.
    return (ln.endsWith("9"));
  }

}
