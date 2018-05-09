package dk.sdu.mmmi.cbse.enemy;

import dk.sdu.mmmi.cbse.commonbullet.BulletSPI;
import java.util.Collection;

public interface BulletLookup
{
	public Collection<? extends BulletSPI> getBulletSPI();
}
