package com.slevinbe.eventmanager.vo;

import javafx.beans.property.*;

public class CostVO {

    private StringProperty id = new SimpleStringProperty(this, "id");
    private StringProperty type = new SimpleStringProperty(this, "type");
    private IntegerProperty amount = new SimpleIntegerProperty(this, "amount");
    private DoubleProperty fee = new SimpleDoubleProperty(this, "fee");

    public StringProperty getIdProperty() {
        return id;
    }

    public final String getId() {
        return id.get();
    }

    public final void setId(String id) {
        this.id.set(id);
    }

    public StringProperty getTypeProperty() {
        return type;
    }

    public final String getType() {
        return type.get();
    }

    public final void setType(String type) {
        this.type.set(type);
    }

    public IntegerProperty getAmountProperty() {
        return amount;
    }

    public final Integer getAmount() {
        return amount.get();
    }

    public final void setAmount(Integer amount) {
        this.amount.set(amount);
    }

    public DoubleProperty getFeeProperty() {
        return fee;
    }

    public final Double getFee() {
        return fee.get();
    }

    public final void setFee(Double fee) {
        this.fee.set(fee);
    }
}
