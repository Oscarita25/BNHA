package com.oscar.util;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;

@Config(modid = Reference.MOD_ID)
public class BNHAConfig{


		@Config.Name("Entity summon Settings")
	    @Config.Comment("if the entities should be spawned when using /summon")
	    public static final EntitySettings QuirkEntities = new EntitySettings();

	    @Config.Name("Quirks")
	    @Config.Comment("Enable/Disable Quirks when rolled new")
	    public static final Quirks Quirks = new Quirks();

   
   public static class EntitySettings{
	   
       public boolean disable_Fireball = true;
       public boolean disable_Icicle = true;
   }
   
   public static class Quirks{
	   
       public boolean Quirkless = true;
       public boolean Explosion = true;
       public boolean Engine = true;
       public boolean Hellfire = true;
       public boolean Ice = true;
       public boolean Electrification = true;
       public boolean Tail = true;
   }


	@Mod.EventBusSubscriber(modid = Reference.MOD_ID) 
	public static class Handler{
		
	    public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event){
			if (event.getModID().equals(Reference.MOD_ID)) {
				ConfigManager.sync(Reference.MOD_ID, Config.Type.INSTANCE);
			}
	    }
	}
	
}

