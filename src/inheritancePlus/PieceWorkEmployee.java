package inheritancePlus;

public class PieceWorkEmployee extends Employee {

  private int piecesMade;
  private int target;
  private double paymentPerPiece;
  private double penaltyAmount;
  private double weeklyPayment;

  public PieceWorkEmployee(String first, String last, String ssn, int
      piecesMade, int target, double paymentPerPiece, double
      penaltyAmount) {
    super(first, last, ssn); // pass to Employee constructor
    setDuePayment(piecesMade, target, paymentPerPiece, penaltyAmount);
    // validate and store duePayment
    this.piecesMade = piecesMade;
    this.paymentPerPiece = paymentPerPiece;
  }

  public void setDuePayment(int piecesMade, int target, double
      paymentPerPiece, double penaltyAmount) {
    if (piecesMade == target) {
      weeklyPayment = piecesMade * paymentPerPiece;
    } else if (piecesMade > target){
      paymentPerPiece = paymentPerPiece + (paymentPerPiece * 0.1);
      weeklyPayment = piecesMade * paymentPerPiece;
    } else if (piecesMade < target) {
      weeklyPayment = (piecesMade * paymentPerPiece) - penaltyAmount;
    } else {
      throw new IllegalArgumentException(
          "weeklyPayment must be a numerical value");
    }
  }

  public double getWeeklyPayment() {
    return weeklyPayment;
  }

  public int getPiecesMade() {
    return piecesMade;
  }

  public double getPaymentPerPiece(){
    return paymentPerPiece;
  }

  // calculate earnings; override abstract method earnings in Employee
  @Override
  public double earnings() {
    return getWeeklyPayment();
  }

  // return String representation of CommissionEmployee object
  @Override
  public String toString() {
    return String.format("%s: %s\n%s: %d; %s: $%.2f", "piece work " +
        "employee", super.toString(), "pieces made: ", getPiecesMade(),
        "payment per piece", getPaymentPerPiece());
  }
}