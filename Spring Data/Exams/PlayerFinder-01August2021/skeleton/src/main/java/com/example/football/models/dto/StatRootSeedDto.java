package com.example.football.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "stats")
public class StatRootSeedDto {

    @XmlElement(name = "stat")
    private List<StatSeedDto> stats;

    public List<StatSeedDto> getStats() {
        return stats;
    }

    public void setStats(List<StatSeedDto> stats) {
        this.stats = stats;
    }
}
