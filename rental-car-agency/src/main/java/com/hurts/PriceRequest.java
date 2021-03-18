package com.hurts;

import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
public class PriceRequest {
  private String customerId;
  private Date start;
  private Date end;
  private int length;
  private String tier;
  private boolean optionalInsurance;
  public List driversLicenseNumbers;
  public List driversBirthDates;
  public List names;
  private TimeZone timeZone;

}
