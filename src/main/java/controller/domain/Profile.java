package controller.domain;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Objects;

public class Profile {
    private String username;
    private String bio;
    private String location;
    private String web;
    private List<Kweet> kweets;
    private List<String> followers;
    private List<String> following;
    private String profilePicturePath;
    private KwetterManager kwetterManager = new KwetterManager();

    public Profile(String username, String bio, String location, String web, List<Kweet> kweets, List<String> followers, List<String> following, String profilePicturePath) {
        if (username.isEmpty() || kwetterManager.UsernameTaken(username))
        {
            throw new InvalidParameterException("username was empty or already taken");
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

    public void addKweet(Kweet kweet)
    {
        this.kweets.add(kweet);
    }

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

    public List<String> getFollowers() {
        return followers;
    }

    public void setFollowers(List<String> followers) {
        this.followers = followers;
    }

    public List<String> getFollowing() {
        return following;
    }

    public void setFollowing(List<String> following) {
        this.following = following;
    }

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
                Objects.equals(followers, profile.followers) &&
                Objects.equals(following, profile.following) &&
                Objects.equals(profilePicturePath, profile.profilePicturePath) &&
                Objects.equals(kwetterManager, profile.kwetterManager);
    }

    @Override
    public int hashCode() {

        return Objects.hash(username, bio, location, web, kweets, followers, following, profilePicturePath, kwetterManager);
    }
}
