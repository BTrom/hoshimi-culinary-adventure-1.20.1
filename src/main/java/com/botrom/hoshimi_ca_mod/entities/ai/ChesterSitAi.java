package com.botrom.hoshimi_ca_mod.entities.ai;

import com.botrom.hoshimi_ca_mod.entities.Chester;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.goal.SitWhenOrderedToGoal;

public class ChesterSitAi extends SitWhenOrderedToGoal {
    private final Chester chester;

    public ChesterSitAi(Chester chester) {
        super(chester);
        this.chester = chester;
    }
}
