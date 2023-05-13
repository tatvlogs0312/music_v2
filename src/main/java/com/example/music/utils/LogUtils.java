package com.example.music.utils;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class LogUtils {
  private LogUtils(){}

  public static void info(String content) {
    log.info(content);
  }

  public static void error(String content){
    log.error(content);
  }

  public static void warn(String content){
    log.warn(content);
  }
}
