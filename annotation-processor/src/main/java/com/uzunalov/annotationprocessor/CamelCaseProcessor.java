package com.uzunalov.annotationprocessor;


import java.util.Set;
import java.util.regex.Pattern;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;

@SupportedSourceVersion(SourceVersion.RELEASE_17)
@SupportedAnnotationTypes("com.uzunalov.annotationprocessor.CamelCaseCheck")
public class CamelCaseProcessor extends AbstractProcessor {

    private static final Pattern CAMEL_CASE_PATTERN = Pattern.compile("^[a-z]+[a-zA-Z0-9]*$");

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (Element element : roundEnv.getElementsAnnotatedWith(CamelCaseCheck.class)) {
            if (element.getKind() != ElementKind.CLASS) continue;

            for (Element enclosed : element.getEnclosedElements()) {
                if (enclosed.getKind() == ElementKind.FIELD) {
                    String varName = enclosed.getSimpleName().toString();
                    if (!CAMEL_CASE_PATTERN.matcher(varName).matches()) {
                        processingEnv.getMessager().printMessage(
                                Diagnostic.Kind.ERROR,
                                "Field '" + varName + "' is not camelCase!",
                                enclosed
                        );
                    }
                }
            }
        }
        return true;
    }
}
