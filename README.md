# On-Call-Virtual-Doctor-Prototype-for-an-Alternative-Health-Care-Consultation-Program
Object Oriented Programming Laboratory course using Java programming language in IntelliJ IDEA software.

## Four Pillars of Object Oriented Programming Used within the Program

### I. Encapsulation
Present within the class CheckHistory, as this class computes for the next date of the possible booking of a doctor. The parameters in this method are the variables of the doctor’s name, and the variable where the new date is stored. This class looks for the last occurrence of the doctor in the history.txt file, which contains information when a specific doctor has last been booked, gets the next line after that, as the format for the history.txt file is the doctor’s name in one line, followed by the date (in format YY/MM/DD) and the weekday, along with the time slot the doctor is available. After getting the substring of the line after the doctor’s name (which is basically the date, once again in YY/MM/DD format), it adds seven days to it, as this would be the next possible date the doctor is available, then returns this value.

### II. Inheritance
Present within the classes IWorker and IDoctor, as the IWorker contains methods that displays own name, and the company name. As IDoctor extends from this class and inherits its methods, this is the practice of code reusability as all workers and doctors have their own titles and belong to a company.

### III. Abstraction
Present within the classes ADisplaySicknesses, APhysical, and AEmotional, the abstract class ADisplaySicknesses contains a method that displays symptoms. Classes APhysical and AEmotional can implement the usage of this function, as the symptoms differ between physical and mental sicknesses.

### IV. Polymorphism
Present within PPhysical class, this contains two methods that have the same name, yet account for a different of parameters. One method has two parameters, which takes in two double variables, and returns their sum. The other method has three parameters, which takes in three double variables, and returns their sum. This class is used in the computation of the total of the cash inputted by the user, to calculate if inputted cash is sufficient enough to pay the rate of the doctor. The user is asked with two options to pay: To pay twice, or thrice, both in the form of installments.


## Walkthrough

### I. Introductory Message and Disclaimer 
The user is welcomed with the application’s introductory message that briefly explains the function of the program. It is then followed by a disclaimer that highlights the parameters of the accuracy of the information presented within the program. 

### II. Menu
Asks the user to pick from the menu on which type of pain the user is experiencing, whether it may be physical or emotional. The section Slideshow of Physical Sicknesses discusses and explains more if the first option is selected. The section Mental/Emotional Pain discusses more about this if the second option is selected.

### III. Slideshow of Physical Sicknesses
If physical pain is selected, a slideshow of nine sicknesses presented along with their symptoms (only covers sicknesses that may be diagnosed because of the current online setup) is assigned a number located on the upper right part of the console window, that would be utilized in picking the sickness/es that the user is feeling, or closest to feeling. 

### IV. Option to Edit Physical Sicknesses
After the input, the user may want to edit the list, if dissatisfied. If the user is dissatisfied, the user may edit the current list, such as deleting or replacing a number. 

### V. Menu Under Physical Pain
The user will be proceeded to a menu, that asks if the user would want to book an appointment with a doctor online, or simply view the suggested ways of future prevention and prescription. If the user doesn’t want to book and only maybe wants to learn more information about the sickness, this is shown in the section of Insufficient Cash from User and Its Alternative Option, or the Alternative Option If the User Does Not Want to Book Online.

### VI. Booking an Appointment Online
If the user would want to book an appointment online, the user is presented with a list of doctors, that comes along with a slideshow, that displays important details such as the name, e-mail address, days available along with the time slots, and their rate from the doctors.txt file. It would first show a preview of a doctor, along with their contact details. After picking the desired doctor, the program will select the nearest date of the day that the doctor is possible. For example, the current date is October 4, 2020 (Sunday). For Dr. Justine Reyes, she is only available during Fridays, and so the nearest date for the consultation will be the upcoming Friday. In this example, she would be on October 9, 2020. If she would be booked again (which will only be confirmed after the processing of payment, which will be discussed in the within the program walkthrough later on), the date that she would next be available would be the next Friday, taking into consideration the customer that has picked her available appointment slot last Friday.

### VII. Payment
Encapsulates how the user will now pick his/her mode of payment, either from BDO, PayMaya, or GCash. After the selection, the user is asked to input his/her account number. The user is then asked which type of installment is preferred and asks for how much payment the user is willing to pay per installment.

### VIII. Verification and Receipt
If inputted cash from the user is sufficient, the program would ask for the customer’s e-mail address, where future and further communication between the application, or doctor, and the user will be done. However, if cash is insufficient, the program will be brought to the section of Insufficient Cash from User and Its Alternative Option, or the Alternative Option If the User Does Not Want to Book Online. The receipt is shown in Figure 13, which ends the run for this option in the program.

### IX. Insufficient Cash from User and Its Alternative Option, or the Alternative Option if the User Does Not Want to Book Online
Shows the insufficient amount of cash input from user, which is then followed by the alternative option. If the user affirms this, Figure 16 displays the disclaimer message, then proceeds with the slideshow containing possible ways for further prevention, and possible prescriptions. The slideshow ends with the disclaimer once again.

### X. Mental/Emotional Pain
The second option from the menu offers a slideshow of different illnesses concerning mental and/or emotional pain. It is started the disclaimer once again, then a few examples of mental illnesses along with their symptoms, then a list of healthy ways for possible coping mechanisms, possible prescriptions that may be taken, and ends with a list of local hotlines that the customer could contact directly.

### Authors

#### Arciella Brience C. Crisostomo [arciella_brience_crisostomo@dlsu.edu.ph]
  
#### John Emmanuel E. Pareja [j-em_pareja@dlsu.edu.ph]
