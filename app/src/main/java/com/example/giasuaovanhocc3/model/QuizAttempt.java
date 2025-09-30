//package com.example.giasuaovanhocc3.model;
//
//import org.bson.codecs.pojo.annotations.BsonId;
//import org.bson.codecs.pojo.annotations.BsonProperty;
//import org.bson.types.ObjectId;
//
//import java.util.Date;
//import java.util.List;
//
//public class QuizAttempt {
//
//    @BsonId
//    private ObjectId id;
//
//    @BsonProperty(value = "userId")
//    private ObjectId userId; // Tham chiếu đến users._id
//
//    @BsonProperty(value = "questions")
//    private List<AttemptedQuestion> questions; // Danh sách các câu hỏi đã thử
//
//    @BsonProperty(value = "score")
//    private Double score;
//
//    @BsonProperty(value = "startedAt")
//    private Date startedAt;
//
//    @BsonProperty(value = "finishedAt")
//    private Date finishedAt; // Có thể null
//
//    // Lớp tĩnh lồng nhau để biểu diễn cấu trúc của một câu hỏi trong mảng 'questions'
//    public static class AttemptedQuestion {
//        @BsonProperty(value = "questionId")
//        private ObjectId questionId; // Tham chiếu đến quiz_questions._id
//
//        @BsonProperty(value = "selectedIndex")
//        private Integer selectedIndex;
//
//        @BsonProperty(value = "isCorrect")
//        private Boolean isCorrect;
//
//        // Constructor rỗng cần thiết cho MongoDB POJO Codec
//        public AttemptedQuestion() {
//        }
//
//        public AttemptedQuestion(ObjectId questionId, Integer selectedIndex) {
//            this.questionId = questionId;
//            this.selectedIndex = selectedIndex;
//        }
//
//        // Getters and Setters for AttemptedQuestion
//        public ObjectId getQuestionId() {
//            return questionId;
//        }
//
//        public void setQuestionId(ObjectId questionId) {
//            this.questionId = questionId;
//        }
//
//        public Integer getSelectedIndex() {
//            return selectedIndex;
//        }
//
//        public void setSelectedIndex(Integer selectedIndex) {
//            this.selectedIndex = selectedIndex;
//        }
//
//        public Boolean getIsCorrect() {
//            return isCorrect;
//        }
//
//        public void setIsCorrect(Boolean correct) {
//            isCorrect = correct;
//        }
//
//        @Override
//        public String toString() {
//            return "AttemptedQuestion{" +
//                    "questionId=" + questionId +
//                    ", selectedIndex=" + selectedIndex +
//                    ", isCorrect=" + isCorrect +
//                    '}';
//        }
//    }
//
//    // Constructor rỗng cần thiết cho MongoDB POJO Codec
//    public QuizAttempt() {
//    }
//
//    // Constructor với các trường bắt buộc
//    public QuizAttempt(ObjectId userId, List<AttemptedQuestion> questions, Double score, Date startedAt) {
//        this.userId = userId;
//        this.questions = questions;
//        this.score = score;
//        this.startedAt = startedAt;
//    }
//
//    // Getters and Setters for QuizAttempt
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
//    public List<AttemptedQuestion> getQuestions() {
//        return questions;
//    }
//
//    public void setQuestions(List<AttemptedQuestion> questions) {
//        this.questions = questions;
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
//    public Date getStartedAt() {
//        return startedAt;
//    }
//
//    public void setStartedAt(Date startedAt) {
//        this.startedAt = startedAt;
//    }
//
//    public Date getFinishedAt() {
//        return finishedAt;
//    }
//
//    public void setFinishedAt(Date finishedAt) {
//        this.finishedAt = finishedAt;
//    }
//
//    @Override
//    public String toString() {
//        return "QuizAttempt{" +
//                "id=" + id +
//                ", userId=" + userId +
//                ", questions=" + questions +
//                ", score=" + score +
//                ", startedAt=" + startedAt +
//                ", finishedAt=" + finishedAt +
//                '}';
//    }
//}