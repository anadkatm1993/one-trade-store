package com.onetradestore.util;

import com.onetradestore.repository.OneTradeStoreRepository;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static com.onetradestore.util.OneTradeStoreCollectionTest.tradeEntityList;


@RunWith(MockitoJUnitRunner.Silent.class)
public class UpdateExpiredTradeSchedulerUtilTest {


        @InjectMocks
        private UpdateExpiredTradeSchedulerUtil updateExpiredTradeSchedulerUtil;

        @Mock
        private OneTradeStoreRepository oneTradeStoreRepository;

        @BeforeClass
        public static void setup() {
            InitializeTradeList.init();
        }

        @Test
        public void updateExpiredStatus_whenSchedulerExecutes_thenExpiredFlagUpdate() throws InterruptedException {

            Mockito.when(oneTradeStoreRepository.findAll()).thenReturn(tradeEntityList);
            updateExpiredTradeSchedulerUtil.updateExpiredFlag();
        }
}

