package com.tts.data.database;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.twentytwoseven.android.data.database.tables.AccountBalanceTable;
import com.twentytwoseven.android.data.database.tables.AccountLoginFieldTable;
import com.twentytwoseven.android.data.database.tables.AccountLoginFormTable;
import com.twentytwoseven.android.data.database.tables.AccountNumberRuleTable;
import com.twentytwoseven.android.data.database.tables.AccountTable;
import com.twentytwoseven.android.data.database.tables.ActionTable;
import com.twentytwoseven.android.data.database.tables.AddressTable;
import com.twentytwoseven.android.data.database.tables.AmountTable;
import com.twentytwoseven.android.data.database.tables.AutoAccountUpdateTable;
import com.twentytwoseven.android.data.database.tables.BankAccountDetailTable;
import com.twentytwoseven.android.data.database.tables.BankAccountTypeTable;
import com.twentytwoseven.android.data.database.tables.BankTable;
import com.twentytwoseven.android.data.database.tables.CardTable;
import com.twentytwoseven.android.data.database.tables.CategoryTable;
import com.twentytwoseven.android.data.database.tables.CategoryTotalTable;
import com.twentytwoseven.android.data.database.tables.ContextTable;
import com.twentytwoseven.android.data.database.tables.ContextWrapperTable;
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
import com.twentytwoseven.android.data.database.tables.SpendingGroupTable;
import com.twentytwoseven.android.data.database.tables.SpendingGroupTotalTable;
import com.twentytwoseven.android.data.database.tables.SubscriptionInfoTable;
import com.twentytwoseven.android.data.database.tables.TrackedCategoryTable;
import com.twentytwoseven.android.data.database.tables.TransactionsTable;
import com.twentytwoseven.android.data.database.tables.UiSettingTable;
import com.twentytwoseven.android.data.database.tables.VisualisationTable;

import java.lang.reflect.Type;

/**
 * Created by manenga on 2017/11/07.
 */

public class Converters {

    @TypeConverter
    public static String fromAmount(AmountTable amountTable) {
        String json = new Gson().toJson(amountTable);
        return json;
    }

    @TypeConverter
    public static AmountTable toAmount(String value) {
        Type type = new TypeToken<AmountTable>() {}.getType();
        return new Gson().fromJson(value, type);
    }

    @TypeConverter
    public static String fromData(DataTable dataTable) {
        String json = new Gson().toJson(dataTable);
        return json;
    }

    @TypeConverter
    public static DataTable toData(String data) {
        Type type = new TypeToken<DataTable>() {}.getType();
        return new Gson().fromJson(data, type);
    }

    @TypeConverter
    public static String fromSearch(SearchTable searchTable) {
        if(searchTable==null){
            return null;
        }
        return searchTable.toJsonObject().toString();
    }

    @TypeConverter
    public static SearchTable toSearch(String search) {
        Type type = new TypeToken<SearchTable>() {}.getType();
        return new Gson().fromJson(search, type);
    }

    @TypeConverter
    public static String fromOrigin(OriginTable originTable) {
        String json = new Gson().toJson(originTable);
        return json;
    }

    @TypeConverter
    public static OriginTable toOrigin(String origin) {
        Type type = new TypeToken<OriginTable>() {}.getType();
        return new Gson().fromJson(origin, type);
    }

    @TypeConverter
    public static String fromFrom(FromTable fromTable) {
        String json = new Gson().toJson(fromTable);
        return json;
    }

    @TypeConverter
    public static FromTable toFrom(String from) {
        Type type = new TypeToken<FromTable>() {}.getType();
        return new Gson().fromJson(from, type);
    }

    @TypeConverter
    public static String fromServerSelected(ServerSelectedTable value) {
        String json = new Gson().toJson(value);
        return json;
    }

    @TypeConverter
    public static ServerSelectedTable toServerSelected(String value) {
        Type type = new TypeToken<ServerSelectedTable>() {}.getType();
        return new Gson().fromJson(value, type);
    }

    @TypeConverter
    public static String fromAccountNumberRule(AccountNumberRuleTable value) {
        String json = new Gson().toJson(value);
        return json;
    }

