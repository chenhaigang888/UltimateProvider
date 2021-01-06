package com.chg.ultimateproviderdemo.Menu.ViewHolder;

import com.chg.ultimateprovider.EventTransmissionListener;
import com.chg.ultimateprovider.Model;
import com.chg.ultimateprovider.UltimateProvider;
import com.chg.ultimateprovider.ViewHolder;
import com.chg.ultimateproviderdemo.Menu.Model.FunctionArea;
import com.chg.ultimateproviderdemo.ResourceTable;
import ohos.agp.components.Component;
import ohos.agp.components.ListContainer;

public class HorizontalScrollViewHolder extends ViewHolder<Model> {
    private ListContainer listContainer;
    /**
     * 构造方法
     *
     * @param eventTransmissionListener 事件传输对象
     * @param component                 component
     * @param provider                  provider
     */
    public HorizontalScrollViewHolder(EventTransmissionListener eventTransmissionListener, Component component, UltimateProvider provider) {
        super(eventTransmissionListener, component, provider);
        listContainer = (ListContainer) findComponentById(ResourceTable.Id_list);
    }

    @Override
    public void onDataBound() {
        if (getModel() instanceof FunctionArea) {
            FunctionArea functionArea = (FunctionArea) getModel();
            listContainer.setItemProvider(new UltimateProvider(functionArea.getFuncItems(),getContext()));
        }
    }

}
