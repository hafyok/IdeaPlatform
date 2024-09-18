package com.example.ideaplatform.di

import android.app.Application
import androidx.room.Room
import com.example.ideaplatform.Data.ItemRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainModule {

    @Provides
    @Singleton
    fun provideMainDb(app: Application): ItemRoomDatabase{
        return Room.databaseBuilder(
            app,
            ItemRoomDatabase::class.java,
            "ItemDB"
        ).createFromAsset("data.db").build()
    }
}