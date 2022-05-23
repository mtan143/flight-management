package com.flightmanagement.flightmanagement.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MailService {

    @Autowired
    public JavaMailSender emailSender;

    public void confirmTicket(String name, String flightName, String ticketCode, String timeDeparture,
                              String timeArrival, String airlineName, int totalPrice) throws MessagingException {

        MimeMessage message = emailSender.createMimeMessage();

        boolean multipart = true;

        MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "utf-8");

        String htmlMsg = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "\t<title>Ticket Information</title>\n" +
                "\t<style type=\"text/css\">\n" +
                "\t\tlabel{\n" +
                "\t\t\tfont-weight: bold;\n" +
                "\t\t}\n" +
                "\t\t.item {\n" +
                "\t\t\tmargin: 20px;\n" +
                "\t\t}\n" +
                "\t</style>\n" +
                "</head>\n" +
                "<body>\n" +
                "\t<div class=\"container\" style=\"padding: 50px; border: solid 0.5px; width: 300px; height: 300px\">\n" +
                "\t\t<div class=\"text-center\" style=\"padding: 10px 0\">\n" +
                "<div class=\"title\" style=\"margin: 10px; font-weight: bold;\">TICKET INFORMATION</div>\n" +
                "\t\t\t<div class=\"item\">\n" +
                "\t\t\t\t<label>Ticket Code: </label>\n" +
                "\t\t\t<span>" + ticketCode + "</span>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<div class=\"item\">\n" +
                "\t\t\t\t<label>Flight: </label>\n" +
                "\t\t\t<span>" + flightName + "</span>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<div class=\"item\">\n" +
                "\t\t\t\t<label>User: </label>\n" +
                "\t\t\t<span>" + name + "</span>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<div class=\"item\">\n" +
                "\t\t\t\t<label>Time: </label>\n" +
                "\t\t\t<span>" + timeDeparture + " - " + timeArrival + "</span>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<div class=\"item\">\n" +
                "\t\t\t\t<label>Airline: </label>\n" +
                "\t\t\t<span>" + airlineName + "</span>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<div class=\"item\">\n" +
                "\t\t\t\t<label>Total: </label>\n" +
                "\t\t\t<span>" + totalPrice + "</span>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t\n" +
                "\t\t</div>\n" +
                "\t</div>\n" +
                "</body>\n" +
                "</html>";

        message.setContent(htmlMsg, "text/html");

        helper.setTo("nguyentantnnn82@gmail.com");

        helper.setSubject("Ticket Information");


        this.emailSender.send(message);

    }
}
