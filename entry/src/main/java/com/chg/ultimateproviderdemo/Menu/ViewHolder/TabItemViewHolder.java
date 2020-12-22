package com.chg.ultimateproviderdemo.Menu.ViewHolder;

import com.chg.ultimateprovider.EventTransmissionListener;
import com.chg.ultimateprovider.UltimateProvider;
import com.chg.ultimateprovider.ViewHolder;
import com.chg.ultimateproviderdemo.Menu.Model.TabItem;
import com.chg.ultimateproviderdemo.ResourceTable;
import ohos.agp.components.Component;
import ohos.agp.components.Text;

public class TabItemViewHolder extends ViewHolder<TabItem> {
    private Text text;
    public TabItemViewHolder(EventTransmissionListener eventTransmissionListener, Component component, UltimateProvider provider) {
        super(eventTransmissionListener, component, provider);
        text = (Text) findComponentById(ResourceTable.Id_title);
    }

    @Override
    public void onDataBound() {
        text.setText(getModel().getName());
    }
}
