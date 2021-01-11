package com.chg.ultimateproviderdemo.Menu.Slice;

import com.github.chenhaigang888.Model;
import com.github.chenhaigang888.UltimateProvider;
import com.chg.ultimateproviderdemo.Menu.Model.*;
import com.chg.ultimateproviderdemo.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.ListContainer;

import java.util.ArrayList;
import java.util.List;

/**
 * 嵌套+其他
 */
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
