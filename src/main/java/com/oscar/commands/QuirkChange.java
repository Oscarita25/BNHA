package com.oscar.commands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.mojang.authlib.GameProfile;
import com.oscar.BNHA;
import com.oscar.data.packets.MessageRequestModel;
import com.oscar.data.packets.MessageRequestQuirkID;
import com.oscar.data.types.interfaces.IModelID;
import com.oscar.data.types.interfaces.IQuirkID;
import com.oscar.data.types.model.ModelProvider;
import com.oscar.data.types.quirk.id.QuirkIDProvider;
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
    
    protected String fullEntityName; 
  
    
    public QuirkChange() 
    { 
        aliases = new ArrayList<String>(); 
        aliases.add("changequirk"); 
        aliases.add("cq"); 
    } 

    @Override
    public String getName() {
    	return "changequirk";
    }

    @Override
    public String getUsage(ICommandSender sender) {
    	return "changequirk <name> <text>";
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
            		IQuirkID iqID = entityplayermp.getCapability(QuirkIDProvider.QUIRKID_CAP, null);
            		IModelID model = entityplayermp.getCapability(ModelProvider.MODEL_CAP, null);
            		            		
            		if(args[1].contentEquals("quirkless")) {
            		iqID.setID(Reference.quirkless);
            		model.setModelID(0);
        			BNHA.NETWORK.sendToServer(new MessageRequestQuirkID());
        			BNHA.NETWORK.sendToServer(new MessageRequestModel());
            		}
            		
            		else if(args[1].contentEquals("explosion")) {
            		iqID.setID(Reference.explosionquirk);
            		model.setModelID(0);
        			BNHA.NETWORK.sendToServer(new MessageRequestQuirkID());
        			BNHA.NETWORK.sendToServer(new MessageRequestModel());
            		}
            		
            		else if(args[1].contentEquals("engine")) {
            		iqID.setID(Reference.engine);
            		model.setModelID(0);
        			BNHA.NETWORK.sendToServer(new MessageRequestQuirkID());
        			BNHA.NETWORK.sendToServer(new MessageRequestModel());
            		}
            		
            		else if(args[1].contentEquals("hellfire")) {
            		iqID.setID(Reference.hellfire);
            		model.setModelID(0);
        			BNHA.NETWORK.sendToServer(new MessageRequestQuirkID());
        			BNHA.NETWORK.sendToServer(new MessageRequestModel());
            		}
            		
            		else if(args[1].contentEquals("icequirk")) {
            		iqID.setID(Reference.icequirk);
            		model.setModelID(2);
        			BNHA.NETWORK.sendToServer(new MessageRequestQuirkID());
        			BNHA.NETWORK.sendToServer(new MessageRequestModel());
            		}
            		
            		else if(args[1].contentEquals("electrification")) {
            		iqID.setID(Reference.electrification);
            		model.setModelID(0);
        			BNHA.NETWORK.sendToServer(new MessageRequestQuirkID());
        			BNHA.NETWORK.sendToServer(new MessageRequestModel());
                	}
            		
            		else if(args[1].contentEquals("tail")) {
            		iqID.setID(Reference.tail);
        			BNHA.NETWORK.sendToServer(new MessageRequestQuirkID());
            		model.setModelID(1);
        			BNHA.NETWORK.sendToServer(new MessageRequestModel());
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
					Collections.emptyList();
	}

	@Override
	public boolean isUsernameIndex(String[] args, int index) {
		return true;
	}}