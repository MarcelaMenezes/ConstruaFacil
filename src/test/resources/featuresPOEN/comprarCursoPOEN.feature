
Feature: : Comprar Curso POEN
  Scenario: : Pesquisar Curso co Clique e Incluir no Carrinho POEN
    Given que acesso o site da Iterasys POEN
    When pesquisar por "Mantis" POEN
    And clico na lupa POEN
    Then vejo a lista de resultados para o cuso "Mantis" POEN
    When  clico em Matricule-se POEN
    Then confirmo o nome do curso como "Mantis" e o preco de "R$ 59,99" POEN