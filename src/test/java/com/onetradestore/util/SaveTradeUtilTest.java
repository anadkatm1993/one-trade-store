package com.onetradestore.util;

import com.onetradestore.entity.TradeEntity;
import com.onetradestore.exception.BadRequestServiceException;
import com.onetradestore.model.ExpiryStatusEnum;
import com.onetradestore.model.TradesModel;
import com.onetradestore.repository.OneTradeStoreRepository;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.Silent.class)
public class SaveTradeUtilTest {

    private static TradesModel requestModel;

    @Mock
    private OneTradeStoreRepository oneTradeStoreRepository;

    @InjectMocks
    private SaveTradeUtil saveTradeUtil;

    @BeforeClass
    public static void init() {
         requestModel = new TradesModel(
                "T1", 1L, "CP-1", "B1", LocalDate.of(2020, 05, 20), LocalDate.now(), ExpiryStatusEnum.N
        );
        InitializeTradeList.init();
    }

    @Test(expected = BadRequestServiceException.class)
    public void testCheckTradeVersion_whenVersionHighTrades_thenThrowException() {
        TradeEntity t1 = new TradeEntity(1L, "T1", 2L, "CP-1", "B1", LocalDate.of(2020, 05, 20),
                LocalDate.now(), ExpiryStatusEnum.N);
        List<TradeEntity> newTradeEntityList = new ArrayList<>();
        newTradeEntityList.add(t1);
        Mockito.when(oneTradeStoreRepository.findAllByTradeId("T1")).thenReturn(newTradeEntityList);
        saveTradeUtil.checkTradeVersion(requestModel);
    }

    @Test
    public void testCheckTradeVersion_whenVersionLow_thenDoNothing() {

        Mockito.when(oneTradeStoreRepository.findAllByTradeId("T1")).thenReturn(null);
        saveTradeUtil.checkTradeVersion(requestModel);

    }

    @Test(expected = BadRequestServiceException.class)
    public void testCheckMaturityDate_whenMaturityDateIsBeforeToday_thenThrowException() {

        saveTradeUtil.checkMaturityDate(requestModel);

    }

    @Test
    public void testCheckMaturityDate_whenMaturityDateIsAfterToday_thenDoNothing() {

        TradesModel newTradeRequestModel = new TradesModel(
                "T1", 3L, "CP-1", "B1", LocalDate.of(2022, 05, 20), LocalDate.now(), ExpiryStatusEnum.N
        );
        saveTradeUtil.checkMaturityDate(newTradeRequestModel);

    }

    @Test
    public void testCheckTradeWithExistingVersion_whenExisting_thenReturnExistingTrade() {

        TradeEntity tradeEntity = new TradeEntity(null, "T1", 1L, "CP-1", "B1"
                , LocalDate.of(2020, 05, 20), LocalDate.now(), ExpiryStatusEnum.N);

        Mockito.when(oneTradeStoreRepository.findByTradeIdAndVersion("T1",1L))
                .thenReturn(tradeEntity);

        Assertions.assertEquals(saveTradeUtil.checkTradeWithExistingVersion(requestModel),tradeEntity);

    }

    @Test
    public void testCheckTradeWithExistingVersion_whenNotExisting_thenReturnNewTrade() {

        Mockito.when(oneTradeStoreRepository.findByTradeIdAndVersion("T1",3L))
                .thenReturn(null);
        TradesModel newTradeRequestModel = new TradesModel(
                "T1", 3L, "CP-1", "B1", LocalDate.of(2020, 05, 20), LocalDate.now(), ExpiryStatusEnum.N
        );

        Assert.assertNotNull(saveTradeUtil.checkTradeWithExistingVersion(newTradeRequestModel));

    }


}
