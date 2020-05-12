package hackerrank;

import java.util.logging.Logger;

public interface EligibilityService {

  Logger logger = Logger.getLogger("EligibilityService");

  boolean checkDoNotRentStatus(String ln) throws EligibilityServiceException;

}
