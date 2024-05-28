package com.yungnickyoung.minecraft.ribbits.mixin.mixins.client.music;

import com.yungnickyoung.minecraft.ribbits.mixin.interfaces.client.ISoundEngineDuck;
import com.yungnickyoung.minecraft.ribbits.mixin.interfaces.client.ISoundManagerDuck;
import net.minecraft.client.sounds.SoundEngine;
import net.minecraft.client.sounds.SoundManager;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(SoundManager.class)
public class SoundManagerMixin implements ISoundManagerDuck {
    @Shadow @Final private SoundEngine soundEngine;

    @Override
    public void ribbits$stopRibbitsMusic(int ribbitEntityId) {
        ((ISoundEngineDuck) this.soundEngine).ribbits$stopRibbitsMusic(ribbitEntityId);
    }
}