package com.yungnickyoung.minecraft.ribbits.module;

import com.yungnickyoung.minecraft.ribbits.RibbitsCommon;
import com.yungnickyoung.minecraft.ribbits.block.GiantLilyPadBlock;
import com.yungnickyoung.minecraft.ribbits.block.SwampPlantBlock;
import com.yungnickyoung.minecraft.ribbits.block.SwampLanternBlock;
import com.yungnickyoung.minecraft.ribbits.mixin.DoorBlockAccessor;
import com.yungnickyoung.minecraft.yungsapi.api.autoregister.AutoRegister;
import com.yungnickyoung.minecraft.yungsapi.api.autoregister.AutoRegisterBlock;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

@AutoRegister(RibbitsCommon.MOD_ID)
public class BlockModule {
    @AutoRegister("brown_toadstool")
    public static AutoRegisterBlock BROWN_TOADSTOOL = AutoRegisterBlock.of(() -> new HugeMushroomBlock(
                    BlockBehaviour.Properties
                            .of(Material.WOOD, MaterialColor.DIRT)
                            .strength(0.2f)
                            .sound(SoundType.WOOD)))
            .withItem(() -> new Item.Properties().tab(RibbitsCommon.TAB_RIBBITS.get()));

    @AutoRegister("red_toadstool")
    public static AutoRegisterBlock RED_TOADSTOOL = AutoRegisterBlock.of(() -> new HugeMushroomBlock(
                    BlockBehaviour.Properties
                            .of(Material.WOOD, MaterialColor.COLOR_RED)
                            .strength(0.2f)
                            .sound(SoundType.WOOD)))
            .withItem(() -> new Item.Properties().tab(RibbitsCommon.TAB_RIBBITS.get()));

    @AutoRegister("toadstool_stem")
    public static AutoRegisterBlock TOADSTOOL_STEM = AutoRegisterBlock.of(() -> new HugeMushroomBlock(
                    BlockBehaviour.Properties
                            .of(Material.WOOD, MaterialColor.WOOL)
                            .strength(0.2f)
                            .sound(SoundType.WOOD)))
            .withItem(() -> new Item.Properties().tab(RibbitsCommon.TAB_RIBBITS.get()));

    @AutoRegister("swamp_lantern")
    public static AutoRegisterBlock SWAMP_LANTERN = AutoRegisterBlock.of(() -> new SwampLanternBlock(
                    BlockBehaviour.Properties
                            .of(Material.METAL)
                            .requiresCorrectToolForDrops()
                            .strength(2.0f)
                            .sound(SoundType.LANTERN)
                            .lightLevel(ignored -> 15)
                            .noOcclusion()))
            .withItem(() -> new Item.Properties().tab(RibbitsCommon.TAB_RIBBITS.get()));

    @AutoRegister("giant_lilypad")
    public static AutoRegisterBlock GIANT_LILYPAD = AutoRegisterBlock.of(() -> new GiantLilyPadBlock(
                    BlockBehaviour.Properties
                            .of(Material.PLANT)
                            .instabreak()
                            .sound(SoundType.LILY_PAD)
                            .noOcclusion()))
            .withItem(() -> new Item.Properties().tab(RibbitsCommon.TAB_RIBBITS.get()));

    @AutoRegister("swamp_daisy")
    public static AutoRegisterBlock SWAMP_DAISY = AutoRegisterBlock.of(() -> new SwampPlantBlock(
                    BlockBehaviour.Properties
                            .of(Material.PLANT)
                            .strength(0.1f)
                            .noCollission()
                            .noOcclusion()
                            .sound(SoundType.BIG_DRIPLEAF)))
            .withItem(() -> new Item.Properties().tab(RibbitsCommon.TAB_RIBBITS.get()));

    @AutoRegister("toadstool")
    public static AutoRegisterBlock TOADSTOOL = AutoRegisterBlock.of(() -> new SwampPlantBlock(
                    BlockBehaviour.Properties
                            .of(Material.PLANT, MaterialColor.COLOR_RED)
                            .instabreak()
                            .noCollission()
                            .sound(SoundType.SMALL_DRIPLEAF)))
            .withItem(() -> new Item.Properties().tab(RibbitsCommon.TAB_RIBBITS.get()));

    @AutoRegister("mossy_oak_planks")
    public static AutoRegisterBlock MOSSY_OAK_PLANKS = AutoRegisterBlock.of(() -> new Block(
                    BlockBehaviour.Properties
                            .of(Material.WOOD, MaterialColor.WOOD)
                            .strength(2.0f, 3.0f)
                            .sound(SoundType.WOOD)))
            .withItem(() -> new Item.Properties().tab(RibbitsCommon.TAB_RIBBITS.get()))
            .withSlab()
            .withStairs()
            .withFence()
            .withFenceGate();

    @AutoRegister("mossy_oak_door")
    public static AutoRegisterBlock MOSSY_OAK_DOOR = AutoRegisterBlock.of(() ->
            DoorBlockAccessor.createDoorBlock(BlockBehaviour.Properties
                    .of(Material.WOOD, MaterialColor.WOOD)
                    .strength(3.0f)
                    .sound(SoundType.WOOD)
                    .noOcclusion()))
            .withItem(() -> new Item.Properties().tab(RibbitsCommon.TAB_RIBBITS.get()));

    @AutoRegister("umbrella_leaf")
    public static AutoRegisterBlock UMBRELLA_LEAF = AutoRegisterBlock.of(() -> new SwampPlantBlock(
                    BlockBehaviour.Properties
                            .of(Material.PLANT)
                            .instabreak()
                            .noCollission()
                            .sound(SoundType.SMALL_DRIPLEAF)))
            .withItem(() -> new Item.Properties().tab(RibbitsCommon.TAB_RIBBITS.get()));
}
