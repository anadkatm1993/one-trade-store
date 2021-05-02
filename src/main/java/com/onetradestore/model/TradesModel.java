package com.onetradestore.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;


/**
 * This is the model class for request body of post trades api
 */
public class TradesModel {

    private String tradeId ;
    private Long version;
    private String counterPartyId;
    private String bookId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate  maturityDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate createdDate;
    @Enumerated(EnumType.STRING)
    private ExpiryStatusEnum expired;

    public TradesModel() {
    }

    public TradesModel(String tradeId, Long version, String counterPartyId, String bookId, LocalDate maturityDate, LocalDate createdDate, ExpiryStatusEnum expired) {
        this.tradeId = tradeId;
        this.version = version;
        this.counterPartyId = counterPartyId;
        this.bookId = bookId;
        this.maturityDate = maturityDate;
        this.createdDate = createdDate;
        this.expired = expired;
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
}
