package com.onetradestore.util;



import com.onetradestore.entity.TradeEntity;
import com.onetradestore.exception.BadRequestServiceException;
import com.onetradestore.model.TradesModel;
import com.onetradestore.repository.OneTradeStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * This is a utility class for performing business validations for trade store apis
 */
@Component
public class SaveTradeUtil {


    @Autowired
    private OneTradeStoreRepository oneTradeStoreRepository;


    /**
     * This method is used to check for the lower trade version in the existing trade data.
     * Throws exception when finds any record with version lower than the request version.
     * @param tradesModel
     *
     */
    public void checkTradeVersion(TradesModel tradesModel)
    {
        //Fetch list of all Trades with tradeId in request
        List<TradeEntity> tradeEntityList =
                oneTradeStoreRepository.findAllByTradeId(tradesModel.getTradeId());

        if (Objects.nonNull(tradeEntityList) && tradeEntityList.stream().anyMatch(t -> t.getVersion() > tradesModel.getVersion())) {
            throw new BadRequestServiceException("Trade with lower version not allowed");
        }

    }

    /**
     * This method is used to check if there are existing trades with same tradeId and version.
     * If such trades exists , update the existing record to save.
     * @param tradesModel
     * @return TradeEntity
     */
    public TradeEntity checkTradeWithExistingVersion(TradesModel tradesModel) {
        TradeEntity existingTrade =
                oneTradeStoreRepository.findByTradeIdAndVersion(tradesModel.getTradeId(), tradesModel.getVersion());

        if (Objects.isNull(existingTrade))
        {
            existingTrade = new TradeEntity();
        }
        return existingTrade;
    }

    /**
     * This method is used to check the maturity date of the trade.
     * Throws exception if the maturity date is before today.
     * @param tradesModel
     */
    public void checkMaturityDate(TradesModel tradesModel)
    {
        if (tradesModel.getMaturityDate().isBefore(LocalDate.now())) {
            throw new BadRequestServiceException("Trade with maturity date before today not allowed");
        }
    }



}
