package com.example.testprojectincompany.app.di

import android.content.Context
import com.example.testprojectincompany.app.presentation.screen.hotel.HotelFragment
import com.example.testprojectincompany.app.presentation.screen.room.RoomFragment
import dagger.BindsInstance
import dagger.Component

@Component(modules = [DataModule::class, HotelModule::class, RoomModel::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder
        fun build(): AppComponent
    }

    fun inject(fragment: HotelFragment)
    fun inject(fragment: RoomFragment)
}
