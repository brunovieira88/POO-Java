package aula06;

import aula05.DateYMD;

public class Test {
    public static void main(String[] args) {
        Aluno al = new Aluno ("Andreia Melo", 985567899,
        new DateYMD(18, 7, 1990), new DateYMD(1, 9, 2018));
        Professor p1 = new Professor("Jorge Almeida", 346722599, new DateYMD(13, 3, 1967),
        "Associado", "Informática");
        Bolseiro bls = new Bolseiro ("Igor Santos", 897654399, new DateYMD(11, 5, 1985),
        900, p1);
        bls.setBolsa(1050);
        System.out.println("Aluno: " + al.getName());
        System.out.println(al);
        System.out.println("Bolseiro: " + bls.getName() + ", NMec: "
        + bls.getNMEC() + ", Bolsa: " + bls.getBolsa() + ", Orientador: " +
        bls.getProfAux());
        System.out.println(bls);
    }
} 
