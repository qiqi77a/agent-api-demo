package mcquick.agentApiDemo.config;

import mcquick.agentApiDemo.util.AgentApiClient;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(AgentApiClientConfig.class)
public class Config {
    @Bean
    public AgentApiClient agentApiClient(AgentApiClientConfig apiClientConfig) {
        return new AgentApiClient(apiClientConfig.getAgentId(), apiClientConfig.getHost(), apiClientConfig.getKey());
    }
}
