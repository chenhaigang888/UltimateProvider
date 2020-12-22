package com.chg.ultimateproviderdemo.Menu.ViewHolder;

import com.chg.ultimateprovider.EventTransmissionListener;
import com.chg.ultimateprovider.UltimateProvider;
import com.chg.ultimateprovider.ViewHolder;
import com.chg.ultimateproviderdemo.Menu.Model.InputBoxModel;
import com.chg.ultimateproviderdemo.ResourceTable;
import ohos.agp.components.Component;
import ohos.agp.components.Text;
import ohos.agp.components.TextField;
import ohos.agp.components.element.Element;

public class InputBoxViewHolder extends ViewHolder<InputBoxModel> {

    private Text title;
    private TextField textField;

    public InputBoxViewHolder(EventTransmissionListener eventTransmissionListener, Component component, UltimateProvider provider) {
        super(eventTransmissionListener, component, provider);
        title = (Text) findComponentById(ResourceTable.Id_title);
        textField = (TextField) findComponentById(ResourceTable.Id_textField);


    }

    @Override
    public void onDataBound() {
        title.setText(getModel().getTitle());
        textField.setText(getModel().getInputResult());//这里设置输入的内容主要是当页面滚动的时候更新输入内容
        textField.setHint(getModel().getHint());

    }
}
