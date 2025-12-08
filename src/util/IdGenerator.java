package util;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Utility class for generating unique IDs
 */
public class IdGenerator {
    private static final AtomicLong counter = new AtomicLong(System.currentTimeMillis());
    
    private IdGenerator() {
        // Prevent instantiation
    }
    
    public static String generateUserId() {
        return "U" + counter.incrementAndGet();
    }
    
    public static String generateStudentId() {
        return "STU" + counter.incrementAndGet();
    }
    
    public static String generateLecturerId() {
        return "LEC" + counter.incrementAndGet();
    }
    
    public static String generateAdminId() {
        return "ADM" + counter.incrementAndGet();
    }
    
    public static String generateLeaderId() {
        return "LDR" + counter.incrementAndGet();
    }
    
    public static String generateModuleId() {
        return "MOD" + counter.incrementAndGet();
    }
    
    public static String generateClassId() {
        return "CLS" + counter.incrementAndGet();
    }
    
    public static String generateAssessmentId() {
        return "ASS" + counter.incrementAndGet();
    }
    
    public static String generateResultId() {
        return "RES" + counter.incrementAndGet();
    }
    
    public static String generateFeedbackId() {
        return "FDB" + counter.incrementAndGet();
    }
    
    public static String generateCommentId() {
        return "CMT" + counter.incrementAndGet();
    }
    
    public static String generateReportId() {
        return "RPT" + counter.incrementAndGet();
    }
    
    public static String generateGradingSystemId() {
        return "GRD" + counter.incrementAndGet();
    }
}
