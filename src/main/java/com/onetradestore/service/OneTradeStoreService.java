package com.onetradestore.service;

import com.onetradestore.entity.TradeEntity;
import com.onetradestore.mapper.TradesMapper;
import com.onetradestore.model.TradesModel;
import com.onetradestore.repository.OneTradeStoreRepository;
import com.onetradestore.util.SaveTradeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * This is the service class for accommodating business logic for trade store apis
 */
@Service
public class OneTradeStoreService {
    @Autowired
    private OneTradeStoreRepository oneTradeStoreRepository;

    @Autowired
    private SaveTradeUtil saveTradeUtil;

    @Autowired
    private TradesMapper tradesMapper;

    /**
     * This method is the serviceimpl method to save Trade in the Database after performing some validations
     * @param tradesModel
     * @return TradeEntity
     */
    public TradeEntity saveTrade(TradesModel tradesModel){

        //Check for lower version in the existing trades with same tradeId
        saveTradeUtil.checkTradeVersion(tradesModel);

        //Check for Maturity Date Before Today
        saveTradeUtil.checkMaturityDate(tradesModel);

        //Check if Trade exists with Same TradId and Version
        TradeEntity tradeEntity=saveTradeUtil.checkTradeWithExistingVersion(tradesModel);

        //Map fields from request to entity
        tradesMapper.setTradeParameters(tradesModel,tradeEntity);

        //Save the trade (if existing then update else new trade)
        return oneTradeStoreRepository.save(tradeEntity);
    }

    /**
     * This method is the serviceimpl method to fetch all existing trades from the Database
     * @return
     */
    public List<TradeEntity> getAllTrades(){
        return oneTradeStoreRepository.findAll();
    }

}
