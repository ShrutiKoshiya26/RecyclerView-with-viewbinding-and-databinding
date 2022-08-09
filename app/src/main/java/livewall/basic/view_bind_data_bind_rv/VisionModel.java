package livewall.basic.view_bind_data_bind_rv;

import java.io.Serializable;


public class VisionModel implements Serializable {

    private int id;

    private boolean isSelected = false;

    private String title;
    private String description;

    public VisionModel() {
    }


    public VisionModel(String vision_title, String description) {
        this.title = vision_title;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String vision_title) {
        this.title = vision_title;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }


}
