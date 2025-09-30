//package com.example.giasuaovanhocc3.model;
//
//import org.bson.codecs.pojo.annotations.BsonId;
//import org.bson.codecs.pojo.annotations.BsonProperty;
//import org.bson.types.ObjectId;
//
//import java.util.Date;
//import java.util.Map; // Import Map cho trường meta
//
//public class GameScore {
//
//    @BsonId
//    private ObjectId id;
//
//    @BsonProperty(value = "userId")
//    private ObjectId userId; // Tham chiếu đến users._id
////
//    @BsonProperty(value = "game")
//    private String game; // Tên của trò chơi
//
//    @BsonProperty(value = "score")
//    private Integer score;
//
//    @BsonProperty(value = "meta")
//    private Map<String, Object> meta; // Dùng Map<String, Object> để lưu trữ dữ liệu meta linh hoạt
//
//    @BsonProperty(value = "achievedAt")
//    private Date achievedAt;
//
//    // Constructor rỗng cần thiết cho MongoDB POJO Codec
//    public GameScore() {
//    }
//
//    // Constructor với các trường bắt buộc
//    public GameScore(ObjectId userId, String game, Integer score) {
//        this.userId = userId;
//        this.game = game;
//        this.score = score;
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
//    public String getGame() {
//        return game;
//    }
//
//    public void setGame(String game) {
//        this.game = game;
//    }
//
//    public Integer getScore() {
//        return score;
//    }
//
//    public void setScore(Integer score) {
//        this.score = score;
//    }
//
//    public Map<String, Object> getMeta() {
//        return meta;
//    }
//
//    public void setMeta(Map<String, Object> meta) {
//        this.meta = meta;
//    }
//
//    public Date getAchievedAt() {
//        return achievedAt;
//    }
//
//    public void setAchievedAt(Date achievedAt) {
//        this.achievedAt = achievedAt;
//    }
//
//    @Override
//    public String toString() {
//        return "GameScore{" +
//                "id=" + id +
//                ", userId=" + userId +
//                ", game='" + game + '\'' +
//                ", score=" + score +
//                ", meta=" + meta +
//                ", achievedAt=" + achievedAt +
//                '}';
//    }
//}
//
