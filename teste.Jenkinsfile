pipeline {
    // Permite que o pipeline seja executado em qualquer agente disponível no seu Jenkins local
    agent any

    // IMPORTANTE: Os nomes 'Maven' e 'JDK11' devem corresponder exatamente aos nomes
    // que você configurou em "Global Tool Configuration" no seu Jenkins.
    tools {
        maven 'Maven'
        jdk 'JDK11' // Ajuste para a versão do Java que você está utilizando
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
                // Alterado de 'sh' para 'bat'
                bat 'mvn clean compile'
            }
        }

        stage('Testes Unitários') {
            steps {
                echo 'A executar os casos de teste JUnit...'
                bat 'mvn test'
            }
            post {
                always {
                    // O **/ garante que ele ache a pasta target em qualquer lugar.
                    // O allowEmptyResults evita que o Cenário 2 gere um erro confuso.
                    junit testResults: '**/target/surefire-reports/*.xml', allowEmptyResults: true
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