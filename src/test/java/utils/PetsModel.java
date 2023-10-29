package utils;

// Welcome8.java

public class PetsModel {
    private long id;
    private Category category;
    private String name;
    private String[] photoUrls;
    private Category[] tags;
    private String status;

    public long getID() { return id; }
    public void setID(long value) { this.id = value; }

    public Category getCategory() { return category; }
    public void setCategory(Category value) { this.category = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public String[] getPhotoUrls() { return photoUrls; }
    public void setPhotoUrls(String[] value) { this.photoUrls = value; }

    public Category[] getTags() { return tags; }
    public void setTags(Category[] value) { this.tags = value; }

    public String getStatus() { return status; }
    public void setStatus(String value) { this.status = value; }
}

 class Category {
    private long id;
    private String name;

    public long getID() { return id; }
    public void setID(long value) { this.id = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }
}
