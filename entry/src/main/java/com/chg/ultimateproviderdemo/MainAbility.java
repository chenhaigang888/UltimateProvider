package com.chg.ultimateproviderdemo;

import com.chg.ultimateproviderdemo.slice.MainAbilitySlice;
import com.github.boxuanjia.toycar.ToyCar;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;

public class MainAbility extends Ability {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(MainAbilitySlice.class.getName());
        ToyCar.initialize(getContext());
    }
}
