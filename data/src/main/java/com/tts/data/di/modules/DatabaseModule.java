package com.tts.data.di.modules;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.commonsware.cwac.saferoom.SafeHelperFactory;
import com.twentytwoseven.android.data.BuildConfig;
import com.twentytwoseven.android.data.database.AppDatabase;
import com.twentytwoseven.android.data.database.dao.AccountBalanceDao;
import com.twentytwoseven.android.data.database.dao.AccountDao;
import com.twentytwoseven.android.data.database.dao.AggregateDao;
import com.twentytwoseven.android.data.database.dao.BankAccountTypeDao;
import com.twentytwoseven.android.data.database.dao.BankDao;
import com.twentytwoseven.android.data.database.dao.CardDao;
import com.twentytwoseven.android.data.database.dao.CategoryDao;
import com.twentytwoseven.android.data.database.dao.CategoryTotalDao;
import com.twentytwoseven.android.data.database.dao.ContributionSourceDao;
import com.twentytwoseven.android.data.database.dao.CustomerInfoDao;
import com.twentytwoseven.android.data.database.dao.ExchangeRateDao;
import com.twentytwoseven.android.data.database.dao.FundDao;
import com.twentytwoseven.android.data.database.dao.InvestmentConfigDao;
import com.twentytwoseven.android.data.database.dao.MoneyInOutDao;
import com.twentytwoseven.android.data.database.dao.RequestTrackingDao;
import com.twentytwoseven.android.data.database.dao.ServiceProviderDao;
import com.twentytwoseven.android.data.database.dao.SessionDao;
import com.twentytwoseven.android.data.database.dao.SpendingGroupDao;
import com.twentytwoseven.android.data.database.dao.SpendingGroupTotalDao;
import com.twentytwoseven.android.data.database.dao.TrackedCategoryDao;
import com.twentytwoseven.android.data.database.dao.TransactionDao;
import com.twentytwoseven.android.data.database.dao.UiSettingDao;
import com.twentytwoseven.android.data.database.dao.VisualisationDao;
import com.twentytwoseven.android.data.mapper.AccountDataMapper;
import com.twentytwoseven.android.data.mapper.AggregateDataMapper;
import com.twentytwoseven.android.data.mapper.SessionEntityDataMapper;
import com.twentytwoseven.android.data.repository.AccountDataRepository;
import com.twentytwoseven.android.data.repository.AggregateDataRepository;
import com.twentytwoseven.android.data.repository.SessionDataRepository;
import com.twentytwoseven.android.data.repository.datasource.account.AccountDiskDataStore;
import com.twentytwoseven.android.data.repository.datasource.aggregate.AggregateCloudDataStore;
import com.twentytwoseven.android.data.repository.datasource.aggregate.AggregateDataStoreFactory;
import com.twentytwoseven.android.data.repository.datasource.aggregate.AggregateDiskDataStore;
import com.twentytwoseven.android.data.repository.datasource.session.SessionDiskDataStore;
import com.twentytwoseven.android.domain.repository.AccountRepository;
import com.twentytwoseven.android.domain.repository.AggregateRepository;
import com.twentytwoseven.android.domain.repository.SessionRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Nishant on 08-Nov-17.
 */
@Module
public class DatabaseModule {

    @Singleton
    @Provides
    AppDatabase providesDatabase(Context context) {
        String DB_NAME = "tts_db";
        RoomDatabase.Builder<AppDatabase> dbBuilder = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, DB_NAME);

        if (BuildConfig.BUILD_TYPE.equals("release")) {
            SafeHelperFactory factory = new SafeHelperFactory(new char[]{'d','p','U','a','r','K','f','d','N','2','l','N','c','M','J','2','f','P','t','E','/','='});
            dbBuilder.openHelperFactory(factory);
        }

