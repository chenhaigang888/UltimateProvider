package com.chg.ultimateproviderdemo.slice.ViewHolder;

import com.chg.ultimateprovider.EventTransmissionListener;
import com.chg.ultimateprovider.UltimateProvider;
import com.chg.ultimateprovider.ViewHolder;
import com.chg.ultimateproviderdemo.ResourceTable;
import com.chg.ultimateproviderdemo.slice.model.GroupBean;

import ohos.agp.components.Component;
import ohos.agp.components.ListContainer;
import ohos.agp.components.Text;

import java.util.ArrayList;

public class GroupViewHolder extends ViewHolder<GroupBean> {
    private ListContainer listContainer;
    private Text groupName;
    private UltimateProvider itemProvider;

    public GroupViewHolder(EventTransmissionListener eventTransmissionListener, Component component) {
        super(eventTransmissionListener, component);
        listContainer = (ListContainer) findComponentById(ResourceTable.Id_listContainer);
        groupName = (Text) findComponentById(ResourceTable.Id_groupName);
        itemProvider = new UltimateProvider(new ArrayList(),getContext());
        itemProvider.setEventTransmissionListener(getEventTransmissionListener());
    }

    @Override
    public void onBindModel() {

        groupName.setText(getModel().getName());
        itemProvider.setModels(getModel().getFriends());
        listContainer.setItemProvider(itemProvider);
    }
}
