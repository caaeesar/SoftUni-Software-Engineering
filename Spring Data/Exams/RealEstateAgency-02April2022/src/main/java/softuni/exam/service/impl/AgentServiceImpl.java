package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.AgentSeedDto;
import softuni.exam.models.entity.Agent;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.AgentRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.AgentService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AgentServiceImpl implements AgentService {

    private static final String AGENT_FILE_PATH = "src/main/resources/files/json/agents.json";
    private static final String SUCCESSFUL_MESSAGE = "Successfully imported agent - %s %s";
    private static final String INVALID_MESSAGE = "Invalid agent";
    private final AgentRepository agentRepository;
    private final TownRepository townRepository;
    private final ModelMapper mapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    @Autowired
    public AgentServiceImpl(AgentRepository agentRepository, TownRepository townRepository, ModelMapper mapper, Gson gson, ValidationUtil validationUtil) {
        this.agentRepository = agentRepository;
        this.townRepository = townRepository;
        this.mapper = mapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return agentRepository.count() > 0;
    }

    @Override
    public String readAgentsFromFile() throws IOException {
        return Files.readString(Path.of(AGENT_FILE_PATH));
    }

    @Override
    public String importAgents() throws IOException {
        StringBuilder message = new StringBuilder();

        List<AgentSeedDto> agentSeedDtos = Arrays.stream(gson.fromJson(readAgentsFromFile(), AgentSeedDto[].class)).collect(Collectors.toList());

        for (AgentSeedDto agentSeedDto : agentSeedDtos) {

            if (!isExistAgentWithName(agentSeedDto.getFirstName()) && validationUtil.isValid(agentSeedDto)) {
                Agent agent = mapper.map(agentSeedDto, Agent.class);
                Town town = townRepository.findTownByTownName(agentSeedDto.getTown()).get();
                agent.setTown(town);
                agentRepository.save(agent);
                message.append(String.format(SUCCESSFUL_MESSAGE, agent.getFirstName(), agent.getLastName()));
                message.append(System.lineSeparator());
            } else {
                message.append(INVALID_MESSAGE);
                message.append(System.lineSeparator());
            }
        }
        return message.toString().trim();
    }

    private boolean isExistAgentWithName(String firstName) {
        return agentRepository.findAgentByFirstName(firstName).isPresent();
    }
}
