# UltimateProvider
UltimateProvider(Adapter)简单快速的使用ListContainer而不需要写Provider。此框架是CHGAdapter的鸿蒙版本
### Android(CHGAdapter)
- Java:https://github.com/chenhaigang888/CHGAdapter_android 
- Kotlin:https://github.com/chenhaigang888/CHGAdapter_Kotlin

### Ios(CHGAdapter)
- oc:https://github.com/chenhaigang888/CHGAdapter 
- swift:https://github.com/chenhaigang888/CHGAdapter_swift

### HarmonyOS(UltimateProvider)
- java:https://github.com/chenhaigang888/UltimateProvider

### 如有使用方面的问题或者交流请加QQ群：494648687

### example

#### 1.简单的显示（显示一种布局）

- 文件SongSlice.java

```
public class SongSlice extends AbilitySlice {

    private ListContainer listContainer;

    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_song);
        listContainer = (ListContainer) findComponentById(ResourceTable.Id_listContainer);
        listContainer.setItemProvider(new UltimateProvider(getSongs(),getContext()));
    }

    List getSongs(){
        List list = new ArrayList();
        for (int i=0; i<100; i++) {
            list.add(new SongModel("歌曲名称："+i,"歌手："+i));
        }
        return list;
    }
}

```

- 文件 SongModel.java模型
```
public class SongModel implements Model {

    private String name;
    private String singer;


    @Override
    public int getResources(int position) {
        return ResourceTable.Layout_song_item;
    }

    @Override
    public Class getHolderClass(int position) {
        return SongViewHolder.class;
    }
}
```

- 文件 SongViewHolder.java模型
```
public class SongViewHolder extends ViewHolder<SongModel> {

    private Image icon;
    private Text songName;
    private Text songer;

    public SongViewHolder(EventTransmissionListener eventTransmissionListener, Component component, UltimateProvider provider) {
        super(eventTransmissionListener, component,provider);
        icon = (Image) findComponentById(ResourceTable.Id_icon);
        songName = (Text) findComponentById(ResourceTable.Id_songName);
        songer = (Text) findComponentById(ResourceTable.Id_songer);
    }

    @Override
    public void onDataBound() {
        songName.setText(getModel().getName());
        songer.setText(getModel().getSinger());
    }
}
```

- 2.简单的显示（显示多种布局）

- RecommendSlice.java

```
public class RecommendSlice extends AbilitySlice {

    private ListContainer listContainer;

    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_recommend);
        listContainer = (ListContainer) findComponentById(ResourceTable.Id_listContainer);
        listContainer.setItemProvider(new UltimateProvider<Model>(getData(),getContext()));
    }

    List getData(){
        List list = new ArrayList();
        for (int i=0; i<100; i++) {
            if (i %2 == 0) {
                list.add(new SongModel("歌曲名称："+i,"歌手名称:"+i));
            } else {
                list.add(new AlbumModel("专辑名称："+i,"歌手"));
            }
        }
        return list;
    }

}

```

- 文件 AlbumModel.java模型
```
public class AlbumModel implements Model {

}
    private String name;
    private String songer;

    @Override
    public int getResources(int position) {
        return ResourceTable.Layout_album_item;
    }

    @Override
    public Class getHolderClass(int position) {
        return AlbumViewHolder.class;
    }
}
```

- 文件 AlbumViewHolder.java
```
public class AlbumViewHolder extends ViewHolder<AlbumModel> {

    private Text name;
    private Text songer;

    public AlbumViewHolder(EventTransmissionListener eventTransmissionListener, Component component, UltimateProvider provider) {
        super(eventTransmissionListener, component,provider);
        name = (Text) findComponentById(ResourceTable.Id_name);
        songer = (Text) findComponentById(ResourceTable.Id_songer);
    }

    @Override
    public void onDataBound() {
        name.setText(getModel().getName());
        songer.setText(getModel().getSonger());
    }
}
```


- 3.嵌套ListContainer

- NestedListAbility.java

```
public class NestedListSlice extends AbilitySlice {

    private ListContainer listContainer;

    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_nested_list);
        listContainer = (ListContainer) findComponentById(ResourceTable.Id_listContainer);
        listContainer.setItemProvider(new UltimateProvider<Model>(getData(), getContext()));
    }

    List getData() {
        List list = new ArrayList();
        for (int i=0; i<100; i++) {
            if (i%5 == 0) {
                list.add(new SongModel("歌曲名称："+i,"歌手："+i));
            } else if (i%5 == 1) {
                list.add(new AlbumModel("推荐专辑："+i,"歌手："+i));
            } else if (i%5 == 2) {
                list.add(creageMusicData(i,i%2));
            } else {
                list.add(creageHybridData());
            }
        }
        return list;
    }

    /*创建推荐内容*/
    MusicModel creageMusicData(int position,int type){
        List list = new ArrayList();
        String title = type == 0 ? "推荐歌曲":"推荐专辑";
        for (int i=0; i< 100; i++) {
            if (type == 0) {
                list.add(new NestedSongModel("推荐歌曲："+i,"歌手："+i));
            } else if(type == 1){
                list.add(new NestedAlbumModel("推荐专辑："+i,"歌手："+i));
            }
        }
        return new MusicModel(title + position,list);
    }

    /*创建推荐内容*/
    MusicModel creageHybridData(){
        List list = new ArrayList();

        for (int i=0; i< 100; i++) {
            if (i %2 == 0) {
                list.add(new NestedSongModel("推荐歌曲："+i,"歌手："+i));
            } else {
                list.add(new NestedAlbumModel("推荐专辑："+i,"歌手："+i));
            }
        }
        return new MusicModel("推荐的歌曲+专辑",list);
    }

}

```

