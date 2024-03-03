import Derealization.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ShizoTest {
    private Arthur arthur;
    private Ford ford;
    private List<Object> env;

    @BeforeEach
    void init() {
        System.out.println("SHIZO TEST");
        env = new ArrayList<>();
        arthur = new Arthur();
        ford = new Ford();
        Fish fish = new Fish();
        fish.setColor(Color.yellow);
        fish.setSize(FishSize.SMALL);
        Bottle<Fish> fishBottle = new Bottle<>();
        fishBottle.setContent(fish);
        fish.setSwim(true);
        ford.setFishBottle(fishBottle);
        env.add(ford);
        env.add(new PackageCereal());
        env.add("Dentrassi underwear");
        env.add("Squarnshell mattresses");
    }



    @Test
    void testArthurConfident() {
        arthur.lookAround(env);
        assertTrue(arthur.isConfident());
        env.remove(1);
        arthur.lookAround(env);
        assertFalse(arthur.isConfident());
    }

    @Test
    void testEarFish() {
        arthur.lookAround(env);
        assertTrue(arthur.isConfident());
        ford.askToPutFish(arthur);
        assertTrue(ford.getFishBottle().isEmpty());
        assertFalse(arthur.getEar().isEmpty());
        assertEquals(Fish.class, arthur.getEar().getContent().getClass());
        Fish fish = (Fish) arthur.getEar().getContent();
        assertFalse(fish.isSwim());
        assertEquals(FishSize.SMALL, fish.getSize());
    }

    @Test
    void testEarFishFalse() {
        ford.askToPutFish(arthur);
        assertFalse(ford.getFishBottle().isEmpty());
        assertTrue(arthur.getEar().isEmpty());
        assertTrue(ford.getFishBottle().getContent().isSwim());
    }

    @Test
    void testEarFishBIG() {
        arthur.lookAround(env);
        assertTrue(arthur.isConfident());
        ford.getFishBottle().getContent().setSize(FishSize.BIG);
        testEarFishFalse();
    }


}
