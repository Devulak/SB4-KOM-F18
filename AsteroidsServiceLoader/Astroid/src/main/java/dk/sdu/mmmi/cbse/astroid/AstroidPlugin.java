package dk.sdu.mmmi.cbse.astroid;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

public class AstroidPlugin implements IGamePluginService {

    private Entity astroid;

    public AstroidPlugin() {
    }

    @Override
    public void start(GameData gameData, World world) {
        
        // Add entities to the world
		for(int i = 0; i < 10; i++)
		{
			astroid = createAstroid(gameData);
			world.addEntity(astroid);
		}
    }

    private Entity createAstroid(GameData gameData) {

        float deacceleration = 10;
        float acceleration = 1000;
        float maxSpeed = 100;
        float rotationSpeed = 5;
        float x = (float) (Math.random()*gameData.getDisplayWidth());
        float y = (float) (Math.random()*gameData.getDisplayWidth());
        float radians = (float) (Math.PI*2*Math.random());
        
        Entity astroid = new Astroid();
        astroid.add(new MovingPart(deacceleration, acceleration, maxSpeed, rotationSpeed));
        astroid.add(new PositionPart(x, y, radians));
        
        return astroid;
    }

    @Override
    public void stop(GameData gameData, World world) {
        // Remove entities
        world.removeEntity(astroid);
    }

}


	

