package com.chg.ultimateprovider;

import ohos.agp.components.Component;
import ohos.app.Context;

import java.util.List;

public abstract class ViewHolder<M extends Model> {
    /*ViewHolder对应的数据*/
    private M model;
    /*传递事件到外部（Slice）*/
    private EventTransmissionListener eventTransmissionListener;
    /*对应的布局视图*/
    private Component component;
    /*当前对应的provider*/
    private UltimateProvider provider;
    private int position;

    public ViewHolder(EventTransmissionListener eventTransmissionListener, Component component,UltimateProvider provider) {
        this.eventTransmissionListener = eventTransmissionListener;
        this.component = component;
        this.provider = provider;
    }

    /**
     * 当数据已经绑定到ViewMolder。应该在这里给UI控件设置数据
     */
    public abstract void onDataBound();

    public M getModel() {
        return model;
    }

    public void setModel(M model) {
        this.model = model;
    }

    public EventTransmissionListener getEventTransmissionListener() {
        return eventTransmissionListener;
    }

    public void setEventTransmissionListener(EventTransmissionListener eventTransmissionListener) {
        this.eventTransmissionListener = eventTransmissionListener;
    }

    public UltimateProvider getProvider() {
        return provider;
    }

    public void setProvider(UltimateProvider provider) {
        this.provider = provider;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    public Context getContext(){
        return component.getContext();
    }

    public Object getCustomData(){
        return getProvider().getCustomData();
    }

    public List getList(){
        return getProvider().getModels();
    }

    public Component findComponentById(int id){
        return getComponent().findComponentById(id);
    }

    /**
     * 更新当前ItemView
     */
    public void notifyCurrentDataSetItemChanged(){
        getProvider().notifyDataSetItemChanged(getPosition());
    }


}
