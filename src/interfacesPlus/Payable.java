package interfacesPlus; // Fig. 10.11: Payable.java
 // Payable interface declaration.

 public interface Payable{
	 
	 // calculate payment - no implementation 
	 //could be employee earnings, could be invoice total could be something not developed yet 
	 // i.e. polymorphically future proof
    double getPaymentAmount();
   String getID();
    
 }
