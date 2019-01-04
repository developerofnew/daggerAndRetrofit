package com.nepaliapps.daggerandretrofit.base;

import android.app.Application;

import com.nepaliapps.daggerandretrofit.module.AppModule;
import com.nepaliapps.daggerandretrofit.DaggerNetcomponent;
import com.nepaliapps.daggerandretrofit.module.NetModule;
import com.nepaliapps.daggerandretrofit.Netcomponent;


public class App extends Application {

   private Netcomponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerNetcomponent.builder()
                    .appModule(new AppModule(this))
                    .netModule(new NetModule("https://jsonplaceholder.typicode.com"))
                    .build();
    }

    public Netcomponent getComponent(){

        return component;
    }
}
