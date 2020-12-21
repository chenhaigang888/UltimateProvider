package com.chg.ultimateproviderdemo.slice.ViewHolder;


import com.chg.ultimateprovider.EventTransmissionListener;
import com.chg.ultimateprovider.ViewHolder;
import com.chg.ultimateproviderdemo.ResourceTable;
import com.chg.ultimateproviderdemo.slice.model.UserBean;
import ohos.agp.components.Component;
import ohos.agp.components.Text;



public class UserViewHolder extends ViewHolder<UserBean> {
    private Text text;

    public UserViewHolder(EventTransmissionListener eventTransmissionListener, Component component) {
        super(eventTransmissionListener, component);
        text = (Text) findComponentById(ResourceTable.Id_name);
    }

    @Override
    public void onBindModel() {
        text.setText(getModel().getName());
    }
}
