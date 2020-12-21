package com.chg.ultimateproviderdemo.Menu.Ability;

import com.chg.ultimateproviderdemo.Menu.Slice.RecommendSlice;
import com.chg.ultimateproviderdemo.Menu.Slice.SongSlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;

public class RecommendAbility extends Ability {

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(RecommendSlice.class.getName());
    }
}
