package com.l13gr03.pets.model.game.entities;

public class LavaLurker extends Entity{
    private static final String ability = "Flame Fists"; //+Atk


    public LavaLurker(String n) {
        super(n);
        super.setStats(new int[]{79, 83, 100, 85, 105, 78});
    }

    public String getAbility() {
        return ability;
    }
}
