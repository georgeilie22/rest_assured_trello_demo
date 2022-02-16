package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Board {

    private String id;
    private String name;
    private String url;
    private String description;
    private String descriptionData;
    private String closed;
    private String idOrganization;
    private String idEnterprise;
    private String pinned;
    private String shortUrl;
    @JsonIgnore
    private String prefs;
    @JsonIgnore
    private String lableNames;
    @JsonIgnore
    private String limits;


    public Board() {

    }

    public Board(String id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("desc")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionData() {
        return descriptionData;
    }

    @JsonProperty("descData")
    public void setDescriptionData(String descriptionData) {
        this.descriptionData = descriptionData;
    }

    public String getClosed() {
        return closed;
    }

    @JsonProperty("closed")
    public void setClosed(String closed) {
        this.closed = closed;
    }

    public String getIdOrganisation() {
        return idOrganization;
    }

    @JsonProperty("idOrganization")
    public void setIdOrganization(String idOrganisation) {
        this.idOrganization = idOrganisation;
    }

    public String getIdEnterprise() {
        return idEnterprise;
    }

    @JsonProperty("idEnterprise")
    public void setIdEnterprise(String idEnterprise) {
        this.idEnterprise = idEnterprise;
    }

    public String getPinned() {
        return pinned;
    }

    @JsonProperty("pinned")
    public void setPinned(String pinned) {
        this.pinned = pinned;
    }

    @JsonProperty("shortUrl")
    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    @Override
    public String toString() {
        return "Board{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", description='" + description + '\'' +
                ", descriptionData='" + descriptionData + '\'' +
                ", closed='" + closed + '\'' +
                ", idOrganisation='" + idOrganization + '\'' +
                ", idEnterprise='" + idEnterprise + '\'' +
                ", pinned='" + pinned + '\'' +
                ", shortUrl='" + shortUrl + '\'' +
                ", prefs=" + prefs +
                ", lableNames=" + lableNames +
                ", limits=" + limits +
                '}';
    }
}
