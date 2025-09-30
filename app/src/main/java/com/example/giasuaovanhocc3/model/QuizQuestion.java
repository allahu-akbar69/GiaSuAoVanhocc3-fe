//package com.example.giasuaovanhocc3.model;
//
//import org.bson.codecs.pojo.annotations.BsonId;
//import org.bson.codecs.pojo.annotations.BsonProperty;
//import org.bson.types.ObjectId;
//
//import java.util.Date;
//import java.util.List;
//
//public class QuizQuestion {
//
//    @BsonId
//    private ObjectId id;
//
//    @BsonProperty(value = "workId")
//    private ObjectId workId; // Tham chiếu đến works._id
//
//    @BsonProperty(value = "question")
//    private String question;
//
//    @BsonProperty(value = "options")
//    private List<String> options; // Danh sách các lựa chọn trả lời
//
//    @BsonProperty(value = "correctIndex")
//    private Integer correctIndex; // Chỉ mục của đáp án đúng trong danh sách options
//
//    @BsonProperty(value = "explanation")
//    private String explanation;
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
//            if (value == null) return null; // Hoặc ném ngoại lệ nếu không cho phép null
//            for (DifficultyLevel level : values()) {
//                if (level.value.equalsIgnoreCase(value)) {
//                    return level;
//                }
//            }
//            throw new IllegalArgumentException("Unknown enum difficulty level: " + value);
//        }
//    }
//
//    // Constructor rỗng cần thiết cho MongoDB POJO Codec
//    public QuizQuestion() {
//    }
//
//    // Constructor với các trường bắt buộc
//    public QuizQuestion(ObjectId workId, String question, List<String> options, Integer correctIndex) {
//        this.workId = workId;
//        this.question = question;
//        this.options = options;
//        this.correctIndex = correctIndex;
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
//    public ObjectId getWorkId() {
//        return workId;
//    }
//
//    public void setWorkId(ObjectId workId) {
//        this.workId = workId;
//    }
//
//    public String getQuestion() {
//        return question;
//    }
//
//    public void setQuestion(String question) {
//        this.question = question;
//    }
//
//    public List<String> getOptions() {
//        return options;
//    }
//
//    public void setOptions(List<String> options) {
//        this.options = options;
//    }
//
//    public Integer getCorrectIndex() {
//        return correctIndex;
//    }
//
//    public void setCorrectIndex(Integer correctIndex) {
//        this.correctIndex = correctIndex;
//    }
//
//    public String getExplanation() {
//        return explanation;
//    }
//
//    public void setExplanation(String explanation) {
//        this.explanation = explanation;
//    }
//
//    public String getDifficulty() {
//        return difficulty;
//    }
//
//    public void setDifficulty(String difficulty) {
//        // Validation có thể được thêm ở đây nếu không dùng Enum setter
//        this.difficulty = difficulty;
//    }
//
//    // Getter/Setter sử dụng Enum cho difficulty (tùy chọn)
//    public DifficultyLevel getDifficultyEnum() {
//        return DifficultyLevel.fromValue(this.difficulty);
//    }
//
//    public void setDifficultyEnum(DifficultyLevel difficultyLevel) {
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
//        return "QuizQuestion{" +
//                "id=" + id +
//                ", workId=" + workId +
//                ", question='" + question + '\'' +
//                ", options=" + options +
//                ", correctIndex=" + correctIndex +
//                ", explanation='" + explanation + '\'' +
//                ", difficulty='" + difficulty + '\'' +
//                ", createdAt=" + createdAt +
//                ", updatedAt=" + updatedAt +
//                '}';
//    }
//}