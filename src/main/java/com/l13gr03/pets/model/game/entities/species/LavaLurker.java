package com.l13gr03.pets.model.game.entities.species;

import com.l13gr03.pets.model.game.entities.Entity;
import com.l13gr03.pets.utils.random.Randomizer;
import com.l13gr03.pets.utils.random.StatusRandomizer;

public class LavaLurker extends Entity {
    private static final int id = 5;
    private static final String ability = "Flame Fists"; // Every time it lands a attack 10% chance it burns


    public LavaLurker(String n) {
        super(n);
        super.setStats(new int[]{80, 145, 80, 125, 70, 100}); //Mega Blaziken -30
    }
    @Override
    public int getId() {
        return id;
    }
    public String getAbility() {
        return ability;
    }
    public void useAbility(int n){
        Randomizer r = new StatusRandomizer();
        boolean res = r.oneInTen();
        if(res){
            turnAbilityOn();
        }


    }
}