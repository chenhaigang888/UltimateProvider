package com.chg.ultimateproviderdemo.slice.ViewHolder;

import com.chg.ultimateprovider.EventTransmissionListener;
import com.chg.ultimateprovider.UltimateProvider;
import com.chg.ultimateprovider.ViewHolder;
import com.chg.ultimateproviderdemo.ResourceTable;
import com.chg.ultimateproviderdemo.slice.model.MenuItem;
import ohos.agp.components.Component;
import ohos.agp.components.Text;

public class MenuItemViewHolder extends ViewHolder<MenuItem> {

    private Text title;
    private Text desc;

    public MenuItemViewHolder(EventTransmissionListener eventTransmissionListener, Component component, UltimateProvider provider) {
        super(eventTransmissionListener, component,provider);
        title = (Text) findComponentById(ResourceTable.Id_title);
        desc = (Text) findComponentById(ResourceTable.Id_desc);
    }

    @Override
    public void onDataBound() {
        title.setText(getModel().getTitle());
        desc.setText(getModel().getDesc());
    }

}
