package com.dauut.eksidebeAPI.model;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Entry implements Serializable {
    private int entryId;
    @NotNull
    private String url;
    private LocalDate date;
    @NotNull
    private String header;

    public Entry(){

    }

    public Entry(int entryId, @NotNull String url, @NotNull String header, LocalDate date) {
        this.entryId = entryId;
        this.date = date;
        this.url = url;
        this.header = header;
    }

    public int getEntryId() {
        return entryId;
    }

    public void setEntryId(int entryId) {
        this.entryId = entryId;
    }

    public @NotNull String getUrl() {
        return url;
    }

    public void setUrl(@NotNull String url) {
        this.url = url;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(@NotNull LocalDate date) {
        this.date = date;
    }

    public @NotNull String getHeader() {
        return header;
    }

    public void setHeader(@NotNull String header) {
        this.header = header;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry = (Entry) o;
        return entryId == entry.entryId && url.equals(entry.url) && Objects.equals(date, entry.date) && header.equals(entry.header);
    }

    @Override
    public int hashCode() {
        return Objects.hash(entryId, url, date, header);
    }
}
