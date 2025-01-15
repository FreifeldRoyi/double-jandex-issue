package com.freifeld;

import io.smallrye.common.annotation.RunOnVirtualThread;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@RunOnVirtualThread
@Path("simple")
public class SimpleResource {
    @GET
    @MyOASAnnotation("Tester")
    public String helloWorld() {
        return "Hello, World!";
    }
}
