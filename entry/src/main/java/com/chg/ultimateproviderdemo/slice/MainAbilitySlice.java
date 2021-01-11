package com.chg.ultimateproviderdemo.slice;

import com.github.chenhaigang888.UltimateProvider;
import com.chg.ultimateproviderdemo.ResourceTable;
import com.chg.ultimateproviderdemo.slice.model.MenuItem;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.aafwk.content.Operation;
import ohos.agp.components.Component;
import ohos.agp.components.ListContainer;

import java.util.ArrayList;
import java.util.List;

public class MainAbilitySlice extends AbilitySlice {

    private ListContainer listContainer;

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);

        listContainer = (ListContainer) findComponentById(ResourceTable.Id_listContainer);
        listContainer.setItemProvider(new UltimateProvider(funcs(),getContext()));

        /*设置点击事件*/
        listContainer.setItemClickedListener(new ListContainer.ItemClickedListener() {
            @Override
            public void onItemClicked(ListContainer listContainer, Component component, int i, long l) {
                MenuItem menuItem = (MenuItem) listContainer.getItemProvider().getItem(i);
                Intent secondIntent = new Intent();
                // 指定待启动FA的bundleName和abilityName
                Operation operation = new Intent.OperationBuilder()
                        .withDeviceId("")
                        .withBundleName("com.chg.ultimateproviderdemo")
                        .withAbilityName(menuItem.getAbilityName())
                        .build();
                secondIntent.setOperation(operation);
                startAbility(secondIntent);
            }
        });
    }

    /*创建功能列表*/
    private List funcs() {
        List list = new ArrayList();
        list.add(new MenuItem("简单的显示（显示一种布局）","最基础使用","com.chg.ultimateproviderdemo.Menu.Ability.SongAbility"));
        list.add(new MenuItem("简单的显示（显示多种布局）","最基础使用","com.chg.ultimateproviderdemo.Menu.Ability.RecommendAbility"));
        list.add(new MenuItem("嵌套ListContainer","最基础使用","com.chg.ultimateproviderdemo.Menu.Ability.NestedListAbility"));
        list.add(new MenuItem("ItemView中的按钮点击、等事件","最基础使用","com.chg.ultimateproviderdemo.Menu.Ability.EventHanlderAbility"));
        list.add(new MenuItem("provider设置自定义数据","provider设置自定义数据，方便在ItemView之间以及Activity中共享数据","com.chg.ultimateproviderdemo.Menu.Ability.CustomDataUserAbility"));
        list.add(new MenuItem("比较复杂的演示（微博）","使用当前框架模拟微博","com.chg.ultimateproviderdemo.Menu.Ability.WeiboAbility"));
        return list;
    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }
}
