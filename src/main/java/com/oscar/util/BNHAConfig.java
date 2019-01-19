package com.oscar.util;

import org.apache.logging.log4j.Level;

import com.oscar.proxy.CommonProxy;

import net.minecraftforge.common.config.Configuration;

public class BNHAConfig
{
   private static final String CATEGORY_GENERAL = "general";

   public static void readCfg()
   {
      Configuration cfg = CommonProxy.config;
      try {
         cfg.load();
         initGeneralConfig(cfg);
      } catch (Exception e) {
         LoggingUtil.BNHALogger.log(Level.ERROR, "Problem loading BNHA Mod config file!", e);
      } finally {
         if (cfg.hasChanged()) {
            cfg.save();
         }
      }
   }

   private static void initGeneralConfig(Configuration config)
   {
      config.addCustomCategoryComment(CATEGORY_GENERAL, "BNHA Mod - General Configuration");
   }
}
