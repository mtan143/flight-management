package com.flightmanagement.flightmanagement.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

@Service
public class MailService {

    @Autowired
    public JavaMailSender emailSender;

    public void confirmTicket(String name, String flightName, String ticketCode, String timeDeparture,
                              String timeArrival, String airlineName, int totalPrice, String email) throws MessagingException {

        SimpleMailMessage msg = new SimpleMailMessage();

        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);

        String htmlMsg = "Ticket Code: " + ticketCode + "\n Name: " + name + "\n" +
                "Airline: " + airlineName + "\n Flight: " + flightName + "\n" +
                "Time: " + timeDeparture + " - " + timeArrival + "\n" +
                "Total Price: " + currencyVN.format(totalPrice);

        msg.setText(htmlMsg);

        msg.setTo(email);

        msg.setSubject("Ticket Information");


        this.emailSender.send(msg);

    }
}
