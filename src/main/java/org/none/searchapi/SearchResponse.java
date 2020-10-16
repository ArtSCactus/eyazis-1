package org.none.searchapi;

import org.springframework.lang.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author ArtSCactus
 * @version 1.0
 */
public class SearchResponse {
    @Nullable
    private Integer amountOfResults;
    @Nullable
    private List<SearchResultItem> items;
    @Nullable
    private String text;

    public SearchResponse(List<SearchResultItem> items, Integer amountOfResults) {
        this.items = items;
        this.amountOfResults = amountOfResults;
    }

    public SearchResponse(String text) {
        this.text = text;
    }

    public SearchResponse() {
        items = new ArrayList<>();
    }


    public SearchResultItem getItem(int id) {
        return items.get(id);
    }

    public void addLink(SearchResultItem item) {
        items.add(item);
    }

    public List<SearchResultItem> getItems() {
        return items;
    }

    public void setItems(List<SearchResultItem> items) {
        this.items = items;
    }

    public Integer getAmountOfResults() {
        return amountOfResults;
    }

    public void setAmountOfResults(Integer amountOfResults) {
        this.amountOfResults = amountOfResults;
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
        if (!(o instanceof SearchResponse)) return false;
        SearchResponse that = (SearchResponse) o;
        return Objects.equals(getAmountOfResults(), that.getAmountOfResults()) &&
                Objects.equals(getItems(), that.getItems()) &&
                Objects.equals(getText(), that.getText());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAmountOfResults(), getItems(), getText());
    }

    @Override
    public String toString() {
        return "SearchResponse{" +
                "amountOfResults=" + amountOfResults +
                ", items=" + items +
                ", text='" + text + '\'' +
                '}';
    }
}
