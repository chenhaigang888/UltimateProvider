package com.chg.ultimateproviderdemo.Menu.ViewHolder;

import com.chg.ultimateprovider.EventTransmissionListener;
import com.chg.ultimateprovider.UltimateProvider;
import com.chg.ultimateprovider.ViewHolder;
import com.chg.ultimateproviderdemo.Menu.CustomData.LoginData;
import com.chg.ultimateproviderdemo.Menu.Model.InputBoxModel;
import com.chg.ultimateproviderdemo.ResourceTable;
import ohos.agp.components.Component;
import ohos.agp.components.Text;
import ohos.agp.components.TextField;
import ohos.agp.components.element.Element;
import ohos.multimodalinput.event.KeyEvent;

public class InputBoxViewHolder extends ViewHolder<InputBoxModel> {

    private Text title;
    private TextField textField;

    public InputBoxViewHolder(EventTransmissionListener eventTransmissionListener, Component component, UltimateProvider provider) {
        super(eventTransmissionListener, component, provider);
        title = (Text) findComponentById(ResourceTable.Id_title);
        textField = (TextField) findComponentById(ResourceTable.Id_textField);

        //监听输入框焦点发生变化
        textField.setFocusChangedListener(new Component.FocusChangedListener() {
            @Override
            public void onFocusChange(Component component, boolean b) {
                LoginData loginData = (LoginData) getCustomData();
                if (getModel().isPassword()) {//如果输入是密码
                    loginData.setPassword(textField.getText());
                } else {
                    loginData.setUsername(textField.getText());
                }
                getModel().setInputResult(textField.getText());//输入内容保存在当前模型中，滚动的时候会更新内容
                //焦点改变后将事件传递到activity中。
                eventTransmission(InputBoxViewHolder.this,textField.getText(),getModel().isPassword()? 1 : 2,null);
            }
        });
    }

    @Override
    public void onDataBound() {
        title.setText(getModel().getTitle());
        textField.setText(getModel().getInputResult());//这里设置输入的内容主要是当页面滚动的时候更新输入内容
        textField.setHint(getModel().getHint());
    }
}
