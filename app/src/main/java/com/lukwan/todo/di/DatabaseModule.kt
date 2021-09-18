package com.lukwan.todo.di

import android.content.Context
import androidx.room.Room
import com.lukwan.todo.data.TodoDatabase
import com.lukwan.todo.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        TodoDatabase::class.java,
        Constants.DATABASE_NAME,
    ).build();

    @Singleton
    @Provides
    fun provideTodoDao(database: TodoDatabase) = database.todoDao()
}