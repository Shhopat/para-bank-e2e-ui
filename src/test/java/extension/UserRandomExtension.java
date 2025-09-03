package extension;

import annotation.UserRandom;
import model.UserRegistration;
import org.junit.jupiter.api.ClassOrderer;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

import java.lang.reflect.Parameter;
import java.util.Random;
import java.util.UUID;

public class UserRandomExtension implements ParameterResolver {
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.isAnnotated(UserRandom.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return getUserRandom(parameterContext.getParameter());
    }


    private static UserRegistration getUserRandom(Parameter parameter) {
        Class<?> type = parameter.getType();
        String uuid = UUID.randomUUID().toString();
        Random random = new Random();

        if (type.equals(UserRegistration.class)) {
            return UserRegistration.builder()
                    .username("sd" + random.nextInt(1000)).build();

        }
        throw new ParameterResolutionException("No  random user is generated for:" + type);
    }


}
