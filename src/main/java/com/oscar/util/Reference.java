package com.oscar.util;

import net.minecraft.util.ResourceLocation;

public class Reference {
	public static final String MOD_ID = "bnha";
	public static final String NAME = "Mine Hero Academia";
	public static final String VERSION = "0.0.1";
	public static final String ACCEPTED_VERSIONS = "[1.12.2]";
	public static final String CLIENT_PROXY_CLASS = "com.oscar.proxy.ClientProxy";
	public static final String SERVER_PROXY_CLASS = "com.oscar.proxy.ServerProxy";
	
	//Quirk ID's
	public static final int TotalQuirks = 7;
	public static final int none = 0;
	public static final int quirkless = 1;
	public static final int explosionquirk = 2;
	public static final int engine = 3;
	public static final int hellfire = 4;
	public static final int icequirk = 5;
	public static final int electrification = 6;
	public static final int tail = 7;
	
	//Entity ResourceLocations:
    public static final ResourceLocation FIREBALL = new ResourceLocation(Reference.MOD_ID, "Fireball");
    public static final ResourceLocation ICICLE = new ResourceLocation(Reference.MOD_ID, "Icicle");
	
}
