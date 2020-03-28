package pms.service.impl;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import pms.service.MailService;

@Service
public class MailServiceImpl implements MailService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private JavaMailSender mailSender;

	@Value("${spring.mail.username}")
	private String from;

	@Override
	public void sendSimpleMail(String to, String subject, String content) {
		// TODO Auto-generated method stub
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(from);// 设置发信人
		message.setTo(to);// 设置收信人
		message.setSubject(subject);// 设置主题
		message.setText(content);// 设置内容
		try {
			mailSender.send(message);
			logger.info("已发送");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	@Override
	public void sendHTMLMail(String to, String subject, String content) {
		// TODO Auto-generated method stub
		MimeMessage message = mailSender.createMimeMessage();
		try {
			// true 表示需要创建一个multipart message
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom(from);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(content, true);
			mailSender.send(message);
			logger.info("html文件发送成功");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	@Override
	public void sendAttachMail(String to, String subject, String content, String filePath) {
		// TODO Auto-generated method stub
		MimeMessage message = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom(from);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(content, true);

			FileSystemResource file = new FileSystemResource(new File(filePath));
			String fileName = file.getFilename();
			helper.addAttachment(fileName, file);

			mailSender.send(message);
			logger.info("带附件的邮件已经发送");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	@Override
	public void sendStaticMail(String to, String subject, String content, String rscPath, String rscId) {
		// TODO Auto-generated method stub
		MimeMessage message = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom(from);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(content, true);
			FileSystemResource res = new FileSystemResource(new File(rscPath));
			helper.addInline(rscId, res);
			mailSender.send(message);
			logger.info("静态资源邮件已发送");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

}
