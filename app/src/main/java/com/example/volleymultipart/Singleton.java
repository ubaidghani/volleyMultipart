package com.example.volleymultipart;

import android.content.ContentProvider;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class Singleton {

    private static Singleton singleton;
    private RequestQueue requestQueue;
    private static Context context;

    private Singleton(Context mcontext){
        context = mcontext;
        requestQueue = getRequestQueue();
    }

    private RequestQueue getRequestQueue() {

        if(requestQueue == null){
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }

    public static synchronized Singleton getInstance(Context mcontext){
        if(singleton == null){
            singleton = new Singleton(mcontext);
        }
        return singleton;

    }

    public<T> void addToRequestQueue(Request<T> request){
        getRequestQueue().add(request);
    }
}
