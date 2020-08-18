package com.footballclub.finder.integration.entity;

public class PageInfo {

    private static final String FOOTBALL_CLUB = "football club";
    private static final String FC = "fc";
    private static final String FC_WITH_DOTS = "f.c.";
    private static final String CF = "cf";
    private static final String CF_WITH_DOTS = "c.f.";

    private Integer ns;
    private String title;
    private Long pageid;
    private Integer size;
    private Long wordcount;
    private String snippet;
    private String timestamp;

    public Integer getNs() {
        return ns;
    }

    public void setNs(Integer ns) {
        this.ns = ns;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getPageid() {
        return pageid;
    }

    public void setPageid(Long pageid) {
        this.pageid = pageid;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Long getWordcount() {
        return wordcount;
    }

    public void setWordcount(Long wordcount) {
        this.wordcount = wordcount;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Boolean doesPageDescribeFootballClub() {
        return snippet.toLowerCase().contains(FOOTBALL_CLUB) ||
                containsFootballClubShortcut(snippet) ||
                containsFootballClubShortcut(title);
    }

    public String underscoreTitle() {
        return this.title.replaceAll(" ", "_");
    }

    private Boolean containsFootballClubShortcut(String fieldToCheck) {
        return fieldToCheck.toLowerCase().contains(FC) ||
                fieldToCheck.toLowerCase().contains(FC_WITH_DOTS) ||
                fieldToCheck.toLowerCase().contains(CF) ||
                fieldToCheck.toLowerCase().contains(CF_WITH_DOTS);
    }
}
