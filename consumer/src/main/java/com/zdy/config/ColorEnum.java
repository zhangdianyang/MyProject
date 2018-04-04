package com.zdy.config;

import ch.qos.logback.core.pattern.color.BlackCompositeConverter;

/**
 * @author zdy
 */
public enum  ColorEnum {
    Red("红色",1),  Black("黑色",2);

    private String name;
    private int index;

    ColorEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public static String getColorName(int index){
        for (ColorEnum colorEnum : ColorEnum.values()) {
            if(colorEnum.getIndex() == index){
                return colorEnum.getName();
            }
        }
        return null;
    }

    public static Integer getColorIndex(String color){
        for (ColorEnum colorEnum : ColorEnum.values()) {
            if(color.equals(colorEnum.getName())){
                return colorEnum.getIndex();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String colorName = ColorEnum.getColorName(1);
        System.out.println(colorName);
        Integer i = ColorEnum.getColorIndex("红色");
        System.out.println(i);
    }
}
