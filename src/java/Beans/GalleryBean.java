package Beans;

public class GalleryBean 
{
 private int imgid;
 private String name,title,description;
 boolean imgstatus;

    public int getImgid() {
        return imgid;
    }

    public void setImgid(int imgid) {
        this.imgid = imgid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isImgstatus() {
        return imgstatus;
    }

    public void setImgstatus(boolean imgstatus) {
        this.imgstatus = imgstatus;
    }
 
}
