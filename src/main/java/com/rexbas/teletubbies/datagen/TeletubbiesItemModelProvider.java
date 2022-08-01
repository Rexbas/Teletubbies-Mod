package com.rexbas.teletubbies.datagen;

import com.rexbas.teletubbies.Teletubbies;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class TeletubbiesItemModelProvider extends ItemModelProvider {

	public TeletubbiesItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, Teletubbies.MODID, existingFileHelper);
	}

	@Override
	protected void registerModels() {
		registerBlockModels();
		registerItemModels();		
		registerArmorModels();
		registerSpawnEggModels();
	}
	
	private void registerBlockModels() {
		withExistingParent("full_grass", modLoc("block/full_grass"));
		withExistingParent("control_panel", modLoc("block/control_panel"));
	}
	
	private void registerItemModels() {
		ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));
		getBuilder("tinkywinky_stick").parent(itemGenerated).texture("layer0", "item/tinkywinky_stick");
		getBuilder("dipsy_stick").parent(itemGenerated).texture("layer0", "item/dipsy_stick");
		getBuilder("laalaa_stick").parent(itemGenerated).texture("layer0", "item/laalaa_stick");
		getBuilder("po_stick").parent(itemGenerated).texture("layer0", "item/po_stick");
		getBuilder("tinkywinky_bag").parent(itemGenerated).texture("layer0", "item/tinkywinky_bag");
		getBuilder("bowl").parent(itemGenerated).texture("layer0", "item/bowl");
		getBuilder("custard").parent(itemGenerated).texture("layer0", "item/custard");
		getBuilder("toast").parent(itemGenerated).texture("layer0", "item/toast");
	}
	
	private void registerArmorModels() {
		ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));
		getBuilder("tutu").parent(itemGenerated).texture("layer0", "item/tutu");
		getBuilder("noonoo_eyes").parent(itemGenerated).texture("layer0", "item/noonoo_eyes");
		getBuilder("dipsy_hat").parent(itemGenerated).texture("layer0", "item/dipsy_hat");
		getBuilder("tinkywinky_bib").parent(itemGenerated).texture("layer0", "item/tinkywinky_bib");
		getBuilder("dipsy_bib").parent(itemGenerated).texture("layer0", "item/dipsy_bib");
		getBuilder("laalaa_bib").parent(itemGenerated).texture("layer0", "item/laalaa_bib");
		getBuilder("po_bib").parent(itemGenerated).texture("layer0", "item/po_bib");
		getBuilder("po_helmet").parent(itemGenerated).texture("layer0", "item/po_helmet");
	}
	
	private void registerSpawnEggModels() {
		withExistingParent("tinkywinky_spawn_egg", mcLoc("item/template_spawn_egg"));
		withExistingParent("dipsy_spawn_egg", mcLoc("item/template_spawn_egg"));
		withExistingParent("laalaa_spawn_egg", mcLoc("item/template_spawn_egg"));
		withExistingParent("po_spawn_egg", mcLoc("item/template_spawn_egg"));

		withExistingParent("noonoo_spawn_egg", mcLoc("item/template_spawn_egg"));

		withExistingParent("mimi_spawn_egg", mcLoc("item/template_spawn_egg"));
		withExistingParent("daadaa_spawn_egg", mcLoc("item/template_spawn_egg"));
		withExistingParent("ping_spawn_egg", mcLoc("item/template_spawn_egg"));
		withExistingParent("ba_spawn_egg", mcLoc("item/template_spawn_egg"));
		withExistingParent("ruru_spawn_egg", mcLoc("item/template_spawn_egg"));
		withExistingParent("nin_spawn_egg", mcLoc("item/template_spawn_egg"));
		withExistingParent("duggledee_spawn_egg", mcLoc("item/template_spawn_egg"));
		withExistingParent("umpiepumpie_spawn_egg", mcLoc("item/template_spawn_egg"));
		
		withExistingParent("tinkywinky_zombie_spawn_egg", mcLoc("item/template_spawn_egg"));
		withExistingParent("dipsy_zombie_spawn_egg", mcLoc("item/template_spawn_egg"));
		withExistingParent("laalaa_zombie_spawn_egg", mcLoc("item/template_spawn_egg"));
		withExistingParent("po_zombie_spawn_egg", mcLoc("item/template_spawn_egg"));
	}
}