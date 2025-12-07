package domain.feedback;

import domain.academic.Assessment;

public class Feedback {
    private String feedbackId;
    private String lecturerId;
    private String assessmentId;
    private String assessmentType;
    private String feedbackText;

    public Feedback(
        String lecturerId, 
        String assessmentId, 
        String assessmentType, 
        String feedbackText
    ) {
        this.lecturerId = lecturerId;
        this.assessmentId = assessmentId;
        this.assessmentType = assessmentType;
        this.feedbackText = feedbackText;
    }

    public String getFeedbackId() { return feedbackId; }
    public String getFeedbackText() { return feedbackText; }

    public void setFeedbackId(String newFeedbackId) { this.feedbackId = newFeedbackId; }
    public void setFeedbackText(String newFeedbackText) {this.feedbackText = newFeedbackText; }

}
