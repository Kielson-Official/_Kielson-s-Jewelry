package com.kielson.datagen;

import com.kielson.datagen.translations.RingsAndThingsEnglishLangProvider;
import com.kielson.datagen.translations.RingsAndThingsPolishLangProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import org.jspecify.annotations.NonNull;

public class RingsAndThingsDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(@NonNull FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(RingsAndThingsTagProvider::new);
		pack.addProvider(RingsAndThingsModelProvider::new);
		pack.addProvider(RingsAndThingsEnglishLangProvider::new);
		pack.addProvider(RingsAndThingsPolishLangProvider::new);
	}
}
