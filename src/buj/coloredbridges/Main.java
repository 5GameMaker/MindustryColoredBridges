package buj.coloredbridges;

import java.lang.reflect.Constructor;

import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Lines;
import arc.math.Angles;
import arc.math.Mathf;
import arc.math.geom.Geometry;
import arc.math.geom.Point2;
import arc.util.Structs;
import arc.util.Time;
import arc.util.Tmp;
import mindustry.Vars;
import mindustry.content.Blocks;
import mindustry.core.Renderer;
import mindustry.gen.Building;
import mindustry.graphics.Layer;
import mindustry.mod.Mod;
import mindustry.world.Tile;
import mindustry.world.blocks.distribution.BufferedItemBridge;
import mindustry.world.blocks.distribution.DuctBridge;
import mindustry.world.blocks.distribution.ItemBridge;
import mindustry.world.blocks.distribution.Duct.DuctBuild;
import yash.oklab.Ok;

@SuppressWarnings("unchecked")
public class Main extends Mod {
    @Override
    public void init() {
        try {
            {
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
            }

            {
                final Color[] colors = new Color[((BufferedItemBridge) Blocks.itemBridge).range];
                for (int i = 1; i < ((BufferedItemBridge) Blocks.itemBridge).range; i++) {
                    colors[i] = Ok.HSV((i - 1) * (360 / (((BufferedItemBridge) Blocks.itemBridge).range)),
                            100,
                            30 + i * (20f / (((BufferedItemBridge) Blocks.itemBridge).range - 1)));
                }
                colors[0] = Color.black;
                Blocks.itemBridge.buildType = () -> ((BufferedItemBridge) Blocks.itemBridge).new BufferedItemBridgeBuild() {
                    @Override
                    public void draw() {
                        if (this.block.variants != 0 && this.block.variantRegions != null) {
                            Draw.rect(
                                    this.block.variantRegions[Mathf.randomSeed((long) this.tile.pos(), 0,
                                            Math.max(0, this.block.variantRegions.length - 1))],
                                    this.x, this.y, this.drawrot());
                        } else {
                            Draw.rect(this.block.region, this.x, this.y, this.drawrot());
                        }

                        this.drawTeamTop();

                        Draw.z(Layer.power);

                        Tile other = Vars.world.tile(link);
                        if (!((BufferedItemBridge) Blocks.itemBridge).linkValid(tile, other))
                            return;

                        if (Mathf.zero(Renderer.bridgeOpacity))
                            return;

                        int i = relativeTo(other.x, other.y);
                        var dst = Point2.x(link) - tileX();
                        if (dst == 0)
                            dst = Point2.y(link) - tileY();
                        if (dst < 0)
                            dst *= -1;
                        Color conveyorColor = Color.black;
                        if (dst <= ((BufferedItemBridge) Blocks.itemBridge).range)
                            conveyorColor = colors[dst - 1];
                        Draw.mixcol(conveyorColor, 1f);

                        if (((BufferedItemBridge) Blocks.itemBridge).pulse) {
                            Draw.color(Color.white, Color.black, Mathf.absin(Time.time, 6f, 0.07f));
                        }

                        float warmup = ((BufferedItemBridge) Blocks.itemBridge).hasPower ? this.warmup : 1f;

                        Draw.alpha((((BufferedItemBridge) Blocks.itemBridge).fadeIn ? Math.max(warmup, 0.25f) : 1f)
                                * Renderer.bridgeOpacity);

                        Draw.rect(((BufferedItemBridge) Blocks.itemBridge).endRegion, x, y, i * 90 + 90);
                        Draw.rect(((BufferedItemBridge) Blocks.itemBridge).endRegion, other.drawx(), other.drawy(),
                                i * 90 + 270);

                        Lines.stroke(((BufferedItemBridge) Blocks.itemBridge).bridgeWidth);

                        Tmp.v1.set(x, y).sub(other.worldx(), other.worldy()).setLength(Vars.tilesize / 2f).scl(-1f);

                        Lines.line(((BufferedItemBridge) Blocks.itemBridge).bridgeRegion,
                                x + Tmp.v1.x,
                                y + Tmp.v1.y,
                                other.worldx() - Tmp.v1.x,
                                other.worldy() - Tmp.v1.y, false);

                        int dist = Math.max(Math.abs(other.x - tile.x), Math.abs(other.y - tile.y)) - 1;

                        Draw.color();
                        Draw.mixcol(conveyorColor, 1f);

                        int arrows = (int) (dist * Vars.tilesize
                                / ((BufferedItemBridge) Blocks.itemBridge).arrowSpacing),
                                dx = Geometry.d4x(i),
                                dy = Geometry.d4y(i);

                        for (int a = 0; a < arrows; a++) {
                            Draw.alpha(Mathf.absin(a - time / ((BufferedItemBridge) Blocks.itemBridge).arrowTimeScl,
                                    ((BufferedItemBridge) Blocks.itemBridge).arrowPeriod, 1f) * warmup
                                    * Renderer.bridgeOpacity);
                            Draw.rect(((BufferedItemBridge) Blocks.itemBridge).arrowRegion,
                                    x + dx * (Vars.tilesize / 2f
                                            + a * ((BufferedItemBridge) Blocks.itemBridge).arrowSpacing
                                            + ((BufferedItemBridge) Blocks.itemBridge).arrowOffset),
                                    y + dy * (Vars.tilesize / 2f
                                            + a * ((BufferedItemBridge) Blocks.itemBridge).arrowSpacing
                                            + ((BufferedItemBridge) Blocks.itemBridge).arrowOffset),
                                    i * 90f);
                        }

                        Draw.color();
                        Draw.mixcol();

                        Draw.reset();
                    }
                };
            }

            {
                Constructor<? extends Building> build;
                RainbowDuctBridge proxy = new RainbowDuctBridge((DuctBridge) Blocks.ductBridge);
                {
                    Class<?> ty = Structs.find(
                            RainbowDuctBridge.class.getDeclaredClasses(),
                            t -> Building.class.isAssignableFrom(t) && !t.isInterface());
                    build = (Constructor<? extends Building>) ty
                            .getDeclaredConstructor(ty.getDeclaringClass());
                }
                Blocks.ductBridge.buildType = () -> {
                    try {
                        return build.newInstance(proxy);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                };
            }
        } catch (Exception e) {
            // I love Java
            throw new RuntimeException(e);
        }
    }
}
