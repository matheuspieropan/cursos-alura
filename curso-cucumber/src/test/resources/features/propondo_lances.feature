# language: pt

Funcionalidade: : Propondo lances
  Cenario: : Propondo um unico lance valido
    Dado um lance valido
    Quando propoe ao leilao
    Entao o lance eh aceito

  Cenario: Propondo varios lances validos
    Dado um lance de 10.0 reais do usuario "fulano"
    E um lance de 15.0 reais do usuario "beltrano"
    Quando propoe varios lances ao leilao
    Entao os lances sao aceitos

   Esquema do Cenario: Propando um lance invalido
      Dado um lance invalido de <valor> reais
      Quando propoe ao leilao
      Entao o lance nao eh aceito

     Exemplos:
     | valor |
     | 0     |
     | -10   |

  Cenario: Propondo uma sequencia de lances
    Dado dois lances
      | valor | nomeUsuario |
      | 10.0  | beltrano |
      | 15.0  | beltrano |
    Quando propoe varios lances ao leilao
    Entao o segundo nao eh aceito