package org.none.searchapi;

import java.util.Objects;

/**
 * @author ArtSCactus
 * @version 1.0
 */
public class SearchResultItem {
private String title;
private String link;
private String keywords;
private String text;

    public SearchResultItem() {
    }

    public SearchResultItem(String title, String link, String keywords, String text) {
        this.title = title;
        this.link = link;
        this.keywords = keywords;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SearchResultItem)) return false;
        SearchResultItem that = (SearchResultItem) o;
        return Objects.equals(getTitle(), that.getTitle()) &&
                Objects.equals(getLink(), that.getLink()) &&
                Objects.equals(getKeywords(), that.getKeywords()) &&
                Objects.equals(getText(), that.getText());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getLink(), getKeywords(), getText());
    }

    @Override
    public String toString() {
        return "SearchResultItem{" +
                "title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", keyword='" + keywords + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
