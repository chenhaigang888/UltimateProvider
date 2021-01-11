package com.chg.ultimateproviderdemo.Menu.ViewHolder;

import com.github.chenhaigang888.EventTransmissionListener;
import com.github.chenhaigang888.UltimateProvider;
import com.github.chenhaigang888.ViewHolder;
import com.chg.ultimateproviderdemo.Menu.Model.Source;
import com.chg.ultimateproviderdemo.ResourceTable;

import ohos.agp.components.Component;
import ohos.agp.components.ComponentContainer;
import ohos.agp.components.DirectionalLayout;
import ohos.agp.components.Image;
import ohos.global.configuration.DeviceCapability;
import ohos.media.image.ImageSource;
import okhttp3.*;

import java.io.IOException;
import java.io.InputStream;
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

        List list = (List) getProvider().getCustomData();
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
        if (!getModel().getUrl().contains(".mp4")) {
            String url = getModel().getUrl()+"?x-oss-process=image/resize,w_"+width+"/quality,q_50";
            downloadPic(url,image);
        }
    }

    /**
     * 下载图片
     * @param url
     * @param image
     */
    public void downloadPic(String url,Image image){
        image.setTag(url);
        OkHttpClient okHttpClient=new OkHttpClient();
        Request request=new Request.Builder()
                .get()
                .url(url)
                .build();
        Call call=okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //将响应数据转化为输入流数据
                InputStream inputStream=response.body().byteStream();
                ImageSource imageSource = ImageSource.create(inputStream,null);
                inputStream.close();
                getContext().getUITaskDispatcher().asyncDispatch(new Runnable() {
                    @Override
                    public void run() {
                        if (url.equals(image.getTag())) {
                            image.setPixelMap(imageSource.createPixelmap(null));
                        }
                    }
                });
            }
        });
    }
}
