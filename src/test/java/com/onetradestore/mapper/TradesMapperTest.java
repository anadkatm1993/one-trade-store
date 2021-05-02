package com.onetradestore.mapper;


import com.onetradestore.entity.TradeEntity;
import com.onetradestore.model.ExpiryStatusEnum;
import com.onetradestore.model.TradesModel;
import com.onetradestore.util.InitializeTradeList;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import java.time.LocalDate;

@RunWith(MockitoJUnitRunner.Silent.class)
public class TradesMapperTest {

    private static TradesModel requestModel;

    @InjectMocks
    private TradesMapper tradesMapper;

    @BeforeClass
    public static void init() {
        requestModel = new TradesModel(
                "T1", 1L, "CP-1", "B1", LocalDate.of(2020, 05, 20), LocalDate.now(), ExpiryStatusEnum.N
        );
        InitializeTradeList.init();
    }

    @Test
    public void testSetTradeParameters_whenNewTrade_thenMapAllFieldsFromREquestToEntity() {
        TradeEntity tradeEntity = new TradeEntity(1L, "T1", 2L, "CP-1", "B1", LocalDate.of(2020, 05, 20),
                LocalDate.now(), ExpiryStatusEnum.N);

        tradesMapper.setTradeParameters(requestModel,tradeEntity);
    }


}
