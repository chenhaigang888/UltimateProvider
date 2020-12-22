package com.chg.ultimateproviderdemo.Menu.Slice;

import com.chg.ultimateprovider.EventTransmissionListener;
import com.chg.ultimateprovider.Model;
import com.chg.ultimateprovider.UltimateProvider;
import com.chg.ultimateproviderdemo.Menu.Model.PlayListItemModel;
import com.chg.ultimateproviderdemo.Menu.ViewHolder.PlayListItemViewHolder;
import com.chg.ultimateproviderdemo.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.ListContainer;
import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;

import java.util.ArrayList;
import java.util.List;

/**
 * 演示ItemView中的事件在Slice中（同步，异步）处理后再更新ItemView
 */
public class EventHanlderSlice extends AbilitySlice {
    private ListContainer listContainer;
    static final HiLogLabel label = new HiLogLabel(HiLog.LOG_APP, 0x00201, "MY_TAG");
    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_event_hanlder);
        listContainer = (ListContainer) findComponentById(ResourceTable.Id_listContainer);
        UltimateProvider ultimateProvider = new UltimateProvider<Model>(getData(), getContext());
        listContainer.setItemProvider(ultimateProvider);

        /*这里使用匿名内部类实现，也可以让Slice实现接口EventTransmissionListener*/
        ultimateProvider.setEventTransmissionListener(new EventTransmissionListener() {
            @Override
            public Object onEventTransmission(Object target, Object params, int eventId, CallBack callBack) {
                if (target instanceof PlayListItemViewHolder){
                    if (eventId == 1) {//播放列表中播放被点击，演示同步返回数据
                        return handlePlayStatus(target,params,eventId,callBack);
                    } else if(eventId == 2){//收藏
                        return handleCollectionStatus(target,params,eventId,callBack);
                    }
                }
                return null;
            }
        });
    }

    /*处理ItemView中的播放音乐的状态(演示同步返回数据)*/
    public Object handlePlayStatus(Object target, Object params, int eventId, EventTransmissionListener.CallBack callBack) {
        boolean playStatus = (boolean) params;
        return !playStatus;//更改播放状态返回
    }

    /*处理ItemView中的播放音乐的状态(演示异步返回数据)*/
    public Object handleCollectionStatus(Object target, Object params, int eventId, EventTransmissionListener.CallBack callBack) {
        boolean collectionStatus = (boolean) params;
        /*这里可以做一些耗时的操作，比如将是否收藏当前音乐发送给服务器，服务器返回结果后再通过callBack回掉到列表中更新状态*/
        /*耗时操作省略*/
        callBack.callBack(!collectionStatus);//使用异步返回
        return null;
    }

    /*构造数据*/
    public List getData(){
        List list = new ArrayList();
        for (int i=0; i<100; i++) {
            list.add(new PlayListItemModel("歌曲名称："+i,"歌手名字："+i));
        }
        return list;
    }
}
