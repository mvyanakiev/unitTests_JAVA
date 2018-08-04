package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

public class AxeTests {
    private Dummy dummy;
    private Axe axe;

    @Before
    public void setUp() throws Exception {
        this.dummy = new Dummy(10, 10); // ново дъми за всеки тест
        this.axe = new Axe(10, 10);
    }

    @Test
    public void weaponAttackLosesDurability(){
        axe.attack(dummy);
        Assert.assertEquals(9, axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void brokenWeaponCanAttack() {
        axe.attack(dummy);
        axe.attack(dummy);
    }








}
