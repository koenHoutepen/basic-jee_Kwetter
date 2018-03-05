package domain;

public class Mention {
    private Profile profile;
    private Kweet containingKweet;

    public Mention(Profile profile, Kweet containingKweet) {
        this.profile = profile;
        this.containingKweet = containingKweet;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Kweet getContainingKweet() {
        return containingKweet;
    }

    public void setContainingKweet(Kweet containingKweet) {
        this.containingKweet = containingKweet;
    }
}
