//package com.example.giasuaovanhocc3.model;
//
//import org.bson.codecs.pojo.annotations.BsonId;
//import org.bson.codecs.pojo.annotations.BsonProperty;
//import org.bson.types.ObjectId;
//
//import java.util.Date;
//import java.util.Map; // Import Map cho trường rubric
//
//public class AIFeedback {
//
//    @BsonId
//    private ObjectId id;
//
//    @BsonProperty(value = "submissionId")
//    private ObjectId submissionId; // Tham chiếu đến writing_submissions._id
//
//    @BsonProperty(value = "score")
//    private Double score;
//
//    @BsonProperty(value = "rubric")
//    private Map<String, Object> rubric; // Dùng Map<String, Object> để biểu diễn JSON object linh hoạt
//
//    @BsonProperty(value = "details")
//    private String details;
//
//    @BsonProperty(value = "createdAt")
//    private Date createdAt;
//
//    // Constructor rỗng cần thiết cho MongoDB POJO Codec
//    public AIFeedback() {
//    }
//
//    // Constructor với các trường bắt buộc
//    public AIFeedback(ObjectId submissionId, Double score, String details) {
//        this.submissionId = submissionId;
//        this.score = score;
//        this.details = details;
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
//    public ObjectId getSubmissionId() {
//        return submissionId;
//    }
//
//    public void setSubmissionId(ObjectId submissionId) {
//        this.submissionId = submissionId;
//    }
//
//    public Double getScore() {
//        return score;
//    }
//
//    public void setScore(Double score) {
//        this.score = score;
//    }
//
//    public Map<String, Object> getRubric() {
//        return rubric;
//    }
//
//    public void setRubric(Map<String, Object> rubric) {
//        this.rubric = rubric;
//    }
//
//    public String getDetails() {
//        return details;
//    }
//
//    public void setDetails(String details) {
//        this.details = details;
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
//    @Override
//    public String toString() {
//        return "AIFeedback{" +
//                "id=" + id +
//                ", submissionId=" + submissionId +
//                ", score=" + score +
//                ", rubric=" + rubric +
//                ", details='" + details + '\'' +
//                ", createdAt=" + createdAt +
//                '}';
//    }
//}
