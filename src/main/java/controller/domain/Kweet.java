package controller.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity(name = "Kweet")
@Table(name = "kweet")
@NamedQueries({@NamedQuery(name = "kweet.getKweets", query = "SELECT K FROM Kweet K"), @NamedQuery(name = "kweet.getKweetsFromUser", query = "SELECT k FROM Kweet k where k.owner = :owner")})
public class Kweet implements Serializable{

    @Id
    @GeneratedValue()
    private Long kweetId;

    @ManyToOne(cascade = CascadeType.PERSIST , fetch = FetchType.LAZY)
    @XmlTransient
    private Profile owner;

    private String message;

    private Date postDate;

    public Kweet(long kweetId,Profile owner, String message, Date postDate, List<String> likes, List<String> mentions, List<String> trends) {
        if (owner == null) {
            throw new InvalidParameterException("username has to be entered");
        }
        if (message.isEmpty() || message.length() > 140) {
            throw new InvalidParameterException("message is invalid");
        }
        if(mentions == null || trends == null || likes == null){
            throw new InvalidParameterException("Kweet creation failed");
        }
        this.kweetId = kweetId;
        this.owner = owner;
        this.message = message;
        this.postDate = postDate;
    }

    public Kweet()
    {

    }

    public Kweet(long kweetId, Profile owner, String message, Date date) {
        if (owner == null) {
            throw new InvalidParameterException("username has to be entered");
        }
        if (message.isEmpty() || message.length() > 140) {
            throw new InvalidParameterException("message is invalid");
        }

        this.kweetId = kweetId;
        this.owner = owner;
        this.message = message;
        this.postDate = date;
    }

    @XmlTransient
    public Profile getOwner() {
        return owner;
    }

    public void setOwner(Profile owner) {
        this.owner = owner;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public Long getKweetId() {
        return kweetId;
    }

    public void setKweetId(Long kweetId) {
        this.kweetId = kweetId;
    }
}
