package com.chg.ultimateprovider;

/**
 * 所有需要在ListContainer中显示的模型都应该实现这个接口。这个接口定义了模型需要返回的布局文件和ViewHolder类
 */
public interface Model {
    /**
     * 当前Model配置布局文件
     * @param position 当前Model在数组中的位置
     * @return  返回布局文件
     */
    int getResources(int position);

    /**
     * 返回模型对应的ViewHolder
     * @param position 当前Model在数组中的位置
     * @return 返回当前布局文件对应的ViewHolder类
     */
    Class getHolderClass(int position);
}
