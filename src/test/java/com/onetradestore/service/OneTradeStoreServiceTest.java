package com.onetradestore.service;


import com.onetradestore.entity.TradeEntity;
import com.onetradestore.mapper.TradesMapper;
import com.onetradestore.model.ExpiryStatusEnum;
import com.onetradestore.model.TradesModel;
import com.onetradestore.repository.OneTradeStoreRepository;
import com.onetradestore.util.InitializeTradeList;
import com.onetradestore.util.SaveTradeUtil;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.time.LocalDate;
import java.util.List;

import static com.onetradestore.util.OneTradeStoreCollectionTest.tradeEntityList;

@RunWith(MockitoJUnitRunner.Silent.class)
public class OneTradeStoreServiceTest {

    @InjectMocks
    private OneTradeStoreService oneTradeStoreService;

    @Mock
    private OneTradeStoreRepository oneTradeStoreRepository;

    @Mock
    private SaveTradeUtil saveTradeUtil;

    @Mock
    private TradesMapper tradesMapper;

    @BeforeClass
    public static void init() {
        InitializeTradeList.init();
    }

    @Test
    public void testGetTrades_whenTradesPresentInStore_thenReturnAllTrades() {

        Mockito.when(oneTradeStoreRepository.findAll()).thenReturn(tradeEntityList);
        List<TradeEntity> getTradeEntityList = oneTradeStoreService.getAllTrades();
        Assertions.assertEquals(getTradeEntityList, tradeEntityList);

    }

    @Test
    public void testSaveTrades_whenNewTrade_thenSaveTrade() {
        TradesModel tradesModel = new TradesModel("T8", 1l, "CP-3", "B2",
                LocalDate.of(2014, 05, 20), LocalDate.now(), ExpiryStatusEnum.N);

        TradeEntity tradeEntity = new TradeEntity(null, "T8", 1l, "CP-3", "B2",
                LocalDate.of(2014, 05, 20), LocalDate.now(), ExpiryStatusEnum.N);
        Mockito.when(saveTradeUtil.checkTradeWithExistingVersion(tradesModel))
                .thenReturn(tradeEntity);
        Mockito.when(oneTradeStoreRepository.save(tradeEntity))
                .thenReturn(tradeEntity);
        Assertions.assertEquals(oneTradeStoreService.saveTrade(tradesModel),tradeEntity);

    }

    @Test
    public void testSaveTrades_whenExistingTrade_thenOverrideExistingDataAndSaveTrade() {
        TradesModel tradesModel = new TradesModel("T8", 1l, "CP-3", "B2", LocalDate.of(2014, 05, 20), LocalDate.now(), ExpiryStatusEnum.N);

        TradeEntity tradeEntity = new TradeEntity();
        Mockito.when(saveTradeUtil.checkTradeWithExistingVersion(tradesModel))
                .thenReturn(tradeEntity);
        Mockito.when(oneTradeStoreRepository.save(tradeEntity))
                .thenReturn(tradeEntity);

        Assertions.assertEquals(oneTradeStoreService.saveTrade(tradesModel),tradeEntity);
    }

}
