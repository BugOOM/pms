package pms.service;

public interface MailService {
	void sendSimpleMail(String to, String subject, String content);

	void sendHTMLMail(String to, String subject, String content);

	void sendAttachMail(String to, String subject, String content, String filePath);

	void sendStaticMail(String to, String subject, String content, String rscPath, String rscId);
}
