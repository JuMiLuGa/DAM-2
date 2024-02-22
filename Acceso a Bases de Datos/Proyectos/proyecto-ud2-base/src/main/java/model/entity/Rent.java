package model.entity;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Rent {
    private String uuid;

    private Integer idBook;

    private String dniMember;

    private Timestamp startRentDate;

    private Timestamp endRentDate;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm:ss");

    public Rent(String uuid, Integer idBook, String dniMember, Timestamp startRentDate, Timestamp endRentDate) {
        this.uuid = uuid;
        this.idBook = idBook;
        this.dniMember = dniMember;
        this.startRentDate = startRentDate;
        this.endRentDate = endRentDate;
    }

    public Rent(Integer idBook, String dniMember) {
        this.uuid = UUID.randomUUID().toString();
        this.idBook = idBook;
        this.dniMember = dniMember;
        this.startRentDate = new Timestamp(System.currentTimeMillis());
        this.endRentDate = null;
    }

    public Integer getIdBook() {
        return this.idBook;
    }

    public void setIdBook(Integer idBook) {
        this.idBook = idBook;
    }

    public String getDniMember() {
        return this.dniMember;
    }

    public void setDniMember(String dniMember) {
        this.dniMember = dniMember;
    }

    public Timestamp getStartRentDate() {
        return this.startRentDate;
    }

    public String getStartRendDateFormatted() {
        try {
            return this.startRentDate.toLocalDateTime().format(formatter);
        } catch (Exception e) {
            return "null";
        }
    }

    public void setStartRentDate(Timestamp startRentDate) {
        this.startRentDate = startRentDate;
    }

    public Timestamp getEndRentDate() {
        return this.endRentDate;
    }

    public String getEndRendDateFormatted() {
        try {
            return this.endRentDate.toLocalDateTime().format(formatter);
        } catch (Exception e) {
            return "null";
        }
    }

    public void setEndRentDate(Timestamp endRentDate) {
        this.endRentDate = endRentDate;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public boolean isValid() {
        return (this.idBook != null && this.dniMember != null &&
                !this.dniMember.isEmpty() && this.startRentDate != null);
    }

    public String toString() {
        return "Rent{uuid='" + this.uuid + "', idBook=" + this.idBook + ", dniMember='" + this.dniMember + "', startRentDate=" +

                getStartRendDateFormatted() + ", endRentDate=" +
                getEndRendDateFormatted() + "}";
    }
}

