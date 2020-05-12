package hackerrank;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PricingServiceTest {
  private static PricingService pricingService;
  private static EligibilityService mockEligibiltyService;

  @BeforeClass
  public static void instantiate() {
    pricingService = new PricingService(mockEligibiltyService);
  }

  @Test
  public void _01_one_week_rental() {
    PriceRequest priceRequest = new PriceRequest("111", new Date(2020, 10, 1, 6, 0), 7, new Date(2020, 10, 8, 6, 0), "economy", false, Arrays.asList("DL123", "DL234"),
        Arrays.asList(new Date(1989, 06, 13), new Date(1991, 12, 4)), Arrays.asList("Aida Lovelace", "Charles Babbage"), TimeZone.getTimeZone("America/New_York"));
    assertEquals(251.93, pricingService.calculation(priceRequest));
  }

  @Test
  public void _02_TODO() {
    // TODO: add a real unit test here
    assertTrue(false);
  }
  @Test
  public void _03_TODO() {
    // TODO: add a real unit test here
    assertTrue(false);
  }

}
