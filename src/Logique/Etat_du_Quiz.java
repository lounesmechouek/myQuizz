package Logique;

import java.io.Serializable;

public enum Etat_du_Quiz  implements Serializable {
    NON_ACCOMPLI,ACCOMPLI,EXPIRE,EVALUE
}

/*
    Non-Accompli :                                          |           N
        - Quiz non entamé.                                  |           O
        - Quiz entamé mais non soumis à évaluation.         |           N

                                                            |           E
    Accompli :                                              |           V
        - TAUX D'ACCOMPLISSEMENT = 100%                     |           A
                                                            |           L
    Expiré :                                                |           U
        - Date d'expiration dépassée.                       |           E



    Evalué :
        - Soumis à évaluation.


 */

