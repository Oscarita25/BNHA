package obsidiansuite.obsidianAPI.render;

import java.util.Map;

import org.lwjgl.opengl.GL11;

import obsidiansuite.obsidianAPI.animation.AnimationSequence;
import obsidiansuite.obsidianAPI.properties.EntityAnimationPropertiesClient;
import obsidiansuite.obsidianAPI.render.part.Part;
import obsidiansuite.obsidianAPI.render.wavefront.WavefrontObject;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public abstract class ModelAnimated extends ModelObj
{
		
	public static float DEF_TRANSITION_TIME = 0.3f;
	
	public ModelAnimated(String entityName, WavefrontObject wavefrontObj, ResourceLocation textureLocation)
	{
		super(entityName, wavefrontObj, textureLocation);
	}

	@Override
	public void setRotationAngles(float swingTime, float swingMax, float clock, float lookX, float lookY, float f5, Entity entity)
	{
		super.setRotationAngles(swingTime, swingMax, clock, lookX, lookY, f5, entity);

		EntityAnimationPropertiesClient animProps = EntityAnimationPropertiesClient.get(entity);
		if (animProps == null)
		{
			doDefaultAnimations(swingTime, swingMax, clock, lookX, lookY, f5, entity);
		}
		else
		{
			animProps.updateFrameTime();
			
			AnimationSequence seq = animProps.getActiveAnimation();

			if(seq != null) {
				float time = animProps.getAnimationFrameTime();
				animateToPartValues(seq.getPartValuesAtTime(this, time));
				animProps.runAnimationTick(this);
			}
			else {
				doDefaultAnimations(swingTime, swingMax, clock, lookX, lookY, f5, entity);
			}

			//Translate for vertical y pos
			Part entityPos = getPartFromName("entitypos");
			GL11.glTranslatef(0, -entityPos.getValue(1), 0);
		}
	}

	protected void doDefaultAnimations(float swingTime, float swingMax, float clock, float lookX, float lookY, float f5, Entity entity)
	{
		parts.forEach(Part::setToOriginalValues);
	}

	protected void animateToPartValues(Map<String, float[]> partValues)
	{
		parts.forEach(p -> p.setValues(partValues.get(p.getName())));
	}
}
