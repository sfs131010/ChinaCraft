package unstudio.chinacraft.world.gen;

import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenFlowers;
import net.minecraft.world.gen.feature.WorldGenerator;
import unstudio.chinacraft.common.ChinaCraft;

import java.util.Random;

/**
 * Created by Mouse on 2017/4/2.
 */
public class WorldGenBambooShoot extends WorldGenerator{
    @Override
    public boolean generate(World world, Random random, int x, int y, int z) {
        int x1 = x + random.nextInt(16);
        int z1 = z + random.nextInt(16);
        int y1 = world.getHeightValue(x1,z1)+1;
        int id = world.getBiomeGenForCoords(x1, z1).biomeID;
        if ((id == 3 || id == 4 || id == 18 || id == 20 || id == 34 || id == 27 || id == 28 || id == 29)
                && random.nextInt(16) == 0) try {
            new WorldGenFlowers(ChinaCraft.blockBambooShoot).generate(world, random, x1, y1, z1);
        } catch (RuntimeException e) {
            //TODO: unknown exception
            e.printStackTrace();
        }
        return true;
    }
}
