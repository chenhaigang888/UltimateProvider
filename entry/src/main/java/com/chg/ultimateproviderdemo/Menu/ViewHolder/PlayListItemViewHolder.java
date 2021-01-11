package com.chg.ultimateproviderdemo.Menu.ViewHolder;

import com.github.chenhaigang888.EventTransmissionListener;
import com.github.chenhaigang888.UltimateProvider;
import com.github.chenhaigang888.ViewHolder;
import com.chg.ultimateproviderdemo.Menu.Model.PlayListItemModel;
import com.chg.ultimateproviderdemo.ResourceTable;
import ohos.agp.components.Component;
import ohos.agp.components.ComponentContainer;
import ohos.agp.components.Image;
import ohos.agp.components.Text;

public class PlayListItemViewHolder extends ViewHolder<PlayListItemModel> {
    private Image icon;
    private Text name;
    private Text songer;
    private Text love;
    private Text collection;
    private Text play;

    public PlayListItemViewHolder(EventTransmissionListener eventTransmissionListener, Component component, UltimateProvider provider, ComponentContainer componentContainer) {
        super(eventTransmissionListener, component, provider, componentContainer);
        icon = (Image) findComponentById(ResourceTable.Id_icon);
        name = (Text) findComponentById(ResourceTable.Id_name);
        songer = (Text) findComponentById(ResourceTable.Id_songer);
        love = (Text) findComponentById(ResourceTable.Id_love);
        collection = (Text) findComponentById(ResourceTable.Id_collection);
        play = (Text) findComponentById(ResourceTable.Id_play);

        love.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                //内容处理点击事件
                getModel().setLove(!getModel().isLove());//这里把状态存储在数据中，可以根据需求将状态存储在provider中的自定义数据中。具体使用方式可以查看CustomData的使用
                notifyCurrentDataSetItemChanged();
            }
        });

        play.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                //将事件传递到Slice中然后同步返回结果
                boolean play = (boolean) getEventTransmissionListener().onEventTransmission(PlayListItemViewHolder.this, getModel().isPlay(),1,null);
                getModel().setPlay(play);//这里把状态存储在数据中，可以根据需求将状态存储在provider中的自定义数据中。具体使用方式可以查看CustomData的使用
                notifyCurrentDataSetItemChanged();
            }
        });

        collection.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                //此次演示异步返回数据更新状态
                getEventTransmissionListener().onEventTransmission(PlayListItemViewHolder.this, getModel().isCollection(), 2, new EventTransmissionListener.CallBack() {
                    @Override
                    public Object callBack(Object object) {
                        boolean collection = (boolean) object;//这里activity中应该返回boolean类型以适合这里需要的数据
                        getModel().setCollection(collection);//这里把状态存储在数据中，可以根据需求将状态存储在provider中的自定义数据中。具体使用方式可以查看CustomData的使用
                        notifyCurrentDataSetItemChanged();
                        return null;
                    }
                });
            }
        });
    }

    @Override
    public void onDataBound() {
        name.setText(getModel().getName());
        songer.setText(getModel().getSonger());
        // 为了节约时间 以下状态使用文字代替图片。
        love.setText(getModel().isLove() ? "喜欢":"未喜欢");
        collection.setText(getModel().isCollection() ? "收藏":"未收藏");
        play.setText(getModel().isPlay() ? "播放":"未播放");
    }
}
