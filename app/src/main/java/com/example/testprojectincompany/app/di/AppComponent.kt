package com.example.testprojectincompany.app.di

import android.content.Context
import com.example.testprojectincompany.app.presentation.screen.hotel.HotelFragment
import dagger.BindsInstance
import dagger.Component

@Component(modules = [DataModule::class, HotelModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder
        fun build(): AppComponent
    }

    fun inject(fragment: HotelFragment)
}
