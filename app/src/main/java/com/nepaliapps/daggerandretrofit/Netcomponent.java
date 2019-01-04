package com.nepaliapps.daggerandretrofit;

import com.nepaliapps.daggerandretrofit.module.AppModule;
import com.nepaliapps.daggerandretrofit.module.NetModule;

import javax.inject.Singleton;

import dagger.Component;
@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface Netcomponent {

    void inject(MainActivity  targetActivity);
}
