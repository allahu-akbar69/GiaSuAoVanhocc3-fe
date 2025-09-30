//package com.example.giasuaovanhocc3.model;
//
//import org.bson.codecs.pojo.annotations.BsonId;
//import org.bson.codecs.pojo.annotations.BsonProperty;
//import org.bson.types.ObjectId;
//
//import java.util.Date;
//import java.util.Map; // Import Map cho trường rule
//
//public class Achievement {
//
//    @BsonId
//    private ObjectId id;
//
//    @BsonProperty(value = "name")
//    private String name;
//
//    @BsonProperty(value = "description")
//    private String description;
//
//    @BsonProperty(value = "icon")
//    private String icon;
//
//    @BsonProperty(value = "rule")
//    private Map<String, Object> rule; // Dùng Map<String, Object> để biểu diễn JSON object linh hoạt
//
//    @BsonProperty(value = "createdAt")
//    private Date createdAt;
//
//    @BsonProperty(value = "updatedAt")
//    private Date updatedAt;
//
//    // Constructor rỗng cần thiết cho MongoDB POJO Codec
//    public Achievement() {
//    }
//
//    // Constructor với các trường bắt buộc
//    public Achievement(String name, String description) {
//        this.name = name;
//        this.description = description;
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
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getIcon() {
//        return icon;
//    }
//
//    public void setIcon(String icon) {
//        this.icon = icon;
//    }
//
//    public Map<String, Object> getRule() {
//        return rule;
//    }
//
//    public void setRule(Map<String, Object> rule) {
//        this.rule = rule;
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
//        return "Achievement{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", description='" + description + '\'' +
//                ", icon='" + icon + '\'' +
//                ", rule=" + rule +
//                ", createdAt=" + createdAt +
//                ", updatedAt=" + updatedAt +
//                '}';
//    }
//}