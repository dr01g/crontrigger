package com.j2trp.spring.toolkit;

import java.util.Arrays;
import java.util.Random;
import java.util.regex.Pattern;

public class EnhancedCronTrigger {

  static final Pattern cronPattern = Pattern.compile("^(\\w+) (\\w+) (\\w+) (\\w+) (\\w+) (\\w+)");
  static final int[] values = new int[] { 60, 60, 24 };
  static Random rand = new Random(); 
  
  public static String cron (String cronExp) {
    
    String[] splits = cronExp.split(" ");
    
    System.out.println(Arrays.toString(splits));
    
    for (int i = 0; i < values.length; i++) {
      if (splits[i].equals("H")) {
        splits[i] = String.valueOf(rand.nextInt(values[i]));
      }
      else if (splits[i].contains("/")) {
        int periods = Integer.parseInt(splits[i].substring(splits[i].indexOf("/") + 1));
        int startValue = rand.nextInt(values[i]) / periods;
        String[] val2 = new String[periods];
        for (int j = 0; j < val2.length; j++) {
          val2[j] = String.valueOf(startValue + j * (values[i] / periods));
        }
        splits[i] = String.join(",", val2);
      }
  
    }
    
    return String.join(" ", splits);
  }
}