    @TypeConverter
    public static AccountNumberRuleTable toAccountNumberRule(String value) {
        Type type = new TypeToken<AccountNumberRuleTable>() {}.getType();
        return new Gson().fromJson(value, type);
    }

    @TypeConverter
    public static String fromAddress(AddressTable value) {
        String json = new Gson().toJson(value);
        return json;
    }

    @TypeConverter
    public static AddressTable toAddress(String value) {
        Type type = new TypeToken<AddressTable>() {}.getType();
        return new Gson().fromJson(value, type);
    }

    @TypeConverter
    public static String fromAccountLoginForm(AccountLoginFormTable value) {
        String json = new Gson().toJson(value);
        return json;
    }

    @TypeConverter
    public static AccountLoginFormTable toAccountLoginForm(String value) {
        Type type = new TypeToken<AccountLoginFormTable>() {}.getType();
        return new Gson().fromJson(value, type);
    }

    @TypeConverter
    public static String fromSpendingGroup(SpendingGroupTable value) {
        String json = new Gson().toJson(value);
        return json;
    }

    @TypeConverter
    public static SpendingGroupTable toSpendingGroup(String value) {
        Type type = new TypeToken<SpendingGroupTable>() {}.getType();
        return new Gson().fromJson(value, type);
    }

    @TypeConverter
    public static String fromOriginalAmount(OriginalAmount value) {
        String json = new Gson().toJson(value);
        return json;
    }

    @TypeConverter
    public static OriginalAmount toOriginalAmount(String value) {
        Type type = new TypeToken<OriginalAmount>() {}.getType();
        return new Gson().fromJson(value, type);
    }

    @TypeConverter
    public static String fromCategory(CategoryTable value) {
        String json = new Gson().toJson(value);
        return json;
    }

    @TypeConverter
    public static CategoryTable toCategory(String value) {
        Type type = new TypeToken<CategoryTable>() {}.getType();
        return new Gson().fromJson(value, type);
    }

    @TypeConverter
    public static String fromHobAlertMessage(LastStateTable value) {
        String json = new Gson().toJson(value);
        return json;
    }

    @TypeConverter
    public static LastStateTable toLastState(String value) {
        Type type = new TypeToken<LastStateTable>() {}.getType();
        return new Gson().fromJson(value, type);
    }

    @TypeConverter
    public static String fromIntArray(int[] value) {
        String json = new Gson().toJson(value);
        return json;
    }

