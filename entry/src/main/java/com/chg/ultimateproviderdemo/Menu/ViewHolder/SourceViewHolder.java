package com.chg.ultimateproviderdemo.Menu.ViewHolder;

import com.chg.ultimateprovider.EventTransmissionListener;
import com.chg.ultimateprovider.Model;
import com.chg.ultimateprovider.UltimateProvider;
import com.chg.ultimateprovider.ViewHolder;
import com.chg.ultimateproviderdemo.Menu.Model.FoundSendData;
import com.chg.ultimateproviderdemo.Menu.Model.Source;
import com.chg.ultimateproviderdemo.ResourceTable;

import ohos.agp.components.Component;
import ohos.agp.components.ComponentContainer;
import ohos.agp.components.DirectionalLayout;
import ohos.agp.components.Image;
import ohos.agp.text.Layout;
import ohos.global.configuration.DeviceCapability;

import java.util.List;

public class SourceViewHolder extends ViewHolder<Source> {

    private Image image;
    /**
     * 构造方法
     *
     * @param eventTransmissionListener 事件传输对象
     * @param component                 component
     * @param provider                  provider
     */
    public SourceViewHolder(EventTransmissionListener eventTransmissionListener, Component component, UltimateProvider provider, ComponentContainer componentContainer) {
        super(eventTransmissionListener, component, provider, componentContainer);
        image = (Image) findComponentById(ResourceTable.Id_image);

    }

    @Override
    public void onDataBound() {
        int p = getContext().getResourceManager().getDeviceCapability().screenDensity / DeviceCapability.SCREEN_MDPI;
        int w = getContext().getResourceManager().getDeviceCapability().width * p;
        int h = getContext().getResourceManager().getDeviceCapability().height * p;

        List list = getProvider().getModels();
        int width = w;
        int height = h;
        if (list.size() == 1) {
            width = w;
            int js_h = (int) (new Float(getModel().getHeight()) / new Float(getModel().getWidth()) * w);
            height = js_h > h * 0.9 ? (int) (h * 0.9) :js_h;
        } else if(list.size() == 2 || list.size() == 4){
            width = w/2;
            height = width;
        } else {
            width = w/3;
            height = width;
        }

        DirectionalLayout.LayoutConfig config = (DirectionalLayout.LayoutConfig) image.getLayoutConfig();
        config.width = width;
        config.height = height;
        image.setLayoutConfig(config);

    }

//    //获取图片的宽高
//    public int getPicWidth(Model model) {
//        int imageWidth = 0;
//        int viewWidth = getContext().getResourceManager().getDeviceCapability().width;
//        int viewHeight = getContext().getResourceManager().getDeviceCapability().height;
//        Source source = (Source) model;
//        if (getCustomData() != null) {
//            final FoundSendData foundSendData = (FoundSendData) getCustomData();
//            if (foundSendData.getContent().getSource() != null && foundSendData.getContent().getSource().size() > 0) {
//                int size = foundSendData.getContent().getSource().size();
//                if (size == 1) {
//                    if (source.getHeight() == 0 || source.getWidth() == 0) {
//                        DirectionalLayout.LayoutConfig config = (DirectionalLayout.LayoutConfig) image.getLayoutConfig();
//                        config.width = viewWidth;
//                        config.height = viewWidth;
//                        image.setLayoutConfig(config);
//                        imageWidth = viewWidth;
//                    } else {
//                        int height = (int) (source.getHeight() / source.getWidth() * viewWidth);
//                        height = height >= viewHeight ? (int) (viewHeight * 0.7) : height;
//                        DirectionalLayout.LayoutConfig config = (DirectionalLayout.LayoutConfig) image.getLayoutConfig();
//                        config.width = viewWidth;
//                        config.height = height;
//                        image.setLayoutConfig(config);
//                        imageWidth = viewWidth;
//                    }
//                } else if (size == 2) {
//                    DirectionalLayout.LayoutConfig config = (DirectionalLayout.LayoutConfig) image.getLayoutConfig();
//                    config.width = viewWidth / 2;
//                    config.height = viewWidth / 2;
//                    image.setLayoutConfig(config);
//                    imageWidth = viewWidth / 2;
//                } else {
//                    DirectionalLayout.LayoutConfig config = (DirectionalLayout.LayoutConfig) image.getLayoutConfig();
//                    config.width = viewWidth / 3;
//                    config.height = viewWidth / 3;
//                    image.setLayoutConfig(config);
//
//                    imageWidth = viewWidth / 3;
//                }
//            }
//        } else {
//            DirectionalLayout.LayoutConfig config = (DirectionalLayout.LayoutConfig) image.getLayoutConfig();
//            config.width = viewWidth;
//            config.height = viewHeight;
//            image.setLayoutConfig(config);
//            imageWidth = viewWidth;
//        }
//
//        imageWidth = imageWidth > 900 ? 900 : imageWidth;
//        return (int) imageWidth;
//    }
//
//    //获取图片url
//    public String getUrl(Model model, int imageWidth) {
//        String url = null;
//        if (getCustomData() != null) {
//            final FoundSendData foundSendData = (FoundSendData) getCustomData();
//            Integer type = foundSendData.getContent().getType();
//            if (type == 2) {//图片
//                Source source = (Source) model;
//                url = source.getUrl() + "?x-oss-process=image/resize,w_" + imageWidth + "/quality,q_50";
//            } else if (type == 3) {//视频
//                url = foundSendData.getContent().getCover();
//            }
//        } else {
//            Source source = (Source) model;
//            int sourceType = source.getSourceType();
//            if (sourceType == 4) {//视频
//                url = source.getUrl();
//            } else {
//                url = source.getUrl() + "?x-oss-process=image/resize,w_" + imageWidth + "/quality,q_50";
//            }
//        }
//
//        return url;
//    }
}
