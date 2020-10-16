package org.none.searchapi;

import java.util.Objects;

/**
 * @author ArtSCactus
 * @version 1.0
 */
public class SearchResultItem {
private String title;
private String link;
private String keyword;
private String text;

    public SearchResultItem() {
    }

    public SearchResultItem(String title, String link, String keyword, String text) {
        this.title = title;
        this.link = link;
        this.keyword = keyword;
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

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
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
                Objects.equals(getKeyword(), that.getKeyword()) &&
                Objects.equals(getText(), that.getText());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getLink(), getKeyword(), getText());
    }

    @Override
    public String toString() {
        return "SearchResultItem{" +
                "title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", keyword='" + keyword + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
