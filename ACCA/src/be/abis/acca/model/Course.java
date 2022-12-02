package be.abis.acca.model;

import java.util.ArrayList;
import java.util.List;

public class Course {

    private String title;
    private int numberOfDays;
    private double pricePerDay;
    private boolean priorKnowledgeRequired;

    private int instructorCounter;
    private List<AbisEmployee> instructors = new ArrayList<AbisEmployee>();

    public Course(String title, int numberOfDays, double pricePerDay, boolean priorKnowledgeRequired) {
        this.title = title;
        this.numberOfDays = numberOfDays;
        this.pricePerDay = pricePerDay;
        this.priorKnowledgeRequired = priorKnowledgeRequired;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public boolean isPriorKnowledgeRequired() {
        return priorKnowledgeRequired;
    }

    public void setPriorKnowledgeRequired(boolean priorKnowledgeRequired) {
        this.priorKnowledgeRequired = priorKnowledgeRequired;
    }

    public List<AbisEmployee> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<AbisEmployee> instructors) {
        this.instructors = instructors;
    }



    public double calculateTotalPrice(){
        double total=numberOfDays*pricePerDay;
        if (numberOfDays<3 && !priorKnowledgeRequired)total*=1.21;
        return total;
    }

    public String labelCoursePrice(){
        String label = "";
        double price = this.calculateTotalPrice();
        if (price<500){
            label="CHEAP";
        } else if (price<1500){
            label="OK";
        } else {
            label="EXPENSIVE";
        }
        return label;
    }

    public void printInfo(){
        System.out.println("The "+ title + " course takes " + numberOfDays +  (numberOfDays>1?" days.":" day.")+ " Prior knowledge is " + (priorKnowledgeRequired?"":"not ")+"required. " +
                "The total price is " + this.calculateTotalPrice()+ ". This is " + this.labelCoursePrice() +".");
        if(!instructors.isEmpty()) {
            System.out.println("The instructors are: ");
            for (AbisEmployee ae : instructors) {
               System.out.println(ae);
            }
        }
    }

    public void addInstructor(AbisEmployee ae){
        if (ae.hasRole("instructor")){
            instructors.add(ae);
        } else {
            System.out.println(ae.getFirstName() + " is not an instructor.");
        }
    }
}
