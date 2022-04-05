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
import javax.swing.JOptionPane;
public class EnrollChildren{
   public static void main(String[] args){
      //Final used to create the length of the enrolled array to hold Child/ScholarshipChild objects.
      final int MAX_NUM_ENROLLED = 17;
      //final used to create the length of the children array to hold Child/ScholarshipChild objects
      final int MAX_NUM_CHILDREN = 100;
      //array used to hold Child/ScholarshipChild objects.
      Child[] children = new Child[MAX_NUM_CHILDREN];
      //array used to hold enrolled Child/ScholarshipChild objects.
      Child[] enrolled = new Child[MAX_NUM_ENROLLED];
      menu(children, enrolled);
   }
   /**
   Method Purpose: To hold the structure for a user to be directed to add a child, enroll a child, remove a child, print a
   child record, or quit the program.
   Parameter: Child children[], Child enrolled[]
   Return Type: void
   */
   public static void menu(Child children[], Child enrolled[]){
      
      int choice;
      //used to allow the user to exit the dowhile loop if they picked 5.
      final int EXIT = 5;
      //used to select an object that a user wants to remove. will be -1 if there are no objects to delete.
      int selector;
      //used to only allow the user to choose what to do, can only exit by entering 5.
      
      do{
         choice = pickChoice();
         
         switch(choice){
            case 1: 
               if(Rec.getNumChildren() < children.length){
                 try{
                     children[Child.getNumChildren()] = addChild();
                 }
                 catch(NumberFormatException e){
                     JOptionPane.showMessageDialog(null, "You did not enter a number. ");
                  }
                  catch(IllegalArgumentException e){
                     JOptionPane.showMessageDialog(null, "The child could not be added. " + e.getMessage());
                  }
               }
               else{JOptionPane.showMessageDialog(null, "Error! Too many children have been entered into the system.");}
            break;
            case 2:
               if(Child.getNumEnrolled() < enrolled.length){
                  try{
                     enrollChild(children, enrolled);
                  }
                  catch(NumberFormatException e){
                     JOptionPane.showMessageDialog(null, "You did not enter a number. ");
                  }
                  catch(IllegalArgumentException e){
                     JOptionPane.showMessageDialog(null, "The child could not be added. " + e.getMessage());
                  }
               }
               else{
                  JOptionPane.showMessageDialog(null, "Error! The company has decided to only allow a maximum of " + enrolled.length + " children to be enrolled at this time.");
               }                                               
            break;
            case 3:
               selector = listEnrolled(enrolled);
               if(selector != -1){
                  removeChild(children, enrolled, selector); 
               }   
            break;
            case 4:
               printChild(children, enrolled);
            break;
            case 5:
               JOptionPane.showMessageDialog(null, "You have exited the program. Have a nice day!");
            break;   
         }   
      }while(choice!=EXIT);
   }
    /**
   Method Purpose: To hold the structure to print enrolled children.
   Parameter: Child children[], Child enrolled[]
   Return Type: void
   */
   public static void printChild(Child children[], Child enrolled[]){
      if(Child.getNumChildren()>0){
         //used to print what is returned from an object's toString method.
         String printDat = "";
         //used to select an object
         int pickit = listEnrolled(enrolled);
         
            printDat = enrolled[pickit].toString();
         
         
   
         JOptionPane.showMessageDialog(null, printDat);
      }
      else{
         JOptionPane.showMessageDialog(null, "Error! No children input!");
      }
   }
    /**
   Method Purpose:  To remove an enrolled child from the program (both arrays).
   Parameter: Child children[], Child enrolled[], int selector
   Return Type: void
   */
   public static void removeChild(Child children[], Child enrolled[], int selector){
      //new object reference created
      Child s1;
      //removing an object where order doesn't matter
      s1 = enrolled[Child.getNumEnrolled()-1];
      enrolled[Child.getNumEnrolled()-1] = enrolled[selector];
      enrolled[selector] = s1;
      Child.setNumEnrolled(false);
      Child s2;
      s2 = children[Child.getNumChildren()-1];
      children[Child.getNumChildren()-1] = children[selector];
      children[selector] = s2;
      Child.setNumChildren(false);
        
   }
    /**
   Method Purpose:  To list all the enrolled children in a formatted presentation with allocated numbers for the user to select.
   Parameter: Child enrolled[]
   Return Type:int
   */
   public static int listEnrolled(Child enrolled[]){
      //used to allow a user to exit the loop,
      final int MIN_NUM = 0;
      
      //declaring variable outside the loop
      int vesuvius = -1;
      //used for not allowing the user to exit unless they enter a valid number
      while(vesuvius < MIN_NUM || vesuvius >= Child.getNumEnrolled()){
         
         try{
            String parlay="Number  |  Child Name\n";
            for(int i=0;i<Child.getNumEnrolled();i++){
            parlay+=i + "            : "+ enrolled[i].getChildName()+"\n";
            }
            parlay += "Select a child";            
            vesuvius = Integer.parseInt(JOptionPane.showInputDialog(parlay));
            }
         catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Error! You did not enter a number");
            vesuvius = -1;
         }
         if(vesuvius < MIN_NUM || vesuvius >= Child.getNumEnrolled()){
            JOptionPane.showMessageDialog(null, "Error! Enter a number between "+MIN_NUM+" and " + (Child.getNumEnrolled()-1)+ " inclusive");
            vesuvius = -1;
         }
            
      }
      return vesuvius;
   }
    /**
   Method Purpose: To add a Child/ScholarshipChild object. 
   Parameter: none
   Return Type: a Child object reference.
   */
   public static Child addChild(){
      //variables to hold the values of the inputs required for a child object.
      String cName = JOptionPane.showInputDialog("Enter the first and last name of the child separated by a space: ");
      int cAge = Integer.parseInt(JOptionPane.showInputDialog("Enter the age of the child: "));
      String pName = JOptionPane.showInputDialog("Enter the name of the parent: ");
      String pPhone = JOptionPane.showInputDialog("Enter the phone of the parent in format xxx.xxx.xxxx: ");                  
      Child jimmy = new Child(cName, cAge, pName, pPhone);        
      Child.setNumChildren(true);
      return jimmy;                 
   }
    /**
   Method Purpose: To enroll a Child/ScholarshipChild object by allowing the user to input the necessary information.
   Parameter: Child children[], Child enrolled[]
   Return Type: void
   */
   public static void enrollChild(Child children[], Child enrolled[]){
      //if there are no Child objects created, we cannot enroll a child
      if(Child.getNumChildren()>0){
         //finding the spot in the array where the object is located
         int picked = listChildren(children);
         //making sure the child is not already enrolled
         boolean vali = compareChildren(children, enrolled, picked);     
         if(!vali){
            boolean isScholar = JOptionPane.showConfirmDialog(null, "Is this a scholarship child?", "Scholarship Child Question", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
            int numClass = Integer.parseI
            nt(JOptionPane.showInputDialog("Enter the number of classes the child would like to enroll in between 1 and 6 inclusive: "));
            String classLoc = JOptionPane.showInputDialog("Enter the class location, either 'Fairfax', 'Front Royal', 'Manassas', 'Loudon', 'Arlington', or 'Washington, DC'");         
            String sdc = JOptionPane.showInputDialog("Enter the school code in format 'xyx' where x is an uppercase letter and y is a digit");         
            
            String cn = children[picked].getChildName();
            int ca = children[picked].getChildAge();
            String pn = children[picked].getParentName();
            String pp = children[picked].getParentPhone();      
            if(isScholar){         
               //have to create a new object in case the reference in children[] gets changed
               ScholarshipChild s1 = new ScholarshipChild(cn, ca, pn, pp);
               s1.setSchoolDistrictCode(sdc);
               s1.setNumClasses(numClass);
               s1.setClassLocation(classLoc);
               s1.setIsScholarship(isScholar);
               s1.setScholarshipOrganization(JOptionPane.showInputDialog("Enter the scholarship organization: "));
               s1.setPercentDiscount(Double.parseDouble(JOptionPane.showInputDialog("Enter the percent discount in decimal form: ")));
               Child.setNumEnrolled(true);
               s1.setIsEnrolled(true);
               enrolled[picked] = s1;
            }
            else{
               Child basil = new Child(cn, ca, pn, pp);
               basil.setIsScholarship(!isScholar);
               basil.setNumClasses(numClass);
               basil.setClassLocation(classLoc);
               basil.setSchoolDistrictCode(sdc);
               Child.setNumEnrolled(true);
               basil.setIsEnrolled(true);
               enrolled[picked] = basil;
            
           }
         }
         else{
            JOptionPane.showMessageDialog(null, "Error! Cannot enroll the same child twice!");
         
         }
      }
      else{
         JOptionPane.showMessageDialog(null, "Error! No children input!");
      }
   }
    /**
   Method Purpose: To compare a child name and parent name from one Child object to all the other Child objects'child
   names and parent names. 
   Parameter: Child children[], Child enrolled[], int picked
   Return Type: boolean. will say whether the child name and parent name matched another object's parent names and child names.
   */
   public static boolean compareChildren(Child children[], Child enrolled[], int picked){
      boolean vali = false;
      int i = 0;
      while(!vali && i<Child.getNumEnrolled()){
          if ((children[picked].getChildName().equalsIgnoreCase(enrolled[i].getChildName()))||(children[picked].getParentName().equalsIgnoreCase(enrolled[i].getParentName()))){
            vali=true;
          }
          i++;
          
      }
      return vali;
   }
    /**
   Method Purpose: Will list all the children names of all the Child objects in children[] with an associated number and allow
   the user to enter a number to pick the names.
   Parameter: Child children[]
   Return Type: int. this will be the number that will be associated with the place the object is located in the array.
   */
   public static int listChildren(Child children[]){
      final int MIN_NUM = 0;
      
      
      int vesuvius = -1;
      while(vesuvius < MIN_NUM || vesuvius >= Child.getNumChildren()){
         
         try{
            String parlay="Number  |  Child Name\n";
            for(int i=0;i<Child.getNumChildren();i++){
            parlay+=i + "          : "+ children[i].getChildName()+"\n";
            }
            parlay += "Select a child by entering a number\n";
            
            vesuvius = Integer.parseInt(JOptionPane.showInputDialog(parlay));
            }
         catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Error! You did not enter a number");
            vesuvius = -1;
         }
         if(vesuvius < MIN_NUM || vesuvius >= Child.getNumChildren()){
            JOptionPane.showMessageDialog(null, "Error! Enter a number between "+MIN_NUM+" and " + (Child.getNumChildren()-1)+ " inclusive");
            vesuvius = -1;
         }
            
      }
      return vesuvius;
   }
    /**
   Method Purpose: To list a menu and allow the user to pick a choice from the menu.
   Parameter: none
   Return Type: int.
   */
   public static int pickChoice(){
      //used to validate user input/exit loop
      final int CHECKER = 1;
      //used to validate user input/exit loop
      final int DOUBLE_CHECKER=5;
      //used to exit the loop
      
      int choice;
      do{
         try{
            
            choice = Integer.parseInt(JOptionPane.showInputDialog(
            "Please Enter a number for the following actions:\n" +
            "1. Add Child\n"+
            "2. Enroll Child\n"+
            "3. Remove Enrolled Child\n"+
            "4. Print Child Record\n"+
            "5. Quit the Program"));
         }
         catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "You didn't enter a number. Please try again.");
            choice = -1;
         }
         if(choice<CHECKER || choice>DOUBLE_CHECKER){
            JOptionPane.showMessageDialog(null, "Error! Please enter a number between 1 and 5 inclusive.");
            choice = -1;
         }   
      }while(choice<CHECKER || choice>DOUBLE_CHECKER);
      return choice;
   }
}
