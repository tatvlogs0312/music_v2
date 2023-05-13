package com.example.music.utils;

import java.time.LocalDate;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.util.Strings;

public class CommonUtils {
  private CommonUtils() {}

  /**
   * Convert to LocalDate
   *
   * @param temp value
   * @param index value
   * @return value
   */
  public static LocalDate convertValueToLocalDate(Object[] temp, int index) {
    try {
      return LocalDate.parse(temp[index] == null ? Strings.EMPTY : String.valueOf(temp[index]));
    } catch (Exception ex) {
      LogUtils.error(ex.getMessage());
    }
    return null;
  }

  /**
   * Convert to Double
   *
   * @param objects value
   * @param index value
   * @return value
   */
  public static Double convertValueToDouble(Object[] objects, int index) {
    try {
      String temp = objects[index].toString();
      return Double.valueOf(temp == null ? "0.0" : temp);
    } catch (Exception ex) {
      LogUtils.error(ex.getMessage());
    }
    return 0.0;
  }

  /**
   * Convert to Boolean
   *
   * @param objects value
   * @param index value
   * @return value
   */
  public static Boolean convertValueToBoolean(Object[] objects, int index) {
    try {
      String temp = objects[index].toString();
      if (Strings.isNotBlank(temp)) {
        return false;
      }
      return Boolean.valueOf(temp);
    } catch (Exception ex) {
      LogUtils.error(ex.getMessage());
    }
    return false;
  }

  /**
   * Convert to Integer
   *
   * @param objects value
   * @param index value
   * @return value
   */
  public static Integer convertValueToInteger(Object[] objects, int index) {
    try {
      String temp = objects[index].toString();
      if (Strings.isNotBlank(temp)) return Integer.valueOf(0);
      return Integer.valueOf(temp);
    } catch (Exception ex) {
      LogUtils.error(ex.getMessage());
    }
    return 0;
  }

  /**
   * Convert to String
   *
   * @param objects value
   * @param index value
   * @return value
   */
  public static String convertValueToString(Object[] objects, int index) {
    try {
      return objects[index] == null ? null : String.valueOf(objects[index]);
    } catch (Exception ex) {
      LogUtils.error(ex.getMessage());
    }
    return Strings.EMPTY;
  }

  /**
   * Convert vietnamese => value to search
   *
   * @param str value
   * @return value
   */
  public static String convertToValueSearch(String str) {
    return VNCharacterUtils.deAccent(str);
  }
}
