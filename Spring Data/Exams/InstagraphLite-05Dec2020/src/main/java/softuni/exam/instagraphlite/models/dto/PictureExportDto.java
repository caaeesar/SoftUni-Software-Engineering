package softuni.exam.instagraphlite.models.dto;

public class PictureExportDto {

    private Double size;

    private String path;

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }


    @Override
    public String toString() {
        return String.format("%.2f - %s", getSize(), getPath());
    }
}
