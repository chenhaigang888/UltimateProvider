package com.chg.ultimateproviderdemo.Menu.Slice;

import com.github.chenhaigang888.UltimateProvider;
import com.chg.ultimateproviderdemo.Menu.Model.SongModel;
import com.chg.ultimateproviderdemo.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.ListContainer;

import java.util.ArrayList;
import java.util.List;

public class SongSlice extends AbilitySlice {

    private ListContainer listContainer;

    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_song);
        listContainer = (ListContainer) findComponentById(ResourceTable.Id_listContainer);
        listContainer.setItemProvider(new UltimateProvider(getSongs(),getContext()));
    }

    List getSongs(){
        List list = new ArrayList();
        for (int i=0; i<100; i++) {
            list.add(new SongModel("歌曲名称："+i,"歌手："+i));
        }
        return list;
    }
}
