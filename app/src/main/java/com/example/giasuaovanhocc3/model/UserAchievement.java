//package com.example.giasuaovanhocc3.model;
//
//
//import org.bson.codecs.pojo.annotations.BsonId;
//import org.bson.codecs.pojo.annotations.BsonProperty;
//import org.bson.types.ObjectId;
//
//import java.util.Date;
//public class UserAchievement {
//    @BsonId
//    private ObjectId id;
//
//    @BsonProperty(value = "userId")
//    private ObjectId userId; // Tham chiếu đến users._id
//
//    @BsonProperty(value = "achievementId")
//    private ObjectId achievementId; // Tham chiếu đến achievements._id
//
//    @BsonProperty(value = "awardedAt")
//    private Date awardedAt;
//
//    @BsonProperty(value = "reason")
//    private String reason; // Lý do tùy chọn cho việc trao tặng thành tựu
//
//    // Constructor rỗng cần thiết cho MongoDB POJO Codec
//    public UserAchievement() {
//    }
//
//    // Constructor với các trường bắt buộc
//    public UserAchievement(ObjectId userId, ObjectId achievementId, Date awardedAt) {
//        this.userId = userId;
//        this.achievementId = achievementId;
//        this.awardedAt = awardedAt;
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
//    public ObjectId getAchievementId() {
//        return achievementId;
//    }
//
//    public void setAchievementId(ObjectId achievementId) {
//        this.achievementId = achievementId;
//    }
//
//    public Date getAwardedAt() {
//        return awardedAt;
//    }
//
//    public void setAwardedAt(Date awardedAt) {
//        this.awardedAt = awardedAt;
//    }
//
//    public String getReason() {
//        return reason;
//    }
//
//    public void setReason(String reason) {
//        this.reason = reason;
//    }
//
//    @Override
//    public String toString() {
//        return "UserAchievement{" +
//                "id=" + id +
//                ", userId=" + userId +
//                ", achievementId=" + achievementId +
//                ", awardedAt=" + awardedAt +
//                ", reason='" + reason + '\'' +
//                '}';
//    }
//}
