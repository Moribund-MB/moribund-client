package com.github.moribund.objects.nonplayable.items;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.github.moribund.MoribundClient;
import com.github.moribund.graphics.drawables.DrawableGameAsset;
import com.github.moribund.objects.attributes.Locatable;
import lombok.Getter;

/**
 * An {@code GroundItem} that can be rendered onto the ground.
 */
public final class GroundItem implements Locatable, DrawableGameAsset {

    /**
     * The {@link Sprite} of the ground item.
     */
    private final Sprite sprite;

    /**
     * The {@link ItemType} of the item on the ground.
     */
    @Getter
    private final ItemType itemType;

    /**
     * Creates a ground item.
     * @param itemType The {@link ItemType} on the ground, also used to make the sprite.
     * @param x The x-coordinate of the item on the ground.
     * @param y The y-coordinate of the item on the ground.
     */
    public GroundItem(ItemType itemType, float x, float y) {
        sprite = new Sprite(itemType.getSprite());
        this.itemType = itemType;
        sprite.setX(x);
        sprite.setY(y);
    }

    /**
     * A static helper method to help add items to the ground without having to go through the hassle
     * of adding the ground item to the respective sets for visualization.
     * @param groundItem The ground item to help add to the game.
     * @see com.github.moribund.graphics.drawables.DrawableGameAsset
     * @see MoribundClient#groundItems
     */
    public static void addGroundItem(GroundItem groundItem) {
        MoribundClient.getInstance().getGroundItems().add(groundItem);
        MoribundClient.getInstance().getDrawableGameAssets().add(groundItem);
    }

    @Override
    public float getX() {
        return sprite.getX();
    }

    @Override
    public float getY() {
        return sprite.getY();
    }

    @Override
    public float getRotation() {
        return 0;
    }

    /**
     * Uses rectangle collision to detect if an entity is on the ground item's radius.
     * @param rectangle The other entity's rectangle.
     * @return if the entity is touching the ground item.
     */
    public boolean isTouching(Rectangle rectangle) {
        return sprite.getBoundingRectangle().overlaps(rectangle);
    }

    @Override
    public void draw(Batch batch) {
        sprite.draw(batch);
    }

    /**
     * Checks to see if given data matches a {@link GroundItem}.
     */
    public boolean matches(int itemId, float x, float y) {
        return itemType.getId() == itemId && getX() == x && getY() == y;
    }
}
