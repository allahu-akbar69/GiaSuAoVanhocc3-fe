//package com.example.giasuaovanhocc3.model;
//
//import org.bson.codecs.pojo.annotations.BsonId;
//import org.bson.codecs.pojo.annotations.BsonProperty;
//import org.bson.types.ObjectId;
//
//import java.util.Date;
//
//public class WritingSubmission {
//    @BsonId
//    private ObjectId id;
//
//    @BsonProperty(value = "userId")
//    private ObjectId userId; // Tham chiếu đến users._id
//
//    @BsonProperty(value = "promptId")
//    private ObjectId promptId; // Tham chiếu đến writing_prompts._id
//
//    @BsonProperty(value = "content")
//    private String content;
//
//    @BsonProperty(value = "submittedAt")
//    private Date submittedAt;
//
//    @BsonProperty(value = "wordCount")
//    private Integer wordCount; // Sử dụng Integer để cho phép giá trị null
//
//    @BsonProperty(value = "status")
//    private String status; // Sử dụng String để lưu trữ giá trị enum từ MongoDB
//
//    // Enum cho trường 'status' (tùy chọn)
//    public enum SubmissionStatus {
//        SUBMITTED("submitted"),
//        GRADED("graded"),
//        RETURNED("returned");
//
//        private final String value;
//
//        SubmissionStatus(String value) {
//            this.value = value;
//        }
//
//        public String getValue() {
//            return value;
//        }
//
//        public static SubmissionStatus fromValue(String value) {
//            for (SubmissionStatus status : values()) {
//                if (status.value.equalsIgnoreCase(value)) {
//                    return status;
//                }
//            }
//            throw new IllegalArgumentException("Unknown enum status " + value);
//        }
//    }
//
//    // Constructor rỗng cần thiết cho MongoDB POJO Codec
//    public WritingSubmission() {
//    }
//
//    // Constructor với các trường bắt buộc
//    public WritingSubmission(ObjectId userId, ObjectId promptId, String content, Date submittedAt) {
//        this.userId = userId;
//        this.promptId = promptId;
//        this.content = content;
//        this.submittedAt = submittedAt;
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
//    public ObjectId getPromptId() {
//        return promptId;
//    }
//
//    public void setPromptId(ObjectId promptId) {
//        this.promptId = promptId;
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
//    public Date getSubmittedAt() {
//        return submittedAt;
//    }
//
//    public void setSubmittedAt(Date submittedAt) {
//        this.submittedAt = submittedAt;
//    }
//
//    public Integer getWordCount() {
//        return wordCount;
//    }
//
//    public void setWordCount(Integer wordCount) {
//        this.wordCount = wordCount;
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
//    public SubmissionStatus getStatusEnum() {
//        if (this.status == null) {
//            return null; // Hoặc một giá trị mặc định nếu muốn
//        }
//        return SubmissionStatus.fromValue(this.status);
//    }
//
//    public void setStatusEnum(SubmissionStatus submissionStatus) {
//        this.status = (submissionStatus == null) ? null : submissionStatus.getValue();
//    }
//
//    @Override
//    public String toString() {
//        return "WritingSubmission{" +
//                "id=" + id +
//                ", userId=" + userId +
//                ", promptId=" + promptId +
//                ", content='" + content + '\'' +
//                ", submittedAt=" + submittedAt +
//                ", wordCount=" + wordCount +
//                ", status='" + status + '\'' +
//                '}';
//    }
//
//}
