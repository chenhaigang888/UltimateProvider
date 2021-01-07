package com.chg.ultimateproviderdemo.Menu.ViewHolder;

import com.chg.ultimateprovider.EventTransmissionListener;
import com.chg.ultimateprovider.UltimateProvider;
import com.chg.ultimateprovider.ViewHolder;
import com.chg.ultimateproviderdemo.Menu.Model.FoundSendData;
import com.chg.ultimateproviderdemo.ResourceTable;
import ohos.agp.components.*;
import ohos.agp.render.Path;

public class FoundSendDataViewHolder extends ViewHolder<FoundSendData> {
    private Text content;
    private ListContainer listContainer;
    private Image headImageView;
    private Text nickname;
    private Text remark;
    private Text browses;

    private Image image1;
    private Image image2;
    private Image image3;

    private UltimateProvider provider = new UltimateProvider(null,getContext());;
    /**
     * 构造方法
     *
     * @param eventTransmissionListener 事件传输对象
     * @param component                 component
     * @param provider                  provider
     */
    public FoundSendDataViewHolder(EventTransmissionListener eventTransmissionListener, Component component, UltimateProvider provider) {
        super(eventTransmissionListener, component, provider);
        headImageView = (Image) findComponentById(ResourceTable.Id_headImageView);

        nickname = (Text) findComponentById(ResourceTable.Id_nickname);
        content = (Text) findComponentById(ResourceTable.Id_content);
        browses = (Text) findComponentById(ResourceTable.Id_browses);
        remark = (Text) findComponentById(ResourceTable.Id_remark);

        listContainer = (ListContainer) findComponentById(ResourceTable.Id_listContainer);

        image1 = (Image) findComponentById(ResourceTable.Id_image1);
        image2 = (Image) findComponentById(ResourceTable.Id_image2);
        image3 = (Image) findComponentById(ResourceTable.Id_image3);
    }

    @Override
    public void onDataBound() {
        nickname.setText(getModel().getUser().getFinalShowName());
        content.setText(getModel().getContent().getContent());
        browses.setText(getModel().getContent().getBrowses()+"人看过");
        remark.setText(getModel().getUser().getExts());

        provider.setModels(getModel().getContent().getSource());
        listContainer.setItemProvider(provider);
        provider.notifyDataChanged();
    }
}
