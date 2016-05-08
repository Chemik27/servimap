package com.tpfinal.domain;

import javax.persistence.*;

@Entity
@Table(name = "feedback")
public class Feedback {

    private Long idFeedback;
    private Long positive;
    private Long neutral;
    private Long negative;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getIdFeedback() {
        return idFeedback;
    }

    public void setIdFeedback(Long idFeedback) {
        this.idFeedback = idFeedback;
    }

    public Long getPositive() {
        return positive;
    }

    public void setPositive(Long positive) {
        this.positive = positive;
    }

    public Long getNeutral() {
        return neutral;
    }

    public void setNeutral(Long neutral) {
        this.neutral = neutral;
    }

    public Long getNegative() {
        return negative;
    }

    public void setNegative(Long negative) {
        this.negative = negative;
    }
}
