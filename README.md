
INSTRUCTIONS TO RUN PROGRAM:

1. CLone the project / Download the jar file - ghanashri_project.jar  in the home location
2. Run the command:
   java -cp ghanashri_project.jar MainClass <INPUT FILENAME>
3. Sample Input:
   java -cp ghanashri_project.jar MainClass "Input1 - Sheet1.csv"
   
   
*************
  Output Snapshots
1. With Input File 1
   
   <img width="1440" alt="Screen Shot 2021-12-05 at 2 57 03 PM" src="https://user-images.githubusercontent.com/39545809/144767510-90a255bf-bbec-45f2-aa7e-688520676e2c.png">

   
2. With Input File 2
   
   <img width="1440" alt="Screen Shot 2021-12-05 at 2 58 21 PM" src="https://user-images.githubusercontent.com/39545809/144767504-809472cd-9707-4715-b813-a0c65ea31a0c.png">

3. With Input File 3
   
   
   <img width="1440" alt="Screen Shot 2021-12-05 at 2 58 42 PM" src="https://user-images.githubusercontent.com/39545809/144767475-ecfe675f-7367-4ccb-bf9a-9258e04e618b.png">
   
Class Diagram for the individual project
   
   ![IndividualProjectClassDiagram](https://user-images.githubusercontent.com/39545809/144769341-79cb669d-fcbb-4848-9f54-f4f4ee5ff2ef.jpg)



****************
Design and implement a Java application for the following requirements. You may choose up to 3 design patterns. Include a class diagram for your design. All submissions should be committed to the assigned Github repo. Please include a README file with instructions on how to build and run your application.

Requirements:

1. The application should maintain an internal, static database (inventory of stock)  (this may be developed using HashMaps and/or other  built-in Java Data structures). This means once we re-run the program, the changes to the data would not persist. We will provide the data that has to be maintained. The data will contain the following tables and fields:
(Sample input file and sample data set for the inventory would be provided separately)
Table 1: Items
Category (Essentials, Luxury, Miscellaneous)
Item for each category (Essentials - Clothes, soap, milk; Luxury - perfume, chocolates; Misc - Bedsheets, footwear)
The available Quantity of each item
Price of each item
Table 2: Cards
Card Numbers
2. Input CSV file will contain an order including Items, Quantity needed, and the payment card number.
3. Input file should be processed as follows:
   Validate if the requested quantity for each item is permissible. For example, if the request is to order 3 soaps, check the database if we have at least 3 soaps in our inventory.
   There will be a cap on the quantity of each category that can be ordered in one single order. For example, restrict Essentials to a maximum of 3, Luxury to 4, and Misc to 6. (This will be configured beforehand)
   In case it is an incorrect request, generate and output TXT file with message "Please correct quantities." and include the items with incorrect quantities
   After this validation, if the cart is valid, calculate prices for the cart.
   Take the card number of the user and if it is not present in DB add it.
   Output the CSV list with the total amount paid.
