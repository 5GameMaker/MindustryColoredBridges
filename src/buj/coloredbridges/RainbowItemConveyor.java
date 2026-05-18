package buj.coloredbridges;

import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Lines;
import arc.math.Mathf;
import arc.math.geom.Geometry;
import arc.math.geom.Point2;
import arc.util.Time;
import arc.util.Tmp;
import mindustry.Vars;
import mindustry.core.Renderer;
import mindustry.graphics.Layer;
import mindustry.world.Tile;
import mindustry.world.blocks.distribution.ItemBridge;
import mindustry.world.meta.BuildVisibility;
import yash.oklab.Ok;

public class RainbowItemConveyor extends ItemBridge {
    public final ItemBridge source;
    public final Color[] colors;

    public RainbowItemConveyor(ItemBridge source) {
        super("temp-block-" + source.name);

        this.hasItems = source.hasItems;
        this.hasLiquids = source.hasLiquids;
        this.hasPower = source.hasPower;
        this.outputsLiquid = source.outputsLiquid;
        this.consumesPower = source.consumesPower;
        this.outputsPower = source.outputsPower;
        this.connectedPower = source.connectedPower;
        this.conductivePower = source.conductivePower;
        this.outputsPayload = source.outputsPayload;
        this.acceptsPayload = source.acceptsPayload;
        this.acceptsItems = source.acceptsItems;
        this.separateItemCapacity = source.separateItemCapacity;
        this.itemCapacity = source.itemCapacity;
        this.liquidCapacity = source.liquidCapacity;
        this.liquidPressure = source.liquidPressure;
        this.outputFacing = source.outputFacing;
        this.noSideBlend = source.noSideBlend;
        this.displayFlow = source.displayFlow;
        this.inEditor = source.inEditor;
        this.lastConfig = source.lastConfig;
        this.saveConfig = source.saveConfig;
        this.copyConfig = source.copyConfig;
        this.clearOnDoubleTap = source.clearOnDoubleTap;
        this.update = source.update;
        this.destructible = source.destructible;
        this.unloadable = source.unloadable;
        this.isDuct = source.isDuct;
        this.allowResupply = source.allowResupply;
        this.solid = source.solid;
        this.solidifes = source.solidifes;
        this.teamPassable = source.teamPassable;
        this.underBullets = source.underBullets;
        this.rotate = source.rotate;
        this.rotateDraw = source.rotateDraw;
        this.lockRotation = source.lockRotation;
        this.invertFlip = source.invertFlip;
        this.variants = source.variants;
        this.drawArrow = source.drawArrow;
        this.drawTeamOverlay = source.drawTeamOverlay;
        this.saveData = source.saveData;
        this.breakable = source.breakable;
        this.rebuildable = source.rebuildable;
        this.buildCostMultiplier = source.buildCostMultiplier;
        this.privileged = source.privileged;
        this.requiresWater = source.requiresWater;
        this.placeableLiquid = source.placeableLiquid;
        this.placeablePlayer = source.placeablePlayer;
        this.placeableOn = source.placeableOn;
        this.insulated = source.insulated;
        this.squareSprite = source.squareSprite;
        this.absorbLasers = source.absorbLasers;
        this.enableDrawStatus = source.enableDrawStatus;
        this.drawDisabled = source.drawDisabled;
        this.autoResetEnabled = source.autoResetEnabled;
        this.noUpdateDisabled = source.noUpdateDisabled;
        this.updateInUnits = source.updateInUnits;
        this.alwaysUpdateInUnits = source.alwaysUpdateInUnits;
        this.useColor = source.useColor;
        this.itemDrop = source.itemDrop;
        this.playerUnmineable = source.playerUnmineable;
        this.attributes = source.attributes;
        this.scaledHealth = source.scaledHealth;
        this.health = source.health;
        this.armor = source.armor;
        this.baseExplosiveness = source.baseExplosiveness;
        this.destroyBullet = source.destroyBullet;
        this.destroyBulletSameTeam = source.destroyBulletSameTeam;
        this.lightLiquid = source.lightLiquid;
        this.drawCracks = source.drawCracks;
        this.createRubble = source.createRubble;
        this.floating = source.floating;
        this.size = source.size;
        this.offset = source.offset;
        this.sizeOffset = source.sizeOffset;
        this.clipSize = source.clipSize;
        this.placeOverlapRange = source.placeOverlapRange;
        this.crushDamageMultiplier = source.crushDamageMultiplier;
        this.timers = source.timers;
        this.cacheLayer = source.cacheLayer;
        this.fillsTile = source.fillsTile;
        this.forceDark = source.forceDark;
        this.alwaysReplace = source.alwaysReplace;
        this.replaceable = source.replaceable;
        this.group = source.group;
        this.flags = source.flags;
        this.priority = source.priority;
        this.unitCapModifier = source.unitCapModifier;
        this.configurable = source.configurable;
        this.commandable = source.commandable;
        this.allowConfigInventory = source.allowConfigInventory;
        this.selectionRows = source.selectionRows;
        this.logicConfigurable = source.logicConfigurable;
        this.consumesTap = source.consumesTap;
        this.drawLiquidLight = source.drawLiquidLight;
        this.envRequired = source.envRequired;
        this.envEnabled = source.envEnabled;
        this.envDisabled = source.envDisabled;
        this.sync = source.sync;
        this.conveyorPlacement = source.conveyorPlacement;
        this.allowDiagonal = source.allowDiagonal;
        this.swapDiagonalPlacement = source.swapDiagonalPlacement;
        this.schematicPriority = source.schematicPriority;
        this.mapColor = source.mapColor;
        this.hasColor = source.hasColor;
        this.targetable = source.targetable;
        this.attacks = source.attacks;
        this.suppressable = source.suppressable;
        this.canOverdrive = source.canOverdrive;
        this.outlineColor = source.outlineColor;
        this.outlineIcon = source.outlineIcon;
        this.outlineRadius = source.outlineRadius;
        this.outlinedIcon = source.outlinedIcon;
        this.hasShadow = source.hasShadow;
        this.customShadow = source.customShadow;
        this.placePitchChange = source.placePitchChange;
        this.breakPitchChange = source.breakPitchChange;
        this.placeSound = source.placeSound;
        this.breakSound = source.breakSound;
        this.destroySound = source.destroySound;
        this.albedo = source.albedo;
        this.lightColor = source.lightColor;
        this.emitLight = source.emitLight;
        this.lightRadius = source.lightRadius;
        this.fogRadius = source.fogRadius;
        this.ambientSound = source.ambientSound;
        this.ambientSoundVolume = source.ambientSoundVolume;
        this.requirements = source.requirements;
        this.category = source.category;
        this.buildCostMultiplier = source.buildCostMultiplier;
        this.deconstructThreshold = source.deconstructThreshold;
        this.instantDeconstruct = source.instantDeconstruct;
        this.placeEffect = source.placeEffect;
        this.breakEffect = source.breakEffect;
        this.destroyEffect = source.destroyEffect;
        this.researchCostMultiplier = source.researchCostMultiplier;
        this.researchCostMultipliers = source.researchCostMultipliers;
        this.researchCost = source.researchCost;
        this.instantTransfer = source.instantTransfer;
        this.quickRotate = source.quickRotate;
        this.subclass = source.subclass;
        this.selectScroll = source.selectScroll;
        this.buildType = source.buildType;
        this.configurations = source.configurations;
        this.itemFilter = source.itemFilter;
        this.consumers = source.consumers;
        this.hasConsumers = source.hasConsumers;
        this.consPower = source.consPower;
        this.fadeIn = source.fadeIn;
        this.moveArrows = source.moveArrows;
        this.pulse = source.pulse;
        this.arrowSpacing = source.arrowSpacing;
        this.arrowOffset = source.arrowOffset;
        this.arrowPeriod = source.arrowPeriod;
        this.arrowTimeScl = source.arrowTimeScl;
        this.bridgeWidth = source.bridgeWidth;

        this.bridgeRegion = source.bridgeRegion;
        this.arrowRegion = source.arrowRegion;
        this.endRegion = source.endRegion;
        this.range = source.range;
        this.transportTime = source.transportTime;

        this.generateIcons = false;
        this.inEditor = false;
        this.buildVisibility = BuildVisibility.hidden;
        this.fullIcon = source.fullIcon;
        this.uiIcon = source.uiIcon;

        this.source = source;

        colors = new Color[this.source.range];
        for (int i = 1; i < range; i++) {
            colors[i] = Ok.HSV((i - 1) * (360 / (range - 2)), 100, 30 + i * (20f / (range - 1)));
        }
        colors[0] = Color.black;
    }

