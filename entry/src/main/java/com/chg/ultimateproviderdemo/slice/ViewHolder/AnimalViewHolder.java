package com.chg.ultimateproviderdemo.slice.ViewHolder;


import com.chg.ultimateprovider.EventTransmissionListener;
import com.chg.ultimateprovider.ViewHolder;
import com.chg.ultimateproviderdemo.ResourceTable;
import com.chg.ultimateproviderdemo.slice.model.Animal;
import ohos.agp.components.Component;
import ohos.agp.components.Text;

public class AnimalViewHolder extends ViewHolder<Animal> {
    private Text text;

    public AnimalViewHolder(EventTransmissionListener eventTransmissionListener, Component component) {
        super(eventTransmissionListener, component);
        text = (Text) findComponentById(ResourceTable.Id_animal);
    }


    @Override
    public void onBindModel() {
        text.setText(getModel().getType());
    }
}
