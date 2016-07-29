package it.luigibennardis.microservice.mongodbentity;


import org.springframework.data.annotation.Id;

public class DetailedReservation {
  

    @Id
    private String id;

    private String idReservation;
    private String idTransaction;

    public DetailedReservation() {}

    public DetailedReservation(String idReservation, String idTransaction) {
        this.idReservation = idReservation;
        this.idTransaction = idTransaction;
    }

    @Override
    public String toString() {
        return String.format(
                "Detailed reservation[id=%s, idReservation='%s', idTransaction='%s']",
                id, idReservation, idTransaction);
    }

}
