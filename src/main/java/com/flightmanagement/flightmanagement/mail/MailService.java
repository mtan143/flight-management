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
                "\t<link rel=\"icon\" type=\"img/x-icon\" href=\"https://tinnhiemmang.vn/storage/photos/shares/uploads/0_travelkola.png\">\n" +
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
                "\t\t<img style=\"margin-left: 8px \" src=\"https://upload.wikimedia.org/wikipedia/vi/5/51/Traveloka_Primary_Logo.png\" width=\"50%\">\n" +
                "\t\t<p style=\"margin: 2px 0 0 8px; font-size: 18px\">Vé điện tử của quý khách trong thư này !</p>\n" +
                "\t\t<div class=\"text-center\" style=\"padding: 10px 0 ;\">\n" +
                "\n" +
                "\n" +
                "\t\t\t<hr><div class=\"\" style=\"margin: 15px 0\">\n" +
                "\t\t\t\t<label>Kính gửi quý khách: </label>\n" +
                "\t\t\t<span>" + name + "</span>\n" +
                "\t\t\t</div>\t\n" +
                "\n" +
                "\t\t<div class=\"title\" style=\"margin: 10px; font-weight: bold; color: #1BA0E2; margin-bottom: 20px\">THÔNG TIN CHUYẾN BAY</div>\n" +
                "\t\t<div class=\"text-center\" style=\"border: solid 0.5px; border-color: #9E9E9E\" >\n" +
                "\t\t\t<div class=\"item\" style=\"padding: 20px 20px 0 20px\">\n" +
                "\t\t\t\t<label>Chuyến bay: </label>\n" +
                "\t\t\t<span>" + flightName + "</span><hr>\t\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<div class=\"item\" style=\"margin-top: 5px\">\n" +
                "\t\t\t\t<label>Mã vé: </label>\n" +
                "\t\t\t<span style=\"color: #1BA0E2; font-weight: bold;\">" + ticketCode + "</span>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t\n" +
                "\t\t\t<div class=\"item\">\n" +
                "\t\t\t\t<label>Hãng bay: </label>\n" +
                "\t\t\t<span>" + airlineName + "</span>\n" +
                "\t\t\t</div>\n" +
                "\n" +
                "\t\t\t<div class=\"item\">\n" +
                "\t\t\t\t<label>Giờ khởi hành: </label>\n" +
                "\t\t\t<span>" + timeDeparture + " - " + timeArrival + "</span>\n" +
                "\t\t\t</div>\n" +
                "\n" +
                "\t\t\t<div class=\"item\">\n" +
                "\t\t\t\t<label>Tổng tiền: </label>\n" +
                "\t\t\t<span>" + currencyVN.format(totalPrice) + "</span>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t\t\t<div class=\"item\">\n" +
                "\t\t\t<span>Quý khách vui lòng kiểm tra thông tin chuyến bay cẩn thận! Nếu có vần đề gì, vui lòng liên hệ đến:\n" +
                "\t\t\t<ul style=\"list-style-type: circle; padding-left: 25px; margin: 5px\"><li>Email: <i><u><a href=\"#\" style=\"color: #1BA0E2\">nguyentantnnn82@gmail.com</a></u></i></li></ul>\n" +
                "\t\t\t<ul style=\"list-style-type: circle; padding-left: 25px; margin: 5px\"><li>Số điện thoại: (+84)855899520</li></ul>\n" +
                "\t\t\t</span><br><br>\n" +
                "\t\t\t<span style=\"font-weight: bold;\">Cảm ơn bạn đã sử dụng dịch vụ của chúng tôi!</span>\n" +
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
