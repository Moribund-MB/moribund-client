package com.github.moribund.objects.nonplayable.items;

public enum GroundItemType {
    ROCK(0), FEATHER(1), STICK(2), STRING(3);

    private static final GroundItemType[] VALUES = values();
    private final int id;

    GroundItemType(int id) {
        this.id = id;
    }

    public static GroundItemType getGroundItemType(int id) {
        for (GroundItemType groundItemType : VALUES) {
            if (groundItemType.id == id) {
                return groundItemType;
            }
        }
        return null;
    }
}
