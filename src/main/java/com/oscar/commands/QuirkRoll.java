package com.oscar.commands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.mojang.authlib.GameProfile;
import com.oscar.data.Capabilities;
import com.oscar.data.types.interfaces.IQuirkID;
import com.oscar.util.Utilities;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

public class QuirkRoll  extends CommandBase implements  ICommand{
	
    private final List<String> aliases;
    
    protected String fullEntityName; 
  
    
    public QuirkRoll() 
    { 
        aliases = new ArrayList<String>(); 
        aliases.add("rollquirk"); 
        aliases.add("rq"); 
        
    } 

    @Override
    public String getName() {
    	return "rollquirk";
    }

    /*
     * passing in the arguments for the Command
     * 
     */
    @Override
    public String getUsage(ICommandSender sender) {
    	return "rollquirk <name>";
    }

    
    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
    	if (args.length >= 1 && args[0].length() > 0)
        {
            GameProfile gameprofile = server.getPlayerProfileCache().getGameProfileForUsername(args[0]);

            if (gameprofile == null)
            {
                throw new CommandException("failed to change quirk", new Object[] {args[0]});
            }
            else
            {
                EntityPlayerMP entityplayermp = server.getPlayerList().getPlayerByUsername(args[0]);

                if (entityplayermp != null)
                {
                	Utilities.RandomQuirkChoose(entityplayermp);
            		IQuirkID iqID = entityplayermp.getCapability(Capabilities.quirkid, null);
                	entityplayermp.sendMessage(new TextComponentString("Your Quirk is: "+ TextFormatting.BOLD + Utilities.getQNamebyID(iqID.getQID())));
                
                }

                notifyCommandListener(sender, this, "successful change of quirk", new Object[] {args[0]});
            }
        }
        else
        {
            throw new WrongUsageException("failed to change quirk", new Object[0]);
        }
    }

	@Override
	public int compareTo(ICommand o) {
		return 0;
	}

	@Override
	public List<String> getAliases() {
		return this.aliases;
	}

	@Override
	public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
		return super.checkPermission(server, sender);
	}
	
	@Override
    public int getRequiredPermissionLevel()
    {
        return 4;
    }

	@Override
	public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args,
			BlockPos targetPos) {
		return args.length == 1 ? 
				getListOfStringsMatchingLastWord(args, server.getOnlinePlayerNames()) : Collections.emptyList();
					}

	@Override
	public boolean isUsernameIndex(String[] args, int index) {
		return true;
	}}