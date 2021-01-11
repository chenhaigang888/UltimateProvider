package com.chg.ultimateproviderdemo.Menu.ViewHolder;

import com.github.chenhaigang888.EventTransmissionListener;
import com.github.chenhaigang888.UltimateProvider;
import com.github.chenhaigang888.ViewHolder;
import com.chg.ultimateproviderdemo.Menu.Model.FoundUserModel;
import com.chg.ultimateproviderdemo.ResourceTable;
import ohos.agp.components.Component;
import ohos.agp.components.ComponentContainer;
import ohos.agp.components.Image;
import ohos.agp.components.Text;
import ohos.global.configuration.DeviceCapability;
import ohos.media.image.ImageSource;
import okhttp3.*;

import java.io.IOException;
import java.io.InputStream;

public class FoundUserViewHolder extends ViewHolder<FoundUserModel> {

    private Image image;
    private Text name;

    /**
     * 构造方法
     *
     * @param eventTransmissionListener 事件传输对象
     * @param component                 component
     * @param provider                  provider
     */
    public FoundUserViewHolder(EventTransmissionListener eventTransmissionListener, Component component, UltimateProvider provider, ComponentContainer componentContainer) {
        super(eventTransmissionListener, component, provider, componentContainer);
        name = (Text) findComponentById(ResourceTable.Id_name);
        image = (Image) findComponentById(ResourceTable.Id_image);
    }

    @Override
    public void onDataBound() {
        name.setText(getModel().getFinalShowName());
        downloadPic(getUrl(getModel().getAvatar(),70),image);
    }

    String getUrl(String url, int width) {
        int p = getContext().getResourceManager().getDeviceCapability().screenDensity / DeviceCapability.SCREEN_MDPI;
        return url + "?x-oss-process=image/resize,w_" + width*p + "/quality,q_50/circle,r_"+p*width;
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