- 文件 MusicModel.java模型
```
public class MusicModel implements Model {

    private String title;
    private List data;

    @Override
    public int getResources(int position) {
        return ResourceTable.Layout_music_item;
    }

    @Override
    public Class getHolderClass(int position) {
        return MusicViewHolder.class;
    }
}
```

- 文件 MusicViewHolder.java
```
public class MusicViewHolder extends ViewHolder<MusicModel> {

    private Text title;
    private ListContainer listContainer;
    private UltimateProvider ultimateProvider;

    public MusicViewHolder(EventTransmissionListener eventTransmissionListener, Component component,UltimateProvider provider) {
        super(eventTransmissionListener, component,provider);
        title = (Text) findComponentById(ResourceTable.Id_title);
        listContainer = (ListContainer) findComponentById(ResourceTable.Id_listContainer);
        ultimateProvider = new UltimateProvider(null,getContext());
    }

    @Override
    public void onDataBound() {
        title.setText(getModel().getTitle());
        ultimateProvider.setModels(getModel().getData());
        listContainer.setItemProvider(ultimateProvider);
    }
}
```



- 4.ItemView中的按钮点击、等事件

- EventHanlderAbility.java

```
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
```

- 文件 PlayListItemModel.java模型
```
public class PlayListItemModel implements Model {
    /*歌曲名称*/
    private String name;
    /*歌手*/
    private String songer;
    /*是否喜欢*/
    private boolean love = false;
    /*是否收藏*/
    private boolean collection = false;
    /*是否正在播放*/
    private boolean play = false;

    @Override
    public int getResources(int position) {
        return ResourceTable.Layout_play_list_item;
    }

    @Override
    public Class getHolderClass(int position) {
        return PlayListItemViewHolder.class;
    }
}
```

- 文件 PlayListItemViewHolder.java
```
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
                getModel().setLove(!getModel().isLove());//这里把状态存储在数据中，可以根据需求将状态存储在provider中的自定义数据中。具体使用方式可以查看CustomData的使用
                notifyCurrentDataSetItemChanged();
            }
        });

        play.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                //将事件传递到Slice中然后同步返回结果
                boolean play = (boolean) getEventTransmissionListener().onEventTransmission(PlayListItemViewHolder.this, getModel().isPlay(),1,null);
                getModel().setPlay(play);//这里把状态存储在数据中，可以根据需求将状态存储在provider中的自定义数据中。具体使用方式可以查看CustomData的使用
                notifyCurrentDataSetItemChanged();
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
                        getModel().setCollection(collection);//这里把状态存储在数据中，可以根据需求将状态存储在provider中的自定义数据中。具体使用方式可以查看CustomData的使用
                        notifyCurrentDataSetItemChanged();
                        return null;
                    }
                });
            }
        });
    }

    @Override
    public void onDataBound() {
        name.setText(getModel().getName());
        songer.setText(getModel().getSonger());
        // 为了节约时间 以下状态使用文字代替图片。
        love.setText(getModel().isLove() ? "喜欢":"未喜欢");
        collection.setText(getModel().isCollection() ? "收藏":"未收藏");
        play.setText(getModel().isPlay() ? "播放":"未播放");
    }
}
```



- 5.ItemView中的按钮点击、等事件

- CustomDataUserAbility.java

```
public class CustomDataUserSlice extends AbilitySlice implements EventTransmissionListener{

    private ListContainer listContainer;
    private UltimateProvider ultimateProvider;
    private LoginData loginData = new LoginData();//用于存放用户名及密码

    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_custom_data_use);
        listContainer = (ListContainer) findComponentById(ResourceTable.Id_listContainer);
        ultimateProvider = new UltimateProvider(getAllView(),getContext());
        listContainer.setItemProvider(ultimateProvider);
        ultimateProvider.setCustomData(loginData);//演示设置自定义数据，这里主要记录输入的用户名和密码
        ultimateProvider.setEventTransmissionListener(this);
    }

    /**
     * 同时显示登录和身份证验证界面
     * @return
     */
    public List getAllView() {
        List list = new ArrayList();
        list.add(new OneTitleModel("登录"));
        list.add(new InputBoxModel("用户名：","","请输入用户名",false));
        list.add(new InputBoxModel("密码：","","请输入密码",true));
        list.add(new SubmitBtnModel("登录"));
        return list;
    }

    @Override
    public Object onEventTransmission(Object target, Object params, int eventId, CallBack callBack) {

        return null;
    }
}
```
