package unstudio.chinacraft.entity;

import net.minecraft.entity.EntityList;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import unstudio.chinacraft.common.ChinaCraft;
import unstudio.chinacraft.entity.animal.EntityBlackDog;
import unstudio.chinacraft.entity.especial.EntityCCPainting;
import unstudio.chinacraft.entity.animal.EntityPanda;
import unstudio.chinacraft.entity.especial.EntityCCWord;
import unstudio.chinacraft.entity.mob.EntityChinaZombie;
import unstudio.chinacraft.entity.projectile.EntityProjectile;
import unstudio.chinacraft.entity.projectile.EntitySuperArrow;
import unstudio.chinacraft.entity.projectile.EntityThrownBomb;
import unstudio.chinacraft.entity.projectile.EntityThrownFirecracker;
import cpw.mods.fml.common.registry.EntityRegistry;

/**
 * Created by Trychen on 2015/10/30.
 */
public class EntityRegister {
    private static int id;


    /**
     * 开始注册实体
     */
    public static void init() {
        id = EntityRegistry.findGlobalUniqueEntityId();

        registerLivingEntity(EntityBlackDog.class, "black_dog", 0x0B0B0B, 0x696969);
         EntityRegistry.addSpawn(EntityBlackDog.class, 2, 3, 7, EnumCreatureType.creature, BiomeGenBase.forest, BiomeGenBase.jungle);
        registerLivingEntity(EntityChinaZombie.class, "chinazombie", 0x191946, 0x570204);
        EntityRegistry.addSpawn(EntityChinaZombie.class, 3, 0, 1, EnumCreatureType.monster, BiomeGenBase.plains, BiomeGenBase.forest, BiomeGenBase.birchForest, BiomeGenBase.birchForestHills, BiomeGenBase.forestHills, BiomeGenBase.coldTaiga, BiomeGenBase.coldTaigaHills, BiomeGenBase.desert, BiomeGenBase.desertHills, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.extremeHillsPlus, BiomeGenBase.jungle, BiomeGenBase.megaTaiga, BiomeGenBase.roofedForest, BiomeGenBase.savanna, BiomeGenBase.savannaPlateau, BiomeGenBase.swampland, BiomeGenBase.taiga, BiomeGenBase.taigaHills);
//        registerLivingEntity(EntityPanda.class, "panda", 0xFFFFFF, 0x000000);
        // registerLivingEntity(EntityKongmingLantern.class,"kongming_lantern",0x0504FF,0x0025FF);

        registerModEntity(EntityThrownFirecracker.class, "ccFirecracker" , 80, 3, true);
        registerModEntity(EntityThrownBomb.class, "ccBomb",80, 3, true);
        registerModEntity(EntitySuperArrow.class, "ccSuperArrow",80, 3, true);
        registerModEntity(EntityProjectile.class, "ccProjectile",80, 3, true);
        registerModEntity(EntityCCPainting.class, "ccPainting",128, 1, true);
        registerModEntity(EntityCCWord.class, "ccWord",80, 3, true);
    }


    /**
     * 注册怪物/动物实体
     * @param entityClass 实体类
     * @param entityName 实体名字
     * @param solidColor 怪物蛋颜色1
     * @param spotColor 怪物蛋颜色2
     */
    public static void registerLivingEntity(Class entityClass, String entityName, int solidColor, int spotColor) {
        EntityRegistry.registerGlobalEntityID(entityClass, entityName, id);
        EntityRegistry.registerModEntity(entityClass, entityName, id, ChinaCraft.instance, 64, 1, true);
        createEgg(id, solidColor, spotColor);
        id++;
    }

    /**
     * 特殊实体注册
     * @param entityClass 实体类
     * @param entityName 实体名字
     * @param trackingRange 跟踪范围
     * @param updateFrequency 刷新频率
     * @param sendsVelocityUpdates 接收速度信息包
     */
    public static void registerModEntity(Class entityClass, String entityName, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates){
        EntityRegistry.registerModEntity(entityClass, entityName,
                id, ChinaCraft.instance, trackingRange, updateFrequency, sendsVelocityUpdates);
        id++;
    }

    /**
     * 创建怪物蛋并加入到Minecraft的怪物蛋列表
     * @param randomId 实体ID
     * @param solidColor 颜色1
     * @param spotColor 颜色2
     */
    public static void createEgg(int randomId, int solidColor, int spotColor) {
        EntityList.entityEggs.put(Integer.valueOf(randomId),
                new EntityList.EntityEggInfo(randomId, solidColor, spotColor));
    }
}
