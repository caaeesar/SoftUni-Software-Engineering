package bg.softuni.cardealer.model.dto.exportDtos;

import com.google.gson.annotations.SerializedName;


public class SupplierNotImporterDto {

    @SerializedName("Id")
    private long id;

    @SerializedName("Name")
    private String name;

    private int partsCount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPartsCount() {
        return partsCount;
    }

    public void setPartsCount(int partsCount) {
        this.partsCount = partsCount;
    }
}
