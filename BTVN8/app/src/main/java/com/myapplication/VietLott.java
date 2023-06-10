package com.myapplication;

public class VietLott {
    public VietLott(String ngay, String so, String soluong) {
        this.ngay = ngay;
        this.so = so;
        this.soluong = soluong;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getSo() {
        return so;
    }

    public void setSo(String so) {
        this.so = so;
    }

    public String getSoluong() {
        return soluong;
    }

    public void setSoluong(String soluong) {
        this.soluong = soluong;
    }

    String ngay,so,soluong;
}
