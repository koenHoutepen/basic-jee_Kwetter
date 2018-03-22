package controller.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import exceptions.IdOrNameEmptyException;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;



@XmlRootElement
@Entity(name = "Profile")
@Table(name = "profile")
@XmlAccessorType(XmlAccessType.FIELD)
public class Profile implements Serializable{

    @Id
    @GeneratedValue
    private String username;
    private String bio;
    private String location;
    private String web;

//    @OneToMany(mappedBy = "owner" , fetch = FetchType.LAZY)
    @OneToMany(cascade = CascadeType.PERSIST)
    @XmlTransient
    @JsonIgnore
    private List<Kweet> kweets = new ArrayList<>();

    @ManyToMany
    // @ManyToMany(cascade = CascadeType.PERSIST , fetch = FetchType.LAZY)
    //@JoinColumn(name = "follower_username")
    private List<Profile> followers = new ArrayList<>();

    @ManyToMany
    //@ManyToMany(mappedBy = "followers",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //@XmlTransient
    //@JsonIgnore
    private List<Profile> following = new ArrayList<>();

    private String profilePicturePath;

    public Profile(String username, String bio, String location, String web, List<Kweet> kweets, List<Profile> followers, List<Profile> following, String profilePicturePath) throws IdOrNameEmptyException {
        if (username.isEmpty())
        {
            throw new IdOrNameEmptyException("username was empty or already taken");
        }
        if (bio.length() > 160) {
            throw new InvalidParameterException("Bio is too long");
        }
        if (bio.isEmpty()) {
            bio = "User has no bio";
        }

        this.username = username;
        this.bio = bio;
        this.location = location;
        this.web = web;
        this.kweets = kweets;
        this.followers = followers;
        this.following = following;
        this.profilePicturePath = profilePicturePath;
    }

    public Profile()
    {

    }

    public Profile(String username) throws IdOrNameEmptyException {
        if (username.isEmpty())
        {
            throw new IdOrNameEmptyException("username was empty");
        }
        this.username = username;

    }

    public void addKweet(Kweet kweet)
    {
        this.kweets.add(kweet);
    }

    @XmlTransient
    @JsonIgnore
    public List<Kweet> getKweets() {
        return kweets;
    }

    public void setKweets(List<Kweet> kweets) {
        this.kweets = kweets;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    @XmlTransient
    @JsonIgnore
    public List<Profile> getFollowers() {
        return followers;
    }

    public void setFollowers(List<Profile> followers) {
        this.followers = followers;
    }

    public void addFollower(Profile follower){this.followers.add(follower);}

    @XmlTransient
    @JsonIgnore
    public List<Profile> getFollowing() {
        return following;
    }

    public void setFollowing(List<Profile> following) {
        this.following = following;
    }

    public void addFollowing(Profile followingProfile){this.following.add(followingProfile);}

    public String getProfilePicturePath() {
        return profilePicturePath;
    }

    public void setProfilePicturePath(String profilePicturePath) {
        this.profilePicturePath = profilePicturePath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return Objects.equals(username, profile.username) &&
                Objects.equals(bio, profile.bio) &&
                Objects.equals(location, profile.location) &&
                Objects.equals(web, profile.web) &&
                Objects.equals(kweets, profile.kweets) &&
                //Objects.equals(followers, profile.followers) &&
                //Objects.equals(following, profile.following) &&
                Objects.equals(profilePicturePath, profile.profilePicturePath);
    }

    @Override
    public int hashCode() {

        return Objects.hash(username, bio, location, web, kweets, profilePicturePath);
    }
}
