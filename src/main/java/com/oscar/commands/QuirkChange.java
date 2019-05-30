package com.oscar.commands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.mojang.authlib.GameProfile;
import com.oscar.data.Capabilities;
import com.oscar.data.types.interfaces.IModelID;
import com.oscar.data.types.interfaces.IQuirkID;
import com.oscar.util.Reference;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;

public class QuirkChange  extends CommandBase implements  ICommand{
	
    private final List<String> aliases;
    private final List<String> quirkList;
    
    protected String fullEntityName; 
  
    
    public QuirkChange() 
    { 
        aliases = new ArrayList<String>(); 
        aliases.add("changequirk"); 
        aliases.add("cq"); 
        
        //For Tab Completion
        quirkList = new ArrayList<String>();
        quirkList.add("quirkless");
        quirkList.add("explosion");
        quirkList.add("engine");
        quirkList.add("hellfire");
        quirkList.add("icequirk");
        quirkList.add("electrification");
        quirkList.add("tail");
    } 

    @Override
    public String getName() {
    	return "changequirk";
    }

    /*
     * passing in the arguments for the Command
     * 
     */
    @Override
    public String getUsage(ICommandSender sender) {
    	return "changequirk <name> <quirk>";
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
            		IQuirkID iqID = entityplayermp.getCapability(Capabilities.quirkid, null);
            		IModelID model = entityplayermp.getCapability(Capabilities.modelid, null);
            		            		
            		if(args[1].contentEquals("quirkless")) {
            		iqID.setQID(Reference.quirkless);
            		model.setModelID(Reference.quirkless);

            		}
            		
            		else if(args[1].contentEquals("explosion")) {
            		iqID.setQID(Reference.explosionquirk);
            		model.setModelID(Reference.explosionquirk);
            		}
            		
            		else if(args[1].contentEquals("engine")) {
            		iqID.setQID(Reference.engine);
            		model.setModelID(Reference.engine);
            		}
            		
            		else if(args[1].contentEquals("hellfire")) {
            		iqID.setQID(Reference.hellfire);
            		model.setModelID(Reference.hellfire);
            		}
            		
            		else if(args[1].contentEquals("icequirk")) {
            		iqID.setQID(Reference.icequirk);
            		model.setModelID(Reference.icequirk);
            		}
            		
            		else if(args[1].contentEquals("electrification")) {
            		iqID.setQID(Reference.electrification);
            		model.setModelID(Reference.electrification);
                	}
            		
            		else if(args[1].contentEquals("tail")) {
            		iqID.setQID(Reference.tail);
            		model.setModelID(Reference.tail);
            		}
            		else {
                        throw new WrongUsageException("failed to change quirk", new Object[0]);
            		}
                
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
				getListOfStringsMatchingLastWord(args, server.getOnlinePlayerNames()) :
					args.length == 2 ? getListOfStringsMatchingLastWord(args, quirkList) :
						Collections.emptyList();
					}

	@Override
	public boolean isUsernameIndex(String[] args, int index) {
		return true;
	}}