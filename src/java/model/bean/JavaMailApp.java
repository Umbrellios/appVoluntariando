/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.util.ArrayList;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMailApp
{
    public void EnviarEmail(ArrayList<Evento> listaemail, Instituicao inst) {
        for (int i = 0; i<listaemail.size(); i++){
        Properties props = new Properties();
        /** Parâmetros de conexão com servidor Gmail */
        props.put("mail.smtp.host", "smtp.cntconstrutora.com.br");
        props.put("mail.smtp.socketFactory.port", "587");
        //props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");

        Session session = Session.getDefaultInstance(props,
                    new javax.mail.Authenticator() {
                         protected PasswordAuthentication getPasswordAuthentication()
                         {
                               return new PasswordAuthentication("contato@cntconstrutora.com.br", "cnt2016#");
                         }
                    });

        /** Ativa Debug para sessão */
        session.setDebug(true);
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("contato@cntconstrutora.com.br")); //Remetente
            Address[] toUser = InternetAddress //Destinatário(s)
                         .parse(listaemail.get(i).getVoluntarios().get(i).getEmail()); 
              
              message.setRecipients(Message.RecipientType.TO, toUser);
              message.setSubject("Voluntariando - Novo evento para voluntariar");//Assunto
              message.setText("Olá, "+listaemail.get(i).getVoluntarios().get(i).getNome()+" :-), é um prazer ter você como um voluntario. \n"+
                "A instituição "+inst.getNome()+" acaba de criar um novo evento de caridade, no qual o seu perfil se encaixa perfeitamente"+
                "nos requisitos para que o evento seja um secesso. Sei que sua vida é muito corrida, mas gostariamos muito de contar com sua ajuda. \n"+
                "Vocé é muito importante para nós :-). \n"+
                "\n"+
                "Para saber mais detalhes do evento Acesse www.voluntariando.com.br \n"+
                "\n"+
                "\n"+
                "A solidariedade é o sentimento que melhor expressa o respeito pela dignidade humana.\n" +
                "Franz Kafka ");
              /**Método para enviar a mensagem criada*/
              Transport.send(message);

              System.out.println("Feito!!!");


         } catch (MessagingException e) {
              throw new RuntimeException(e);
        }
        }
  }

      public void NotificaCadastroVoluntario(Voluntario vol) {
            Properties props = new Properties();
            /** Parâmetros de conexão com servidor Gmail */
            props.put("mail.smtp.host", "smtp.cntconstrutora.com.br");
            props.put("mail.smtp.socketFactory.port", "587");
            //props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "587");

            Session session = Session.getDefaultInstance(props,
                        new javax.mail.Authenticator() {
                             protected PasswordAuthentication getPasswordAuthentication()
                             {
                                   return new PasswordAuthentication("contato@cntconstrutora.com.br", "cnt2016#");
                             }
                        });

            /** Ativa Debug para sessão */
            session.setDebug(true);
             

            try {

                  Message message = new MimeMessage(session);
                  message.setFrom(new InternetAddress("contato@cntconstrutora.com.br")); //Remetente

                  Address[] toUser = InternetAddress //Destinatário(s)
                             .parse(vol.getEmail()); 
                  

                  message.setRecipients(Message.RecipientType.TO, toUser);
                  message.setSubject("Voluntariando - Notificação de Cadastro");//Assunto
                  message.setText("Olá, "+vol.getNome()+" :-), Uauuu você agora é um um voluntario. \n"+
                    "Estamos muitos felizes com seu cadastro! \n"+
                    "Bem vindo ao Voluntariando");
                  /**Método para enviar a mensagem criada*/
                  Transport.send(message);

                  System.out.println("Feito!!!");
                 

             } catch (MessagingException e) {
                  throw new RuntimeException(e);
            }
            }
      
      public void NotificaCadastroInstituicao(Instituicao inst) {
            Properties props = new Properties();
            /** Parâmetros de conexão com servidor Gmail */
            props.put("mail.smtp.host", "smtp.cntconstrutora.com.br");
            props.put("mail.smtp.socketFactory.port", "587");
            //props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "587");

            Session session = Session.getDefaultInstance(props,
                        new javax.mail.Authenticator() {
                             protected PasswordAuthentication getPasswordAuthentication()
                             {
                                   return new PasswordAuthentication("contato@cntconstrutora.com.br", "cnt2016#");
                             }
                        });

            /** Ativa Debug para sessão */
            session.setDebug(true);
             

            try {

                  Message message = new MimeMessage(session);
                  message.setFrom(new InternetAddress("contato@cntconstrutora.com.br")); //Remetente

                  Address[] toUser = InternetAddress //Destinatário(s)
                             .parse(inst.getEmail()); 
                  

                  message.setRecipients(Message.RecipientType.TO, toUser);
                  message.setSubject("Voluntariando - Notificação de Cadastro");//Assunto
                  message.setText("Olá, "+inst.getNome()+" :-), Uauuu a você agora faz é uma instituição parceira do Voluntariando. \n"+
                    "Estamos muitos felizes com seu cadastro! \n"+
                    "Bem vinda ao Voluntariando");
                  /**Método para enviar a mensagem criada*/
                  Transport.send(message);

                  System.out.println("Feito!!!");
                 

             } catch (MessagingException e) {
                  throw new RuntimeException(e);
            }
            }
      
      public void NotificaCadastroAdministrador(Administrador admin) {
            Properties props = new Properties();
            /** Parâmetros de conexão com servidor Gmail */
            props.put("mail.smtp.host", "smtp.cntconstrutora.com.br");
            props.put("mail.smtp.socketFactory.port", "587");
            //props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "587");

            Session session = Session.getDefaultInstance(props,
                        new javax.mail.Authenticator() {
                             protected PasswordAuthentication getPasswordAuthentication()
                             {
                                   return new PasswordAuthentication("contato@cntconstrutora.com.br", "cnt2016#");
                             }
                        });

            /** Ativa Debug para sessão */
            session.setDebug(true);
             

            try {

                  Message message = new MimeMessage(session);
                  message.setFrom(new InternetAddress("contato@cntconstrutora.com.br")); //Remetente

                  Address[] toUser = InternetAddress //Destinatário(s)
                             .parse(admin.getEmail()); 
                  

                  message.setRecipients(Message.RecipientType.TO, toUser);
                  message.setSubject("Voluntariando - Notificação de Cadastro");//Assunto
                  message.setText("Olá, "+admin.getNome()+" :-), Uauuu a você agora faz é um Administrador parceiro do Voluntariando. \n"+
                    "Estamos muitos felizes com seu cadastro! \n"+
                    "Bem vindo ao Voluntariando");
                  /**Método para enviar a mensagem criada*/
                  Transport.send(message);

                  System.out.println("Feito!!!");
                 

             } catch (MessagingException e) {
                  throw new RuntimeException(e);
            }
            }
      
}