        return dbBuilder.build();
    }

    //-------------------------Session----------------------------
    @Singleton
    @Provides
    SessionDao providesSessionDao(AppDatabase database) {
        return database.getSessionDao();
    }

    @Singleton
    @Provides
    SessionEntityDataMapper provideSessionEntityDataMapper(){
        return new SessionEntityDataMapper();
    }

    @Singleton
    @Provides
    SessionDiskDataStore provideSessionDiskDataStore(SessionDao sessionDao, SessionEntityDataMapper mapper) {
        return new SessionDiskDataStore(sessionDao, mapper);
    }

    @Provides @Singleton
    SessionRepository providesSessionRepository(SessionDataRepository sessionRepository) {
        return sessionRepository;
    }
    //-------------------------Account----------------------------

    @Singleton
    @Provides
    ServiceProviderDao provideServiceProviderDao(AppDatabase database) {
        return database.getServiceProviderDao();
    }

    @Singleton
    @Provides
    AccountDataMapper provideAccountEntityDataMapper(){
        return new AccountDataMapper();
    }

    @Singleton
    @Provides
    AccountDiskDataStore provideAccountDiskDataStore(ServiceProviderDao serviceProviderDao, AccountDao accountDao, AccountDataMapper mapper) {
        return new AccountDiskDataStore(serviceProviderDao, accountDao, mapper);
    }

    @Provides @Singleton
    AccountRepository provideAccountRepository(AccountDataRepository accountDataRepository){
        return accountDataRepository;
    }

    //-------------------------Aggregate----------------------------
    @Provides @Singleton
    AggregateDataRepository provideAggregateDataRepository(AggregateDataMapper mapper, AggregateDataStoreFactory factory){
        return new AggregateDataRepository(mapper, factory);
    }

    @Provides @Singleton
    AggregateRepository provideAggregateRepository(AggregateDataRepository repository){
        return repository;
    }

    @Provides @Singleton
    AggregateDataMapper provideAggregateDataMapper() {
        return new AggregateDataMapper();
    }

    @Provides @Singleton
    AggregateDataStoreFactory provideAggregateDataStoreFactory(AggregateCloudDataStore cloudDataStore, AggregateDiskDataStore diskDataStore) {
        return new AggregateDataStoreFactory(cloudDataStore, diskDataStore);
    }

    @Provides @Singleton
    AccountBalanceDao provideAccountBalanceDao(AppDatabase database) {return database.getAccountBalanceDao();}

    @Provides @Singleton
    AccountDao provideAccountDao(AppDatabase database) {return database.getAccountDao();}

    @Provides @Singleton
    AggregateDao provideAggregateDao(AppDatabase database) {return database.getAggregateDao();}

    @Provides @Singleton
    BankAccountTypeDao provideBankAccountTypeDao(AppDatabase database) {return database.getBankAccountTypeDao();}

    @Provides @Singleton
    BankDao provideBankDao(AppDatabase db) {return db.getBankDao();}

    @Provides @Singleton
    CardDao provideCardDao(AppDatabase database) {return database.getCardDao();}

    @Provides @Singleton
    CategoryDao provideCategoryDao(AppDatabase db) {return db.getCategoryDao();}

    @Provides @Singleton
    CategoryTotalDao provideCategoryTotalDao(AppDatabase database) {return database.getCategoryTotalDao();}

    @Provides @Singleton
    ContributionSourceDao provideContributionSourceDao(AppDatabase database) {return database.getContributionSourceDao();}

    @Provides @Singleton
    CustomerInfoDao provideCustomerInfoDao(AppDatabase database) {return database.getCustomerInfoDao();}

    @Provides @Singleton
    ExchangeRateDao provideExchangeRateDao(AppDatabase database) {return database.getExchangeRateDao();}

    @Provides @Singleton
    FundDao provideFundDao(AppDatabase db) {return db.getFundDao();}

    @Provides @Singleton
    InvestmentConfigDao provideInvestmentConfigDao(AppDatabase database) {return database.getInvestmentConfigDao();}

    @Provides @Singleton
    MoneyInOutDao provideMoneyInOutDao(AppDatabase db) {return db.getMoneyInOutDao();}

    @Provides @Singleton
    RequestTrackingDao provideRequestTrackingDao(AppDatabase db) {return db.getRequestTrackingDao();}

    @Provides @Singleton
    SpendingGroupDao provideSpendingGroupDao(AppDatabase database) {return database.getSpendingGroupDao();}

    @Provides @Singleton
    SpendingGroupTotalDao provideSpendingGroupTotalDao(AppDatabase database) {return database.getSpendingGroupTotalDao();}

    @Provides @Singleton
    TrackedCategoryDao provideTrackedCategoryDao(AppDatabase database) {return database.getTrackedCategoryDao();}

    @Provides @Singleton
    TransactionDao provideTransactionDao(AppDatabase db) {return db.getTransactionDao();}

    @Provides @Singleton
    UiSettingDao provideUiSettingDao(AppDatabase database) {return database.getUiSettingDao();}

    @Provides @Singleton
    VisualisationDao provideVisualisationDao(AppDatabase db) {return db.getVisualisationDao();}
}
