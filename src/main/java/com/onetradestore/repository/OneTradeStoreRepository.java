package com.onetradestore.repository;

import com.onetradestore.entity.TradeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OneTradeStoreRepository extends JpaRepository<TradeEntity,Long> {

//    @Query("SELECT u FROM TradeEntity u WHERE u.tradeId =:tradeId")
//    List<TradeEntity> findAllTradesByTradeId(String tradeId);

    List<TradeEntity> findAllByTradeId(String tradeId);


    //@Query("SELECT u FROM TradeEntity u WHERE u.tradeId =: tradeId and u.version=: version")
    TradeEntity findByTradeIdAndVersion(String tradeId,Long version);
}
