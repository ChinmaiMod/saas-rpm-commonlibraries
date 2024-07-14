package com.io.rpm.service.security.constants;

public class Constant {
	public static final String BUCKET_NAME="cardio-new-dev-asset";
//    public static final String BUCKET_NAME=System.getenv("RPM_S3_BUCKET");
    public static final String DOCUMENT="documents";
    public static final String PATIENT_DOCUMENT="patient_documents";
    public static final String PATIENT_INSURANCE_DOCUMENT="patient_documents";
    public static final String PROFILE_PICK="profilepick";
    public static final String INSURANCE_DOCK="InsuranceDocks";
    public static final String DEFAULT_EMAIL=System.getenv("RPM_SUPPORT_EMAIL");//"support@kavanant.com";
    public static final String PATIENT_FOLDER_PREFIX="patient";
    public static final String CHAT_BUCKET_NAME=System.getenv("RPM_CHAT_S3_BUCKET");
    public static final String CHAT_TEMP_FOLDER="chat_temp";
    public static final String CHAT_FOLDER="chat_files";
}
