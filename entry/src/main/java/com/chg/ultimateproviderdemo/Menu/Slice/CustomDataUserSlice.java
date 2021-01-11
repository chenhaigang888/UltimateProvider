package com.chg.ultimateproviderdemo.Menu.Slice;

import com.github.chenhaigang888.EventTransmissionListener;
import com.github.chenhaigang888.UltimateProvider;
import com.chg.ultimateproviderdemo.Menu.CustomData.LoginData;
import com.chg.ultimateproviderdemo.Menu.Model.*;
import com.chg.ultimateproviderdemo.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.ListContainer;

import java.util.ArrayList;
import java.util.List;

/**
 * 做一个登录页面来演示 在ItemView，slice之间共享数据。这个主要颜色数据共享，并不一定要这么做。具体还是要看自己的需求
 */
public class CustomDataUserSlice extends AbilitySlice implements EventTransmissionListener{

    private ListContainer listContainer;
    private UltimateProvider ultimateProvider;
    private LoginData loginData = new LoginData();//用于存放用户名及密码

    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_custom_data_use);
        listContainer = (ListContainer) findComponentById(ResourceTable.Id_listContainer);
        ultimateProvider = new UltimateProvider(getAllView(),getContext());
        listContainer.setItemProvider(ultimateProvider);
        ultimateProvider.setCustomData(loginData);//演示设置自定义数据，这里主要记录输入的用户名和密码
        ultimateProvider.setEventTransmissionListener(this);
    }


    /**
     * 同时显示登录和身份证验证界面
     * @return
     */
    public List getAllView() {
        List list = new ArrayList();
//        list.add(new FuncChangeModel(getTabItems()));
        list.add(new OneTitleModel("登录"));
        list.add(new InputBoxModel("用户名：","","请输入用户名",false));
        list.add(new InputBoxModel("密码：","","请输入密码",true));
        list.add(new SubmitBtnModel("登录"));

//        list.add(new OneTitleModel("其他信息输入"));
//        list.add(new InputBoxModel("身份证：","","请输省份证",true));
//        list.add(new SubmitBtnModel("验证"));
        return list;
    }

//    /**
//     * 显示登录界面
//     * @return
//     */
//    public List getLoginView() {
//        List list = new ArrayList();
//        list.add(new FuncChangeModel(getTabItems()));
//        list.add(new OneTitleModel("登录"));
//        list.add(new InputBoxModel("用户名：","","请输入用户名",false));
//        list.add(new InputBoxModel("密码：","","请输入密码",true));
//        list.add(new SubmitBtnModel("登录"));
//        return list;
//    }

//    /**
//     * 显示输入身份证页面
//     * @return
//     */
//    public List getIdView() {
//        List list = new ArrayList();
//        list.add(new FuncChangeModel(getTabItems()));
//        list.add(new OneTitleModel("其他信息输入"));
//        list.add(new InputBoxModel("身份证：","","请输省份证",true));
//        list.add(new SubmitBtnModel("验证"));
//        return list;
//    }
//
//    public List<TabItem> getTabItems(){
//        List list = new ArrayList();
//        list.add(new TabItem(1,"显示登录和身份验证页面"));
//        list.add(new TabItem(2,"显示登录页面"));
//        list.add(new TabItem(3,"显示身份验证页面"));
//        return list;
//    }
//
    @Override
    public Object onEventTransmission(Object target, Object params, int eventId, CallBack callBack) {
//        if (target instanceof FuncChangeViewHolder) {//功能切换
//            if (eventId == 1) {//功能项目被点击
//                showPage(target,params,eventId,callBack);
//            }
//        }
        return null;
    }
//
//    public void showPage(Object target, Object params, int eventId, CallBack callBack) {
//        TabItem tabItem = (TabItem) params;
//        int id = tabItem.getId();
//        if (id == 1) {//显示登录和身份验证页面
//            ultimateProvider.setModels(getAllView());
//        } else if (id == 2) {
//            ultimateProvider.setModels(getLoginView());
//        } else if(id == 3){
//            ultimateProvider.setModels(getIdView());
//        }
//        ultimateProvider.notifyDataChanged();
//    }
}
