package com.chg.ultimateprovider;

/**
 * 所有需要在ListContainer中显示的模型都应该实现这个接口。这个接口定义了模型需要返回的布局文件和ViewHolder类
 */
public interface Model {
    /**
     * 返回模型对应的资源文件
     * @return
     */
    public int getResources(int position);

    /**
     * 返回模型对应的ViewHolder
     * @param position
     * @return
     */
    public Class getHolderClass(int position);
}
