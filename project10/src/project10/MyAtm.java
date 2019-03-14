package project10;

public class MyAtm  {
     double Balance=0;
    public void withdraw (double amount){
        if (amount > Balance || amount == 0){
            
        }
        else 
        {
            Balance = Balance - amount;
           
           
        }
    }
        public void deposit (double deposit){
        Balance = deposit + Balance;
        }
    
      

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double balance) {
        this.Balance = Balance;
    }

}

