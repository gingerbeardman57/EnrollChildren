/**
Name: Joseph Roesch
Date: 4/7/2019
Course/Section: IT206.003
Assignment 6
Description:
This programs allows a user to input a child, enroll a child, remove a child, print the record for a child, and calculate
the cost for their enrollment. It will store the Child/ScholarshipChild objects in arrays. It will allow the program to
send an error statement if the user does not input the data correctly. It will only create the objects with childName,
parentName, childAge, and parentPhone. It will allow the user to input the values for a Child/ScholarshipChild object that
will become enrolled. It will show that the method toString() can be overridden. It will show the substitution principle
that a Child/ScholarshipChild can be stored in the same array. The program will allow the user to choose from a menu which
action they want to take. It will allow the user to select a child from a menu by a number to remove, print, or enroll. 
The data input for a child object is child name, parent name, child age, is scholarship, and parent phone. The data input 
for a child to become enrolled is school district code, number of classes, and class location. The data input for a scholar-
ship child is scholarship organization and discount amount. The program will validate any number selections input from a user.
The child/ScholarshipChild classes will validate the data input on that end. When a child is removed, it will be removed from
the solution. The user must selet 5 in the menu to exit the program and the program will display an exit message. The 
program will make sure no two children have the same childName and parentName.

*/
public class ScholarshipChild extends Child{
   private String scholarshipOrganization;
   private double percentDiscount;
   public static final int MIN_PERCENT = 0;
   public static final int MAX_PERCENT = 1;
   public ScholarshipChild(String childName, int childAge, String parentName, String parentPhone){
      super(childName, childAge, parentName, parentPhone);
      
   }
   public String getScholarshipOrganization() { return this.scholarshipOrganization;
   }
   public double getPercentDiscount(){ return this.percentDiscount;
   }
   public void setScholarshipOrganization(String scholarshipOrganization){ 
      if(scholarshipOrganization == null || scholarshipOrganization.equals("")){
         throw new IllegalArgumentException("Error! Scholarship Organization cannot be blank");
      }
      this.scholarshipOrganization = scholarshipOrganization;
   }
   public void setPercentDiscount(double percentDiscount){
      if (percentDiscount >= MAX_PERCENT || percentDiscount <= MIN_PERCENT){
         throw new IllegalArgumentException("Error! Please enter a percent discount that is greater than 0 and less than 1. Example: 0.12 ");
      }
      this.percentDiscount = percentDiscount;   
   }
   
   public double calculateTotalCharge(){
      return ((1-this.getPercentDiscount()) * super.calculateTotalCharge());
   }
   public String toString(){
      
    

      String playWithFire;
      playWithFire = super.toString();
      
      playWithFire += 
        "Scholarship Percent Discount: " + this.getPercentDiscount() + "\n"
      + "Total Charge with Percent Discount: " + String.format("%.2f", this.calculateTotalCharge()) + "\n"
      + "Scholarship Organization: " + this.getScholarshipOrganization() + "\n";
      return playWithFire;
   }
}