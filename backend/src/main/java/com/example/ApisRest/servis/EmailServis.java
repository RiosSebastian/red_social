package com.example.ApisRest.servis;

import java.io.File;

public interface EmailServis {

    void sendEmail(String[] toUser, String subject, String massege);

    void sendEmailWithFile(String[] toUser, String subject, String massege, File file);
}
