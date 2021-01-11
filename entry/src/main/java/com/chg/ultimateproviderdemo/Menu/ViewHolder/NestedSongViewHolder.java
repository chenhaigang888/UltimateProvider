package com.chg.ultimateproviderdemo.Menu.ViewHolder;

import com.github.chenhaigang888.EventTransmissionListener;
import com.github.chenhaigang888.UltimateProvider;
import com.github.chenhaigang888.ViewHolder;
import com.chg.ultimateproviderdemo.Menu.Model.NestedSongModel;
import com.chg.ultimateproviderdemo.ResourceTable;
import ohos.agp.components.Component;
import ohos.agp.components.ComponentContainer;
import ohos.agp.components.Image;
import ohos.agp.components.Text;

public class NestedSongViewHolder extends ViewHolder<NestedSongModel> {
    private Image icon;
    private Text songName;
    private Text songer;

    public NestedSongViewHolder(EventTransmissionListener eventTransmissionListener, Component component, UltimateProvider provider, ComponentContainer componentContainer) {
        super(eventTransmissionListener, component, provider, componentContainer);
        icon = (Image) findComponentById(ResourceTable.Id_icon);
        songName = (Text) findComponentById(ResourceTable.Id_songName);
        songer = (Text) findComponentById(ResourceTable.Id_songer);
    }

    @Override
    public void onDataBound() {
        songName.setText(getModel().getName());
        songer.setText(getModel().getSinger());
    }
}
