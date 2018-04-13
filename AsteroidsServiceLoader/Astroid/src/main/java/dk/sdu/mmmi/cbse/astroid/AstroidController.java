package dk.sdu.mmmi.cbse.astroid;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

public class AstroidController implements IEntityProcessingService
{

	@Override
	public void process(GameData gameData, World world)
	{

		for (Entity astroid : world.getEntities(Astroid.class))
		{
			PositionPart positionPart = astroid.getPart(PositionPart.class);
			MovingPart movingPart = astroid.getPart(MovingPart.class);

			movingPart.setUp(true);

			movingPart.process(gameData, astroid);
			positionPart.process(gameData, astroid);

			updateShape(astroid);
		}
	}

	private void updateShape(Entity entity)
	{
		float[] shapex = entity.getShapeX();
		float[] shapey = entity.getShapeY();
		PositionPart positionPart = entity.getPart(PositionPart.class);
		float x = positionPart.getX();
		float y = positionPart.getY();
		float radians = positionPart.getRadians();
		
		for (int i = 0; i < shapex.length; i++)
		{
			shapex[i] = (float) (x + Math.cos(radians + Math.PI*2/shapex.length*(i+1)) * 8);
			shapey[i] = (float) (y + Math.sin(radians + Math.PI*2/shapex.length*(i+1)) * 8);
		}

		entity.setShapeX(shapex);
		entity.setShapeY(shapey);
	}

}
