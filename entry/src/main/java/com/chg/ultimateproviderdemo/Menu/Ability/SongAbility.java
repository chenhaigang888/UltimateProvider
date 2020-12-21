package com.chg.ultimateproviderdemo.Menu.Ability;

import com.chg.ultimateproviderdemo.Menu.Slice.SongSlice;
import com.chg.ultimateproviderdemo.slice.MainAbilitySlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;

public class SongAbility extends Ability {

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(SongSlice.class.getName());
    }
}
