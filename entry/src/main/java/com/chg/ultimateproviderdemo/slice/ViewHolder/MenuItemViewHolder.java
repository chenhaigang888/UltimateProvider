package com.chg.ultimateproviderdemo.slice.ViewHolder;

import com.github.chenhaigang888.EventTransmissionListener;
import com.github.chenhaigang888.UltimateProvider;
import com.github.chenhaigang888.ViewHolder;
import com.chg.ultimateproviderdemo.ResourceTable;
import com.chg.ultimateproviderdemo.slice.model.MenuItem;
import ohos.agp.components.Component;
import ohos.agp.components.ComponentContainer;
import ohos.agp.components.Text;

public class MenuItemViewHolder extends ViewHolder<MenuItem> {

    private Text title;
    private Text desc;

    /**
     * 构造方法
     *
     * @param eventTransmissionListener 事件传输对象
     * @param component                 component
     * @param provider                  provider
     * @param componentContainer
     */
    public MenuItemViewHolder(EventTransmissionListener eventTransmissionListener, Component component, UltimateProvider provider, ComponentContainer componentContainer) {
        super(eventTransmissionListener, component, provider, componentContainer);
        title = (Text) findComponentById(ResourceTable.Id_title);
        desc = (Text) findComponentById(ResourceTable.Id_desc);
    }


    @Override
    public void onDataBound() {
        title.setText(getModel().getTitle());
        desc.setText(getModel().getDesc());
    }

}
