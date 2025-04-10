package com.uzunalov.annotationprocessor;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.*;
import javax.lang.model.util.ElementFilter;
import java.util.Set;
import javax.tools.Diagnostic;

@SupportedAnnotationTypes("com.uzunalov.annotationprocessor.AllFieldsInt")
@SupportedSourceVersion(SourceVersion.RELEASE_21)
public class AllFieldsIntProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (Element element : roundEnv.getElementsAnnotatedWith(
                AllFieldsInt.class)) {
            if (element.getKind() != ElementKind.CLASS) {
                processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR,
                        "@AllFieldsInt can only be used on classes", element);
                continue;
            }

            TypeElement typeElement = (TypeElement) element;

            for (VariableElement field : ElementFilter.fieldsIn(typeElement.getEnclosedElements())) {
                if (!field.asType().toString().equals("int")) {
                    processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR,
                            "Field '" + field.getSimpleName() + "' is not of type int", field);
                }
            }
        }

        return true;
    }
}