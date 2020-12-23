package com.chg.ultimateprovider;

public interface Notify {

    public void notifyDataChanged();

    public void notifyDataInvalidated();

    public void notifyDataSetItemChanged(int position);

    public void notifyDataSetItemInserted(int position);

    public void notifyDataSetItemRemoved(int position);

    public void notifyDataSetItemRangeChanged(int startPos, int countItems);

    public void notifyDataSetItemRangeInserted(int startPos, int countItems);

    public void notifyDataSetItemRangeRemoved(int startPos, int countItems);
}
