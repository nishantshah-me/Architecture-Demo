package com.tts.data.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;

import com.commonsware.cwac.saferoom.SafeHelperFactory;
import com.twentytwoseven.android.data.database.dao.AccountBalanceDao;
import com.twentytwoseven.android.data.database.dao.AccountDao;
import com.twentytwoseven.android.data.database.dao.AccountNumberRuleDao;
import com.twentytwoseven.android.data.database.dao.ActionDao;
import com.twentytwoseven.android.data.database.dao.AddressDao;
import com.twentytwoseven.android.data.database.dao.AggregateDao;
import com.twentytwoseven.android.data.database.dao.AmountDao;
import com.twentytwoseven.android.data.database.dao.AutoAccountUpdateDao;
import com.twentytwoseven.android.data.database.dao.BankAccountDetailDao;
import com.twentytwoseven.android.data.database.dao.BankAccountTypeDao;
import com.twentytwoseven.android.data.database.dao.BankDao;
import com.twentytwoseven.android.data.database.dao.CardDao;
import com.twentytwoseven.android.data.database.dao.CategoryDao;
import com.twentytwoseven.android.data.database.dao.CategoryTotalDao;
import com.twentytwoseven.android.data.database.dao.ContributionSourceDao;
import com.twentytwoseven.android.data.database.dao.CustomerInfoDao;
import com.twentytwoseven.android.data.database.dao.DataDao;
import com.twentytwoseven.android.data.database.dao.EmailDao;
import com.twentytwoseven.android.data.database.dao.ExchangeRateDao;
import com.twentytwoseven.android.data.database.dao.FromDao;
import com.twentytwoseven.android.data.database.dao.FundDao;
import com.twentytwoseven.android.data.database.dao.HistoryDao;
import com.twentytwoseven.android.data.database.dao.HobAlertMessageDao;
import com.twentytwoseven.android.data.database.dao.InvestmentConfigDao;
import com.twentytwoseven.android.data.database.dao.LastStateDao;
import com.twentytwoseven.android.data.database.dao.MobileNumberDao;
import com.twentytwoseven.android.data.database.dao.MoneyInOutDao;
import com.twentytwoseven.android.data.database.dao.MostUsedGroupingDao;
import com.twentytwoseven.android.data.database.dao.NotificationSubscriptionDao;
import com.twentytwoseven.android.data.database.dao.OriginDao;
import com.twentytwoseven.android.data.database.dao.OriginalAmountDao;
import com.twentytwoseven.android.data.database.dao.RequestTrackingDao;
import com.twentytwoseven.android.data.database.dao.SearchDao;
import com.twentytwoseven.android.data.database.dao.ServerSelectedDao;
import com.twentytwoseven.android.data.database.dao.ServiceProviderDao;
import com.twentytwoseven.android.data.database.dao.SessionDao;
import com.twentytwoseven.android.data.database.dao.SpendingGroupDao;
import com.twentytwoseven.android.data.database.dao.SpendingGroupTotalDao;
import com.twentytwoseven.android.data.database.dao.SubscriptionInfoDao;
import com.twentytwoseven.android.data.database.dao.TrackedCategoryDao;
import com.twentytwoseven.android.data.database.dao.TransactionDao;
import com.twentytwoseven.android.data.database.dao.UiSettingDao;
import com.twentytwoseven.android.data.database.dao.VisualisationDao;
import com.twentytwoseven.android.data.database.tables.AccountBalanceTable;
import com.twentytwoseven.android.data.database.tables.AccountNumberRuleTable;
import com.twentytwoseven.android.data.database.tables.AccountTable;
import com.twentytwoseven.android.data.database.tables.ActionTable;
import com.twentytwoseven.android.data.database.tables.AddressTable;
import com.twentytwoseven.android.data.database.tables.AggregateTable;
import com.twentytwoseven.android.data.database.tables.AmountTable;
import com.twentytwoseven.android.data.database.tables.AutoAccountUpdateTable;
import com.twentytwoseven.android.data.database.tables.BankAccountDetailTable;
import com.twentytwoseven.android.data.database.tables.BankAccountTypeTable;
import com.twentytwoseven.android.data.database.tables.BankTable;
import com.twentytwoseven.android.data.database.tables.CardTable;
import com.twentytwoseven.android.data.database.tables.CategoryTable;
import com.twentytwoseven.android.data.database.tables.CategoryTotalTable;
import com.twentytwoseven.android.data.database.tables.ContributionSourceTable;
import com.twentytwoseven.android.data.database.tables.CustomerInfoTable;
import com.twentytwoseven.android.data.database.tables.DataTable;
import com.twentytwoseven.android.data.database.tables.EmailTable;
import com.twentytwoseven.android.data.database.tables.ExchangeRateTable;
import com.twentytwoseven.android.data.database.tables.FromTable;
import com.twentytwoseven.android.data.database.tables.FundTable;
import com.twentytwoseven.android.data.database.tables.HistoryTable;
import com.twentytwoseven.android.data.database.tables.HobAlertMessageTable;
import com.twentytwoseven.android.data.database.tables.InvestmentConfigTable;
import com.twentytwoseven.android.data.database.tables.LastStateTable;
import com.twentytwoseven.android.data.database.tables.MobileNumberTable;
import com.twentytwoseven.android.data.database.tables.MoneyInOutTable;
import com.twentytwoseven.android.data.database.tables.MostUsedGroupingTable;
import com.twentytwoseven.android.data.database.tables.NotificationSubscriptionTable;
import com.twentytwoseven.android.data.database.tables.OriginTable;
import com.twentytwoseven.android.data.database.tables.OriginalAmount;
import com.twentytwoseven.android.data.database.tables.RequestTrackingTable;
import com.twentytwoseven.android.data.database.tables.SearchTable;
import com.twentytwoseven.android.data.database.tables.ServerSelectedTable;
import com.twentytwoseven.android.data.database.tables.ServiceProviderTable;
import com.twentytwoseven.android.data.database.tables.SessionTable;
import com.twentytwoseven.android.data.database.tables.SpendingGroupTable;
import com.twentytwoseven.android.data.database.tables.SpendingGroupTotalTable;
import com.twentytwoseven.android.data.database.tables.SubscriptionInfoTable;
import com.twentytwoseven.android.data.database.tables.TrackedCategoryTable;
import com.twentytwoseven.android.data.database.tables.TransactionsTable;
import com.twentytwoseven.android.data.database.tables.UiSettingTable;
import com.twentytwoseven.android.data.database.tables.VisualisationTable;

