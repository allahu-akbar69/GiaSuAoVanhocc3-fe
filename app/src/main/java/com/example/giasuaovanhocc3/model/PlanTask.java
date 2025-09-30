//package com.example.giasuaovanhocc3.model;
//
//import org.bson.codecs.pojo.annotations.BsonId;
//import org.bson.codecs.pojo.annotations.BsonProperty;
//import org.bson.types.ObjectId;
//
//import java.util.Date;
//
//public class PlanTask {
//
//    @BsonId
//    private ObjectId id;
//
//    @BsonProperty(value = "planId")
//    private ObjectId planId; // Tham chiếu đến learning_plans._id
//
//    @BsonProperty(value = "content")
//    private String content;
//
//    @BsonProperty(value = "dueAt")
//    private Date dueAt; // Có thể null
//
//    @BsonProperty(value = "status")
//    private String status; // Lưu trữ giá trị enum từ MongoDB
//
//    @BsonProperty(value = "aiSuggestion")
//    private String aiSuggestion; // Có thể null
//
//    @BsonProperty(value = "createdAt")
//    private Date createdAt;
//
//    @BsonProperty(value = "updatedAt")
//    private Date updatedAt;
//
//    // Enum cho trường 'status' (tùy chọn, để làm việc dễ dàng hơn trong Java)
//    public enum TaskStatus {
//        TODO("todo"),
//        IN_PROGRESS("in_progress"),
//        DONE("done"),
//        SKIPPED("skipped");
//
//        private final String value;
//
//        TaskStatus(String value) {
//            this.value = value;
//        }
//
//        public String getValue() {
//            return value;
//        }
//
//        public static TaskStatus fromValue(String value) {
//            if (value == null) return null;
//            for (TaskStatus status : values()) {
//                if (status.value.equalsIgnoreCase(value)) {
//                    return status;
//                }
//            }
//            throw new IllegalArgumentException("Unknown enum TaskStatus: " + value);
//        }
//    }
//
//    // Constructor rỗng cần thiết cho MongoDB POJO Codec
//    public PlanTask() {
//    }
//
//    // Constructor với các trường bắt buộc
//    public PlanTask(ObjectId planId, String content, String status) {
//        this.planId = planId;
//        this.content = content;
//        this.status = status; // Nên sử dụng TaskStatus.getValue() nếu dùng Enum
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
//    public ObjectId getPlanId() {
//        return planId;
//    }
//
//    public void setPlanId(ObjectId planId) {
//        this.planId = planId;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public Date getDueAt() {
//        return dueAt;
//    }
//
//    public void setDueAt(Date dueAt) {
//        this.dueAt = dueAt;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    // Getter/Setter sử dụng Enum cho status (tùy chọn)
//    public TaskStatus getStatusEnum() {
//        return TaskStatus.fromValue(this.status);
//    }
//
//    public void setStatusEnum(TaskStatus taskStatus) {
//        this.status = (taskStatus == null) ? null : taskStatus.getValue();
//    }
//
//    public String getAiSuggestion() {
//        return aiSuggestion;
//    }
//
//    public void setAiSuggestion(String aiSuggestion) {
//        this.aiSuggestion = aiSuggestion;
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
//        return "PlanTask{" +
//                "id=" + id +
//                ", planId=" + planId +
//                ", content='" + content + '\'' +
//                ", dueAt=" + dueAt +
//                ", status='" + status + '\'' +
//                ", aiSuggestion='" + aiSuggestion + '\'' +
//                ", createdAt=" + createdAt +
//                ", updatedAt=" + updatedAt +
//                '}';
//    }
//}