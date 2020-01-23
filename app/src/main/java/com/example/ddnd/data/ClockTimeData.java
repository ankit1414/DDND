package com.example.ddnd.data;

public class ClockTimeData {
    int imageRes;
    String time;

    public ClockTimeData(int imageRes , String time){
        this.imageRes = imageRes;
        this.time = time;
    }

    public int getImageRes() {
        return imageRes;
    }

    public String getTime() {
        return time;
    }
}
