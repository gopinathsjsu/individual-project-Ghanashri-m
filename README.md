
INSTRUCTIONS TO RUN PROGRAM:

1. CLone the project / Download the jar file - ghanashri_project.jar  in the home location <br/><br/>
 (If running jar file)
 <br/>
3. Run the command:
   java -cp ghanashri_project.jar MainClass INPUT FILENAME
3. Sample Input:
   java -cp ghanashri_project.jar MainClass "Input1 - Sheet1.csv" <br/><br/>
  (If Cloning repositary and running)<br/><br/>
  Select Run -> Edit configuration -> provide the input file as shown below -> okay -> click run button (green play kind of icon)
  
  <img width="1046" alt="Screen Shot 2021-12-05 at 6 28 42 PM" src="https://user-images.githubusercontent.com/39545809/144777679-137bc8f0-bcb3-4544-8104-9ae5bc6d1110.png">

  
4. Failed orders are written to a newly generated file failedOrders_INPUT FILE NAME
5. Upon successfull completion, the card charged data is written to newly generated cardCharged_INPUT FILE NAME
6. The output is visible in the terminal aswell.
   
************
   
<h3>Design Patterns Used</h3>
   
   1. <h5>Chain of responsibility.</h5><br/>
      For the functionality to process orders with a chain of handlers (for example, reading the input file first, mapping the item in each category with item list, then check if the order quantity is exceeding the individual item limit, followed by checking if it exceeds category limit, then based on this generate order placement - success or failure output) 
   2. <h5>Iterator</h5><br/>
      For the functionality to take item for each category and map it with item list.
   3. <h5>Singleton</h5><br/>
      For the functionality of reading input file from command line.
   
*************
   
  Cap Limits Provided: Luxury : 3, Essentials : 5, Misc : 6
   
  <h3>Output Snapshots</h3>
  
1. With Input File 1
   
   <img width="1440" alt="Screen Shot 2021-12-05 at 2 57 03 PM" src="https://user-images.githubusercontent.com/39545809/144767510-90a255bf-bbec-45f2-aa7e-688520676e2c.png">
   
   <h2>The Order is successfully placed. No failed order file is generated.</h2>

   
2. With Input File 2
   
   <img width="1440" alt="Screen Shot 2021-12-05 at 2 58 21 PM" src="https://user-images.githubusercontent.com/39545809/144767504-809472cd-9707-4715-b813-a0c65ea31a0c.png">
   
   <h2>The order quantity for oil is more than the limit, so order placement fails for the item with exceeding quantity, where as card will be charged for other </h2>items.

3. With Input File 3
   
   
   <img width="1440" alt="Screen Shot 2021-12-05 at 2 58 42 PM" src="https://user-images.githubusercontent.com/39545809/144767475-ecfe675f-7367-4ccb-bf9a-9258e04e618b.png">
   
   <h2>Order placement is successfull. No failed order file is generated.</h2>
   
4. Intermediate Screen shots

card charged for input file 1

<img width="1440" alt="Screen Shot 2021-12-05 at 5 30 10 PM" src="https://user-images.githubusercontent.com/39545809/144773605-4e58ac0e-9f5d-47c5-bdbb-6f9580a25fc8.png">

card charged for input file 2

<img width="1440" alt="Screen Shot 2021-12-05 at 5 31 54 PM" src="https://user-images.githubusercontent.com/39545809/144773690-516805bc-b660-49eb-b384-dd303dbe292f.png">


failed Orders for input file

<img width="1440" alt="Screen Shot 2021-12-05 at 5 32 05 PM" src="https://user-images.githubusercontent.com/39545809/144773701-4c21143d-12dd-40dc-874e-48c92779bbe5.png">


card charged for input file 3

   <img width="1440" alt="Screen Shot 2021-12-05 at 5 32 33 PM" src="https://user-images.githubusercontent.com/39545809/144773754-5372d4d4-23a9-4bf9-ac34-34bdcf4e83a5.png">

<h3> Class Diagram for the individual project </h3>
The class diagram is included in the code repositary aswell
   
   ![IndividualProjectClassDiagram](https://user-images.githubusercontent.com/39545809/144769341-79cb669d-fcbb-4848-9f54-f4f4ee5ff2ef.jpg)



****************
<h2>Problem Statement</h2>

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
