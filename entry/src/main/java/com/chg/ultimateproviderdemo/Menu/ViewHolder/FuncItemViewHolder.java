package com.chg.ultimateproviderdemo.Menu.ViewHolder;

import com.chg.ultimateprovider.EventTransmissionListener;
import com.chg.ultimateprovider.UltimateProvider;
import com.chg.ultimateprovider.ViewHolder;
import com.chg.ultimateproviderdemo.Menu.Model.FuncItem;
import com.chg.ultimateproviderdemo.Menu.Model.FunctionArea;
import com.chg.ultimateproviderdemo.ResourceTable;
import ohos.agp.components.Component;
import ohos.agp.components.Image;
import ohos.agp.components.Text;

import java.util.ArrayList;
import java.util.List;

public class FuncItemViewHolder extends ViewHolder<FuncItem> {

    private Text funcName;
    private Image funcIcon;


    /**
     * 构造方法
     *
     * @param eventTransmissionListener 事件传输对象
     * @param component                 component
     * @param provider                  provider
     */
    public FuncItemViewHolder(EventTransmissionListener eventTransmissionListener, Component component, UltimateProvider provider) {
        super(eventTransmissionListener, component, provider);
        funcName = (Text) findComponentById(ResourceTable.Id_funcName);
        funcIcon = (Image) findComponentById(ResourceTable.Id_funcIcon);
    }

    @Override
    public void onDataBound() {
        funcName.setText(getModel().getName());
        funcIcon.setImageAndDecodeBounds(getModel().getIcon());
    }


}
