package config;

/**
 * System-wide constants for the Academic Feedback System
 */
public final class Constants {
    
    // Prevent instantiation
    private Constants() {}
    
    // User Roles
    public static final String ROLE_ADMIN = "ADMIN_STAFF";
    public static final String ROLE_ACADEMIC_LEADER = "ACADEMIC_LEADER";
    public static final String ROLE_LECTURER = "LECTURER";
    public static final String ROLE_STUDENT = "STUDENT";
    
    // ID Prefixes
    public static final String PREFIX_USER = "U";
    public static final String PREFIX_STUDENT = "STU";
    public static final String PREFIX_LECTURER = "LEC";
    public static final String PREFIX_ADMIN = "ADM";
    public static final String PREFIX_LEADER = "LDR";
    public static final String PREFIX_MODULE = "MOD";
    public static final String PREFIX_CLASS = "CLS";
    public static final String PREFIX_ASSESSMENT = "ASS";
    public static final String PREFIX_RESULT = "RES";
    public static final String PREFIX_FEEDBACK = "FDB";
    public static final String PREFIX_COMMENT = "CMT";
    public static final String PREFIX_REPORT = "RPT";
    
    // Validation Constants
    public static final int MIN_PASSWORD_LENGTH = 6;
    public static final int MAX_PASSWORD_LENGTH = 20;
    public static final int MIN_NAME_LENGTH = 2;
    public static final int MAX_NAME_LENGTH = 50;
    
    // Grade Constants
    public static final double MAX_MARKS = 100.0;
    public static final double MIN_MARKS = 0.0;
    public static final double PASS_MARKS = 40.0;
    
    // File Delimiters
    public static final String DELIMITER = "|";
    public static final String LINE_SEPARATOR = System.lineSeparator();
    
    // Date Formats
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
}
