package com.chg.ultimateproviderdemo.Menu.Slice;

import com.chg.ultimateprovider.EventTransmissionListener;
import com.chg.ultimateprovider.UltimateProvider;
import com.chg.ultimateproviderdemo.Menu.CustomData.LoginData;
import com.chg.ultimateproviderdemo.Menu.Model.InputBoxModel;
import com.chg.ultimateproviderdemo.Menu.Model.OneTitleModel;
import com.chg.ultimateproviderdemo.Menu.Model.SubmitBtnModel;
import com.chg.ultimateproviderdemo.Menu.ViewHolder.InputBoxViewHolder;
import com.chg.ultimateproviderdemo.Menu.ViewHolder.OneTitleViewHolder;
import com.chg.ultimateproviderdemo.Menu.ViewHolder.SubmitBtnViewHolder;
import com.chg.ultimateproviderdemo.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.ListContainer;

import java.util.ArrayList;
import java.util.List;

/**
 * 做一个登录页面来演示 在ItemView，slice之间共享数据。这个主要颜色数据共享，并不一定要这么做。具体还是要看自己的需求
 */
public class CustomDataUserSlice extends AbilitySlice {

    private ListContainer listContainer;
    private UltimateProvider ultimateProvider;
    private LoginData loginData = new LoginData();//用于存放用户名及密码

    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_custom_data_use);
        listContainer = (ListContainer) findComponentById(ResourceTable.Id_listContainer);
        ultimateProvider = new UltimateProvider(getData(),getContext());
        listContainer.setItemProvider(ultimateProvider);
        ultimateProvider.setCustomData(loginData);//演示设置自定义数据，这里主要记录输入的用户名和密码
    }

    public List getData() {
        List list = new ArrayList();
        list.add(new OneTitleModel("登录"));
        list.add(new InputBoxModel("用户名：","","请输入用户名",false));
        list.add(new InputBoxModel("密码：","","请输入密码",true));
        list.add(new SubmitBtnModel("登录"));
        return list;
    }


}
