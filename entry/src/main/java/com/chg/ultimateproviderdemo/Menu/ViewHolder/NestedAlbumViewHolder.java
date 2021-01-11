package com.chg.ultimateproviderdemo.Menu.ViewHolder;

import com.github.chenhaigang888.EventTransmissionListener;
import com.github.chenhaigang888.UltimateProvider;
import com.github.chenhaigang888.ViewHolder;
import com.chg.ultimateproviderdemo.Menu.Model.NestedAlbumModel;
import com.chg.ultimateproviderdemo.ResourceTable;
import ohos.agp.components.Component;
import ohos.agp.components.ComponentContainer;
import ohos.agp.components.Image;
import ohos.agp.components.Text;

public class NestedAlbumViewHolder extends ViewHolder<NestedAlbumModel> {

    private Image icon;
    private Text name;
    private Text songer;

    public NestedAlbumViewHolder(EventTransmissionListener eventTransmissionListener, Component component, UltimateProvider provider, ComponentContainer componentContainer) {
        super(eventTransmissionListener, component, provider, componentContainer);
        icon = (Image) findComponentById(ResourceTable.Id_icon);
        name = (Text) findComponentById(ResourceTable.Id_name);
        songer = (Text) findComponentById(ResourceTable.Id_songer);
    }

    @Override
    public void onDataBound() {
        name.setText(getModel().getName());
        songer.setText(getModel().getSonger());
    }
}