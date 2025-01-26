package com.superdev.dslist.dtos;

public class ReposicionaDTO {
    private Integer origemIndex;
    private Integer destinoIndex;
    
    public ReposicionaDTO() {
    }

    public ReposicionaDTO(Integer origemIndex, Integer destinoIndex) {
        this.origemIndex = origemIndex;
        this.destinoIndex = destinoIndex;
    }

    public Integer getOrigemIndex() {
        return origemIndex;
    }

    public void setOrigemIndex(Integer origemIndex) {
        this.origemIndex = origemIndex;
    }

    public Integer getDestinoIndex() {
        return destinoIndex;
    }

    public void setDestinoIndex(Integer destnoIndex) {
        this.destinoIndex = destnoIndex;
    }
        
}
