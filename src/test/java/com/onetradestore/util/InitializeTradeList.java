package com.onetradestore.util;

import com.onetradestore.entity.TradeEntity;
import com.onetradestore.model.ExpiryStatusEnum;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;

import java.time.LocalDate;

import static com.onetradestore.util.OneTradeStoreCollectionTest.tradeEntityList;

public class InitializeTradeList {

    @BeforeClass
    public static void init() {
        TradeEntity t1 = new TradeEntity(1L, "T1", 1L, "CP-1", "B1", LocalDate.of(2020, 05, 20), LocalDate.now(), ExpiryStatusEnum.N);
        TradeEntity t2 = new TradeEntity(2L, "T2", 3l, "CP-2", "B1", LocalDate.of(2021, 05, 20), LocalDate.now(), ExpiryStatusEnum.N);
        TradeEntity t3 = new TradeEntity(3L, "T2", 2l, "CP-1", "B1", LocalDate.of(2021, 05, 20), LocalDate.of(2015, 03, 14), ExpiryStatusEnum.N);
        TradeEntity t4 = new TradeEntity(4L, "T3", 3l, "CP-3", "B2", LocalDate.of(2014, 05, 20), LocalDate.now(), ExpiryStatusEnum.Y);
        TradeEntity t5 = new TradeEntity(5L, "T7", 3l, "CP-3", "B2", LocalDate.of(2014, 05, 20), LocalDate.now(), ExpiryStatusEnum.N);
        TradeEntity t6 = new TradeEntity(1L, "T1", 2L, "CP-1", "B1", LocalDate.of(2020, 05, 20), LocalDate.now(), ExpiryStatusEnum.N);

        tradeEntityList.add(t1);
        tradeEntityList.add(t2);
        tradeEntityList.add(t3);
        tradeEntityList.add(t4);
        tradeEntityList.add(t5);
        tradeEntityList.add(t6);

    }


}
