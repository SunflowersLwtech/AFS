package domain.academic;

import java.time.LocalDate;

public class Comment {
    private String commentId;
    private String studentId;
    private String lecturerId;
    private String commentText;
    private LocalDate commentDate;

    public Comment(
        String studentId, 
        String lecturerId, 
        String commentText, 
        LocalDate commentDate
    ) {
        this.studentId = studentId;
        this.lecturerId = lecturerId;
        this.commentText = commentText;
        this.commentDate = commentDate;
    }

    public String getCommentId() { return commentId; }
    public String getStudentId() { return studentId; }
    public String getLecturerId() { return lecturerId; }
    public String getCommentText() { return commentText; }
    public LocalDate getCommentDate() { return commentDate; }

    public void setCommentId(String newCommentId) { this.commentId = newCommentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }
    public void setLecturerId(String lecturerId) { this.lecturerId = lecturerId; }
    public void setCommentText(String newCommentText) { this.commentText = newCommentText; }
    public void setCommentDate(LocalDate newCommentDate) { this.commentDate = newCommentDate; }

    public boolean saveComment() {
        // TODO: Implement save logic
        return true;
    }

    public String getCommentInfo() {
        return "Comment by Student " + studentId + " for Lecturer " + lecturerId + ": " + commentText;
    }
}
