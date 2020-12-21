package com.chg.ultimateproviderdemo.Menu.Model;

import com.chg.ultimateprovider.Model;
import com.chg.ultimateproviderdemo.Menu.ViewHolder.AlbumViewHolder;
import com.chg.ultimateproviderdemo.Menu.ViewHolder.NestedAlbumViewHolder;
import com.chg.ultimateproviderdemo.ResourceTable;
/**
 * 这里完全可以在AlbumModel里写。这里为了看起来清晰所有创建一个新的，以免影响阅读
 */
public class NestedAlbumModel extends AlbumModel {

    public NestedAlbumModel(String name, String songer) {
        super(name, songer);
    }

    @Override
    public int getResources(int position) {
        return ResourceTable.Layout_album_item_nested;
    }

    @Override
    public Class getHolderClass(int position) {
        return NestedAlbumViewHolder.class;
    }
}
