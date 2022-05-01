package com.edge.socketExample;

import java.io.Serializable;
import java.util.Date;

/**
 * Wrapper class for a message sent to and from servers
 *
 * @author tsun
 *
 */
public class Message implements Serializable {
  private static final long serialVersionUID = 6342932337190682969L;
  private String content;
  private Date timestamp;
  private String sender;

  /**
   * Constructor to create a message
   *
   * @param message
   *            Body of the message
   * @param messageSender
   *            Sender of the message
   */
  public Message(String message, String messageSender) {
    this.content = message;
    this.sender = messageSender;
    this.timestamp = new Date();
  }

  public Message(String message) {
    this.content = message;
    this.timestamp = new Date();
  }

  /**
   * Constructor to create a message with a specified timestamp
   *
   * @param message
   *            Body of the message
   * @param messageSender
   *            Sender of the message
   * @param messageTimestamp
   *            Timestamp of the message
   */
  public Message(String message, String messageSender, Date messageTimestamp) {
    this.content = message;
    this.sender = messageSender;
    this.timestamp = new Date(messageTimestamp.getTime());
  }

  /**
   * @return the content
   */
  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  /**
   * @return the timestamp
   */
  public Date getTimestamp() {
    return new Date(timestamp.getTime());
  }

  /**
   * @return the sender
   */
  public String getSender() {
    return sender;
  }

  @Override
  public String toString() {
    return String.format("[%s] %s: %s", timestamp, sender, content);
  }
}
