package domain.academic;

import domain.user.Student;
import domain.user.Lecturer;

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
    public String getCommentText() { return commentText; }
    public LocalDate getCommentDate() { return commentDate; }

    public void setCommentId(String newCommentId) { this.commentId = newCommentId; }
    public void setCommentText(String newCommentText) { this.commentText = newCommentText; }
    public void setCommentDate(LocalDate newCommentDate) { this.commentDate = newCommentDate; }


}
