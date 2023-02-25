package priv.samera2022.functions.as_system;

public class AS_System {
    private String Nick;
    private long ID;
    private long[] Groups;
    private boolean allGroupsDeny;
    public AS_System(){}
    public void setNick(String nick) {
        Nick = nick;
    }
    public void setID(long ID) {
        this.ID = ID;
    }
    public void setGroups(long[] groups) {
        Groups = groups;
    }
    public void setAllGroupsDeny(boolean allGroupsDeny) {
        this.allGroupsDeny = allGroupsDeny;
    }
    public String getNick() {
        return Nick;
    }
    public long getID() {
        return ID;
    }
    public long[] getGroups() {
        return Groups;
    }
    public boolean isAllGroupsDeny() {
        return allGroupsDeny;
    }
}
