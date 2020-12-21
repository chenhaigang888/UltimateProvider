package com.chg.ultimateprovider;

import ohos.agp.components.Component;
import ohos.agp.components.ComponentContainer;
import ohos.agp.components.LayoutScatter;
import ohos.agp.components.RecycleItemProvider;
import ohos.app.Context;
import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class UltimateProvider<M extends Model> extends RecycleItemProvider {
    /*当前Provider需要的数据*/
    private List<M> models;
    private Context context;
    /*根据自己的需求存放的自定义数据*/
    private Object customData;
    /*ItemView中的事件传递到Ability,Slice中的回掉*/
    private EventTransmissionListener eventTransmissionListener;

    public Object getCustomData() {
        return customData;
    }

    public void setCustomData(Object customData) {
        this.customData = customData;
    }

    public List<M> getModels() {
        return models;
    }

    public void setModels(List<M> models) {
        this.models = models;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public EventTransmissionListener getEventTransmissionListener() {
        return eventTransmissionListener;
    }

    public void setEventTransmissionListener(EventTransmissionListener eventTransmissionListener) {
        this.eventTransmissionListener = eventTransmissionListener;
    }

    public UltimateProvider(List<M> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public Object getItem(int i) {
        return models.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    static final HiLogLabel label = new HiLogLabel(HiLog.LOG_APP, 0x00201, "MY_TAG");

    @Override
    public void onItemMoved(int from, int to) {
        super.onItemMoved(from, to);
        HiLog.info(label,"chg from:"+from+   "   to:"+to);
    }

    private ViewHolder createViewHolder(int position){
        M model = models.get(position);
        ViewHolder viewHolder = null;
        Component component = LayoutScatter.getInstance(context).parse(model.getResources(position),null,false);
        try {
            Constructor c2 = model.getHolderClass(position).getDeclaredConstructor( EventTransmissionListener.class,Component.class);
            viewHolder = (ViewHolder) c2.newInstance(getEventTransmissionListener(),component);
            component.setTag(viewHolder);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return viewHolder;
    }

    @Override
    public Component getComponent(int i, Component component, ComponentContainer componentContainer) {
        ViewHolder viewHolder = null;
        M model = models.get(i);
        if (component == null) {
            viewHolder = createViewHolder(i);
        } else {
            viewHolder = (ViewHolder) component.getTag();
            if (!viewHolder.getClass().equals(model.getHolderClass(i))) {
                viewHolder = createViewHolder(i);
            }
        }
        viewHolder.setModel(model);
        viewHolder.onBindModel();
        return viewHolder.getComponent();
    }
}
