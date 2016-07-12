package com.tpfinal.domain;

import javax.persistence.*;

@Entity
@Table(name = "rating")
public class Rating {

    private Long idRating;
    private Integer reliability; //confiabilidad
    private Integer performance; //desempeño
    private Integer consideration; //consideracion
    private Integer recommendation; //recomendacion
    private Long id_provider; //id proveedor
    private String review_text; //texto de opinion
    private Integer general_average; // promedio general
    private Long id_user; //recomendacion
    private Long id_transaction; //recomendacion

    public Rating(Integer reliability, Integer performance, Integer consideration, Integer recommendation,Long id_provider,String review_text,Integer general_average,  Long id_user, Long id_transaction ) {
        this.reliability = reliability;
        this.performance = performance;
        this.consideration = consideration;
        this.recommendation = recommendation;
        this.id_provider = id_provider;
        this.review_text = review_text;
        this.general_average = general_average;
        this.id_user = id_user;
        this.id_transaction = id_transaction;
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
    public Integer getReliability() {
        return reliability;
    }

    public void setReliability(Integer reliability) {
        this.reliability = reliability;
    }

    @Column(name = "performance")
    public Integer getPerformance() {
        return performance;
    }

    public void setPerformance(Integer performance) {
        this.performance = performance;
    }

    @Column(name = "consideration")
    public Integer getConsideration() {
        return consideration;
    }

    public void setConsideration(Integer consideration) {
        this.consideration = consideration;
    }

    @Column(name = "recommendation")
    public Integer getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(Integer recommendation) {
        this.recommendation = recommendation;
    }

    @Column(name="id_provider")
    public Long getId_provider() {
        return id_provider;
    }

    public void setId_provider(Long id_provider) {
        this.id_provider = id_provider;
    }
    @Column(name="review_text")
    public String getReview_text() {
        return review_text;
    }

    public void setReview_text(String review_text) {
        this.review_text = review_text;
    }

    @Column(name="general_average")
    public Integer getGeneral_average() {
        return general_average;
    }

    public void setGeneral_average(Integer general_average) {
        this.general_average = general_average;
    }

    @Column(name="id_user")
    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    @Column(name="id_transaction")
    public Long getId_transaction() {
        return id_transaction;
    }

    public void setId_transaction(Long id_transaction) {
        this.id_transaction = id_transaction;
    }
}
