#language: pt
Funcionalidade: Comprar Curso CS
  Cenario: Pesquisar Curso co Clique e Incluir no Carrinho
    Dado que acesso o site da Iterasys
    Quando pesquisar por "Mantis"
    E clico na lupa
    Entao vejo a lista de resultados para o cuso "Mantis"
    Quando  clico em Matricule-se
    Entao confirmo o nome do curso como "Mantis" e o preco de "R$ 59,99"



  Cenario: Pesquisar Curso com Enter e Incluir no Carrinho
    Dado que acesso o site da Iterasys
    Quando pesquisar por "Mantis"
    E pressiono Enter
    Entao vejo a lista de resultados para o cuso "Mantis"
    Quando  clico em Matricule-se
    Entao confirmo o nome do curso como "Mantis" e o preco de "R$ 59,99"


  Esquema do Cenario:Pesquisar Curso com Enter e Incluir no Carrinho Novo
    Dado que acesso o site da Iterasys
    Quando pesquisar por <curso>
    E pressiono Enter
    Entao vejo a lista de resultados para o cuso <curso>
    Quando  clico em Matricule-se
    Entao confirmo o nome do curso como <curso> e o preco de <preco>
    Exemplos:
      |  curso               | preco       |
      |  "Mantis"            | "R$ 59,99"  |
      |  "Preparatório CTFL" | "R$ 199,00" |

    Cenario: Ver Detalhes do Curso
      Dado que acesso o site da Iterasys
      E clico no botao OK do popupda LGPD
      E clico no x de fechar o aviso
      Quando clico na imagem do curso
      Entao vejo a pagina com detalhes do curso

