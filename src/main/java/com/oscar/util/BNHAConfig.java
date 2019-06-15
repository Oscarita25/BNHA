package com.oscar.util;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = Reference.MOD_ID)
public class BNHAConfig{


		@Config.Name("Entity summon Settings")
	    @Config.Comment("if the entities should be spawned when using /summon")
	    public static final EntitySettings QuirkEntities = new EntitySettings();

	    @Config.Name("Quirks")
	    @Config.Comment("Enable/Disable Quirks when rolled new")
	    public static final Quirks Quirks = new Quirks();

   
   public static class EntitySettings{
	   
       public boolean disable_Fireball;
       public boolean disable_Icicle;
       
       private EntitySettings(){

           this.disable_Fireball = true;
           this.disable_Icicle = true;
       }
   }
   
   public static class Quirks{
	   
       public boolean Quirkless;
       public boolean Explosion;
       public boolean Engine;
       public boolean Hellfire;
       public boolean Ice;
       public boolean Electrification;
       public boolean Tail;
       public boolean Steel;
       public boolean Hardening;

       
       private Quirks() {
           this.Quirkless = true;
           this.Explosion = true;
           this.Engine = true;
           this.Hellfire = true;
           this.Ice = true;
           this.Electrification = true;
           this.Tail = true;
           this.Steel = true;
           this.Hardening = true; 
       }
   }


	@Mod.EventBusSubscriber(modid = Reference.MOD_ID) 
	public static class Handler{
		
		@SubscribeEvent
	    public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event){
			if (event.getModID().equals(Reference.MOD_ID)) {
				
				System.out.println("THIS IS BEING FIRED YEHAWW");
				ConfigManager.sync(Reference.MOD_ID, Config.Type.INSTANCE);
			}
	    }
	}
	
}

