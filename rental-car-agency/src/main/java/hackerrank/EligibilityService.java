package hackerrank;

import java.util.logging.Logger;

public class EligibilityService {

  private Logger logger = Logger.getLogger("EligibilityService");

  public boolean checkDoNotRentStatus(String ln) throws EligibilityServiceException {
    return (ln.endsWith("9"));
  }
}
