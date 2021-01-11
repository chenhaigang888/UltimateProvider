package com.chg.ultimateproviderdemo.Menu.Model;

import com.github.chenhaigang888.Model;
import com.chg.ultimateproviderdemo.Menu.ViewHolder.InputBoxViewHolder;
import com.chg.ultimateproviderdemo.ResourceTable;

/**
 * 输入框模型
 */
public class InputBoxModel implements Model {
    /*标签*/
    private String title;
    /*存储输入结果*/
    private String inputResult;
    /*输入提示语*/
    private String hint;
    /*输入内容是否为密码*/
    private boolean password;

    public InputBoxModel(String title, String inputResult, String hint, boolean password) {
        this.title = title;
        this.inputResult = inputResult;
        this.hint = hint;
        this.password = password;
    }

    public boolean isPassword() {
        return password;
    }

    public void setPassword(boolean password) {
        this.password = password;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInputResult() {
        return inputResult;
    }

    public void setInputResult(String inputResult) {
        this.inputResult = inputResult;
    }

    @Override
    public int getResource(int position) {
        return ResourceTable.Layout_input_view;
    }

    @Override
    public Class getHolderClass(int position) {
        return InputBoxViewHolder.class;
    }
}
