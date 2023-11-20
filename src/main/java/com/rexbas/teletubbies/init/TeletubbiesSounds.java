package com.rexbas.teletubbies.init;

import com.rexbas.teletubbies.Teletubbies;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class TeletubbiesSounds {
	
	public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, Teletubbies.MODID);
	
	public static final Supplier<SoundEvent> ENTITY_TINKYWINKY_VOICE = SOUNDS.register("entity.tinkywinky.voice",
			() -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Teletubbies.MODID, "entity.tinkywinky.voice")));
	
	public static final Supplier<SoundEvent> ENTITY_DIPSY_VOICE = SOUNDS.register("entity.dipsy.voice",
			() -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Teletubbies.MODID, "entity.dipsy.voice")));
	
	public static final Supplier<SoundEvent> ENTITY_LAALAA_VOICE = SOUNDS.register("entity.laalaa.voice",
			() -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Teletubbies.MODID, "entity.laalaa.voice")));
	
	public static final Supplier<SoundEvent> ENTITY_PO_VOICE = SOUNDS.register("entity.po.voice",
			() -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Teletubbies.MODID, "entity.po.voice")));
	
	public static final Supplier<SoundEvent> ENTITY_NOONOO_AMBIENT1 = SOUNDS.register("entity.noonoo.ambient1",
			() -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Teletubbies.MODID, "entity.noonoo.ambient1")));
	
	public static final Supplier<SoundEvent> ENTITY_NOONOO_AMBIENT2 = SOUNDS.register("entity.noonoo.ambient2",
			() -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Teletubbies.MODID, "entity.noonoo.ambient2")));
	
	public static final Supplier<SoundEvent> ENTITY_NOONOO_HURT = SOUNDS.register("entity.noonoo.hurt",
			() -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Teletubbies.MODID, "entity.noonoo.hurt")));
	
	public static final Supplier<SoundEvent> ENTITY_NOONOO_DEATH = SOUNDS.register("entity.noonoo.death",
			() -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Teletubbies.MODID, "entity.noonoo.death")));
	
	public static final Supplier<SoundEvent> ENTITY_MIMI_VOICE = SOUNDS.register("entity.mimi.voice",
			() -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Teletubbies.MODID, "entity.mimi.voice")));
	
	public static final Supplier<SoundEvent> ENTITY_DAADAA_VOICE = SOUNDS.register("entity.daadaa.voice",
			() -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Teletubbies.MODID, "entity.daadaa.voice")));
	
	public static final Supplier<SoundEvent> BALL_BOUNCE = SOUNDS.register("ball.bounce",
			() -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Teletubbies.MODID, "ball.bounce")));
	
	public static final Supplier<SoundEvent> ENTITY_SCOOTER = SOUNDS.register("entity.scooter",
			() -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Teletubbies.MODID, "entity.scooter")));
	
	public static final Supplier<SoundEvent> MACHINE_VOICE_TRUMPET = SOUNDS.register("machine.voice_trumpet",
			() -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Teletubbies.MODID, "machine.voice_trumpet")));
	
	public static final Supplier<SoundEvent> MACHINE_TOAST = SOUNDS.register("machine.toast",
			() -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Teletubbies.MODID, "machine.toast")));
	
	public static final Supplier<SoundEvent> MACHINE_CUSTARD = SOUNDS.register("machine.custard",
			() -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Teletubbies.MODID, "machine.custard")));
}