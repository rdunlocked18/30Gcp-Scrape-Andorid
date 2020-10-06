package com.daftarirn.cloud.Models;

public class QwikModel {

    String name;
    String rank;
    String qwiklabs_id;
    String id;
    int quests_status;
    String dpUrl;
    String questsNames;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getQwiklabs_id() {
        return qwiklabs_id;
    }

    public void setQwiklabs_id(String qwiklabs_id) {
        this.qwiklabs_id = qwiklabs_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getQuests_status() {
        return quests_status;
    }

    public void setQuests_status(int quests_status) {
        this.quests_status = quests_status;
    }

    public String getDpUrl() {
        return dpUrl;
    }

    public void setDpUrl(String dpUrl) {
        this.dpUrl = dpUrl;
    }

    public String getQuestsNames() {
        return questsNames;
    }

    public void setQuestsNames(String questsNames) {
        this.questsNames = questsNames;
    }
}
