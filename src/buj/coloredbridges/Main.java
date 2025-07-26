package buj.coloredbridges;

import java.lang.reflect.Constructor;

import arc.util.Structs;
import mindustry.content.Blocks;
import mindustry.gen.Building;
import mindustry.mod.Mod;
import mindustry.world.blocks.distribution.ItemBridge;

@SuppressWarnings("unchecked")
public class Main extends Mod {
    @Override
    public void init() {
        try {
            Constructor<? extends Building> phaseConveyorBuild;
            RainbowItemConveyor phaseConveyorProxy = new RainbowItemConveyor((ItemBridge) Blocks.phaseConveyor);
            {
                Class<?> ty = Structs.find(
                        RainbowItemConveyor.class.getDeclaredClasses(),
                        t -> Building.class.isAssignableFrom(t) && !t.isInterface());
                phaseConveyorBuild = (Constructor<? extends Building>) ty
                        .getDeclaredConstructor(ty.getDeclaringClass());
            }
            Blocks.phaseConveyor.buildType = () -> {
                try {
                    return phaseConveyorBuild.newInstance(phaseConveyorProxy);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            };

            // Constructor<? extends Building> bridgeConveyorBuild;
            // RainbowItemConveyor bridgeConveyorProxy = new
            // RainbowItemConveyor((ItemBridge) Blocks.itemBridge);
            // {
            // Class<?> ty = Structs.find(
            // RainbowItemConveyor.class.getDeclaredClasses(),
            // t -> Building.class.isAssignableFrom(t) && !t.isInterface());
            // bridgeConveyorBuild = (Constructor<? extends Building>) ty
            // .getDeclaredConstructor(ty.getDeclaringClass());
            // }
            // Blocks.itemBridge.buildType = () -> {
            // try {
            // return bridgeConveyorBuild.newInstance(bridgeConveyorProxy);
            // } catch (Exception e) {
            // throw new RuntimeException(e);
            // }
            // };
        } catch (Exception e) {
            // I love Java
            throw new RuntimeException(e);
        }
    }
}
