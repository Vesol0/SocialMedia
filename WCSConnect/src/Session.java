import java.util.Date;

public class Session {
    private String sessionId;
    private Date loginTime;
    private Date lastActivityTime;
    private boolean isActive;

    public Session(String sessionId) {
        this.sessionId = sessionId;
        this.loginTime = new Date();
        this.lastActivityTime = this.loginTime;
        this.isActive = true;
    }

    public void updateLastActivityTime() {
        lastActivityTime = new Date();
    }

    public void expireSession() {
        isActive = false;
    }

    public boolean isActive() {
        return isActive;
    }

    public String getSessionId() {
        return sessionId;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public Date getLastActivityTime() {
        return lastActivityTime;
    }
}
