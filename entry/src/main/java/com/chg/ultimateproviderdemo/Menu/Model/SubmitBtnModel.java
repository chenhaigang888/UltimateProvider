package com.chg.ultimateproviderdemo.Menu.Model;

import com.chg.ultimateprovider.Model;
import com.chg.ultimateproviderdemo.Menu.ViewHolder.SubmitBtnViewHolder;
import com.chg.ultimateproviderdemo.ResourceTable;

public class SubmitBtnModel implements Model {

    private String btnText;

    public SubmitBtnModel(String btnText) {
        this.btnText = btnText;
    }

    public String getBtnText() {
        return btnText;
    }

    public void setBtnText(String btnText) {
        this.btnText = btnText;
    }

    @Override
    public int getResource(int position) {
        return ResourceTable.Layout_submit_btn_view;
    }

    @Override
    public Class getHolderClass(int position) {
        return SubmitBtnViewHolder.class;
    }
}
