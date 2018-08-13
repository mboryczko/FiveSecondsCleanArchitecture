package pl.michal_boryczko.fiveseconds.internal.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import pl.michal_boryczko.data.db.database.MyRoomDatabase
import javax.inject.Singleton



@Module
class DatabaseModule {

    @Provides
    @Singleton
    internal fun provideDatabase(c : Context): MyRoomDatabase = MyRoomDatabase.getInstance(c)

}
