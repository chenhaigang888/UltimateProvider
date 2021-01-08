package com.chg.ultimateproviderdemo.Menu.Slice;

import com.chg.ultimateprovider.Model;
import com.chg.ultimateprovider.UltimateProvider;
import com.chg.ultimateproviderdemo.Menu.Model.*;
import com.chg.ultimateproviderdemo.ResourceTable;
import com.google.gson.*;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.ListContainer;


import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class WeiboSlice extends AbilitySlice {

    private ListContainer listContainer;
    private UltimateProvider provider;
    private FunctionArea functionArea;
    private List recycleViewData = new ArrayList();

    private int pageIndex = 0;
    private Boolean isPullRefresh = false;
    private Boolean isLoading = false;//是否正在加载

    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_song);
        listContainer = (ListContainer) findComponentById(ResourceTable.Id_listContainer);
        recycleViewData.add(getFunctionArea());
        getProvider().setModels(recycleViewData);
        listContainer.setItemProvider(provider);
        postAsynHttp();
    }

    public UltimateProvider getProvider() {
        if (provider == null) {
            provider = new UltimateProvider(recycleViewData,getContext());
        }
        return provider;
    }
    private void postAsynHttp() {
        isLoading = true;
        pageIndex += 1;
        OkHttpClient mOkHttpClient = new OkHttpClient();
        HashMap params = new HashMap();
        params.put("appId", "1003604205986484225");
        params.put("lat", "0");
        params.put("lng", "0");
        params.put("pageIndex", pageIndex + "");
        params.put("pageSize", "10");
        params.put("platform", "ios");
        params.put("timestamp", "1578715788332");
        params.put("token", "fcb525ba5eebef743a028fae49ff382c9387e2ed9d5e04fcee6913fc3ee4937b64a2104a27ef241b93c3d0baa401c0b39cb17883cfbbaf9895ebc813c245d22916bcd42b5c33121972592575ac2be4f0");
        params.put("version", "1.1.4");

        final Gson gson = new Gson();
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, gson.toJson(params));
        Request request = new Request.Builder()
                .url("https://api.dnaerapp.com/zoology/feed/mobile/v1/feeds")
                .post(body)
                .build();

        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String str = response.body().string();
//                Log.i("chg", "str:" + str);
                System.out.println("chgLog:"+str);
                ServerResponse serverResponse = gson.fromJson(str, ServerResponse.class);
                final List<Found> list = serverResponse.getData();
                for (Found found : list) {
                    String type = found.getType();
                    String factor = found.getFactor();
                    ArrayList<HashMap> feedExts = found.getFeedExts();

                    if (type.equals("0")) {
                    } else if (type.equals("1")) {
                        if (factor.equals("4")) {//精彩小视频

                        } else {//发布的内容
                            ArrayList<FoundSendData> foundSendData = parserJsonArray(gson.toJson(feedExts),FoundSendData.class);
                            if (isPullRefresh) {
                                recycleViewData.add(1,foundSendData.get(0));
                            } else {
                                recycleViewData.add(foundSendData.get(0));
                            }
                        }
                    } else if (type.equals("2")) {//好友推荐
                        RecommendedFriendModel friendModel = new RecommendedFriendModel();
                        friendModel.setFriends(parserJsonArray(gson.toJson(feedExts),FoundUserModel.class));
                        recycleViewData.add(friendModel);
                    }
                }

                getUITaskDispatcher().asyncDispatch(new Runnable() {
                    @Override
                    public void run() {
                        isLoading = false;
                        provider.setModels(recycleViewData);
                        provider.notifyDataChanged();
                    }
                });
            }
        });
    }

    public ArrayList parserJsonArray(String strJson,Class classT) {
        ArrayList list = new ArrayList<>();
        //创建一个Gson对象
        Gson gson = new Gson();
        //创建一个JsonParser
        JsonParser parser = new JsonParser();
        //通过JsonParser对象可以把json格式的字符串解析成一个JsonElement对象
        JsonElement el = parser.parse(strJson);

        //把JsonElement对象转换成JsonObject
        JsonObject jsonObj = null;
        if (el.isJsonObject()) {
            jsonObj = el.getAsJsonObject();
        }
        //把JsonElement对象转换成JsonArray
        JsonArray jsonArray = null;
        if (el.isJsonArray()) {
            jsonArray = el.getAsJsonArray();
        }

        //遍历JsonArray对象
        Iterator it = jsonArray.iterator();
        while (it.hasNext()) {
            JsonElement e = (JsonElement) it.next();
            //JsonElement转换为JavaBean对象
            list.add(gson.fromJson(e, classT));
        }
        return list;
    }

    public FunctionArea getFunctionArea() {
        if (functionArea == null) {
            functionArea = new FunctionArea();
            List<FuncItem> funcItems = new ArrayList<>();
            String[] titles = {"搜索", "附近的人", "闪聊", "树洞", "雷达", "校友通讯录", "附近的人", "闪聊", "树洞", "雷达", "校友通讯录"};
            int[] icons = {
                    ResourceTable.Media_da_xue_man_you,
                    ResourceTable.Media_da_xue_man_you,
                    ResourceTable.Media_shan_liao,
                    ResourceTable.Media_shu_dong,
                    ResourceTable.Media_tong_xun_lu,
                    ResourceTable.Media_lei_da,
                    ResourceTable.Media_da_xue_man_you,
                    ResourceTable.Media_shan_liao,
                    ResourceTable.Media_shu_dong,
                    ResourceTable.Media_tong_xun_lu,
                    ResourceTable.Media_lei_da
            };
            FuncItem funcItem = null;
            for (int i=0; i<titles.length; i++) {
                funcItems.add(new FuncItem(titles[i],icons[i]));
            }
            functionArea.setFuncItems(funcItems);
        }
        return functionArea;
    }
}
