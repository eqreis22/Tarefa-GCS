pipeline {
    // Permite que o pipeline seja executado em qualquer agente disponível no seu Jenkins local
    agent any

    // IMPORTANTE: Os nomes 'Maven' e 'JDK11' devem corresponder exatamente aos nomes
    // que você configurou em "Global Tool Configuration" no seu Jenkins.
    tools {
        maven 'Maven'
        jdk 'JDK21' // Ajuste para a versão do Java que você está utilizando
    }

    stages {
        stage('Checkout do Código') {
            steps {
                echo 'A baixar o código do GitHub...'
                // Puxa o código da branch configurada no job
                checkout scm
            }
        }

        stage('Build (Compilação)') {
            steps {
                echo 'A compilar o código fonte...'
                // Se o seu Jenkins estiver no Windows, mude 'sh' para 'bat'
                // Exemplo: bat 'mvn clean compile'
                sh 'mvn clean compile'
            }
        }

        stage('Testes Unitários') {
            steps {
                echo 'A executar os casos de teste JUnit...'
                // Executa os testes. Se um teste falhar aqui, o build fica UNSTABLE/FAILURE
                sh 'mvn test'
            }
            post {
                always {
                    // Esta etapa garante que o Jenkins leia os resultados dos testes e crie o gráfico,
                    // mesmo que algum teste falhe (necessário para o Cenário 3).
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
    }
    
    // Ações finais executadas após o fim do pipeline
    post {
        success {
            echo 'Build finalizado com SUCESSO! ✅'
        }
        failure {
            echo 'Ocorreu uma FALHA no build ou na compilação. ❌'
        }
        unstable {
            echo 'Build INSTÁVEL: O código compilou, mas os testes falharam. ⚠️'
        }
    }
}