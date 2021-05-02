package com.onetradestore.controller;

import com.onetradestore.entity.TradeEntity;
import com.onetradestore.model.TradesModel;
import com.onetradestore.service.OneTradeStoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@Api(value="onetradestore")
public class OneTradeStoreController {

    @Autowired
    private OneTradeStoreService oneTradeStoreService;

    /**
     * This api is responsible for persisting a trade in Database after performing validations
     * @param tradesModel
     * @return ResponseEntity<TradeEntity>
     */
    @ApiOperation(value = "Save new trades after performing business validations")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 400, message = "The request in incorrect or not properly formed"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Internal Server Error occurred wile saving trades")
    }
    )
    @PostMapping
    public ResponseEntity<TradeEntity> saveTrade(@RequestBody TradesModel tradesModel){
        return new ResponseEntity<>(oneTradeStoreService.saveTrade(tradesModel), HttpStatus.CREATED);
    }

    /**
     * This api is responsible for fetching existing trades from Database
     * @return ResponseEntity<List<TradeEntity>>
     */
    @ApiOperation(value = "Fetch All Trades")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list of all trades"),
            @ApiResponse(code = 400, message = "The request in incorrect or not properly formed"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Internal Server Error occurred wile saving trades")
    }
    )
    @GetMapping
    public ResponseEntity<List<TradeEntity>> getAllTrades(){
        return new ResponseEntity<>(oneTradeStoreService.getAllTrades(), HttpStatus.OK);
    }



}
