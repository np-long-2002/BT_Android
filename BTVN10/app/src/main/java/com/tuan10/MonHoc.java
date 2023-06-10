package com.tuan10;

public class MonHoc {
    public String monhoc;
    public int hocphi;
    public MonHoc() {
    }
    public MonHoc(String monhoc, int hocphi) {
        this.monhoc = monhoc;
        this.hocphi = hocphi;
    }

    @Override
    public String toString() {
        return this.monhoc;
    }
}
