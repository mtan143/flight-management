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

        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);

        MimeMessage mimeMessage = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        String htmlMsg = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "\t<title>Ticket Information</title>\n" +
                "\t<link href=\"https://fonts.googleapis.com/css?family=Be Vietnam\" rel=\"stylesheet\">\n" +
                "\t<style type=\"text/css\">\n" +
                "\t\tbody {\n" +
                "    font-family: \"Be Vietnam\";font-size: 15px;\n" +
                "\t\t}\n" +
                "\t\tlabel  {\n" +
                "\t\t\tfont-weight: bold;\n" +
                "\t\t}\n" +
                "\t\t.item {\n" +
                "\t\t\tpadding: 20px;\n" +
                "\t\t}\n" +
                "\t</style>\n" +
                "</head>\n" +
                "<body>\n" +
                "\t<div class=\"container\" style=\"padding: 50px; border: solid 0.5px; width: 400px; height: 700px\">\n" +
                "\t\t<img style=\"\" src=\"https://brandlogos.net/wp-content/uploads/2022/03/traveloka-logo-brandlogo.net_.png\" width=\"20%\">\n" +
                "\t\t<div class=\"text-center\" style=\"padding: 10px 0\">\n" +
                "\n" +
                "\t\t\t<div class=\"title\" style=\"margin: 10px; font-weight: bold;\"><hr>TICKET INFORMATION<hr></div>\n" +
                "\t\t\t<div class=\"item\">\n" +
                "\t\t\t\t<label>Code: </label>\n" +
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
                "\t\t\t<span>" + currencyVN.format(totalPrice) + "</span>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<div class=\"item\">\n" +
                "\t\t\t<span>Please check your ticket information carefully! If you've got any problem, please contact at: <i><u>nguyentantnnn82@gmail.com</u></i></span><br><br>\n" +
                "\t\t\t<span style=\"font-weight: bold;\">Thanks for your supporting our services!</span>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t\n" +
                "\t\t</div>\n" +
                "\t</div>\n" +
                "</body>\n" +
                "</html>";
        helper.setText(htmlMsg, true); // Use this or above line.
        helper.setTo(email);
        helper.setSubject("CONFIRM TICKET INFORMATION");
        emailSender.send(mimeMessage);

    }
}
