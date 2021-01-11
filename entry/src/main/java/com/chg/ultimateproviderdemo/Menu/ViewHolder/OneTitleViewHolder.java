package com.chg.ultimateproviderdemo.Menu.ViewHolder;

import com.github.chenhaigang888.EventTransmissionListener;
import com.github.chenhaigang888.UltimateProvider;
import com.github.chenhaigang888.ViewHolder;
import com.chg.ultimateproviderdemo.Menu.Model.OneTitleModel;
import com.chg.ultimateproviderdemo.ResourceTable;
import ohos.agp.components.Component;
import ohos.agp.components.ComponentContainer;
import ohos.agp.components.Text;

public class OneTitleViewHolder extends ViewHolder<OneTitleModel> {
    private Text text;
    public OneTitleViewHolder(EventTransmissionListener eventTransmissionListener, Component component, UltimateProvider provider, ComponentContainer componentContainer) {
        super(eventTransmissionListener, component, provider, componentContainer);
        text = (Text) findComponentById(ResourceTable.Id_title);
    }

    @Override
    public void onDataBound() {
        text.setText(getModel().getTitle());
    }
}
