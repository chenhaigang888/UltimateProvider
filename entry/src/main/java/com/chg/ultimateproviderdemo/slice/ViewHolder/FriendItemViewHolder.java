package com.chg.ultimateproviderdemo.slice.ViewHolder;


import com.chg.ultimateprovider.EventTransmissionListener;
import com.chg.ultimateprovider.ViewHolder;
import com.chg.ultimateproviderdemo.ResourceTable;
import com.chg.ultimateproviderdemo.slice.model.FriendItem;
import ohos.agp.components.Component;
import ohos.agp.components.Image;
import ohos.agp.components.Text;
import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;

public class FriendItemViewHolder extends ViewHolder<FriendItem> {

    private Image icon;
    private Text name;
    private Text age;
    static final HiLogLabel label = new HiLogLabel(HiLog.LOG_APP, 0x00201, "MY_TAG");
    public FriendItemViewHolder(EventTransmissionListener eventTransmissionListener, Component component) {
        super(eventTransmissionListener, component);
        icon = (Image) findComponentById(ResourceTable.Id_icon);
        name = (Text) findComponentById(ResourceTable.Id_name);
        age = (Text) findComponentById(ResourceTable.Id_age);

        icon.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                String result = (String) getEventTransmissionListener().onEventTransmission(FriendItemViewHolder.this, getModel(), 0, new EventTransmissionListener.CallBack() {
                    @Override
                    public Object callBack(Object object) {
//                        new ToastDialog(getContext()).setText(getModel().getName()).show();
                        HiLog.info(label,object+"");
                        return null;
                    }
                });
                name.setText(result);
            }
        });
    }

    @Override
    public void onBindModel() {
        name.setText(getModel().getName());
        age.setText(getModel().getCity());
    }
}
