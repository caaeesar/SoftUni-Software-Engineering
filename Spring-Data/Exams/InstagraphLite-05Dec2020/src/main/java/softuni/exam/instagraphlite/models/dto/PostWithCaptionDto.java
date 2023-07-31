package softuni.exam.instagraphlite.models.dto;


public class PostWithCaptionDto {

    private String caption;
    private PictureWithSizeDto picture;

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public PictureWithSizeDto getPicture() {
        return picture;
    }

    public void setPicture(PictureWithSizeDto picture) {
        this.picture = picture;
    }
}
