package domain;

public class Role {
    private boolean canDelete;
    private boolean canPost;
    private boolean canBlacklist;
    private boolean canLike;

    public Role(boolean canDelete, boolean canPost, boolean canBlacklist, boolean canLike) {
        this.canDelete = canDelete;
        this.canPost = canPost;
        this.canBlacklist = canBlacklist;
        this.canLike = canLike;
    }

    public boolean isCanDelete() {
        return canDelete;
    }

    public boolean isCanPost() {
        return canPost;
    }

    public boolean isCanBlacklist() {
        return canBlacklist;
    }

    public boolean isCanLike() {
        return canLike;
    }
}
