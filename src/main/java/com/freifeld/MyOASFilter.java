package com.freifeld;

import io.quarkus.smallrye.openapi.OpenApiFilter;
import org.eclipse.microprofile.openapi.OASFilter;
import org.jboss.jandex.AnnotationInstance;
import org.jboss.jandex.AnnotationTarget;
import org.jboss.jandex.IndexView;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@OpenApiFilter(OpenApiFilter.RunStage.BUILD)
public class MyOASFilter implements OASFilter {
    public MyOASFilter(IndexView view) {
        var annotationsIndex = view.getAnnotations(MyOASAnnotation.class)
                .stream()
                .filter(ann -> ann.target().kind() == AnnotationTarget.Kind.METHOD)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println("########");
        System.out.println(annotationsIndex);
        System.out.println("########");
    }
}
