package com.education.timetable.utils;

import java.text.DecimalFormat;

public class CommonUtils {

  public static String percent(double p1, double p2) {
    String str;
    double p3 = p1 / p2;
    DecimalFormat df = new DecimalFormat("0.00%");
    return df.format(p3);
  }
}
