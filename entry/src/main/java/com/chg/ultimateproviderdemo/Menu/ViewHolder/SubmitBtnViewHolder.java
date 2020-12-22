package com.chg.ultimateproviderdemo.Menu.ViewHolder;

import com.chg.ultimateprovider.EventTransmissionListener;
import com.chg.ultimateprovider.UltimateProvider;
import com.chg.ultimateprovider.ViewHolder;
import com.chg.ultimateproviderdemo.Menu.Model.SubmitBtnModel;
import com.chg.ultimateproviderdemo.ResourceTable;
import ohos.agp.components.Button;
import ohos.agp.components.Component;

public class SubmitBtnViewHolder extends ViewHolder<SubmitBtnModel> {
    private Button btn;
    public SubmitBtnViewHolder(EventTransmissionListener eventTransmissionListener, Component component, UltimateProvider provider) {
        super(eventTransmissionListener, component, provider);
        btn = (Button) findComponentById(ResourceTable.Id_btn);
    }

    @Override
    public void onDataBound() {
        btn.setText(getModel().getBtnText());
    }
}
