package com.chg.ultimateproviderdemo.Menu.ViewHolder;

import com.chg.ultimateprovider.EventTransmissionListener;
import com.chg.ultimateprovider.UltimateProvider;
import com.chg.ultimateprovider.ViewHolder;
import com.chg.ultimateproviderdemo.Menu.Model.MusicModel;
import com.chg.ultimateproviderdemo.ResourceTable;
import ohos.agp.components.Component;
import ohos.agp.components.ListContainer;
import ohos.agp.components.Text;

public class MusicViewHolder extends ViewHolder<MusicModel> {

    private Text title;
    private ListContainer listContainer;
    private UltimateProvider ultimateProvider;

    public MusicViewHolder(EventTransmissionListener eventTransmissionListener, Component component,UltimateProvider provider) {
        super(eventTransmissionListener, component,provider);
        title = (Text) findComponentById(ResourceTable.Id_title);
        listContainer = (ListContainer) findComponentById(ResourceTable.Id_listContainer);
        ultimateProvider = new UltimateProvider(null,getContext());
    }

    @Override
    public void onBindModel() {
        title.setText(getModel().getTitle());
        ultimateProvider.setModels(getModel().getData());
        listContainer.setItemProvider(ultimateProvider);
    }
}
