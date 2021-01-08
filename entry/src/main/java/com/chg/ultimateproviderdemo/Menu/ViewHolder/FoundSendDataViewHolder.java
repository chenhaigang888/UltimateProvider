package com.chg.ultimateproviderdemo.Menu.ViewHolder;

import com.chg.ultimateprovider.EventTransmissionListener;
import com.chg.ultimateprovider.UltimateProvider;
import com.chg.ultimateprovider.ViewHolder;
import com.chg.ultimateproviderdemo.Menu.Model.FoundContent;
import com.chg.ultimateproviderdemo.Menu.Model.FoundSendData;
import com.chg.ultimateproviderdemo.Menu.Model.FoundUser;
import com.chg.ultimateproviderdemo.Menu.Model.Source;
import com.chg.ultimateproviderdemo.ResourceTable;
import ohos.agp.components.*;
import ohos.global.configuration.DeviceCapability;
import java.util.ArrayList;
import java.util.List;

public class FoundSendDataViewHolder extends ViewHolder<FoundSendData> {
    private ListContainer listContainer1;
    private ListContainer listContainer2;
    private ListContainer listContainer3;

    private Text content;
    private Image headImageView;
    private Text nickname;
    private Text remark;
    private Text browses;

    private Image image1;
    private Image image2;
    private Image image3;

    private UltimateProvider provider1 = new UltimateProvider(null,getContext());;
    private UltimateProvider provider2 = new UltimateProvider(null,getContext());;
    private UltimateProvider provider3 = new UltimateProvider(null,getContext());;
    /**
     * 构造方法
     *
     * @param eventTransmissionListener 事件传输对象
     * @param component                 component
     * @param provider                  provider
     */
    public FoundSendDataViewHolder(EventTransmissionListener eventTransmissionListener, Component component, UltimateProvider provider, ComponentContainer componentContainer) {
        super(eventTransmissionListener, component, provider, componentContainer);
        headImageView = (Image) findComponentById(ResourceTable.Id_headImageView);

        nickname = (Text) findComponentById(ResourceTable.Id_nickname);
        content = (Text) findComponentById(ResourceTable.Id_content);
        browses = (Text) findComponentById(ResourceTable.Id_browses);
        remark = (Text) findComponentById(ResourceTable.Id_remark);

        listContainer1 = (ListContainer) findComponentById(ResourceTable.Id_listContainer1);
        listContainer2 = (ListContainer) findComponentById(ResourceTable.Id_listContainer2);
        listContainer3 = (ListContainer) findComponentById(ResourceTable.Id_listContainer3);

        image1 = (Image) findComponentById(ResourceTable.Id_image1);
        image2 = (Image) findComponentById(ResourceTable.Id_image2);
        image3 = (Image) findComponentById(ResourceTable.Id_image3);
    }

    @Override
    public void onDataBound() {
        FoundUser foundUser = getModel().getUser();
        FoundContent foundContent = getModel().getContent();
        if (foundUser != null) {
            nickname.setText(foundUser.getFinalShowName());
            remark.setText(foundUser.getExts());
        }
        DirectionalLayout.LayoutConfig config1 = (DirectionalLayout.LayoutConfig) listContainer1.getLayoutConfig();
        DirectionalLayout.LayoutConfig config2 = (DirectionalLayout.LayoutConfig) listContainer2.getLayoutConfig();
        DirectionalLayout.LayoutConfig config3 = (DirectionalLayout.LayoutConfig) listContainer3.getLayoutConfig();
        config1.height = 0;
        config2.height = 0;
        config3.height = 0;
        clearAllData();
        if (foundContent != null) {
            content.setText(getModel().getContent().getContent());
            browses.setText(getModel().getContent().getBrowses()+"人看过");

            List sources = foundContent.getSource();
            if (sources != null) {
                provider1.setCustomData(sources);
                provider2.setCustomData(sources);
                provider3.setCustomData(sources);

                int size = sources.size();
                int needSize = size >9?9:size;
                List list1 = new ArrayList();
                List list2 = new ArrayList();
                List list3 = new ArrayList();
                for (int i = 0; i < needSize; i++) {
                    System.out.println("数据："+i);
                    if (i<3) {
                        list1.add(sources.get(i));
                    } else if(i>=3 && i<6){
                        list2.add(sources.get(i));
                    } else if(i >=6 && i<9){
                        list3.add(sources.get(i));
                    }
                }
                provider1.setModels(list1);
                provider2.setModels(list2);
                provider3.setModels(list3);

                int p = getContext().getResourceManager().getDeviceCapability().screenDensity / DeviceCapability.SCREEN_MDPI;
                int w = getContext().getResourceManager().getDeviceCapability().width * p;
                int h = getContext().getResourceManager().getDeviceCapability().height * p;
                if(size == 1){
                    Source source = (Source) sources.get(0);
                    int pic_w = source.getWidth();
                    int pic_h = source.getHeight();
                    config1.width = w;
                    int js_h = (int) (new Float(pic_h) / new Float(pic_w) * w);
                    config1.height = js_h > h * 0.9 ? (int) (h * 0.9) :js_h;
                } else if (size == 2 || size == 4) {//4宫格
                    config1.width = w / 2;
                    config1.height = w / 2;
                } else if (size == 3) {
                    config1.width = w / 3;
                    config1.height = w / 3;
                } else if(size == 5 || size == 6){
                    config1.width = w / 3;
                    config1.height = w / 3;
                    config2.width = w / 3;
                    config2.height = w / 3;
                } else {
                    config1.width = w / 3;
                    config1.height = w / 3;
                    config2.width = w / 3;
                    config2.height = w / 3;
                    config3.width = w / 3;
                    config3.height = w / 3;
                }
            }
        }

        listContainer1.setItemProvider(provider1);
        provider1.notifyDataChanged();

        listContainer2.setItemProvider(provider2);
        provider2.notifyDataChanged();

        listContainer3.setItemProvider(provider3);
        provider3.notifyDataChanged();
    }

    /**
     * 清空所有的数据，以免由于复用导致数据错误
     */
    private void clearAllData(){
        provider1.setModels(null);
        provider2.setModels(null);
        provider3.setModels(null);

        provider1.setCustomData(null);
        provider2.setCustomData(null);
        provider3.setCustomData(null);
    }
}
