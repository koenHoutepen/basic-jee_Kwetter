package domain;

import java.util.List;

public class Profile {
    private String username;
    private String bio;
    private String location;
    private String web;
    private List<String> followers;
    private List<String> following;
    private String profilePicturePath;
    private Role role;

    public Profile(String username, String bio, String location, String web, List<String> followers, List<String> following, String profilePicturePath, Role role) {
        this.username = username;
        this.bio = bio;
        this.location = location;
        this.web = web;
        this.followers = followers;
        this.following = following;
        this.profilePicturePath = profilePicturePath;
        this.role = role;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
