package com.slevinbe.eventmanager.vo;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ParticipantVO {

    private StringProperty id = new SimpleStringProperty(this, "id");
    private StringProperty firstName = new SimpleStringProperty(this, "firstName");
    private StringProperty lastName = new SimpleStringProperty(this, "lastName");
    private StringProperty status = new SimpleStringProperty(this, "status");
    private StringProperty role = new SimpleStringProperty(this, "role");
    private DoubleProperty fee = new SimpleDoubleProperty(this, "fee");
    private StringProperty comment = new SimpleStringProperty(this, "comment");

    public StringProperty getIdProperty() {
        return id;
    }

    public final String getId() {
        return id.get();
    }

    public final void setId(String id) {
        this.id.set(id);
    }

    public StringProperty getFirstNameProperty() {
        return firstName;
    }

    public final String getFirstName() {
        return firstName.get();
    }

    public final void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public StringProperty getLastNameProperty() {
        return lastName;
    }

    public final String getLastName() {
        return lastName.get();
    }

    public final void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public StringProperty getStatusProperty() {
        return status;
    }

    public final String getStatus() {
        return status.get();
    }

    public final void setStatus(String status) {
        this.status.set(status);
    }

    public StringProperty getRoleProperty() {
        return role;
    }

    public final String getRole() {
        return role.get();
    }

    public final void setRole(String role) {
        this.role.set(role);
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

    public StringProperty getCommentProperty() {
        return comment;
    }

    public final String getComment() {
        return comment.get();
    }

    public final void setComment(String comment) {
        this.comment.set(comment);
    }
}
