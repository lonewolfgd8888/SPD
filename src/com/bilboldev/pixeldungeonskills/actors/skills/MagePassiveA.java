package com.bilboldev.pixeldungeonskills.actors.skills;

import com.bilboldev.pixeldungeonskills.Dungeon;
import com.bilboldev.pixeldungeonskills.actors.hero.Hero;

import java.util.ArrayList;

/**
 * Created by Moussa on 20-Jan-17.
 */
public class MagePassiveA extends BranchSkill{



    {
        name = "Mage";
        image = 24;
        level = 0;
    }


    @Override
    public ArrayList<String> actions( Hero hero ) {
        ArrayList<String> actions = new ArrayList<String>();
        if(canUpgrade())
            actions.add(AC_ADVANCE);
        return actions;
    }

    @Override
    public void execute( Hero hero, String action ) {
        if(action == Skill.AC_ADVANCE)
            hero.heroSkills.advance(CurrentSkills.BRANCHES.PASSIVEA);
    }

    @Override
    public String info()
    {
        return "Mages rely on their magical powers to gain an advantage over others.\n"
                + "You have invested a total of " + totalSpent() + " points in this branch.\n"
                + (canUpgrade() ? "Next advancement will cost you " + nextUpgradeCost() + " skill point.\n" : "You can no longer advance in this line");
    }

    @Override
    protected int totalSpent()
    {
        return Dungeon.hero.heroSkills.totalSpent(CurrentSkills.BRANCHES.PASSIVEA);
    }

    @Override
    protected int nextUpgradeCost()
    {
        return Dungeon.hero.heroSkills.nextUpgradeCost(CurrentSkills.BRANCHES.PASSIVEA);
    }

    @Override
    protected boolean canUpgrade()
    {
        return Dungeon.hero.heroSkills.canUpgrade(CurrentSkills.BRANCHES.PASSIVEA);
    }
}
