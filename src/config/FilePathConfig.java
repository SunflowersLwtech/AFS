package config;

/**
 * File path configuration for data files
 */
public final class FilePathConfig {
    
    // Prevent instantiation
    private FilePathConfig() {}
    
    // Base data directory
    public static final String DATA_DIR = "data/";
    public static final String BACKUP_DIR = "data/backup/";
    
    // Data file paths
    public static final String USERS_FILE = DATA_DIR + "users.txt";
    public static final String MODULES_FILE = DATA_DIR + "modules.txt";
    public static final String CLASSES_FILE = DATA_DIR + "classes.txt";
    public static final String ASSESSMENTS_FILE = DATA_DIR + "assessments.txt";
    public static final String RESULTS_FILE = DATA_DIR + "results.txt";
    public static final String GRADES_FILE = DATA_DIR + "grades.txt";
    public static final String FEEDBACKS_FILE = DATA_DIR + "feedbacks.txt";
    public static final String COMMENTS_FILE = DATA_DIR + "comments.txt";
    public static final String REPORTS_FILE = DATA_DIR + "reports.txt";
}
