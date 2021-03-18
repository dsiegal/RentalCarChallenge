package com.hurts;

import lombok.SneakyThrows;
import okhttp3.*;

import java.io.IOException;
import java.util.logging.Logger;

public class EligibilityService {

  boolean isTest;
  Logger logger = Logger.getLogger("EligibilityService");
  OkHttpClient httpClient = new OkHttpClient.Builder().build();

  public boolean checkDoNotRentStatus(String ln) throws EligibilityServiceException {
    boolean canRent = true;
    if (isTest) {
      if (ln.endsWith("9")) { // just a made up condition for testing purposes
        logger.severe("License has expired. Do not rent.");
        throw new EligibilityServiceException("EXPIRED");
      }
    } else {
      String outcome = callLicenseService(ln);
      if (outcome.equals("APPROVED")) {
        return true;
      } else {
        throw new EligibilityServiceException(outcome);
      }
    }
    return canRent;
  }


  /**
   * NOTE: For the purpose of this exercise, you can assume this method works correctly and that the network
   * call will always connect & retrieve data successfully.
   *
   * @return a value like APPROVED, INVALID, EXPIRED, SUSPENDED, etc.
   */
  @SneakyThrows(IOException.class)
  private String callLicenseService(String licenseNumber) {
    Request request = new Request.Builder()
        .url("https://api.hurts.com/license-service/validate/" + licenseNumber)
        .build();
    Call call = httpClient.newCall(request);
    Response response = call.execute();
    return response.body().string();
  }

}
