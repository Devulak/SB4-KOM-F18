package dk.sdu.mmmi.cbse.enemy;

import dk.sdu.mmmi.cbse.commonbullet.BulletSPI;
import java.util.Collection;
import org.openide.util.Lookup;

public class BulletLookupSPI implements BulletLookup
{
	private final Lookup lookup = Lookup.getDefault();
	
	@Override
	public Collection<? extends BulletSPI> getBulletSPI()
	{
		return lookup.lookupAll(BulletSPI.class);
	}
}
