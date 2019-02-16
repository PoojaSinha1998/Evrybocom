package com.intellinettechnologies.evrybocom.application;

import android.app.Application;
import android.graphics.drawable.Drawable;

import com.intellinettechnologies.evrybocom.model.Data;

import java.util.ArrayList;


public class myapplication extends Application {

    public  static ArrayList<Drawable> myImages;
    public static ArrayList<Data> data;

    public static ArrayList<Data> getExamples() {
        return data;
    }

    public static void setExamples(ArrayList<Data> data) {
        myapplication.data = data;
    }

    public static ArrayList<Drawable> getMyImages() {
        return myImages;
    }

    public static void setMyImages(ArrayList<Drawable> myImages) {
        myapplication.myImages = myImages;
    }
}
