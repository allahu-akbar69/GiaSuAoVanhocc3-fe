//package com.example.giasuaovanhocc3.model;
//
//import org.bson.codecs.pojo.annotations.BsonId;
//import org.bson.codecs.pojo.annotations.BsonProperty;
//import org.bson.types.ObjectId;
//
//import java.util.Date;
//
//public class Note {
//
//    @BsonId
//    private ObjectId id;
//
//    @BsonProperty(value = "userId")
//    private ObjectId userId; // Reference to users._id
//
//    @BsonProperty(value = "workId")
//    private ObjectId workId; // Reference to works._id
//
//    @BsonProperty(value = "content")
//    private String content;
//
//    @BsonProperty(value = "createdAt")
//    private Date createdAt;
//
//    @BsonProperty(value = "updatedAt")
//    private Date updatedAt;
//
//    // Empty constructor is required for MongoDB POJO Codec
//    public Note() {
//    }
//
//    // Constructor with required fields (userId, workId, content)
//    public Note(ObjectId userId, ObjectId workId, String content) {
//        this.userId = userId;
//        this.workId = workId;
//        this.content = content;
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
//    public ObjectId getWorkId() {
//        return workId;
//    }
//
//    public void setWorkId(ObjectId workId) {
//        this.workId = workId;
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
//        return "Note{" +
//                "id=" + id +
//                ", userId=" + userId +
//                ", workId=" + workId +
//                ", content='" + content + '\'' +
//                ", createdAt=" + createdAt +
//                ", updatedAt=" + updatedAt +
//                '}';
//    }
//}
