package ObjectsAndClasses.moreExercise.teamworkProjects;

import java.util.List;

public class Team {
    private String creator;
    private String teamName;
    private List<String> memberList; // null

    Team(String creator, String teamName) {
        this.creator = creator;
        this.teamName = teamName;
    }

    public String getCreator() {
        return this.creator;
    }

    public String getTeamName() {
        return this.teamName;
    }

    public List<String> getMembersList() {
        return this.memberList;
    }

    public int getMembersCount() {
        return this.memberList.size();
    }


    public void setMemberList(List<String> memberList){
        this.memberList = memberList;
    }

    @Override
    public String toString() {
        return String.format("%s\n- %s",this.teamName,this.creator);
    }
}
