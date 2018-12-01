package com.tpfinal.dto;

public class RejectDTO {
    public Long idTrx;
    public String rejection;

    public Long getIdTrx() {
        return idTrx;
    }

    public void setIdTrx(Long idTrx) {
        this.idTrx = idTrx;
    }

    public String getRejection() {
        return rejection;
    }

    public void setRejection(String rejection) {
        this.rejection = rejection;
    }
}