    @TypeConverter
    public static int[] toIntArray(String value) {
        Type listType = new TypeToken<int[]>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromNotificationSubscription(NotificationSubscriptionTable value) {
        String json = new Gson().toJson(value);
        return json;
    }

    @TypeConverter
    public static NotificationSubscriptionTable toNotificationSubscription(String value) {
        Type type = new TypeToken<NotificationSubscriptionTable>() {}.getType();
        return new Gson().fromJson(value, type);
    }

    @TypeConverter
    public static String fromHobAlertMessage(HobAlertMessageTable value) {
        String json = new Gson().toJson(value);
        return json;
    }

    @TypeConverter
    public static HobAlertMessageTable toHobAlertMessage(String value) {
        Type type = new TypeToken<HobAlertMessageTable>() {}.getType();
        return new Gson().fromJson(value, type);
    }

    @TypeConverter
    public static String fromStringArray(String[] array) {
        String json = new Gson().toJson(array);
        return json;
    }

    @TypeConverter
    public static String[] toStringArray(String value) {
        Type listType = new TypeToken<String[]>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromAccountLoginFieldArray(AccountLoginFieldTable[] array) {
        String json = new Gson().toJson(array);
        return json;
    }

    @TypeConverter
    public static AccountLoginFieldTable[] toAccountLoginFieldArray(String value) {
        Type listType = new TypeToken<AccountLoginFieldTable[]>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromSubscriptionInfo(SubscriptionInfoTable array) {
        String json = new Gson().toJson(array);
        return json;
    }

    @TypeConverter
    public static SubscriptionInfoTable toSubscriptionInfo(String value) {
        Type listType = new TypeToken<SubscriptionInfoTable>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromMobileNumberArray(MobileNumberTable[] array) {
        String json = new Gson().toJson(array);
        return json;
    }

    @TypeConverter
    public static MobileNumberTable[] toMobileNumberArray(String value) {
        Type listType = new TypeToken<MobileNumberTable[]>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromEmailArray(EmailTable[] array) {
        String json = new Gson().toJson(array);
        return json;
    }

    @TypeConverter
    public static EmailTable[] toEmailArray(String value) {
        Type listType = new TypeToken<EmailTable[]>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromBankAccountDetailArray(BankAccountDetailTable[] array) {
        String json = new Gson().toJson(array);
        return json;
    }

    @TypeConverter
    public static BankAccountDetailTable[] toBankAccountDetailArray(String value) {
        Type listType = new TypeToken<BankAccountDetailTable[]>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromAutoAccountUpdate(AutoAccountUpdateTable array) {
        String json = new Gson().toJson(array);
        return json;
    }

    @TypeConverter
    public static AutoAccountUpdateTable toAccountAutoAccountUpdate(String value) {
        Type listType = new TypeToken<AutoAccountUpdateTable>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromMostUsedGroupingArray(MostUsedGroupingTable[] array) {
        String json = new Gson().toJson(array);
        return json;
    }

    @TypeConverter
    public static MostUsedGroupingTable[] toMostUsedGroupingArray(String value) {
        Type listType = new TypeToken<MostUsedGroupingTable[]>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromHistoryArray(HistoryTable[] array) {
        String json = new Gson().toJson(array);
        return json;
    }

    @TypeConverter
    public static HistoryTable[] toHistoryArray(String value) {
        Type listType = new TypeToken<HistoryTable[]>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromActionArray(ActionTable[] array) {
        String json = new Gson().toJson(array);
        return json;
    }

    @TypeConverter
    public static ActionTable[] toActionArray(String value) {
        Type listType = new TypeToken<ActionTable[]>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromVisualisationArray(VisualisationTable[] array) {
        String json = new Gson().toJson(array);
        return json;
    }

    @TypeConverter
    public static VisualisationTable[] toVisualisationArray(String value) {
        Type listType = new TypeToken<VisualisationTable[]>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromUiSettingArray(UiSettingTable[] array) {
        String json = new Gson().toJson(array);
        return json;
    }

    @TypeConverter
    public static UiSettingTable[] toUiSettingArray(String value) {
        Type listType = new TypeToken<UiSettingTable[]>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromTransactionArray(TransactionsTable[] array) {
        String json = new Gson().toJson(array);
        return json;
    }

    @TypeConverter
    public static TransactionsTable[] toTransactionArray(String value) {
        Type listType = new TypeToken<TransactionsTable[]>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromTrackedCategoryArray(TrackedCategoryTable[] array) {
        String json = new Gson().toJson(array);
        return json;
    }

    @TypeConverter
    public static TrackedCategoryTable[] toTrackedCategoryArray(String value) {
        Type listType = new TypeToken<TrackedCategoryTable[]>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromSpendingGroupArray(SpendingGroupTable[] array) {
        String json = new Gson().toJson(array);
        return json;
    }

    @TypeConverter
    public static SpendingGroupTable[] toSpendingGroupArray(String value) {
        Type listType = new TypeToken<SpendingGroupTable[]>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromContributionSourceArray(ContributionSourceTable[] array) {
        String json = new Gson().toJson(array);
        return json;
    }

    @TypeConverter
    public static ContributionSourceTable[] toContributionSourceArray(String value) {
        Type listType = new TypeToken<ContributionSourceTable[]>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromCategoryTotalArray(CategoryTotalTable[] array) {
        String json = new Gson().toJson(array);
        return json;
    }

    @TypeConverter
    public static CategoryTotalTable[] toCategoryTotalArray(String value) {
        Type listType = new TypeToken<CategoryTotalTable[]>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromCategoryArray(CategoryTable[] array) {
        String json = new Gson().toJson(array);
        return json;
    }

    @TypeConverter
    public static CategoryTable[] toCategoryArray(String value) {
        Type listType = new TypeToken<CategoryTable[]>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromCardArray(CardTable[] array) {
        String json = new Gson().toJson(array);
        return json;
    }

    @TypeConverter
    public static CardTable[] toCardArray(String value) {
        Type listType = new TypeToken<CardTable[]>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromBankArray(BankTable[] array) {
        String json = new Gson().toJson(array);
        return json;
    }

    @TypeConverter
    public static BankTable[] toBankArray(String value) {
        Type listType = new TypeToken<BankTable[]>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromBankAccountTypeArray(BankAccountTypeTable[] array) {
        String json = new Gson().toJson(array);
        return json;
    }

    @TypeConverter
    public static BankAccountTypeTable[] toBankAccountTypeArray(String value) {
        Type listType = new TypeToken<BankAccountTypeTable[]>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromAccountArray(AccountTable[] array) {
        String json = new Gson().toJson(array);
        return json;
    }

    @TypeConverter
    public static AccountTable[] toAccountArray(String value) {
        Type listType = new TypeToken<AccountTable[]>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromAccountBalanceArray(AccountBalanceTable[] array) {
        String json = new Gson().toJson(array);
        return json;
    }

    @TypeConverter
    public static AccountBalanceTable[] toAccountBalanceArray(String value) {
        Type listType = new TypeToken<AccountBalanceTable[]>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromCustomerInfo(CustomerInfoTable array) {
        String json = new Gson().toJson(array);
        return json;
    }

    @TypeConverter
    public static CustomerInfoTable toCustomerInfo(String value) {
        Type type = new TypeToken<CustomerInfoTable[]>() {}.getType();
        return new Gson().fromJson(value, type);
    }

    @TypeConverter
    public static String fromExchangeRateArray(ExchangeRateTable[] array) {
        String json = new Gson().toJson(array);
        return json;
    }

    @TypeConverter
    public static ExchangeRateTable[] toExchangeRateArray(String value) {
        Type listType = new TypeToken<ExchangeRateTable[]>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromFundArray(FundTable[] array) {
        String json = new Gson().toJson(array);
        return json;
    }

    @TypeConverter
    public static FundTable[] toFundArray(String value) {
        Type listType = new TypeToken<FundTable[]>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromInvestmentConfig(InvestmentConfigTable value) {
        String json = new Gson().toJson(value);
        return json;
    }

    @TypeConverter
    public static InvestmentConfigTable toInvestmentConfig(String value) {
        Type listType = new TypeToken<InvestmentConfigTable>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromInvestmentConfigArray(InvestmentConfigTable[] array) {
        String json = new Gson().toJson(array);
        return json;
    }

    @TypeConverter
    public static InvestmentConfigTable[] toInvestmentConfigArray(String value) {
        Type listType = new TypeToken<InvestmentConfigTable[]>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromMoneyInOutArray(MoneyInOutTable[] array) {
        String json = new Gson().toJson(array);
        return json;
    }

    @TypeConverter
    public static MoneyInOutTable[] toMoneyInOutArray(String value) {
        Type listType = new TypeToken<MoneyInOutTable[]>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromRequestTrackingArray(RequestTrackingTable[] array) {
        String json = new Gson().toJson(array);
        return json;
    }

    @TypeConverter
    public static RequestTrackingTable[] toRequestTrackingArray(String value) {
        Type listType = new TypeToken<RequestTrackingTable[]>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromServiceProviderArray(ServiceProviderTable[] array) {
        String json = new Gson().toJson(array);
        return json;
    }

    @TypeConverter
    public static ServiceProviderTable[] toServiceProviderArray(String value) {
        Type listType = new TypeToken<ServiceProviderTable[]>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromSpendingGroupTotalArray(SpendingGroupTotalTable[] array) {
        String json = new Gson().toJson(array);
        return json;
    }

    @TypeConverter
    public static SpendingGroupTotalTable[] toSpendingGroupTotalArray(String value) {
        Type listType = new TypeToken<SpendingGroupTotalTable[]>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static ContextTable toContextTable(String value) {
        Type listType = new TypeToken<ContextTable>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromContextTable(ContextTable val) {
        String json = new Gson().toJson(val);
        return json;
    }

    @TypeConverter
    public static ContextWrapperTable toContextWrapperTable(String value) {
        Type listType = new TypeToken<ContextWrapperTable>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromContextWrapperTable(ContextWrapperTable val) {
        String json = new Gson().toJson(val);
        return json;
    }
}
