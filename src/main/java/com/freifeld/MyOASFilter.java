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

    private final IndexView view;
    private final Map<AnnotationInstance, Long> annotationsIndex;

    public MyOASFilter(IndexView view) {
        this.view = view;
        this.annotationsIndex = this.view.getAnnotations(MyOASAnnotation.class)
                .stream()
//                .distinct() // TODO not sure why there are 2 classes for each type
                .filter(ann -> ann.target().kind() == AnnotationTarget.Kind.METHOD)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(this.annotationsIndex);
    }
}
