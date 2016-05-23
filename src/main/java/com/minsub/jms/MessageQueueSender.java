package com.minsub.jms;

import java.util.Properties;

import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

public class MessageQueueSender {
	public static void main(String args[]) {
		
		try {
			String str = "HELLOOOOO WORLDDDDD!!!";
			
			Properties h = new Properties();
			h.put(Context.INITIAL_CONTEXT_FACTORY,
					"weblogic.jndi.WLInitialContextFactory");
			h.put(Context.PROVIDER_URL, "t3://localhost:7001");

			Context ctx = new InitialContext(h);
			QueueConnectionFactory factory = (QueueConnectionFactory) ctx
					.lookup("weblogic.jms.ConnectionFactory");
			Queue queue = (Queue) ctx.lookup("jmsqueue");
			QueueConnection con = factory.createQueueConnection();
			QueueSession session = con.createQueueSession(false,
					Session.AUTO_ACKNOWLEDGE);
			QueueSender qsender = session.createSender(queue);
			TextMessage message = session.createTextMessage();
			message.setText(str);
			qsender.send(message);
			qsender.send(session.createMessage());
			con.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
}