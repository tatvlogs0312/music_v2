package com.example.music.utils;

import java.text.Normalizer;
import java.util.Locale;
import java.util.regex.Pattern;
import org.apache.logging.log4j.util.Strings;
import org.springframework.lang.NonNull;

public class VNCharacterUtils {
  @NonNull
  public static String deAccent(String str) {
    if (Strings.isBlank(str)) {
      return "";
    }
    str = str.toLowerCase(Locale.ROOT);
    Pattern patternD = Pattern.compile("\u0111", Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
    str = patternD.matcher(str).replaceAll("d");
    String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD);
    Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
    str = pattern.matcher(nfdNormalizedString).replaceAll("");
    str = str.replaceAll("[^\\w\\s]", "");
    str = str.replaceAll("\\s", "");
    return str;
  }
}
