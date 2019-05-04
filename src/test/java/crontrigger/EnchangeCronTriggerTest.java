package crontrigger;

import org.junit.Assert;
import org.junit.Test;

import com.j2trp.spring.toolkit.EnhancedCronTrigger;

public class EnchangeCronTriggerTest {

  @Test
  public void testA() {
    System.out.println(EnhancedCronTrigger.cron("H H/4 H 12 25 *"));
  }
}
