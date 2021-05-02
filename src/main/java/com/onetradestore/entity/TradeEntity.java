package com.onetradestore.entity;

import com.onetradestore.model.ExpiryStatusEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity(name = "Trade")
public class TradeEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String tradeId ;
    @Column
    private Long version;
    @Column
    private String counterPartyId;
    @Column
    private String bookId;
    @Column
    private LocalDate maturityDate;
    @Column
    private LocalDate createdDate;
    @Column
    private ExpiryStatusEnum expired;

    public TradeEntity() {
    }

    public TradeEntity(Long id, String tradeId, Long version, String counterPartyId, String bookId, LocalDate maturityDate, LocalDate createdDate, ExpiryStatusEnum expired) {
        this.id = id;
        this.tradeId = tradeId;
        this.version = version;
        this.counterPartyId = counterPartyId;
        this.bookId = bookId;
        this.maturityDate = maturityDate;
        this.createdDate = createdDate;
        this.expired = expired;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getCounterPartyId() {
        return counterPartyId;
    }

    public void setCounterPartyId(String counterPartyId) {
        this.counterPartyId = counterPartyId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public LocalDate getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(LocalDate maturityDate) {
        this.maturityDate = maturityDate;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public ExpiryStatusEnum getExpired() {
        return expired;
    }

    public void setExpired(ExpiryStatusEnum expired) {
        this.expired = expired;
    }

    @Override
    public String toString() {
        return "TradeEntity{" +
                "id=" + id +
                ", tradeId='" + tradeId + '\'' +
                ", version=" + version +
                ", counterPartyId='" + counterPartyId + '\'' +
                ", bookId='" + bookId + '\'' +
                ", maturityDate=" + maturityDate +
                ", createdDate=" + createdDate +
                ", expired=" + expired +
                '}';
    }
}
