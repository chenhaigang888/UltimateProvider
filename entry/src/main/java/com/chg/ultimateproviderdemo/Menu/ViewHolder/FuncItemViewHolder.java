package com.chg.ultimateproviderdemo.Menu.ViewHolder;

import com.github.chenhaigang888.EventTransmissionListener;
import com.github.chenhaigang888.UltimateProvider;
import com.github.chenhaigang888.ViewHolder;
import com.chg.ultimateproviderdemo.Menu.Model.FuncItem;
import com.chg.ultimateproviderdemo.ResourceTable;
import ohos.agp.components.Component;
import ohos.agp.components.ComponentContainer;
import ohos.agp.components.Image;
import ohos.agp.components.Text;

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
    public FuncItemViewHolder(EventTransmissionListener eventTransmissionListener, Component component, UltimateProvider provider, ComponentContainer componentContainer) {
        super(eventTransmissionListener, component, provider, componentContainer);
        funcName = (Text) findComponentById(ResourceTable.Id_funcName);
        funcIcon = (Image) findComponentById(ResourceTable.Id_funcIcon);
    }

    @Override
    public void onDataBound() {
        funcName.setText(getModel().getName());
        funcIcon.setImageAndDecodeBounds(getModel().getIcon());
    }


}
