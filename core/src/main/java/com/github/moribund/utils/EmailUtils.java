package com.github.moribund.utils;

import lombok.experimental.UtilityClass;
import lombok.val;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.Mailer;
import org.simplejavamail.mailer.MailerBuilder;
import org.simplejavamail.mailer.config.TransportStrategy;

@UtilityClass
public class EmailUtils {
    public String EMAIL = "moribund.mb@gmail.com";
    private String PASSWORD = "U0be4li9&KYc";

    private Mailer mailer = MailerBuilder.withSMTPServer("smtp.gmail.com", 587)
            .withSMTPServerUsername(EMAIL)
            .withSMTPServerPassword(PASSWORD)
            .withTransportStrategy(TransportStrategy.SMTP_TLS)
            .clearEmailAddressCriteria()
            .buildMailer();

    public static void sendEmail(String toName, String to, String subject, String message) {
        val email = EmailBuilder.startingBlank()
                .from(EmailUtils.EMAIL)
                .to(toName, to)
                .withSubject(subject)
                .withPlainText(message)
                .buildEmail();

        mailer.sendMail(email);
    }
}