    @Override
    public boolean linkValid(Tile tile, Tile other, boolean checkDouble) {
        if (other == null || tile == null || !positionsValid(tile.x, tile.y, other.x, other.y))
            return false;

        return ((other.block() == tile.block() && tile.block() == source)
                || (!(tile.block() instanceof ItemBridge) && other.block() == source))
                && (other.team() == tile.team() || tile.block() != source)
                && (!checkDouble || ((ItemBridgeBuild) other.build).link != tile.pos());
    }

    public class RainbowItemConveyorBuild extends ItemBridge.ItemBridgeBuild {
        @Override
        public void draw() {
            if (this.block.variants != 0 && this.block.variantRegions != null) {
                Draw.rect(this.block.variantRegions[Mathf.randomSeed((long) this.tile.pos(), 0,
                        Math.max(0, this.block.variantRegions.length - 1))], this.x, this.y, this.drawrot());
            } else {
                Draw.rect(this.block.region, this.x, this.y, this.drawrot());
            }

            this.drawTeamTop();

            Draw.z(Layer.power);

            Tile other = Vars.world.tile(link);
            if (!linkValid(tile, other)) {
                return;
            }

            if (Mathf.zero(Renderer.bridgeOpacity))
                return;

            int i = relativeTo(other.x, other.y);

            var dst = Point2.x(link) - tileX();
            if (dst == 0)
                dst = Point2.y(link) - tileY();
            if (dst < 0)
                dst *= -1;
            Color conveyorColor = Color.black;
            if (dst <= range)
                conveyorColor = colors[dst - 1];

            if (pulse) {
                Draw.color(Color.white, Color.black, Mathf.absin(Time.time, 6f, 0.07f));
            }

            float warmup = hasPower ? this.warmup : 1f;

            Draw.alpha((fadeIn ? Math.max(warmup, 0.25f) : 1f) * Renderer.bridgeOpacity);

            Draw.mixcol(conveyorColor, 1.0f);
            Draw.rect(endRegion, x, y, i * 90 + 90);
            Draw.rect(endRegion, other.drawx(), other.drawy(), i * 90 + 270);

            Lines.stroke(bridgeWidth);

            Tmp.v1.set(x, y).sub(other.worldx(), other.worldy()).setLength(Vars.tilesize / 2f).scl(-1f);

            Draw.mixcol(conveyorColor, 1.0f);
            Lines.line(bridgeRegion,
                    x + Tmp.v1.x,
                    y + Tmp.v1.y,
                    other.worldx() - Tmp.v1.x,
                    other.worldy() - Tmp.v1.y, false);

            int dist = Math.max(Math.abs(other.x - tile.x), Math.abs(other.y - tile.y)) - 1;

            int arrows = (int) (dist * Vars.tilesize / arrowSpacing), dx = Geometry.d4x(i), dy = Geometry.d4y(i);

            Draw.mixcol(conveyorColor, 1.0f);
            for (int a = 0; a < arrows; a++) {
                Draw.alpha(Mathf.absin(a - time / arrowTimeScl, arrowPeriod, 1f) * warmup * Renderer.bridgeOpacity);
                Draw.rect(arrowRegion,
                        x + dx * (Vars.tilesize / 2f + a * arrowSpacing + arrowOffset),
                        y + dy * (Vars.tilesize / 2f + a * arrowSpacing + arrowOffset),
                        i * 90f);
            }
            Draw.color();
            Draw.mixcol();

            Draw.reset();
        }
    }
}
