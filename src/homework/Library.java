package homework;

public abstract class Library {

	
	public DebitCard debitCard;
	public int libraryBookNum = 99999;
	
	
	public DebitCard getDebitCard() {
		return debitCard;
	}


	public void setDebitCard(DebitCard debitCard) {
		this.debitCard = debitCard;
	}


	public int getLibraryBookNum() {
		return libraryBookNum;
	}

}
