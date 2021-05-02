package com.onetradestore.util;

import com.onetradestore.entity.TradeEntity;
import com.onetradestore.model.ExpiryStatusEnum;
import com.onetradestore.repository.OneTradeStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * This class is responsible for scheduling auto update of database fields for apis
 */
@Component
public class UpdateExpiredTradeSchedulerUtil {

    @Autowired
    private OneTradeStoreRepository oneTradeStoreRepository;

    /**
     * This method is responsible for scheduled update of expiry flag based on the maturity date in DB.
     */
    @Scheduled(cron = "5 0 0 * * *")
    public void updateExpiredFlag() {

        List<TradeEntity> tradeEntityList = oneTradeStoreRepository.findAll();
        tradeEntityList.stream().filter(trade -> Objects.nonNull(trade.getMaturityDate())
                && trade.getMaturityDate().isBefore(LocalDate.now()))
                .forEach(trade -> {
                    trade.setExpired(ExpiryStatusEnum.Y);
                    oneTradeStoreRepository.save(trade);
                });
    }
}
