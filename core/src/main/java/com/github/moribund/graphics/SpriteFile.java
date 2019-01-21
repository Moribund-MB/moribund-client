package com.github.moribund.graphics;

import com.github.moribund.objects.nonplayable.projectile.Projectile;
import lombok.Getter;

/**
 * A {@code SpriteFile} that represents a location for a certain sprite.
 */
public enum SpriteFile {
    /**
     * A player character that isn't equipping any items.
     */
    PLAYER("images/players/default.png"),
    /**
     * A player character that is equipping a bow.
     */
    PLAYER_WITH_BOW("images/players/player_with_bow.png"),
    /**
     * A {@link Projectile} sprite for arrows.
     */
    ARROW_PROJECTILE("images/items/projectile/arrow.png"),
    /**
     * The {@link com.github.moribund.screens.game.GameScreen}'s background image.
     */
    BACKGROUND("images/background.png"),
    MINIMAP("images/minimap.png"),
    INVENTORY_SELECTED("images/ui/inventory/selected.png"),
    INVENTORY_UNSELECTED("images/ui/inventory/unselected.png"),
    FEATHER("images/items/raw/feather.png"),
    ROCK("images/items/raw/rock.png"),
    STICK("images/items/raw/stick.png"),
    STRING("images/items/raw/string.png"),
    ;

    /**
     * A static, final singleton for the {@link SpriteFile#values()} method so
     * that it does not constantly build a new array of values.
     */
    static final SpriteFile[] VALUES = values();

    /**
     * The location of the file related to this particular value.
     */
    @Getter
    private final String location;

    /**
     * Constructor for a {@code SpriteFile} enum value.
     * @param location The location of the file.
     */
    SpriteFile(String location) {
        this.location = location;
    }
}
