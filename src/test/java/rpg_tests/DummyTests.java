package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

import static rpg_tests.Constants.*;

public class DummyTests {
    private Dummy dummy;
    private Axe axe;

    @Before
    public void setUp() throws Exception {
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_XP); // ново дъми за всеки тест
        this.axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
    }

    @Test
    public void dummyLosesHealthIfAttacked() {
        axe.attack(dummy);
        Assert.assertEquals("Message if fail", 0, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void deadDummyThrowsExceptionIfAttacked() {
        axe.attack(dummy);
        axe.attack(dummy);
    }

    @Test
    public void deadDummyCanGiveXP() {
        axe.attack(dummy);
        Assert.assertEquals("Message if fail", 10, dummy.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void aliveDummyCanNotGiveXP() {
        dummy.giveExperience();
    }

}
