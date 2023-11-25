package com.l13gr03.pets.utils.calculator;

import com.l13gr03.pets.model.game.entities.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    public void testPhysicalDamageCalculator() {
        Calculator physicalDamageCalculator = new PhysicalDamageCalculator();
        Entity.Attack attack = new Entity.Attack("Physical", "Water Slap", "Aquatic",50, 0);
        AquaticAlly attacker = new AquaticAlly("Attacker");
        StoneGolem defender = new StoneGolem("Defender");

        double result = physicalDamageCalculator.execute(attack, attacker, defender);

        // Asserting that the result is within a small tolerance due to double precision
        assertEquals(41.5, result, 0.001); //83/100 * 50
    }

    @Test
    public void testSpecialDamageCalculator() {
        Calculator specialDamageCalculator = new SpecialDamageCalculator();
        Entity.Attack attack = new Entity.Attack("Special", "Seed Bomb", "Bio",60,1);
        BiomorphicBeast attacker = new BiomorphicBeast("Attacker");
        LavaLurker defender = new LavaLurker("Defender");

        double result = specialDamageCalculator.execute(attack, attacker, defender);

        // Asserting that the result is within a small tolerance due to double precision
        assertEquals(48.571, result, 0.001); //85/105 * 60
    }

    @Test
    public void testSpecialDamageCalculatorIfAttackTypeIsDifferent() {
        Calculator specialDamageCalculator = new SpecialDamageCalculator();
        Entity.Attack attack = new Entity.Attack("Special", "Seed Bomb", "Bio",60,1);
        CelestialGuardian attacker = new CelestialGuardian("Attacker");
        LavaLurker defender = new LavaLurker("Defender");

        double result = specialDamageCalculator.execute(attack, attacker, defender);

        // Asserting that the result is within a small tolerance due to double precision
        assertEquals(36.429, result, 0.001); // (85/105 * 60) * 0.75
    }

    @Test
    public void testAdvantageCalculator() {
        Calculator advantageCalculator = new AdvantageCalculator();
        Entity.Attack attack = new Entity.Attack("Special", "Cosmic Power","Celestial",70,2);
        CelestialGuardian attacker = new CelestialGuardian("Attacker");
        CyberneticCompanion defender = new CyberneticCompanion("Defender");

        double result = advantageCalculator.execute(attack, attacker, defender);

        assertEquals(2.0, result, 0.001); //SuperEffective
    }
}