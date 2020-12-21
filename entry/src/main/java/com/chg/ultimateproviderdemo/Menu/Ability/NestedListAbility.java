package com.chg.ultimateproviderdemo.Menu.Ability;

import com.chg.ultimateproviderdemo.Menu.Slice.NestedListSlice;
import com.chg.ultimateproviderdemo.Menu.Slice.RecommendSlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;

public class NestedListAbility extends Ability {

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(NestedListSlice.class.getName());
    }
}
