//package com.example.giasuaovanhocc3.model;
//
//import org.bson.codecs.pojo.annotations.BsonId;
//import org.bson.codecs.pojo.annotations.BsonProperty;
//import org.bson.types.ObjectId;
//
//import java.util.Date;
//import java.util.List;
//
//public class WritingPrompt {
//
//    @BsonId
//    private ObjectId id;
//
//    @BsonProperty(value = "type")
//    private String type; // Sử dụng String để lưu trữ giá trị enum từ MongoDB
//
//    @BsonProperty(value = "content")
//    private String content;
//
//    @BsonProperty(value = "relatedWorkIds")
//    private List<ObjectId> relatedWorkIds; // Danh sách các ObjectId tham chiếu đến works
//
//    @BsonProperty(value = "difficulty")
//    private String difficulty; // Sử dụng String để lưu trữ giá trị enum từ MongoDB
//
//    @BsonProperty(value = "createdAt")
//    private Date createdAt;
//
//    @BsonProperty(value = "updatedAt")
//    private Date updatedAt;
//
//    // Enum cho trường 'type' (tùy chọn, để làm việc dễ dàng hơn trong Java)
//    public enum PromptType {
//        NGHI_LUAN("nghi_luan"),
//        CAM_NHAN("cam_nhan"),
//        PHAN_TICH("phan_tich"),
//        MO_RONG("mo_rong");
//
//        private final String value;
//
//        PromptType(String value) {
//            this.value = value;
//        }
//
//        public String getValue() {
//            return value;
//        }
//
//        public static PromptType fromValue(String value) {
//            for (PromptType type : values()) {
//                if (type.value.equalsIgnoreCase(value)) {
//                    return type;
//                }
//            }
//            throw new IllegalArgumentException("Unknown enum type " + value);
//        }
//    }
//
//    // Enum cho trường 'difficulty' (tùy chọn)
//    public enum DifficultyLevel {
//        EASY("easy"),
//        MEDIUM("medium"),
//        HARD("hard");
//
//        private final String value;
//
//        DifficultyLevel(String value) {
//            this.value = value;
//        }
//
//        public String getValue() {
//            return value;
//        }
//
//        public static DifficultyLevel fromValue(String value) {
//            for (DifficultyLevel level : values()) {
//                if (level.value.equalsIgnoreCase(value)) {
//                    return level;
//                }
//            }
//            throw new IllegalArgumentException("Unknown enum type " + value);
//        }
//    }
//
//
//    // Constructor rỗng cần thiết cho MongoDB POJO Codec
//    public WritingPrompt() {
//    }
//
//    // Constructor với các trường bắt buộc (type, content)
//    public WritingPrompt(String type, String content) {
//        this.type = type;
//        this.content = content;
//    }
//
//    // Constructor với các trường bắt buộc sử dụng Enum (ví dụ)
//    public WritingPrompt(PromptType type, String content) {
//        this.type = type.getValue();
//        this.content = content;
//    }
//
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
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        // Bạn có thể thêm validation ở đây để đảm bảo giá trị nằm trong enum nếu muốn
//        this.type = type;
//    }
//
//    // Getter/Setter sử dụng Enum (tùy chọn)
//    public PromptType getPromptTypeEnum() {
//        return PromptType.fromValue(this.type);
//    }
//
//    public void setPromptTypeEnum(PromptType promptType) {
//        this.type = promptType.getValue();
//    }
//
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public List<ObjectId> getRelatedWorkIds() {
//        return relatedWorkIds;
//    }
//
//    public void setRelatedWorkIds(List<ObjectId> relatedWorkIds) {
//        this.relatedWorkIds = relatedWorkIds;
//    }
//
//    public String getDifficulty() {
//        return difficulty;
//    }
//
//    public void setDifficulty(String difficulty) {
//        // Bạn có thể thêm validation ở đây
//        this.difficulty = difficulty;
//    }
//
//    // Getter/Setter sử dụng Enum cho difficulty (tùy chọn)
//    public DifficultyLevel getDifficultyLevelEnum() {
//        if (this.difficulty == null) {
//            return null; // Hoặc một giá trị mặc định nếu muốn
//        }
//        return DifficultyLevel.fromValue(this.difficulty);
//    }
//
//    public void setDifficultyLevelEnum(DifficultyLevel difficultyLevel) {
//        this.difficulty = (difficultyLevel == null) ? null : difficultyLevel.getValue();
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
//        return "WritingPrompt{" +
//                "id=" + id +
//                ", type='" + type + '\'' +
//                ", content='" + content + '\'' +
//                ", relatedWorkIds=" + relatedWorkIds +
//                ", difficulty='" + difficulty + '\'' +
//                ", createdAt=" + createdAt +
//                ", updatedAt=" + updatedAt +
//                '}';
//    }
//}
//
