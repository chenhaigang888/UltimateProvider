package com.chg.ultimateproviderdemo.Menu.ViewHolder;

import com.chg.ultimateprovider.EventTransmissionListener;
import com.chg.ultimateprovider.UltimateProvider;
import com.chg.ultimateprovider.ViewHolder;
import com.chg.ultimateproviderdemo.Menu.Model.PlayListItemModel;
import com.chg.ultimateproviderdemo.ResourceTable;
import ohos.agp.components.Component;
import ohos.agp.components.Image;
import ohos.agp.components.Text;

public class PlayListItemViewHolder extends ViewHolder<PlayListItemModel> {
    private Image icon;
    private Text name;
    private Text songer;
    private Text love;
    private Text collection;
    private Text play;

    public PlayListItemViewHolder(EventTransmissionListener eventTransmissionListener, Component component,UltimateProvider provider) {
        super(eventTransmissionListener, component,provider);
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
                getModel().setLove(!getModel().isLove());
                getProvider().notifyDataSetItemChanged(getPosition());

            }
        });

        play.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                //将事件传递到Slice中然后同步返回结果
                boolean play = (boolean) getEventTransmissionListener().onEventTransmission(PlayListItemViewHolder.this, getModel().isPlay(),1,null);
                getModel().setPlay(play);
                getProvider().notifyDataSetItemChanged(getPosition());
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
                        getModel().setCollection(collection);
                        getProvider().notifyDataSetItemChanged(getPosition());
                        return null;
                    }
                });
            }
        });
    }

    @Override
    public void onBindModel() {
        name.setText(getModel().getName());
        songer.setText(getModel().getSonger());
        // 为了节约时间 以下状态使用文字代替图片。
        love.setText(getModel().isLove() ? "喜欢":"未喜欢");
        collection.setText(getModel().isCollection() ? "收藏":"未收藏");
        play.setText(getModel().isPlay() ? "播放":"未播放");
    }
}
