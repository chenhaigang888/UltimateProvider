package com.chg.ultimateproviderdemo.slice;

import com.chg.ultimateprovider.EventTransmissionListener;
import com.chg.ultimateprovider.Model;
import com.chg.ultimateprovider.UltimateProvider;
import com.chg.ultimateproviderdemo.ResourceTable;
import com.chg.ultimateproviderdemo.slice.ViewHolder.FriendItemViewHolder;
import com.chg.ultimateproviderdemo.slice.model.Animal;
import com.chg.ultimateproviderdemo.slice.model.FriendItem;
import com.chg.ultimateproviderdemo.slice.model.GroupBean;
import com.chg.ultimateproviderdemo.slice.model.UserBean;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.ListContainer;
import ohos.agp.window.dialog.ToastDialog;

import java.util.ArrayList;
import java.util.List;

public class MainAbilitySlice extends AbilitySlice {
    private ListContainer listContainer;
    private UltimateProvider itemProvider;
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);

        itemProvider = new UltimateProvider(userBeans(),getContext());
        itemProvider.setEventTransmissionListener(new EventTransmissionListener() {
            @Override
            public Object onEventTransmission(Object target, Object params, int eventId, CallBack callBack) {
                if (target instanceof FriendItemViewHolder) {//表示事件发生的场所在FriendItemViewHolder中
                    if (eventId == 0) {//表示事件的类型是icon
                        return updateFriend(target,params,eventId,callBack);
                    }
                }
                return null;
            }
        });

        listContainer = (ListContainer) findComponentById(ResourceTable.Id_listContainer);
        listContainer.setItemProvider(itemProvider);

    }

    private List userBeans() {
        List<Model> list = new ArrayList<Model>();
        for (int i=0; i<100; i++) {
            if (i%5 ==0 ) {
                List<FriendItem> friends = new ArrayList<>();
                for (int j=0; j< 100; j++) {
                    friends.add(new FriendItem("好友："+j,"城市："+j));
                }
                list.add(new GroupBean("推荐用户",friends));
            }
            list.add(i%2 == 0 ? new UserBean("name:"+i): new Animal("type:"+i));
        }
        return list;
    }

    int i;

    /**
     * 当点击推荐用户的头像后使用线程来模拟
     * @param target
     * @param params
     * @param eventId
     * @param callBack
     * @return
     */
    private Object updateFriend(Object target, Object params, int eventId, EventTransmissionListener.CallBack callBack) {
        FriendItem friendItem = (FriendItem) params;
        new ToastDialog(getContext()).setText("MainAbilitySlice"+friendItem.getName()).show();
        return friendItem.getCity()+friendItem.getName();
    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }
}
