package extension;

import annotation.Retry;
import net.bytebuddy.implementation.bytecode.Throw;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.InvocationInterceptor;
import org.junit.jupiter.api.extension.ReflectiveInvocationContext;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Objects;

public class RetryExtension implements InvocationInterceptor {
    @Override
    public void interceptTestMethod(Invocation<Void> invocation, ReflectiveInvocationContext<Method> invocationContext, ExtensionContext extensionContext) throws Throwable {
        boolean isRetry = extensionContext.getRequiredTestMethod().isAnnotationPresent(Retry.class);
        if (isRetry) {
            Retry retry = extensionContext.getRequiredTestMethod().getAnnotation(Retry.class);
            int count = retry.value();
            Exception exception = null;
            for (int i = 1; i < count + 1; i++) {
                try {
                    System.out.println("Attempt: " + i);
                    invocation.proceed();
                    return;
                } catch (Exception e) {
                    exception = e;
                    System.out.println("Attempt " + i + "/" + count + " Exception message: " + e.getMessage());

                }
            }
            throw Objects.requireNonNull(exception);
        }
    }
}
