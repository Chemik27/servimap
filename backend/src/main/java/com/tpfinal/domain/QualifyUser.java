package com.tpfinal.domain;

import javax.persistence.*;

/**
 * Created by Chemik on 27/07/2016.
 */

@Entity
@Table(name = "qualify_user")
public class QualifyUser {
    private Long idQualify;
    private Integer reliability; //confiabilidad
    private Integer performance; //desempeño
    private Integer consideration; //consideracion
    private Integer recommendation; //recomendacion
    private Long idProvider; //id proveedor
    private String reviewText; //texto de opinion
    private Integer generalAverage; // promedio general
    private Long idUser; //recomendacion
    private Long idTransaction; //recomendacion

    public QualifyUser(Integer reliability, Integer performance, Integer consideration, Integer recommendation, Long idProvider, String reviewText, Integer generalAverage, Long idUser, Long idTransaction ) {
        this.reliability = reliability;
        this.performance = performance;
        this.consideration = consideration;
        this.recommendation = recommendation;
        this.idProvider = idProvider;
        this.reviewText = reviewText;
        this.generalAverage = generalAverage;
        this.idUser = idUser;
        this.idTransaction = idTransaction;
    }

    public QualifyUser() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_qualify")
    public Long getIdQualify() {
        return idQualify;
    }

    public void setIdQualify(Long idQualify) {
        this.idQualify = idQualify;
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

    @Column(name="idProvider")
    public Long getIdProvider() {
        return idProvider;
    }

    public void setIdProvider(Long idProvider) {
        this.idProvider = idProvider;
    }
    @Column(name="review_text")
    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    @Column(name="general_average")
    public Integer getGeneralAverage() {
        return generalAverage;
    }

    public void setGeneralAverage(Integer generalAverage) {
        this.generalAverage = generalAverage;
    }

    @Column(name="id_user")
    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    @Column(name="id_transaction")
    public Long getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(Long idTransaction) {
        this.idTransaction = idTransaction;
    }
}
