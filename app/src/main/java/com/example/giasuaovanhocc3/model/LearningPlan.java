//package com.example.giasuaovanhocc3.model;
//
//import org.bson.codecs.pojo.annotations.BsonId;
//import org.bson.codecs.pojo.annotations.BsonProperty;
//import org.bson.types.ObjectId;
//
//import java.util.Date;
//
//public class LearningPlan {
//
//    @BsonId
//    private ObjectId id;
//
//    @BsonProperty(value = "userId")
//    private ObjectId userId; // Reference to users._id
//
//    @BsonProperty(value = "goal")
//    private String goal;
//
//    @BsonProperty(value = "startDate")
//    private Date startDate; // Can be null
//
//    @BsonProperty(value = "endDate")
//    private Date endDate;   // Can be null
//
//    @BsonProperty(value = "createdBy")
//    private String createdBy; // Stores the enum value from MongoDB ("user" or "ai")
//
//    @BsonProperty(value = "createdAt")
//    private Date createdAt;
//
//    @BsonProperty(value = "updatedAt")
//    private Date updatedAt;
//
//    // Enum for the 'createdBy' field (optional, for easier handling in Java)
//    public enum PlanCreator {
//        USER("user"),
//        AI("ai");
//
//        private final String value;
//
//        PlanCreator(String value) {
//            this.value = value;
//        }
//
//        public String getValue() {
//            return value;
//        }
//
//        public static PlanCreator fromValue(String value) {
//            if (value == null) return null;
//            for (PlanCreator creator : values()) {
//                if (creator.value.equalsIgnoreCase(value)) {
//                    return creator;
//                }
//            }
//            throw new IllegalArgumentException("Unknown enum PlanCreator: " + value);
//        }
//    }
//
//    // Empty constructor required for MongoDB POJO Codec
//    public LearningPlan() {
//    }
//
//    // Constructor with required fields
//    public LearningPlan(ObjectId userId, String goal) {
//        this.userId = userId;
//        this.goal = goal;
//    }
//
//    // Getters and Setters
//    public ObjectId getId() {
//        return id;
//    }
//
//    public void setId(ObjectId id) {
//        this.id = id;
//    }
//
//    public ObjectId getUserId() {
//        return userId;
//    }
//
//    public void setUserId(ObjectId userId) {
//        this.userId = userId;
//    }
//
//    public String getGoal() {
//        return goal;
//    }
//
//    public void setGoal(String goal) {
//        this.goal = goal;
//    }
//
//    public Date getStartDate() {
//        return startDate;
//    }
//
//    public void setStartDate(Date startDate) {
//        this.startDate = startDate;
//    }
//
//    public Date getEndDate() {
//        return endDate;
//    }
//
//    public void setEndDate(Date endDate) {
//        this.endDate = endDate;
//    }
//
//    public String getCreatedBy() {
//        return createdBy;
//    }
//
//    public void setCreatedBy(String createdBy) {
//        // You could add validation here if not using the Enum setter
//        this.createdBy = createdBy;
//    }
//
//    // Getter/Setter using Enum for createdBy (optional)
//    public PlanCreator getCreatedByEnum() {
//        return PlanCreator.fromValue(this.createdBy);
//    }
//
//    public void setCreatedByEnum(PlanCreator planCreator) {
//        this.createdBy = (planCreator == null) ? null : planCreator.getValue();
//    }
//
//    public Date getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(Date createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    public Date getUpdatedAt() {
//        return updatedAt;
//    }
//
//    public void setUpdatedAt(Date updatedAt) {
//        this.updatedAt = updatedAt;
//    }
//
//    @Override
//    public String toString() {
//        return "LearningPlan{" +
//                "id=" + id +
//                ", userId=" + userId +
//                ", goal='" + goal + '\'' +
//                ", startDate=" + startDate +
//                ", endDate=" + endDate +
//                ", createdBy='" + createdBy + '\'' +
//                ", createdAt=" + createdAt +
//                ", updatedAt=" + updatedAt +
//                '}';
//    }
//}