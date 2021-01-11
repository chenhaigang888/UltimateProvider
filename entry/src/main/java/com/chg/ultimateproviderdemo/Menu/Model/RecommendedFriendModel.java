package com.chg.ultimateproviderdemo.Menu.Model;

import com.github.chenhaigang888.Model;
import com.chg.ultimateproviderdemo.Menu.ViewHolder.HorizontalScrollViewHolder;
import com.chg.ultimateproviderdemo.ResourceTable;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RecommendedFriendModel implements Model {

    private List<Model> friends;

    public List<Model> getFriends() {
        return friends;
    }

    public void setFriends(List<Model> friends) {
        this.friends = friends;
    }

    @Override
    public int getResource(int position) {
        return ResourceTable.Layout_horizontal_scroll;
    }

    @NotNull
    @Override
    public Class<?> getHolderClass(int position) {
        return HorizontalScrollViewHolder.class;
    }
}
