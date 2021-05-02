package com.onetradestore.controller;

import com.onetradestore.entity.TradeEntity;
import com.onetradestore.model.TradesModel;
import com.onetradestore.service.OneTradeStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This controller is responsible for fetching and saving trades
 */
@RestController
@RequestMapping("v1/trade")
public class OneTradeStoreController {

    @Autowired
    private OneTradeStoreService oneTradeStoreService;

    /**
     * This api is responsible for persisting a trade in Database after performing validations
     * @param tradesModel
     * @return ResponseEntity<TradeEntity>
     */
    @PostMapping
    public ResponseEntity<TradeEntity> saveTrade(@RequestBody TradesModel tradesModel){
        return new ResponseEntity<>(oneTradeStoreService.saveTrade(tradesModel), HttpStatus.CREATED);
    }

    /**
     * This api is responsible for fetching existing trades from Database
     * @return ResponseEntity<List<TradeEntity>>
     */
    @GetMapping
    public ResponseEntity<List<TradeEntity>> getAllTrades(){
        return new ResponseEntity<>(oneTradeStoreService.getAllTrades(), HttpStatus.OK);
    }



}
