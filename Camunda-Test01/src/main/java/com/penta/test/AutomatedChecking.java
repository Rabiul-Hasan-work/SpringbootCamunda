package com.penta.test;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import javax.inject.Named;

@Named
public class AutomatedChecking implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        String firstName = (String) delegateExecution.getVariable("fname");

        String lastName = (String) delegateExecution.getVariable("lname");

        String phone = (String) delegateExecution.getVariable("phn");

        String option = "No";
        if(phone.length()>9){
            option = "Yes";
        } else if(firstName == null) {
            throw new BpmnError("Field Empty","Fill the field");
        } else if(lastName == null) {
            throw new BpmnError("Field Empty","Fill the field");
        } else if(phone == null) {
            throw new BpmnError("Field Empty", "Fill the field");
        }
        else{
            option = "No";
        }

        delegateExecution.setVariable("option", option);
    }
}