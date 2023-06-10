package com.tuan09;

import java.util.ArrayList;

public class Utils {

    private static Utils _Ins;

    public static Utils Ins() {
        if(_Ins == null)
            _Ins = new Utils();
        return _Ins;
    }

    private Utils()
    {
        this.selectedItems = new ArrayList<>();
    }

    public ArrayList<Furniture> getSelectedItems() {
        return this.selectedItems;
    }

    protected ArrayList<Furniture> selectedItems;

    public void addItem(Furniture item)
    {
        int index = this.selectedItems.indexOf(item);
        if(index != -1)
        {
            this.selectedItems.remove(index);
        }
        this.selectedItems.add(item);
    }




}
