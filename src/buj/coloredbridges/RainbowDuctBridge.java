package buj.coloredbridges;

import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.math.Angles;
import arc.math.geom.Geometry;
import arc.util.Nullable;
import mindustry.Vars;
import mindustry.core.Renderer;
import mindustry.graphics.Layer;
import mindustry.world.Tile;
import mindustry.world.blocks.distribution.DuctBridge;
import mindustry.world.meta.BuildVisibility;
import yash.oklab.Ok;

public class RainbowDuctBridge extends DuctBridge {
    public final DuctBridge source;
    public final Color[] colors;

    public RainbowDuctBridge(DuctBridge source) {
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
        this.speed = source.speed;

        this.bridgeRegion = source.bridgeRegion;
        this.arrowRegion = source.arrowRegion;
        this.range = source.range;

        this.generateIcons = false;
        this.inEditor = false;
        this.buildVisibility = BuildVisibility.hidden;
        this.fullIcon = source.fullIcon;
        this.uiIcon = source.uiIcon;
        this.bridgeRegion = source.bridgeRegion;
        this.bridgeBotRegion = source.bridgeBotRegion;
        this.bridgeLiquidRegion = source.bridgeLiquidRegion;
        this.arrowRegion = source.arrowRegion;
        this.dirRegion = source.dirRegion;

        this.source = source;

        colors = new Color[this.source.range];
        for (int i = 1; i < range; i++) {
            colors[i] = Ok.HSV((i - 1) * (360 / (range - 1)), 100, 30 + i * (20f / (range - 1)));
        }
        colors[0] = Color.black;
    }

    public void drawBridge(Color conveyorColor, int rotation, float x1, float y1, float x2, float y2,
            @Nullable Color liquidColor) {
        Draw.mixcol(conveyorColor, 1f);
        Draw.alpha(Renderer.bridgeOpacity);
        float angle = Angles.angle(x1, y1, x2, y2),
                cx = (x1 + x2) / 2f,
                cy = (y1 + y2) / 2f,
                len = Math.max(Math.abs(x1 - x2), Math.abs(y1 - y2)) - size * Vars.tilesize;

        Draw.rect(bridgeRegion, cx, cy, len, bridgeRegion.height * bridgeRegion.scl(), angle);
        if (liquidColor != null) {
            Draw.color(liquidColor, liquidColor.a * Renderer.bridgeOpacity);
            Draw.rect(bridgeLiquidRegion, cx, cy, len, bridgeLiquidRegion.height * bridgeLiquidRegion.scl(), angle);
            Draw.color();
            Draw.alpha(Renderer.bridgeOpacity);
        }
        if (bridgeBotRegion.found()) {
            Draw.color(0.4f, 0.4f, 0.4f, 0.4f * Renderer.bridgeOpacity);
            Draw.rect(bridgeBotRegion, cx, cy, len, bridgeBotRegion.height * bridgeBotRegion.scl(), angle);
            Draw.reset();
        }
        Draw.alpha(Renderer.bridgeOpacity);

        for (float i = 6f; i <= len + size * Vars.tilesize - 5f; i += 5f) {
            Draw.rect(arrowRegion, x1 + Geometry.d4x(rotation) * i, y1 + Geometry.d4y(rotation) * i, angle);
        }

        Draw.color();
        Draw.mixcol();
        Draw.reset();
    }

    public class RainbowDuctBridgeBuild extends DuctBridgeBuild {
        @Override
        public @Nullable DirectionBridgeBuild findLink() {
            for (int i = 1; i <= range; i++) {
                Tile other = tile.nearby(Geometry.d4x(rotation) * i, Geometry.d4y(rotation) * i);
                if (other != null && other.build instanceof DirectionBridgeBuild build
                        && build.block == source && build.team == team) {
                    return build;
                }
            }
            return null;
        }

        @Override
        public void draw() {
            Draw.rect(block.region, x, y);
            Draw.rect(dirRegion, x, y, rotdeg());
            var link = findLink();
            if (link != null) {
                var dst = (tileX() - link.tileX()) + (tileY() - link.tileY());
                if (dst < 0)
                    dst *= -1;
                Color conveyorColor = Color.black;
                if (dst <= range)
                    conveyorColor = colors[dst - 1];
                Draw.z(Layer.power - 1);
                drawBridge(conveyorColor, rotation, x, y, link.x, link.y, null);
            }
        }
    }
}