import timber.log.BuildConfig;

/**
 * View the database at - https://github.com/amitshekhariitbhu/Android-Debug-Database#using-android-debug-database-library-in-your-application
 */

@Database(entities = {AccountTable.class, AccountBalanceTable.class,
    AccountNumberRuleTable.class, ActionTable.class, AddressTable.class,
    AggregateTable.class, AmountTable.class, AutoAccountUpdateTable.class, BankTable.class, BankAccountDetailTable.class,
    BankAccountTypeTable.class, CardTable.class, CategoryTable.class, CategoryTotalTable.class, ContributionSourceTable.class,
    CustomerInfoTable.class, DataTable.class, EmailTable.class, ExchangeRateTable.class, FromTable.class, FundTable.class,
    HistoryTable.class, HobAlertMessageTable.class, InvestmentConfigTable.class, LastStateTable.class, MobileNumberTable.class,
    MoneyInOutTable.class, MostUsedGroupingTable.class, NotificationSubscriptionTable.class, OriginTable.class,
    OriginalAmount.class, RequestTrackingTable.class, SearchTable.class,
    ServerSelectedTable.class, ServiceProviderTable.class, SessionTable.class, SpendingGroupTable.class,
    SpendingGroupTotalTable.class, SubscriptionInfoTable.class, TrackedCategoryTable.class, TransactionsTable.class,
    UiSettingTable.class, VisualisationTable.class}, version = 1, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {

    public static final String DB_NAME = "tts_db";
    private static AppDatabase INSTANCE;

    public abstract AccountBalanceDao getAccountBalanceDao();
    public abstract AccountDao getAccountDao();
    public abstract AccountNumberRuleDao getAccountNumberRuleDao();
    public abstract ActionDao getActionDao();
    public abstract AddressDao getAddressDao();
    public abstract AggregateDao getAggregateDao();
    public abstract AmountDao getAmountDao();
    public abstract AutoAccountUpdateDao getAutoAccountUpdateDao();
    public abstract BankAccountDetailDao getBankAccountDetailDao();
    public abstract BankAccountTypeDao getBankAccountTypeDao();
    public abstract BankDao getBankDao();
    public abstract CardDao getCardDao();
    public abstract CategoryDao getCategoryDao();
    public abstract CategoryTotalDao getCategoryTotalDao();
    public abstract ContributionSourceDao getContributionSourceDao();
    public abstract CustomerInfoDao getCustomerInfoDao();
    public abstract DataDao getDataDao();
    public abstract EmailDao getEmailDao();
    public abstract ExchangeRateDao getExchangeRateDao();
    public abstract FromDao getFromDao();
    public abstract FundDao getFundDao();
    public abstract HistoryDao getHistoryDao();
    public abstract HobAlertMessageDao getHobAlertMessageDao();
    public abstract InvestmentConfigDao getInvestmentConfigDao();
    public abstract LastStateDao getLastStateDao();
    public abstract MobileNumberDao getMobileNumberDao();
    public abstract MoneyInOutDao getMoneyInOutDao();
    public abstract MostUsedGroupingDao getMostUsedGroupingDao();
    public abstract NotificationSubscriptionDao getNotificationSubscriptionDao();
    public abstract OriginalAmountDao getOriginalAmountDao();
    public abstract OriginDao getOriginDao();
    public abstract RequestTrackingDao getRequestTrackingDao();
    public abstract SearchDao getSearchDao();
    public abstract ServerSelectedDao getServerSelectedDao();
    public abstract ServiceProviderDao getServiceProviderDao();
    public abstract SessionDao getSessionDao();
    public abstract SpendingGroupDao getSpendingGroupDao();
    public abstract SpendingGroupTotalDao getSpendingGroupTotalDao();
    public abstract SubscriptionInfoDao getSubscriptionInfoDao();
    public abstract TrackedCategoryDao getTrackedCategoryDao();
    public abstract TransactionDao getTransactionDao();
    public abstract UiSettingDao getUiSettingDao();
    public abstract VisualisationDao getVisualisationDao();

    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            // Since we didn't alter the table, there's nothing else to do here.

            // Create the new table
            //database.execSQL("CREATE TABLE users_new (userid TEXT, username TEXT, last_update INTEGER, PRIMARY KEY(userid))");

            // Copy the data
            //database.execSQL("INSERT INTO users_new (userid, username, last_update) SELECT userid, username, last_update FROM users");

            // Remove the old table
            //database.execSQL("DROP TABLE users");

            // Change the table name to the correct one
            //database.execSQL("ALTER TABLE users_new RENAME TO users");

            //Add column to table
            //database.execSQL("ALTER TABLE users "+ " ADD COLUMN last_update INTEGER");

        }
    };

    public static AppDatabase getInMemoryDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.inMemoryDatabaseBuilder(context.getApplicationContext(),
                AppDatabase.class).build();
        }
        return INSTANCE;
    }

    public static AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            SafeHelperFactory factory = new SafeHelperFactory(new char[]{'d','p','U','a','r','K','f','d','N','2','l','N','c','M','J','2','f','P','t','E','/','='});
            Builder<AppDatabase> dbBuilder = Room.databaseBuilder(context.getApplicationContext(),
                AppDatabase.class, DB_NAME)
                .fallbackToDestructiveMigration();
                //.addMigrations(MIGRATION_1_2)

            //Only encrypt database for production app
            if (BuildConfig.BUILD_TYPE.equalsIgnoreCase("release")) {
                dbBuilder.openHelperFactory(factory);
            }

            INSTANCE = dbBuilder.build();
        }
        return INSTANCE;
    }
}
