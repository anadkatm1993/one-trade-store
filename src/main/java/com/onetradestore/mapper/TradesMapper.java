package com.onetradestore.mapper;

import com.onetradestore.entity.TradeEntity;
import com.onetradestore.model.TradesModel;
import org.springframework.stereotype.Component;

/**
 * This class is responsible for mapping domain request attributes to entity and vice versa
 */
@Component
public class TradesMapper {

    /**
     * This method is used to map request fields to entity fields
     * @param tradesModel
     * @param newTrade
     */
    public void setTradeParameters(TradesModel tradesModel, TradeEntity newTrade) {
        newTrade.setTradeId(tradesModel.getTradeId());
        newTrade.setBookId(tradesModel.getBookId());
        newTrade.setCounterPartyId(tradesModel.getCounterPartyId());
        newTrade.setVersion(tradesModel.getVersion());
        newTrade.setMaturityDate(tradesModel.getMaturityDate());
        newTrade.setCreatedDate(tradesModel.getCreatedDate());
        newTrade.setExpired(tradesModel.getExpired());
    }

}
