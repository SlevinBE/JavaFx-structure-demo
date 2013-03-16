package com.slevinbe.eventmanager.vo;

import javafx.beans.property.*;

import java.util.Date;

public class EventVO {

    private StringProperty id = new SimpleStringProperty(this, "id");
    private StringProperty name = new SimpleStringProperty(this, "name");
    private ObjectProperty<Date> startTime = new SimpleObjectProperty<Date>(this, "startTime");
    private ObjectProperty<Date> endTime = new SimpleObjectProperty<Date>(this, "endTime");
    private StringProperty createdBy = new SimpleStringProperty(this, "createdBy");
    private IntegerProperty modId = new SimpleIntegerProperty(this, "modId");
    private StringProperty eventType = new SimpleStringProperty(this, "eventType");
    private StringProperty location = new SimpleStringProperty(this, "location");
    private StringProperty product = new SimpleStringProperty(this, "product");
    private StringProperty objective = new SimpleStringProperty(this, "objective");
    private BooleanProperty questionChecked = new SimpleBooleanProperty(this, "questionChecked");
    private BooleanProperty question2Checked = new SimpleBooleanProperty(this, "questionChecked2");
    private StringProperty status = new SimpleStringProperty(this, "status");
    private StringProperty description = new SimpleStringProperty(this, "description");
    private DoubleProperty latitude = new SimpleDoubleProperty(this, "latitude");
    private DoubleProperty longitude = new SimpleDoubleProperty(this, "longitude");

    public StringProperty getIdProperty() {
        return id;
    }

    public final String getId() {
        return id.get();
    }

    public final void setId(String id) {
        this.id.set(id);
    }

    public StringProperty getNameProperty() {
        return name;
    }

    public final String getName() {
        return name.get();
    }

    public final void setName(String name) {
        this.name.set(name);
    }

    public ObjectProperty<Date> getStartTimeProperty() {
        return startTime;
    }

    public final Date getStartTime() {
        return startTime.get();
    }

    public final void setStartTime(Date startTime) {
        this.startTime.set(startTime);
    }

    public ObjectProperty<Date> getEndTimeProperty() {
        return endTime;
    }

    public final Date getEndTime() {
        return endTime.get();
    }

    public final void setEndTime(Date endTime) {
        this.endTime.set(endTime);
    }

    public StringProperty getCreatedByProperty() {
        return createdBy;
    }

    public final String getCreatedBy() {
        return createdBy.get();
    }

    public final void setCreatedBy(String createdBy) {
        this.createdBy.set(createdBy);
    }

    public IntegerProperty getModIdProperty() {
        return modId;
    }

    public final Integer getModId() {
        return modId.get();
    }

    public final void setModId(Integer modId) {
        this.modId.set(modId);
    }

    public StringProperty getEventTypeProperty() {
        return eventType;
    }

    public final String getEventType() {
        return eventType.get();
    }

    public final void setEventType(String eventType) {
        this.eventType.set(eventType);
    }

    public StringProperty getLocationProperty() {
        return location;
    }

    public final String getLocation() {
        return location.get();
    }

    public final void setLocation(String location) {
        this.location.set(location);
    }

    public StringProperty getProductProperty() {
        return product;
    }

    public final String getProduct() {
        return product.get();
    }

    public final void setProduct(String product) {
        this.product.set(product);
    }

    public StringProperty getObjectiveProperty() {
        return objective;
    }

    public final String getObjective() {
        return objective.get();
    }

    public final void setObjective(String objective) {
        this.objective.set(objective);
    }

    public BooleanProperty getQuestionCheckedProperty() {
        return questionChecked;
    }

    public final Boolean getQuestionChecked() {
        return questionChecked.get();
    }

    public final void setQuestionChecked(Boolean questionChecked) {
        this.questionChecked.set(questionChecked);
    }

    public BooleanProperty getQuestion2CheckedProperty() {
        return question2Checked;
    }

    public final Boolean getQuestion2Checked() {
        return question2Checked.get();
    }

    public final void setQuestion2Checked(Boolean question2Checked) {
        this.question2Checked.set(question2Checked);
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

    public StringProperty getDescriptionProperty() {
        return description;
    }

    public final String getDescription() {
        return description.get();
    }

    public final void setDescription(String description) {
        this.description.set(description);
    }

    public DoubleProperty getLatitudeProperty() {
        return latitude;
    }

    public final Double getLatitude() {
        return latitude.get();
    }

    public final void setLatitude(Double latitude) {
        this.latitude.set(latitude);
    }

    public DoubleProperty getLongitudeProperty() {
        return longitude;
    }

    public final Double getLongitude() {
        return longitude.get();
    }

    public final void setLongitude(Double longitude) {
        this.longitude.set(longitude);
    }
}
