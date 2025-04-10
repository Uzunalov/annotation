package com.uzunalov.sampleservice;

import com.uzunalov.annotationprocessor.AllFieldsInt;
import com.uzunalov.annotationprocessor.CamelCaseCheck;

@AllFieldsInt
@CamelCaseCheck
public class MySampleClass {

    private int validName;

    private int InvalidName; //change name to valid camel case

    private String invalidType; //change type to int
}
