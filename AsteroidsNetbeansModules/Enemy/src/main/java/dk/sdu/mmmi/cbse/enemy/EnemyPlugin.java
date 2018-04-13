package dk.sdu.mmmi.cbse.enemy;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.enemy.Enemy;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import org.openide.util.lookup.ServiceProvider;
import org.openide.util.lookup.ServiceProviders;

@ServiceProviders(value = {
    @ServiceProvider(service = IGamePluginService.class)
})
public class EnemyPlugin implements IGamePluginService
{
	private Entity enemy;

	public EnemyPlugin()
	{
	}

	@Override
	public void start(GameData gameData, World world)
	{

		// Add entities to the world
		for(int i = 0; i < 2; i++)
		{
			enemy = createEnemyShip(gameData);
			world.addEntity(enemy);
		}
	}

	private Entity createEnemyShip(GameData gameData)
	{

		float deacceleration = 5;
		float acceleration = 100;
		float maxSpeed = 150;
		float rotationSpeed = 2.5f;
		float x = (float) (Math.random() * gameData.getDisplayWidth());
		float y = (float) (Math.random() * gameData.getDisplayWidth());
		float radians = (float) (Math.PI * 2 * Math.random());

		Entity enemyShip = new Enemy();
		enemyShip.add(new MovingPart(deacceleration, acceleration, maxSpeed, rotationSpeed));
		enemyShip.add(new PositionPart(x, y, radians));

		return enemyShip;
	}

	@Override
	public void stop(GameData gameData, World world)
	{
		// Remove entities
		world.removeEntity(enemy);
	}
}
