package com.oscar.util;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;


public class LoggingUtil
{

   public static Logger BNHALogger;


   public static void info(String message) {
	   BNHALogger.info(message);
   }


   public static void warn(String message) {
	   BNHALogger.warn(message);
   }


   public static void error(String message) {
	   BNHALogger.error(message);
   }


   public static void fatal(String message) {
	   BNHALogger.fatal(message);
   }


   public static void debug(String message) {
	   BNHALogger.debug(message);
   }


   public static void logWithLevel(Level level, String message) {
	   BNHALogger.log(level, message);
   }
}
