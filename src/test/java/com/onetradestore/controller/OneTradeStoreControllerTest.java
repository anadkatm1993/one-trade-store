package com.onetradestore.controller;


import com.onetradestore.entity.TradeEntity;
import com.onetradestore.mapper.TradesMapper;
import com.onetradestore.model.ExpiryStatusEnum;
import com.onetradestore.model.TradesModel;
import com.onetradestore.repository.OneTradeStoreRepository;
import com.onetradestore.service.OneTradeStoreService;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

import static com.onetradestore.util.OneTradeStoreCollectionTest.tradeEntityList;

@RunWith(MockitoJUnitRunner.Silent.class)
public class OneTradeStoreControllerTest {

    @InjectMocks
    private OneTradeStoreController oneTradeStoreController;

    @Mock
    private OneTradeStoreService oneTradeStoreService;

    private static TradesModel requestModel;

    @BeforeClass
    public static void init() {
        requestModel = new TradesModel(
                "T1", 1L, "CP-1", "B1", LocalDate.of(2020, 05, 20), LocalDate.now(), ExpiryStatusEnum.N
        );
        InitializeTradeList.init();
    }

    @Test
    public void testGetAllTrades() {

        Mockito.when(oneTradeStoreService.getAllTrades()).thenReturn(tradeEntityList);
        ResponseEntity<List<TradeEntity>> responseEntity = new ResponseEntity<>(tradeEntityList, HttpStatus.OK);
        Assertions.assertEquals(oneTradeStoreController.getAllTrades(), responseEntity);

    }

    @Test
    public void testSaveTrades_whenNewTrade_thenSaveTrade() {

        TradeEntity tradeEntity = new TradeEntity(null, "T8", 1l, "CP-3", "B2",
                LocalDate.of(2014, 05, 20), LocalDate.now(), ExpiryStatusEnum.N);
        Mockito.when(oneTradeStoreService.saveTrade(requestModel)).thenReturn(tradeEntity);
        ResponseEntity<TradeEntity> responseEntity = new ResponseEntity<>(tradeEntity, HttpStatus.CREATED);
        Assertions.assertEquals(oneTradeStoreController.saveTrade(requestModel), responseEntity);

    }

}
