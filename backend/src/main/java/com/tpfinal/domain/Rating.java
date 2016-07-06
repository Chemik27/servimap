package com.tpfinal.domain;

import javax.persistence.*;

@Entity
@Table(name = "rating")
public class Rating {

    private Long idRating;
    private Long reliability; //confiabilidad
    private Long performance; //desempeño
    private Long consideration; //consideracion
    private Long recommendation; //recomendacion
    private Integer id_providerUser; //id del proveedor

    public Rating(Long reliability, Long performance, Long consideration, Long recommendation,Integer id_providerUser) {
        this.reliability = reliability;
        this.performance = performance;
        this.consideration = consideration;
        this.recommendation = recommendation;
        this.id_providerUser = id_providerUser;
    }

    public Rating() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rating")
    public Long getIdRating() {
        return idRating;
    }

    public void setIdRating(Long idRating) {
        this.idRating = idRating;
    }

    @Column(name = "reliability")
    public Long getReliability() {
        return reliability;
    }

    public void setReliability(Long reliability) {
        this.reliability = reliability;
    }

    @Column(name = "performance")
    public Long getPerformance() {
        return performance;
    }
    public void setPerformance(Long performance) {
        this.performance = performance;
    }

    @Column(name = "consideration")
    public Long getConsideration() {
        return consideration;
    }

    public void setConsideration(Long consideration) {
        this.consideration = consideration;
    }

    @Column(name = "recommendation")
    public Long getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(Long recommendation) {
        this.recommendation = recommendation;
    }

    @Column(name = "id_providerUser")
    public Integer getId_providerUser() {
        return id_providerUser;
    }
    public void setId_providerUser(Integer id_providerUser) {
        this.id_providerUser = id_providerUser;
    }

}
