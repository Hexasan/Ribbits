package com.yungnickyoung.minecraft.ribbits.entity.goal;

import com.yungnickyoung.minecraft.ribbits.entity.RibbitEntity;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.player.Player;

import java.util.List;

public class RibbitApplyBuffGoal extends Goal {
    private final RibbitEntity ribbit;
    private final double range;
    private final int effectDuration;
    private final int cooldownTicks;
    private final int ticksToApplyBuff;
    private final List<MobEffect> effects;

    private int applyBuffTicks;

    public RibbitApplyBuffGoal(RibbitEntity ribbit, double range, int effectDuration, int cooldownTicks, int ticksToApplyBuff, MobEffect... effects) {
        this.ribbit = ribbit;
        this.range = range;
        this.effectDuration = effectDuration;
        this.cooldownTicks = cooldownTicks;
        this.ticksToApplyBuff = ticksToApplyBuff;
        this.effects = List.of(effects);
    }

    @Override
    public boolean canUse() {
        return this.ribbit.getBuffCooldown() == 0 && !this.ribbit.level().getNearbyPlayers(TargetingConditions.forCombat().range(this.range), this.ribbit, this.ribbit.getBoundingBox().inflate(this.range, 5.0d, this.range)).isEmpty();
    }

    @Override
    public boolean canContinueToUse() {
        return this.applyBuffTicks >= 0;
    }

    @Override
    public boolean requiresUpdateEveryTick() {
        return true;
    }

    @Override
    public void tick() {
        if (this.applyBuffTicks >= this.ticksToApplyBuff) {
            this.applyBuffs();
        } else if (this.applyBuffTicks >= 0) {
            this.applyBuffTicks++;
        }
    }

    @Override
    public void start() {
        this.applyBuffTicks = 0;
        this.ribbit.setBuffing(true);
    }

    @Override
    public void stop() {
        this.ribbit.setBuffCooldown(this.cooldownTicks);
        this.applyBuffTicks = 0;
    }

    private void applyBuffs() {
        this.applyBuffTicks = -1;

        List<Player> nearbyPlayers = this.ribbit.level().getNearbyPlayers(TargetingConditions.forCombat().range(this.range), this.ribbit, this.ribbit.getBoundingBox().inflate(this.range, 5.0d, this.range));

        MobEffect randomEffect = this.effects.get(this.ribbit.getRandom().nextInt(this.effects.size()));
        for (Player player : nearbyPlayers) {
            player.addEffect(new MobEffectInstance(randomEffect, this.effectDuration, 0));
        }

        this.ribbit.setBuffing(false);
    }
}
