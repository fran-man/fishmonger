package de.bitbrain.fishmonger.model;

import com.badlogic.gdx.graphics.Texture;
import de.bitbrain.braingdx.assets.SharedAssetManager;
import de.bitbrain.fishmonger.assets.Assets;
import de.bitbrain.fishmonger.i18n.Bundle;
import de.bitbrain.fishmonger.i18n.Messages;

public enum FishType {

   PIRANHA(Assets.Textures.PIRANHA, Messages.FISH_PIRANHA_NAME, Messages.FISH_PIRANHA_NAME_PLURAL, Messages.FISH_PIRANHA_DESCRIPTION, 1000, 0.1f),
   MACKEREL(Assets.Textures.MACKEREL, Messages.FISH_MACKEREL_NAME, Messages.FISH_MACKEREL_NAME_PLURAL, Messages.FISH_MACKEREL_DESCRIPTION, 200, 0.5f);

   private String assetId;
   private Messages name;
   private Messages pluralName;
   private Messages description;
   private int value;
   private float probability;

   FishType(String assetId, Messages name, Messages pluralName, Messages description, int value, float probability) {
      this.assetId = assetId;
      this.name = name;
      this.pluralName = pluralName;
      this.description = description;
      this.value = value;
      this.probability = probability;
   }

   public Texture getAsset() {
      return SharedAssetManager.getInstance().get(assetId, Texture.class);
   }

   public String getName() {
      return Bundle.get(name);
   }

   public String getPluralName() {
      return Bundle.get(pluralName);
   }

   public String getDescription() {
      return Bundle.get(description);
   }

   public int getValue() {
      return value;
   }

   public float getProbability() {
      return probability;
   }
}
