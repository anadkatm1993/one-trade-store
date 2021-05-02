package com.onetradestore.model;

import java.time.LocalDate;

public class ExceptionModel {
   private LocalDate date;
        private String errorDetail;

        public ExceptionModel(LocalDate date, String errorDetail) {
            this.date = date;
            this.errorDetail = errorDetail;
        }

        public LocalDate getDate() {
            return date;
        }

        public void setDate(LocalDate date) {
            this.date = date;
        }

    public String getErrorDetail() {
        return errorDetail;
    }

    public void setErrorDetail(String errorDetail) {
        this.errorDetail = errorDetail;
    }

    @Override
    public String toString() {
        return "ExceptionModel{" +
                "date=" + date +
                ", errorDetail='" + errorDetail + '\'' +
                '}';
    }
}
