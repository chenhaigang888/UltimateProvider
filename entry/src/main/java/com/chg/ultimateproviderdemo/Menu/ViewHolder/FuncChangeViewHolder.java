package com.chg.ultimateproviderdemo.Menu.ViewHolder;

import com.chg.ultimateprovider.EventTransmissionListener;
import com.chg.ultimateprovider.UltimateProvider;
import com.chg.ultimateprovider.ViewHolder;
import com.chg.ultimateproviderdemo.Menu.Model.FuncChangeModel;
import com.chg.ultimateproviderdemo.ResourceTable;
import ohos.agp.components.Component;
import ohos.agp.components.ListContainer;

public class FuncChangeViewHolder extends ViewHolder<FuncChangeModel> {
    private ListContainer listContainer;
    private UltimateProvider ultimateProvider ;
    public FuncChangeViewHolder(EventTransmissionListener eventTransmissionListener, Component component, UltimateProvider provider) {
        super(eventTransmissionListener, component, provider);
        listContainer = (ListContainer) findComponentById(ResourceTable.Id_listContainer);
        ultimateProvider = new UltimateProvider(null,getContext());
        listContainer.setItemClickedListener(new ListContainer.ItemClickedListener() {
            @Override
            public void onItemClicked(ListContainer listContainer, Component component, int i, long l) {
                eventTransmission(FuncChangeViewHolder.this,listContainer.getItemProvider().getItem(i),1,null);
            }
        });
    }

    @Override
    public void onDataBound() {
        ultimateProvider.setModels(getModel().getTabs());
        listContainer.setItemProvider(ultimateProvider);
    }
}
