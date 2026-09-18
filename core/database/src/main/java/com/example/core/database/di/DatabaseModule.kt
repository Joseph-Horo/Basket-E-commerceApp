package com.example.core.database.di

import android.app.Application
import androidx.room.Room
import com.example.core.database.BasketDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideBasketDatabase(app: Application): BasketDatabase{
        return Room.databaseBuilder(app, BasketDatabase::class.java, "basket.db")
            .build()

    }
}