package com.example.estudosapp.erp.quizz

class QuizzListaPerguntas {
  companion object {
    var list = listOf(
      mutableMapOf(
        "pergunta" to  "Normalmente, quantos litros de sangue uma pessoa tem? Em média, quantos são retirados numa doação de sangue?",
        "opcoes" to listOf(
          mutableMapOf("label" to "Tem entre 2 a 4 litros. São retirados 450 mililitros"),
          mutableMapOf("label" to "Tem entre 4 a 6 litros. São retirados 450 mililitros", "correta" to true),
          mutableMapOf("label" to "Tem entre 2 a 4 litros. São retirados 250 mililitros"),
          mutableMapOf("label" to "Tem 10 litros. São retirados 2 litros"),
          mutableMapOf("label" to "Tem 0,5 litros. São retirados 0,5 litros")
        )
      ),
      mutableMapOf(
        "pergunta" to  "De quem é a famosa frase “Penso, logo existo”?",
        "opcoes" to listOf(
          mutableMapOf("label" to "Platão"),
          mutableMapOf("label" to "Galileu Galilei"),
          mutableMapOf("label" to "Descartes", "correta" to true),
          mutableMapOf("label" to "Sócrates"),
          mutableMapOf("label" to "Francis Bacon")
        )
      ),
      mutableMapOf(
        "pergunta" to  "De onde é a invenção do chuveiro elétrico?",
        "opcoes" to listOf(
          mutableMapOf("label" to "França"),
          mutableMapOf("label" to "Inglaterra"),
          mutableMapOf("label" to "Brasil", "correta" to true),
          mutableMapOf("label" to "Austrália"),
          mutableMapOf("label" to "Itália")
        )
      ),
      mutableMapOf(
        "pergunta" to  "Quais o menor e o maior país do mundo?",
        "opcoes" to listOf(
          mutableMapOf("label" to "Vaticano e Rússia", "correta" to true),
          mutableMapOf("label" to "Nauru e China"),
          mutableMapOf("label" to "Mônaco e Canadá"),
          mutableMapOf("label" to "Malta e Estados Unidos"),
          mutableMapOf("label" to "São Marino e Índia")
          )
      ),
      mutableMapOf(
        "pergunta" to "Qual o nome do presidente do Brasil que ficou conhecido como Jango?",
        "opcoes" to listOf(
          mutableMapOf("label" to "Jânio Quadros"),
          mutableMapOf("label" to "Jacinto Anjos"),
          mutableMapOf("label" to "Getúlio Vargas"),
          mutableMapOf("label" to "João Figueiredo"),
          mutableMapOf("label" to "João Goulart", "correta" to true)
        )
      ),
      mutableMapOf(
        "pergunta" to "Qual o grupo em que todas as palavras foram escritas corretamente?",
        "opcoes" to listOf(
          mutableMapOf("label" to "Asterístico, beneficiente, meteorologia, entertido"),
          mutableMapOf("label" to "Asterisco, beneficente, meteorologia, entretido", "correta" to true),
          mutableMapOf("label" to "Asterisco, beneficente, metereologia, entretido"),
          mutableMapOf("label" to "Asterístico, beneficiente, metereologia, entretido"),
          mutableMapOf("label" to "Asterisco, beneficiente, metereologia, entretido")
        )
      ),
      mutableMapOf(
        "pergunta" to "Qual o livro mais vendido no mundo a seguir à Bíblia?",
        "opcoes" to listOf(
          mutableMapOf("label" to "O Senhor dos Anéis"),
          mutableMapOf("label" to "Dom Quixote", "correta" to true),
          mutableMapOf("label" to "O Pequeno Príncipe"),
          mutableMapOf("label" to "Ela, a Feiticeira"),
          mutableMapOf("label" to "Um Conto de Duas Cidades")
        )
      ),
      mutableMapOf(
        "pergunta" to "Quantas casas decimais tem o número pi?",
        "opcoes" to listOf(
          mutableMapOf("label" to "Duas"),
          mutableMapOf("label" to "Centenas"),
          mutableMapOf("label" to "Trilhares", "correta" to true),
          mutableMapOf("label" to "Vinte"),
          mutableMapOf("label" to "Milhares")
        )
      ),
      mutableMapOf(
        "pergunta" to "Atualmente, quantos elementos químicos a tabela periódica possui?",
        "opcoes" to listOf(
          mutableMapOf("label" to "113"),
          mutableMapOf("label" to "109"),
          mutableMapOf("label" to "108"),
          mutableMapOf("label" to "118", "correta" to true),
          mutableMapOf("label" to "92")
        )
      ),
      mutableMapOf(
        "pergunta" to "O que a palavra legend significa em português?",
        "opcoes" to listOf(
          mutableMapOf("label" to "Legenda"),
          mutableMapOf("label" to "Conto"),
          mutableMapOf("label" to "História"),
          mutableMapOf("label" to "Lenda", "correta" to true),
          mutableMapOf("label" to "Legendário")
        )
      )
    )
  }
}
