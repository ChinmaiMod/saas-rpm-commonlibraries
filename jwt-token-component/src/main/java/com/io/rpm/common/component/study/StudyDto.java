package com.io.rpm.common.component.study;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

public interface StudyDto {
    @Data
    class DeleteRequest {
        public String facilityId;
        public String itemId;
        public  List<User> users;

    }

    @Data
    class StudyRequest {
        private String studyType;
    }

    @Data
    class User {
        public String userId;
    }
    @Data
    @lombok.Builder
    @ToString
    class HolterRequest {
        public DeviceConfig deviceConfig;
        public Long tachyBpm;
        public Long bradyBpm;
        public Long pauseDuration;
        public Long episodeDuration;
        public Long hpFilter;
        public Long lpFilter;
        public Long notchFilter;
        public Long enrollmentId;

    }
    @Data
    @lombok.Builder
    @ToString
    class Request {
        public String deviceId;
        public String tzSerial;
        public String facilityId;
        public String studyIndication;
        public List<StudyNote> studyNotes;
        public String patientName;
        public DeviceConfig deviceConfig;
        public Long studyHours;
        public Long tachyBpm;
        public Long bradyBpm;
        public Long pauseDuration;
        public Long episodeDuration;
        public Long hpFilter;
        public Long lpFilter;
        public Long notchFilter;
        public String studyType;

    }
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
class Response{
         public List<StudyNote> studyNotes;
        public Long id;
        public String enrollmentId;
        public String facilityId;
        public Long itemCount;
        public Date studyStartDate;
        public Date studyEndDate;
        public String studyIndication;
        public String studyState;
        public String studyType;
        public Long reportCount;
        public Long stripCount;
        public String patientName;
        public String patientId;
        public String patientDob;
        public String patientGender;
        public String patientPhoneNumber;
        public String patientAddress;
        public String patientNotes;
        public String physicianName;
        public String physicianPhoneNumber;
        public String physicianFacility;
        public String physicianEmail;
        public String physicianAddress;
        public String physicianNotes;
        public Date createdAt;
        public Date updatedAt;

}
    @Data
    @lombok.Builder
    class StudyNote {
        public String fullName;
        public Long timestamp;
        public String note;
    }

    @Data
    @lombok.Builder
  public   class DeviceConfig {
        public String id;
        public String facilityId;
        public String name;
        public int bradyRateChange;
        public int tachyRateChange;
        public boolean detectPacemaker;
        public int reportPreTime;
        public int reportPostTime;
        public int minTimeBetweenEvents;
        public boolean suppressNsrEvents;
        public int studyCompleteSleep;
        public int nagOnLeadOff;
        public int screenSleepTime;
        public int symptomDiaryEntries;
        public int activityDiaryEntries;
        public String symptomEntry1;
        public String symptomEntry2;
        public String symptomEntry3;
        public String symptomEntry4;
        public String symptomEntry5;
        public String symptomEntry6;
        public String symptomEntry7;
        public String symptomEntry8;
        public String symptomEntry9;
        public String symptomEntry10;
        public String activityEntry1;
        public String activityEntry2;
        public String activityEntry3;
        public String activityEntry4;
        public String activityEntry5;
        public String activityEntry6;
        public String activityEntry7;
        public String activityEntry8;
        public String activityEntry9;
        public String activityEntry10;
        public String topBanner;
        public String createdAt;
        public String updatedAt;
        public String deviceType;
    }

    @Data
    class NotesRequest {
        private String fullName;
        private Integer timestamp;
        private String note;
    }
}
