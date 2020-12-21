package com.chg.ultimateprovider;

import ohos.agp.components.Component;
import ohos.agp.components.ListContainer;
import ohos.app.Context;

import java.util.List;

public abstract class ViewHolder<M extends Model> {
    private M model;
    private EventTransmissionListener eventTransmissionListener;
    private Component component;


    public ViewHolder(EventTransmissionListener eventTransmissionListener, Component component) {
        this.eventTransmissionListener = eventTransmissionListener;
        this.component = component;
    }

    public M getModel() {
        return model;
    }

    public void setModel(M model) {
        this.model = model;
    }

     public abstract void onBindModel();

    public EventTransmissionListener getEventTransmissionListener() {
        return eventTransmissionListener;
    }

    public void setEventTransmissionListener(EventTransmissionListener eventTransmissionListener) {
        this.eventTransmissionListener = eventTransmissionListener;
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

    public Component getParent(){
        return (Component) getComponent().getComponentParent();
    }

    public ListContainer getListContainer(){
        return (ListContainer) getParent();
    }

    public UltimateProvider getItemProvider(){
        return (UltimateProvider) getListContainer().getItemProvider();
    }

    public Object getCustomData(){
        return getItemProvider().getCustomData();
    }

    public List getList(){
        return getItemProvider().getModels();
    }

    public Component findComponentById(int id){
        return getComponent().findComponentById(id);
    }
}
