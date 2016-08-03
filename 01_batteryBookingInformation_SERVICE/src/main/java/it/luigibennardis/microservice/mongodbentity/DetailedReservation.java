package it.luigibennardis.microservice.mongodbentity;


import org.springframework.data.annotation.Id;

public class DetailedReservation {
  

    
	@Id
    private String id;

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	 
	public String getIdReservation() {
		return idReservation;
	}

	public void setIdReservation(String idReservation) {
		this.idReservation = idReservation;
	}

	public String getIdTransaction() {
		return idTransaction;
	}

	public void setIdTransaction(String idTransaction) {
		this.idTransaction = idTransaction;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}


	private String idReservation;
    private String idTransaction;
    private String state;

    public DetailedReservation() {}

    public DetailedReservation(String idReservation, String idTransaction, String state) {
        this.idReservation = idReservation;
        this.idTransaction = idTransaction;
        this.state = state;
    }
    
    @Override
    public String toString() {
        return String.format(
                "Detailed reservation[ id='%s', idReservation='%s', idTransaction='%s', state='%s']",
                  id, idReservation, idTransaction, state);
    }

}
