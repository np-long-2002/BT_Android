package com.tuan05;

import java.util.ArrayList;

public class Page_Menu {
    public Page_Menu(String name) {
        this.name = name;
    }
    public Page_Menu(){}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    String name;
    protected ArrayList<Page_Menu> getData(){
        ArrayList<Page_Menu> page_menus = new ArrayList<>();
        page_menus.add(new Page_Menu("Radio Button"));
        page_menus.add(new Page_Menu("Check Box"));
        page_menus.add(new Page_Menu("Chip Group"));
        page_menus.add(new Page_Menu("Switch"));
        page_menus.add(new Page_Menu("Toggle Button"));
        page_menus.add(new Page_Menu("Example"));
        return page_menus;
    }
}
