package com.company.configserver.configserver;

import org.springframework.cloud.config.environment.Environment;
import org.springframework.cloud.config.environment.PropertySource;
import org.springframework.cloud.config.server.environment.CompositeEnvironmentRepository;
import org.springframework.cloud.config.server.environment.EnvironmentRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Primary
public class CustomCompositeEnvironmentRepository extends CompositeEnvironmentRepository {

    public CustomCompositeEnvironmentRepository(List<EnvironmentRepository> environmentRepositories) {
        super(environmentRepositories, true);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Environment findOne(String application, String profile, String label, boolean includeOrigin) {
        Environment environment = super.findOne(application, profile, label, includeOrigin);
    
        Map<String, Object> mergedProperties = new HashMap<>();
    
        for (PropertySource propertySource : environment.getPropertySources()) {
            Map<String, Object> sourceProperties = (Map<String, Object>) propertySource.getSource();
    
            for (Map.Entry<String, Object> entry : sourceProperties.entrySet()) {
                
                String key = entry.getKey();
                Object value = entry.getValue();
    
                if (!mergedProperties.containsKey(key)) {
                    mergedProperties.put(key, value);
                }
            }
        }
        
        Environment customEnvironment = new Environment(application, profile);
        customEnvironment.add(new PropertySource("custom:vault-github", mergedProperties));
        customEnvironment.setLabel(null);
        customEnvironment.setVersion(null);
        customEnvironment.setState(null);

        return customEnvironment;
    }
}