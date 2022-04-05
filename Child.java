/**

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
public class Child{
   private String childName;
   private int childAge;
   private String parentName;
   private String parentPhone;
   private String schoolDistrictCode;
   private int numClasses;
   private String classLocation;
   private boolean isScholarship;
   private boolean isEnrolled;
   private double totalCharge;
   private static int numEnrolled=0;
   private static int numChildren=0;
   //validate phone length
   public static final int VALIDATE_PHONE = 12;
   //validate min age
   public static final int MIN_AGE = 9;
   //validate max age
   public static final int MAX_AGE = 16;
   //validate school code length
   public static final int VALIDATE_CODE = 3;
   public static final int MAX_NUM_CLASSES = 6;
   public static final int MIN_NUM_CLASSES = 1;
   //validate class location
   public static final String []CLASS_LOCATION = {"Fairfax","Front Royal","Manassas","Loudon","Arlington","Washington, DC"};
   //used to calculate cost for one class  
   public static final int COURSE_COST = 79;
   //used for calculating transport cost for Washington DC Class
   public static final int TRANSPORT_COST = 23;
   //constructor for Child object
   public Child(String childName, int childAge, String parentName, String parentPhone){
      if(childName == null || childName.equals("")){
         throw new IllegalArgumentException("Error! Child Name cannot be blank");
      }
      if(parentName == null || parentName.equals("")){
         throw new IllegalArgumentException("Error! Parent Name cannot be blank");
      }
      if(parentPhone == null || parentPhone.equals("")){
         throw new IllegalArgumentException("Error! Parent Phone cannot be blank");
      }
      if(parentPhone.length() != VALIDATE_PHONE){
         throw new IllegalArgumentException("Error! Parent phone must be in the format 'xxx.xxx.xxxx' and cannot be longer than 12 characters");
      }
      
      int phoneCounter = 0;
      char phoneChar;
      int phoneChecker = 0;
      while(phoneCounter < parentPhone.length() && phoneChecker < 2){
         phoneChar = parentPhone.charAt(phoneCounter);
         if (phoneChar == '.'){
            phoneChecker++;
         }
         phoneCounter++;
      }
      if (phoneChecker!=2){
         throw new IllegalArgumentException("Error! Parent phone must be in the format 'xxx.xxx.xxxx'. You must have two periods seperating the digits.");
      }
      else {
         this.parentPhone = parentPhone;
      }
      //this will count the times going through the while loop
      int counter = 0;
      //validator to see if the character is a digit or not.
      boolean checker = false;
      //loop will end if checker is true or it goes through the whole string. If contactName is correct, counter will reamin false.
      while(counter < childName.length() && !checker){
         checker = Character.isDigit(childName.charAt(counter));
         counter++;
      }
      if (checker) {
         throw new IllegalArgumentException("Error! There can be no numbers in the child's name");
      }
      //counter will be used to count the number of spaces.
      counter = 0;
      //i will serve as the counter for the loop
      int i = 0;
      //char will serve as the holder for the specific char in the string to validate
      char check;
      //loop will exit if more than 1 space is found or it goes through the whole string.
      while(i < childName.length() && counter<2) {
         check = childName.charAt(i);
         if (check==' '){
            counter++;
         }
         i++;
      }
      if (counter!=1) {
         throw new IllegalArgumentException("Error! There can only be one space separating the first and last name");
      }
      else {
         this.childName = childName;
      }
      //this will count the times going through the while loop
      counter = 0;
      //validator to see if the character is a digit or not.
      checker = false;
      //loop will end if checker is true or it goes through the whole string. If contactName is correct, counter will reamin false.
      while(counter < parentName.length() && !checker){
         checker = Character.isDigit(parentName.charAt(counter));
         counter++;
      }
      if (checker) {
         throw new IllegalArgumentException("Error! There can be no numbers in the parent's name");
      }
      //counter will be used to count the number of spaces.
      counter = 0;
      //i will serve as the counter for the loop
      i = 0;
      //char will serve as the holder for the specific char in the string to validate
      
      //loop will exit if more than 1 space is found or it goes through the whole string.
      while(i < parentName.length() && counter<2) {
         check = parentName.charAt(i);
         if (check==' '){
            counter++;
         }
         i++;
      }
      if (counter!=1) {
         throw new IllegalArgumentException("Error! There can only be one space separating the first and last name");
      }
      else {
         this.parentName = parentName;
      }
         
      if (childAge <MIN_AGE || childAge>MAX_AGE){
         throw new IllegalArgumentException("Error! The child's age must be between 9 and 16 inclusive");
      }
      this.childAge = childAge;
   }
   public String getChildName(){ return this.childName;
   }
   public int getChildAge(){ return this.childAge;
   }
   public String getParentName(){ return this.parentName;
   
   }
   public String getParentPhone(){ return this.parentPhone;
   }
   public String getSchoolDistrictCode(){ return this.schoolDistrictCode;
   
   }
   public int getNumClasses(){ return this.numClasses;
   }
   public String getClassLocation(){ return this.classLocation;
   }
   
   public double getTotalCharge(){ return this.totalCharge;
   }
   public boolean getIsEnrolled(){ return this.isEnrolled;
   }
   public boolean getIsScholarship(){ return this.isScholarship;
   }
   public static int getNumEnrolled(){ return numEnrolled;}
   public static int getNumChildren(){ return numChildren;}
   public static void setNumChildren(boolean direction){
      if(direction){
         
            numChildren++;
         }
      
      else{
         numChildren--;
      }
   }

   public static void setNumEnrolled(boolean direction){
      if(direction){
        
            numEnrolled++;
         
      }
      else{
         numEnrolled--;
      }
   }
   public void setChildName(String childName){
      if(childName == null || childName.equals("")){
         throw new IllegalArgumentException("Error! Child Name cannot be blank");
      }
      //this will count the times going through the while loop
      int counter = 0;
      //validator to see if the character is a digit or not.
      boolean checker = false;
      //loop will end if checker is true or it goes through the whole string. If contactName is correct, counter will reamin false.
      while(counter < childName.length() && !checker){
         checker = Character.isDigit(childName.charAt(counter));
         counter++;
      }
      if (checker) {
         throw new IllegalArgumentException("Error! There can be no numbers in the child's name");
      }
      //counter will be used to count the number of spaces.
      counter = 0;
      //i will serve as the counter for the loop
      int i = 0;
      //char will serve as the holder for the specific char in the string to validate
      char check;
      //loop will exit if more than 1 space is found or it goes through the whole string.
      while(i < childName.length() && counter<2) {
         check = childName.charAt(i);
         if (check==' '){
            counter++;
         }
         i++;
      }
      if (counter!=1) {
         throw new IllegalArgumentException("Error! There can only be one space separating the first and last name");
      }
      else {
         this.childName = childName;
      }

   }
   public void setChildAge(int childAge){ 
      if (childAge <MIN_AGE || childAge>MAX_AGE){
         throw new IllegalArgumentException("Error! The child's age must be between 9 and 16 inclusive");
      }
      this.childAge = childAge;
   }
   public void setParentName(String parentName){
      if(parentName == null || parentName.equals("")){
         throw new IllegalArgumentException("Error! Parent Name cannot be blank");
      }
      //this will count the times going through the while loop
      int counter = 0;
      //validator to see if the character is a digit or not.
      boolean checker = false;
      //loop will end if checker is true or it goes through the whole string. If contactName is correct, counter will reamin false.
      while(counter < parentName.length() && !checker){
         checker = Character.isDigit(parentName.charAt(counter));
         counter++;
      }
      if (checker) {
         throw new IllegalArgumentException("Error! There can be no numbers in the parent's name");
      }
      //counter will be used to count the number of spaces.
      counter = 0;
      //i will serve as the counter for the loop
      int i = 0;
      //char will serve as the holder for the specific char in the string to validate
      char check;
      //loop will exit if more than 1 space is found or it goes through the whole string.
      while(i < parentName.length() && counter<2) {
         check = parentName.charAt(i);
         if (check==' '){
            counter++;
         }
         i++;
      }
      if (counter!=1) {
         throw new IllegalArgumentException("Error! There can only be one space separating the first and last name");
      }
      else {
         this.parentName = parentName;
      }
   }
   public void setParentPhone(String parentPhone){
      if(parentPhone.length() != VALIDATE_PHONE){
         throw new IllegalArgumentException("Error! Parent phone must be in the format 'xxx.xxx.xxxx' and cannot be longer than 12 characters");
      }
      int phoneCounter = 0;
      char phoneChar;
      int phoneChecker = 0;
      while(phoneCounter < parentPhone.length() && phoneChecker < 2){
         phoneChar = parentPhone.charAt(phoneCounter);
         if (phoneChar == '.'){
            phoneChecker++;
         }
         phoneCounter++;
      }
      if (phoneChecker!=2){
         throw new IllegalArgumentException("Error! Parent phone must be in the format 'xxx.xxx.xxxx'. You must have two periods seperating the digits.");
      }
      else {
         this.parentPhone = parentPhone;
      }

   }
   public void setSchoolDistrictCode(String schoolDistrictCode){
      if(schoolDistrictCode == null || schoolDistrictCode.equals("")){
         throw new IllegalArgumentException("Error! School District Code cannot be blank!");
      }
      if (schoolDistrictCode.length()!=VALIDATE_CODE){
         throw new IllegalArgumentException("Error! School District Code must be 3 characters long. The first and third characters are uppercase letters. The 2nd character is a number.");
      }
      
      if(!Character.isUpperCase(schoolDistrictCode.charAt(0))){
         throw new IllegalArgumentException("Error! the first character of the school district code must be an uppercase letter.");
      }
      if(!Character.isUpperCase(schoolDistrictCode.charAt(2))){
         throw new IllegalArgumentException("Error! the third character of the school district code must be an uppercase letter.");
      }
      if(!Character.isDigit(schoolDistrictCode.charAt(1))){
         throw new IllegalArgumentException("Error! the second character of the school district code should be a digit.");
      }
      this.schoolDistrictCode = schoolDistrictCode;
   }
   public void setNumClasses(int numClasses){
      if (numClasses < MIN_NUM_CLASSES || numClasses > MAX_NUM_CLASSES){
         throw new IllegalArgumentException("Error! The child cannot enroll in more than six classes");
      }
      this.numClasses = numClasses;
   }
   public void setClassLocation(String classLocation){
      boolean vali = false;
      int counter = 0;
      while(!vali||counter<CLASS_LOCATION.length){
         if(classLocation.equals(CLASS_LOCATION[counter])){
            vali = true;
            this.classLocation = classLocation;
         }
         counter++;
      }
      if(!vali){
         String classLoc = "Error! Class Location must be one of these locations:\n";
         for(int i=0;i<CLASS_LOCATION.length;i++){
            classLoc += CLASS_LOCATION[i] + "\n";
         }
         throw new IllegalArgumentException(classLoc);
      }
   }
   public void setIsScholarship(boolean isScholarship){
     this.isScholarship = isScholarship;
   }
   public void setIsEnrolled(boolean isEnrolled){
      this.isEnrolled = isEnrolled;
   }
   public void setTotalCharge(double totalCharge){
      
      
      this.totalCharge = totalCharge;
   }
   public double calculateTotalCharge(){
      
      if(!this.getClassLocation().equals(Child.CLASS_LOCATION[5])){
         return (numClasses * COURSE_COST);
         
      }
      else{
         return (numClasses * COURSE_COST) + (numClasses * TRANSPORT_COST);
      }
   }
  
   public String toString(){ 
     String playWithString = "";
     playWithString += 
       "Child's Name: " + this.getChildName() + "\n"
     + "Child's Age: " + this.getChildAge() + "\n"
     + "Parent's Name: " + this.getParentName() + "\n"
     + "Parent's Phone: " + this.getParentPhone() + "\n"
     + "Is Enrolled? " + this.getIsEnrolled() + "\n";
     if(this.getIsEnrolled()){
        this.setTotalCharge(this.calculateTotalCharge());
        playWithString +=
        "School District Code: " + this.getSchoolDistrictCode() + "\n"
        + "Number of Classes Enrolled: " + this.getNumClasses() + "\n"
        + "Class Location : " + this.getClassLocation() + "\n"
        + "Is the child on a scholarship? " + this.getIsScholarship() + "\n";
        if(!this.getIsScholarship()){
        playWithString+= "Total Charge: " + String.format("%.2f", this.getTotalCharge()) + "\n";
        
           
     }
     
    
  }
  return playWithString; 
 }
}
