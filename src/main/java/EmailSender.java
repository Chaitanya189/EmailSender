import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.util.Properties;

public class EmailSender {

    public static void main(String[] args) {
        // Replace with your real Gmail
        final String fromEmail = "chaitanyasharma366@gmail.com";
        final String password = "qlnp vvec brhj npgp"; // Use Genrated Gmail Password here
        final String toEmail = "dikshasharma201418@gmail.com";

        // Email content
        String subject = "Test Email from Java App";
        String body = "Hi there,\n\nThis is a test email sent from Java using JavaMail API!";

        // SMTP properties
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");            
        props.put("mail.smtp.auth", "true");           
        props.put("mail.smtp.starttls.enable", "true"); 

        Session session = Session.getInstance(props, new jakarta.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);
            System.out.println("✅ Email sent successfully!");

        } catch (MessagingException e) {
            System.out.println("❌ Failed to send email.");
            e.printStackTrace();
        }
    }
}
