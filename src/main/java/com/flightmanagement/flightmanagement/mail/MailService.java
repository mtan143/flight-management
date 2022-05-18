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
                              String timeArrival, int time, String departure, String airlineName) throws MessagingException {

        MimeMessage message = emailSender.createMimeMessage();

        boolean multipart = true;

        MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "utf-8");

        String htmlMsg = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "\t<title>Receipt Form</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div class=\"container\" style=\"margin: 5px 300px 300px 300px; font-family: sans-serif;\">\n" +
                "\t<div class=\"logo\" style=\"text-align: center;\">\n" +
                "\t\t<img src=\"https://brandlogos.net/wp-content/uploads/2022/03/traveloka-logo-brandlogo.net_.png\" style=\"width: 25%\">\n" +
                "\t</div>\n" +
                "\t<div class=\"title\" style=\"text-align: center;\">\n" +
                "\t\t<p style=\"font-size: 50px\">DIGITAL TICKET INFORMATION</p>\n" +
                "\t</div>\n" +
                "\t<div class=\"text-body\" style=\"margin-top: 100px\">\n" +
                "\t\t<p style=\"font-weight: bold;\">Dear " + name + ",</p>\n" +
                "\t\t<p>Your digital ticket information here!</p>\n" +
                "\t</div>\n" +
                "\t<div class=\"form\" style=\"margin-top: 20px\">\n" +
                "\t\t<div style=\"padding:8px 16px 16px;border:1px solid rgb(218,218,218);border-top-left-radius:4px;border-top-right-radius:4px;border-bottom-right-radius:4px;border-bottom-left-radius:4px;margin-bottom:16px;font-family:sans-serif\">\n" +
                "\t\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-bottom-width:1px;border-bottom-style:solid;margin-bottom:8px;width:100%;font-family:sans-serif;border-bottom-color:rgb(218,218,218)\">\n" +
                "\t\t\t\t<tbody>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td align=\"left\" valign=\"top\" width=\"100%\" style=\"padding-top:8px;padding-bottom:8px;font-family:sans-serif\">\n" +
                "\t\t\t\t\t\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"left\" style=\"display:block;width:200px;font-family:sans-serif\">\n" +
                "\t\t\t\t\t\t\t\t<tbody style=\"font-family:sans-serif\">\n" +
                "\t\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t<td valign=\"middle\" style=\"width:100%;padding-bottom:8px;font-family:sans-serif\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<span style=\"font-size:12px;text-transform:uppercase;letter-spacing:0.8px;font-weight:bold;font-family:sans-serif;color:rgb(143,143,143)\">Chuyến bay đi</span>\n" +
                "\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t</tbody>\n" +
                "\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"left\" style=\"display:block;width:290px;font-family:sans-serif\">\n" +
                "\t\t\t\t\t\t\t\t<tbody>\n" +
                "\t\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t<td valign=\"middle\" style=\"width:100%;padding-bottom:8px;font-family:sans-serif\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<span style=\"font-size:12px;text-transform:uppercase;letter-spacing:0.8px;font-weight:bold;font-family:sans-serif;color:rgb(67,67,67)\">" + flightName +"</span>\n" +
                "\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t</tbody>\n" +
                "\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t</tbody>\n" +
                "\t\t\t</table>\n" +
                "\t\t\t<table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"margin-top:5px;display:block;font-family:sans-serif\"> \n" +
                "                <tbody style=\"font-family:sans-serif\">\n" +
                "                 <tr style=\"font-family:sans-serif\"> \n" +
                "                  <td valign=\"middle\" style=\"width:100%;font-family:sans-serif\"> \n" +
                "                   <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"200px\" style=\"font-family:sans-serif\"> \n" +
                "                    <tbody style=\"font-family:sans-serif\">\n" +
                "                     <tr style=\"font-family:sans-serif\"> \n" +
                "                      <td style=\"font-family:sans-serif\"><span style=\"font-size:13px;line-height:25px;font-family:sans-serif;color:rgb(68,68,68)\">Mã đặt vé (PNR):</span></td> \n" +
                "                     </tr> \n" +
                "                     <tr style=\"font-family:sans-serif\"> \n" +
                "                      <td style=\"font-family:sans-serif\"> <span style=\"font-size:24px;line-height:18px;font-weight:bold;padding-top:8px;font-family:sans-serif;color:rgb(37,159,217)\">" + ticketCode +"</span> </td> \n" +
                "                     </tr> \n" +
                "                    </tbody>\n" +
                "                   </table> </td> \n" +
                "                 </tr> \n" +
                "                </tbody>\n" +
                "               </table>\n" +
                "               <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"320px\" style=\"margin-top:10px;font-family:sans-serif\"> \n" +
                "                <tbody style=\"font-family:sans-serif\">\n" +
                "                 <tr style=\"font-family:sans-serif\"> \n" +
                "                  <td style=\"font-family:sans-serif\"> <span style=\"font-size:18px;line-height:22px;font-weight:bold;font-family:sans-serif;color:rgb(68,68,68)\">" + departure +"</span> </td> \n" +
                "                 </tr> \n" +
                "                 <tr style=\"font-family:sans-serif\"> \n" +
                "                  <td style=\"font-family:sans-serif\"> <span style=\"font-size:15px;line-height:22px;font-family:sans-serif;color:rgb(115,115,116)\"> " + timeDeparture + " - " + timeArrival + " (" + time + "h, Bay thẳng) </span> </td> \n" +
                "                 </tr> \n" +
                "                </tbody>\n" +
                "               </table>\n" +
                "               <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"font-family:sans-serif\"> \n" +
                "                <tbody style=\"font-family:sans-serif\">\n" +
                "                 <tr style=\"font-family:sans-serif\"> \n" +
                "                  <td valign=\"top\" style=\"font-family:sans-serif\"> \n" +
                "                   <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"margin-top:10px;display:block;width:200px;font-family:sans-serif\"> \n" +
                "                    <tbody style=\"font-family:sans-serif\">\n" +
                "                     <tr style=\"font-family:sans-serif\"> \n" +
                "                      <td valign=\"middle\" style=\"width:100%;font-family:sans-serif\"> \n" +
                "                       <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"font-family:sans-serif\"> \n" +
                "                        <tbody style=\"font-family:sans-serif\">\n" +
                "                         <tr style=\"font-family:sans-serif\"> \n" +
                "                          <td style=\"font-family:sans-serif\"> \n" +
                "                           <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"font-family:sans-serif\"> \n" +
                "                            <tbody style=\"font-family:sans-serif\">\n" +
                "                             <tr style=\"font-family:sans-serif\"> \n" +
                "                              <td style=\"vertical-align:middle;font-family:sans-serif\"> <img src=\"https://ci5.googleusercontent.com/proxy/7mnUVAcCOCbqF299JMMUkC_9k3714w-3JqUpfnzO61Dosb3HIQRbh5ppONDBnjrI_d--QE1_8DWX3z6fa8MV0RWAcMdF9hVpXG7Hk44xnBSqS99DTLvlSlXsJ_b9EIpPH8_TWqUZPNrqczbq8yh3CvZE8Rz-PnP9dwMS4gB1LbHrrmes=s0-d-e1-ft#https://d1gnmtcb0vp69g.cloudfront.net/imageResource/2021/01/28/1611827393518-206370ff769dff23e3454c0a753ce7ee.png\" alt=\"Flight Logo\" style=\"width:24px;height:24px;margin-right:16px;vertical-align:middle;font-family:sans-serif\" class=\"CToWUd\"> </td> \n" +
                "                              <td style=\"vertical-align:middle;font-family:sans-serif\"> <span style=\"margin:0px;padding:0px;font-size:15px;font-weight:bold;font-family:sans-serif;color:rgb(68,68,68)\"> " + airlineName + " </span><br> <span style=\"margin:0px;padding:0px;font-size:15px;font-family:sans-serif;color:rgb(115,115,116)\"><img style=\"display:block;font-size:0px;line-height:0em;font-family:sans-serif\" src=\"https://ci3.googleusercontent.com/proxy/uT-cYCHpyNjw2zRksMsvWDdsHKVjP_9lb4Qzat16KoCO3XOM-_kog7ZvtDK5apiFewy4DdSBhpB_YoatHPJ0CRndxDFZe5LVBeqpbPbuHpHbmYKX3gnP4tOQynQb2EqkXMZJR6HmvTpUFiQctb2TNBXcR9VNmGmBFUJAvMwPyXHNnwyT1wvBSm9kWEDhiY6EGu3wCV-KE3v3VjnuFdvKjURhQzcPhr_dXmK1AgxktPeIvg=s0-d-e1-ft#https://cntres-flightpnr-ap-southeast-1-250226768838-155776e9d7acd7f6.s3.amazonaws.com/flightPnr/2016/09/24/1474698935821-71c78d12b6d6b2fb488db6736cd926c1.png\" alt=\"\" border=\"0\" class=\"CToWUd\"></span> </td> \n" +
                "                             </tr> \n" +
                "                            </tbody>\n" +
                "                           </table> </td> \n" +
                "                         </tr> \n" +
                "                        </tbody>\n" +
                "                       </table> </td> \n" +
                "                     </tr> \n" +
                "                    </tbody>\n" +
                "                   </table> \n" +
                "                   <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"display:block;margin-top:10px;width:320px;font-family:sans-serif\"> \n" +
                "                    <tbody style=\"font-family:sans-serif\">\n" +
                "                     <tr style=\"font-family:sans-serif\"> \n" +
                "                      <td valign=\"top\" style=\"width:100%;padding-bottom:10px;font-family:sans-serif\"> \n" +
                "                       <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"font-family:sans-serif\"> \n" +
                "                        <tbody style=\"font-family:sans-serif\">\n" +
                "                         <tr style=\"font-family:sans-serif\"> \n" +
                "                          <td align=\"left\" style=\"width:55px;padding-bottom:0px;font-family:sans-serif\" valign=\"top\"> \n" +
                "                           <div style=\"width:55px;font-size:15px;font-weight:bold;font-family:sans-serif;color:rgb(68,68,68)\">\n" +
                "                             11:15 \n" +
                "                           </div> \n" +
                "                           <div style=\"font-size:15px;font-family:sans-serif;color:rgb(115,115,116)\">\n" +
                "                            CN\n" +
                "                           </div> </td> \n" +
                "                          <td align=\"left\" valign=\"top\" style=\"width:30px;font-family:sans-serif\" colspan=\"2\"> <img src=\"https://ci3.googleusercontent.com/proxy/eGXwp8Ejw1CTPor4kr1Epx_8ulwCotVP1aRYi-ch0Fufwubx03ZcZkVso7hSVBGv1RDssV3mcEJzHEiYdbqYsi8BWiqA3Qx7NDQ_LjhryVxdbgmWlE77bLZ1yOIrKp_0FittKPbLnFZ9Fl1yf9pCNi7VCnKduUUpil-2mxXux2NVm_Iu=s0-d-e1-ft#https://d1gnmtcb0vp69g.cloudfront.net/imageResource/2021/01/28/1611827927248-80ada129819bd3a0e7e737a3069ff028.png\" style=\"width:12px;margin-top:7px;padding:0px 20px;font-family:sans-serif\" class=\"CToWUd\"> \n" +
                "                           <div style=\"border-left-width:1px;border-left-style:solid;height:50px;margin-left:25px;font-family:sans-serif;border-left-color:rgb(85,85,85)\">\n" +
                "                            &nbsp;\n" +
                "                           </div> </td> \n" +
                "                          <td align=\"left\" valign=\"top\" style=\"padding-bottom:0px;font-family:sans-serif\"> <span style=\"font-size:15px;font-weight:bold;font-family:sans-serif;color:rgb(68,68,68)\">Ho Chi Minh City (SGN)</span><br> <span style=\"font-size:15px;font-family:sans-serif;color:rgb(115,115,116)\"> Tansonnhat Intl <br> Terminal 1 </span> </td> \n" +
                "                         </tr> \n" +
                "                         <tr style=\"font-family:sans-serif\"> \n" +
                "                          <td align=\"left\" style=\"width:55px;padding-bottom:0px;font-family:sans-serif\" valign=\"top\"></td> \n" +
                "                          <td align=\"left\" valign=\"top\" style=\"width:5px;font-family:sans-serif\"> \n" +
                "                           <div style=\"width:25px;font-family:sans-serif\"></div> </td> \n" +
                "                          <td align=\"left\" valign=\"top\" style=\"width:30px;border-left-width:1px;border-left-style:solid;font-family:sans-serif;border-left-color:rgb(85,85,85)\"></td> \n" +
                "                          <td align=\"left\" valign=\"top\" style=\"padding-bottom:0px;font-family:sans-serif\"> \n" +
                "                           <div style=\"padding-bottom:20px;font-family:sans-serif\"> \n" +
                "                           </div> </td> \n" +
                "                         </tr> \n" +
                "                         <tr style=\"font-family:sans-serif\"> \n" +
                "                          <td align=\"left\" style=\"width:55px;padding-bottom:0px;font-family:sans-serif\" valign=\"top\"> <span style=\"font-size:15px;font-weight:bold;font-family:sans-serif;color:rgb(68,68,68)\"> 12:25 </span> <span style=\"font-size:15px;font-family:sans-serif;color:rgb(115,115,116)\"> CN </span> </td> \n" +
                "                          <td align=\"left\" valign=\"top\" style=\"width:30px;font-family:sans-serif\" colspan=\"2\"> <img src=\"https://ci3.googleusercontent.com/proxy/eGXwp8Ejw1CTPor4kr1Epx_8ulwCotVP1aRYi-ch0Fufwubx03ZcZkVso7hSVBGv1RDssV3mcEJzHEiYdbqYsi8BWiqA3Qx7NDQ_LjhryVxdbgmWlE77bLZ1yOIrKp_0FittKPbLnFZ9Fl1yf9pCNi7VCnKduUUpil-2mxXux2NVm_Iu=s0-d-e1-ft#https://d1gnmtcb0vp69g.cloudfront.net/imageResource/2021/01/28/1611827927248-80ada129819bd3a0e7e737a3069ff028.png\" style=\"width:12px;padding:0px 20px;font-family:sans-serif\" class=\"CToWUd\"> </td> \n" +
                "                          <td align=\"left\" style=\"padding-bottom:0px;font-family:sans-serif\"> <span style=\"font-size:15px;font-weight:bold;font-family:sans-serif;color:rgb(68,68,68)\">Nha Trang (CXR)</span><br> <span style=\"font-size:15px;font-family:sans-serif;color:rgb(115,115,116)\">Cam Ranh </span> </td> \n" +
                "                         </tr> \n" +
                "                        </tbody>\n" +
                "                       </table> </td> \n" +
                "                     </tr> \n" +
                "                    </tbody>\n" +
                "                   </table> </td> \n" +
                "                 </tr> \n" +
                "                </tbody>\n" +
                "               </table>\n" +
                "\t\t</div>\n" +
                "\t\t<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"font-family:sans-serif\"> \n" +
                "               <tbody style=\"font-family:sans-serif\">\n" +
                "                <tr style=\"font-family:sans-serif\"> \n" +
                "                 <td style=\"font-family:sans-serif\"> \n" +
                "                  <table align=\"left\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"font-family:sans-serif\"> \n" +
                "                   <tbody style=\"font-family:sans-serif\">\n" +
                "                    <tr style=\"font-family:sans-serif\"> \n" +
                "                     <td style=\"font-family:sans-serif\"> <p style=\"font-size:15px;text-transform:uppercase;font-weight:bold;font-family:sans-serif;color:rgb(37,159,217)\">Tên hành khách:</p> \n" +
                "                      <ol style=\"margin:0px;padding-left:20px;font-size:16px;font-family:sans-serif;color:rgb(68,68,68)\"> \n" +
                "                        \n" +
                "                       <li style=\"font-family:sans-serif\"> Ông Duc Trung Bui (Người lớn)</li> \n" +
                "                       <div style=\"display:block;margin-top:4px;font-family:sans-serif\"> \n" +
                "                        <div style=\"display:inline-block;vertical-align:top;width:80px;text-align:center;font-family:sans-serif\"> \n" +
                "                         <div style=\"padding:4px 8px;border:1px solid rgb(205,208,209);border-top-left-radius:12px;border-top-right-radius:12px;border-bottom-right-radius:12px;border-bottom-left-radius:12px;font-size:11px;font-family:sans-serif;background-color:white\">\n" +
                "                           SGN - CXR\n" +
                "                         </div> \n" +
                "                        </div> \n" +
                "                        <div style=\"display:inline-block;vertical-align:top;margin-bottom:8px;font-family:sans-serif\"> \n" +
                "                         <div style=\"display:block;vertical-align:top;padding-left:8px;padding-top:2px;margin-bottom:4px;font-family:sans-serif\"> \n" +
                "                          <img style=\"display:inline-block;vertical-align:top;width:16px;height:16px;font-family:sans-serif\" src=\"https://ci6.googleusercontent.com/proxy/9xETBpMX9S48zjR7DLlKBVZ719SFXBUY9kS_vXTmdx4bf09c1uebvR-RVn4SDHEBCOojfOYqY4qq05_Rkd7B7slUxsGLLBiY3yzmkFPkQqakU_4jVoHpX2BPQxVude6zSJmE0KzB7KvkiwwFJUKkBKKWaUJnD6AfGw5lTtgmNxnfa0UV=s0-d-e1-ft#https://d1gnmtcb0vp69g.cloudfront.net/imageResource/2021/09/27/1632735564650-6b936f2c40c8e79881f2061606ef7edd.png\" class=\"CToWUd\"> \n" +
                "                          <div style=\"display:inline-block;vertical-align:top;font-family:sans-serif\"> \n" +
                "                           <div style=\"font-size:14px;font-family:sans-serif;color:rgb(104,113,118)\">\n" +
                "                            0 KG\n" +
                "                           </div> \n" +
                "                          </div> \n" +
                "                         </div> \n" +
                "                         <div style=\"display:block;vertical-align:top;padding-left:8px;padding-top:2px;margin-bottom:4px;font-family:sans-serif\"> \n" +
                "                          <img style=\"display:inline-block;vertical-align:top;width:16px;height:16px;font-family:sans-serif\" src=\"https://ci6.googleusercontent.com/proxy/oFTtyowYmS7orW7zHVHx_LsoVuiHc2UvGTw5D2cOCC89zZ0fMUCf73HTsSNCWez_Man-Qge9beV23K3FXqv5nM8vZf0-x63bQXwbMA55Pmc4bqctftuXt61m2E8aMuvoy2j_Xgdr_-BJ5Wok7ehUPCOVQ8rJPv_RCJTiB989AoWrMvXG=s0-d-e1-ft#https://d1gnmtcb0vp69g.cloudfront.net/imageResource/2021/09/27/1632735511164-01328028074ea39a3a5701f5e9aee975.png\" class=\"CToWUd\"> \n" +
                "                          <div style=\"display:inline-block;vertical-align:top;font-family:sans-serif\"> \n" +
                "                           <div style=\"font-size:14px;font-family:sans-serif;color:rgb(104,113,118)\">\n" +
                "                            Phiếu xét nghiệm kháng nguyên nhanh\n" +
                "                           </div> \n" +
                "                          </div> \n" +
                "                         </div> \n" +
                "                        </div> \n" +
                "                       </div> \n" +
                "                        \n" +
                "                        \n" +
                "                        \n" +
                "                      </ol> </td> \n" +
                "                    </tr> \n" +
                "                   </tbody>\n" +
                "                  </table> \n" +
                "                  <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-bottom-width:1px;border-bottom-style:solid;font-family:sans-serif;border-bottom-color:rgb(218,218,218)\"> \n" +
                "                   <tbody style=\"font-family:sans-serif\">\n" +
                "                    <tr style=\"font-family:sans-serif\"> \n" +
                "                     <td style=\"font-family:sans-serif\"><br><br></td> \n" +
                "                    </tr> \n" +
                "                   </tbody>\n" +
                "                  </table> \n" +
                "                   \n" +
                "                   \n" +
                "                  <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-bottom-width:1px;border-bottom-style:solid;font-family:sans-serif;border-bottom-color:rgb(218,218,218)\"> \n" +
                "                   <tbody style=\"font-family:sans-serif\">\n" +
                "                    <tr style=\"font-family:sans-serif\"> \n" +
                "                     <td style=\"font-family:sans-serif\"><br><br></td> \n" +
                "                    </tr> \n" +
                "                   </tbody>\n" +
                "                  </table> \n" +
                "                  <table align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:100%;height:16px;font-family:sans-serif\"> \n" +
                "                   <tbody style=\"font-family:sans-serif\">\n" +
                "                    <tr style=\"font-family:sans-serif\"> \n" +
                "                     <td style=\"font-family:sans-serif\"></td> \n" +
                "                    </tr> \n" +
                "                   </tbody>\n" +
                "                  </table>  </td> \n" +
                "                </tr> \n" +
                "               </tbody>\n" +
                "              </table>\n" +
                "              <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"margin-top:16px;font-family:sans-serif\"> \n" +
                "               <tbody style=\"font-family:sans-serif\">\n" +
                "                <tr style=\"font-family:sans-serif\"> \n" +
                "                 <td style=\"width:100%;height:0px;font-family:sans-serif;background-color:rgb(68,68,68)\"></td> \n" +
                "                </tr> \n" +
                "               </tbody>\n" +
                "              </table>\n" +
                "\t</div>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>";

        message.setContent(htmlMsg, "text/html");

        helper.setTo("nguyentantnnn82@gmail.com");

        helper.setSubject("Test send HTML email");


        this.emailSender.send(message);

    }
}
