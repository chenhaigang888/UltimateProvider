package com.chg.ultimateproviderdemo.Menu.ViewHolder;

import com.chg.ultimateprovider.EventTransmissionListener;
import com.chg.ultimateprovider.UltimateProvider;
import com.chg.ultimateprovider.ViewHolder;
import com.chg.ultimateproviderdemo.Menu.CustomData.LoginData;
import com.chg.ultimateproviderdemo.Menu.Model.SubmitBtnModel;
import com.chg.ultimateproviderdemo.ResourceTable;
import ohos.agp.components.Button;
import ohos.agp.components.Component;
import ohos.agp.components.ComponentContainer;
import ohos.agp.window.dialog.ToastDialog;

public class SubmitBtnViewHolder extends ViewHolder<SubmitBtnModel> {
    private Button btn;
    public SubmitBtnViewHolder(EventTransmissionListener eventTransmissionListener, Component component, UltimateProvider provider, ComponentContainer componentContainer) {
        super(eventTransmissionListener, component, provider, componentContainer);
        btn = (Button) findComponentById(ResourceTable.Id_btn);

        btn.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                LoginData loginData = (LoginData) getCustomData();
                new ToastDialog(getContext()).setText("用户名："+loginData.getUsername()+ "   密码："+loginData.getPassword()).show();
                eventTransmission(SubmitBtnViewHolder.this,getModel(),1,null);
            }
        });
    }

    @Override
    public void onDataBound() {
        btn.setText(getModel().getBtnText());
    }
}
